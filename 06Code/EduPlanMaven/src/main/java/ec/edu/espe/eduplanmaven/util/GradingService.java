package ec.edu.espe.eduplanmaven.util;

import ec.edu.espe.eduplanmaven.model.MonthlyReport;
import ec.edu.espe.eduplanmaven.model.Planification;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    
    public boolean gradePlanification(String planificationId, int grade) {
        try {
            Planification plan = planificationManager.findPlanificationById(planificationId);
            if (plan != null) {
                plan.setGrade(grade);
                planificationManager.updatePlanification(plan);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Planification> getPlanificationsByMonth(String teacherId, int month, int year) {
        List<Planification> allPlans = planificationManager.findPlanificationsByTeacher(teacherId);
        
        return allPlans.stream()
                .filter(plan -> plan.getMonth() == month && plan.getYear() == year)
                .collect(Collectors.toList());
    }
    
    public MonthlyReport generateMonthlyReport(String teacherId, int month, int year) {
        List<Planification> monthlyPlans = getPlanificationsByMonth(teacherId, month, year);
        return new MonthlyReport(month, year, teacherId, monthlyPlans);
    }
    
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
    
    public void assignWeekAndMonth(Planification planification) {
        if (planification.getDate() != null) {
            LocalDate date = planification.getDate();
            
            planification.setYear(date.getYear());
            planification.setMonth(date.getMonthValue());
            
            int dayOfMonth = date.getDayOfMonth();
            int weekOfMonth = ((dayOfMonth - 1) / 7) + 1;
            if (weekOfMonth > 4) weekOfMonth = 4;
            
            planification.setWeekOfMonth(weekOfMonth);
        }
    }
    
    public List<Planification> getPendingGrades(String teacherId) {
        List<Planification> allPlans = planificationManager.findPlanificationsByTeacher(teacherId);
        
        return allPlans.stream()
                .filter(plan -> !plan.isGraded())
                .collect(Collectors.toList());
    }
}
