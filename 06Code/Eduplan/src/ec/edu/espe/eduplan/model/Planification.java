package ec.edu.espe.eduplan.model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author SoftCrafters
 */

public class Planification {
    
    //Attributes
    private String activityName;
    private String description;
    private String activityType;
    private String activityStatus;
    private String evaluationCriteria;
    private String responsibleTeacher;
    private ArrayList<String> academicResources;
    
    //Constructor

    public Planification(String activityName, String description, String activityType, String activityStatus, LocalTime startTime, LocalTime endTime, String evaluationCriteria, String responsibleTeacher, ArrayList<String> academicResources) {
        this.activityName = activityName;
        this.description = description;
        this.activityType = activityType;
        this.activityStatus = activityStatus;
        this.evaluationCriteria = evaluationCriteria;
        this.responsibleTeacher = responsibleTeacher;
        this.academicResources = academicResources;
    }
    
    //Methods
    
    public void addResource(String resource) {
        academicResources.add(resource);
    }
    
    //toString

    @Override
    public String toString() {
        return activityName + ";" + description + ";" + activityType + ";" + activityStatus + ";" + evaluationCriteria + ";" + responsibleTeacher + ";" + academicResources;
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
