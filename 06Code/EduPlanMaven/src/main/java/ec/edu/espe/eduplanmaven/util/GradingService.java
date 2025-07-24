package ec.edu.espe.eduplanmaven.util;

import ec.edu.espe.eduplanmaven.model.MonthlyReport;
import ec.edu.espe.eduplanmaven.model.Planification;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling grading operations and monthly reports
 * @author SoftCrafters
 */
public class GradingService {
    
    private static GradingService instance;
    private FileManagerPlanification planificationManager;
    
    private GradingService() {
        this.planificationManager = FileManagerPlanification.getInstance();
    }
    
    public static GradingService getInstance() {
        if (instance == null) {
            instance = new GradingService();
        }
        return instance;
    }
    
    /**
     * Grades a planification
     * @param planificationId ID of the planification
     * @param grade Grade from 1 to 100
     * @return true if successful, false otherwise
     */
    public boolean gradePlanification(String planificationId, int grade) {
        try {
            Planification plan = planificationManager.findPlanificationById(planificationId);
            if (plan != null) {
                plan.setGrade(grade);
                // Update in database
                planificationManager.updatePlanification(plan);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error grading planification: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Gets planifications for a specific month and teacher
     * @param teacherId Teacher ID
     * @param month Month (1-12)
     * @param year Year
     * @return List of planifications for that month
     */
    public List<Planification> getPlanificationsByMonth(String teacherId, int month, int year) {
        List<Planification> allPlans = planificationManager.findPlanificationsByTeacher(teacherId);
        
        return allPlans.stream()
                .filter(plan -> plan.getMonth() == month && plan.getYear() == year)
                .collect(Collectors.toList());
    }
    
    /**
     * Generates a monthly report for a teacher
     * @param teacherId Teacher ID
     * @param month Month (1-12)
     * @param year Year
     * @return MonthlyReport object
     */
    public MonthlyReport generateMonthlyReport(String teacherId, int month, int year) {
        List<Planification> monthlyPlans = getPlanificationsByMonth(teacherId, month, year);
        return new MonthlyReport(month, year, teacherId, monthlyPlans);
    }
    
    /**
     * Gets all monthly reports for a teacher in a specific year
     * @param teacherId Teacher ID
     * @param year Year
     * @return List of monthly reports
     */
    public List<MonthlyReport> getYearlyReports(String teacherId, int year) {
        List<MonthlyReport> reports = new ArrayList<>();
        
        for (int month = 1; month <= 12; month++) {
            MonthlyReport report = generateMonthlyReport(teacherId, month, year);
            if (!report.getPlanifications().isEmpty()) {
                reports.add(report);
            }
        }
        
        return reports;
    }
    
    /**
     * Calculates yearly average for a teacher
     * @param teacherId Teacher ID
     * @param year Year
     * @return Yearly average grade
     */
    public double calculateYearlyAverage(String teacherId, int year) {
        List<MonthlyReport> reports = getYearlyReports(teacherId, year);
        
        if (reports.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        int count = 0;
        
        for (MonthlyReport report : reports) {
            if (report.getMonthlyAverage() > 0) {
                sum += report.getMonthlyAverage();
                count++;
            }
        }
        
        return count > 0 ? sum / count : 0.0;
    }
    
    /**
     * Automatically assigns week and month to planification based on date
     * @param planification Planification to update
     */
    public void assignWeekAndMonth(Planification planification) {
        if (planification.getDate() != null) {
            LocalDate date = planification.getDate();
            
            // Set year and month
            planification.setYear(date.getYear());
            planification.setMonth(date.getMonthValue());
            
            // Calculate week of month (simplified - based on day of month)
            int dayOfMonth = date.getDayOfMonth();
            int weekOfMonth = ((dayOfMonth - 1) / 7) + 1;
            if (weekOfMonth > 4) weekOfMonth = 4; // Max 4 weeks
            
            planification.setWeekOfMonth(weekOfMonth);
        }
    }
    
    /**
     * Gets pending planifications (not graded yet) for a teacher
     * @param teacherId Teacher ID
     * @return List of ungraded planifications
     */
    public List<Planification> getPendingGrades(String teacherId) {
        List<Planification> allPlans = planificationManager.findPlanificationsByTeacher(teacherId);
        
        return allPlans.stream()
                .filter(plan -> !plan.isGraded())
                .collect(Collectors.toList());
    }
}
