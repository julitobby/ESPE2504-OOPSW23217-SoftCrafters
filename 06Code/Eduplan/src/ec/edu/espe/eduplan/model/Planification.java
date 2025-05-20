package ec.edu.espe.eduplan.model;

import java.util.Date;

/**
 *
 * @author SoftCrafters
 */

public class Planification {
    
    //Attributes
    private String educationalLevel;
    private String activityName;
    private String ageGroup;
    private int numberOfChilden;
    private int estimatedTime; //In days
    private Date date;
    private String experienceOverview;
    private String integratingElement;
    private String transverseAxis;
    private String responsibleTeacher;
    private Scope scope;
    
    //Constructor

    public Planification() {
    }
        
    public Planification(String educationalLevel, String activityName, String ageGroup, int numberOfChilden, int estimatedTime, Date date, String experienceOverview, String integratingElement, String transverseAxis, String responsibleTeacher, Scope scope) {
        this.educationalLevel = educationalLevel;
        this.activityName = activityName;
        this.ageGroup = ageGroup;
        this.numberOfChilden = numberOfChilden;
        this.estimatedTime = estimatedTime;
        this.date = date;
        this.experienceOverview = experienceOverview;
        this.integratingElement = integratingElement;
        this.transverseAxis = transverseAxis;
        this.responsibleTeacher = responsibleTeacher;
        this.scope = scope;
    }
   
    
    //Methods
    
    
    
    //toString

    @Override
    public String toString() {
        return educationalLevel + ";" + activityName + ";" + ageGroup + ";" + numberOfChilden + ";" + estimatedTime + ";" + date + ";" + experienceOverview + ";" + integratingElement + ";" + transverseAxis + ";" + responsibleTeacher + ";" + scope;
    }

    //Getters and Setters
    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getNumberOfChilden() {
        return numberOfChilden;
    }

    public void setNumberOfChilden(int numberOfChilden) {
        this.numberOfChilden = numberOfChilden;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExperienceOverview() {
        return experienceOverview;
    }

    public void setExperienceOverview(String experienceOverview) {
        this.experienceOverview = experienceOverview;
    }

    public String getIntegratingElement() {
        return integratingElement;
    }

    public void setIntegratingElement(String integratingElement) {
        this.integratingElement = integratingElement;
    }

    public String getTransverseAxis() {
        return transverseAxis;
    }

    public void setTransverseAxis(String transverseAxis) {
        this.transverseAxis = transverseAxis;
    }

    public String getResponsibleTeacher() {
        return responsibleTeacher;
    }

    public void setResponsibleTeacher(String responsibleTeacher) {
        this.responsibleTeacher = responsibleTeacher;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
    
}
