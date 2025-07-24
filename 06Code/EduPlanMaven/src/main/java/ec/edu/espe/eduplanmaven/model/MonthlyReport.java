package ec.edu.espe.eduplanmaven.model;

import java.util.List;

/**
 * Represents a monthly report with planifications and their average grade
 * @author SoftCrafters
 */
public class MonthlyReport {
    
    private int month;
    private int year;
    private String teacherId;
    private List<Planification> planifications;
    private double monthlyAverage;
    private boolean isComplete; // True if has 4 planifications
    
    public MonthlyReport(int month, int year, String teacherId) {
        this.month = month;
        this.year = year;
        this.teacherId = teacherId;
        this.isComplete = false;
        this.monthlyAverage = 0.0;
    }
    
    public MonthlyReport(int month, int year, String teacherId, List<Planification> planifications) {
        this.month = month;
        this.year = year;
        this.teacherId = teacherId;
        this.planifications = planifications;
        this.isComplete = planifications != null && planifications.size() == 4;
        calculateMonthlyAverage();
    }
    
    /**
     * Calculates the monthly average based on graded planifications
     */
    public void calculateMonthlyAverage() {
        if (planifications == null || planifications.isEmpty()) {
            this.monthlyAverage = 0.0;
            return;
        }
        
        double sum = 0.0;
        int gradedCount = 0;
        
        for (Planification plan : planifications) {
            if (plan.isGraded()) {
                sum += plan.getGrade();
                gradedCount++;
            }
        }
        
        if (gradedCount > 0) {
            this.monthlyAverage = sum / gradedCount;
        } else {
            this.monthlyAverage = 0.0;
        }
    }
    
    /**
     * Gets the performance level based on average
     * @return String representing performance level
     */
    public String getPerformanceLevel() {
        if (monthlyAverage >= 90) return "Excelente";
        if (monthlyAverage >= 80) return "Muy Bueno";
        if (monthlyAverage >= 70) return "Bueno";
        if (monthlyAverage >= 60) return "Regular";
        return "Necesita Mejora";
    }
    
    /**
     * Gets completion percentage (how many planifications are graded)
     * @return percentage as double
     */
    public double getCompletionPercentage() {
        if (planifications == null || planifications.isEmpty()) {
            return 0.0;
        }
        
        int gradedCount = 0;
        for (Planification plan : planifications) {
            if (plan.isGraded()) {
                gradedCount++;
            }
        }
        
        return (gradedCount * 100.0) / planifications.size();
    }
    
    // Getters and Setters
    public int getMonth() {
        return month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    
    public List<Planification> getPlanifications() {
        return planifications;
    }
    
    public void setPlanifications(List<Planification> planifications) {
        this.planifications = planifications;
        this.isComplete = planifications != null && planifications.size() == 4;
        calculateMonthlyAverage();
    }
    
    public double getMonthlyAverage() {
        return monthlyAverage;
    }
    
    public boolean isComplete() {
        return isComplete;
    }
    
    public void setComplete(boolean complete) {
        this.isComplete = complete;
    }
}
