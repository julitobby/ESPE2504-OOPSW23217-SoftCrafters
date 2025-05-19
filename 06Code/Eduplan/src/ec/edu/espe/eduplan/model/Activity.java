package ec.edu.espe.eduplan.model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author SoftCrafters
 */

public class Activity {
    
    //Attributes
    
    private String activityName;
    private String description;
    private String activityType;
    private String activityStatus;
    private LocalTime startTime;
    private LocalTime endTime;
    private String evaluationCriteria;
    private String responsibleTeacher;
    private ArrayList<String> academicResources;
    
    //Constructor

    public Activity(String activityName, String description, String activityType, String activityStatus, LocalTime startTime, LocalTime endTime, String evaluationCriteria, String responsibleTeacher, ArrayList<String> academicResources) {
        this.activityName = activityName;
        this.description = description;
        this.activityType = activityType;
        this.activityStatus = activityStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.evaluationCriteria = evaluationCriteria;
        this.responsibleTeacher = responsibleTeacher;
        this.academicResources = academicResources;
    }
    
    //Methods
    
    public void calculateEndTime(int estimatedDurationMinutes) {
        if (startTime == null) {
            throw new IllegalStateException("Primero Ingresa la hora de inicio de la actividad:");
        }
        this.endTime = startTime.plusMinutes(estimatedDurationMinutes);
    }
    
    public void addResource(String resource) {
        academicResources.add(resource);
    }
    
    //toString

    @Override
    public String toString() {
        return activityName + ";" + description + ";" + activityType + ";" + activityStatus + ";" + startTime + ";" + endTime + ";" + evaluationCriteria + ";" + responsibleTeacher + ";" + academicResources;
    }

    //Getters and Setters
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getEvaluationCriteria() {
        return evaluationCriteria;
    }

    public void setEvaluationCriteria(String evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }

    public String getResponsibleTeacher() {
        return responsibleTeacher;
    }

    public void setResponsibleTeacher(String responsibleTeacher) {
        this.responsibleTeacher = responsibleTeacher;
    }

    public ArrayList<String> getAcademicResources() {
        return academicResources;
    }

    public void setAcademicResources(ArrayList<String> academicResources) {
        this.academicResources = academicResources;
    }
    
}
