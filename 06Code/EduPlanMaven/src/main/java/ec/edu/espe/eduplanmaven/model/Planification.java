package ec.edu.espe.eduplanmaven.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
*
* @author SoftCrafters
*/
public class Planification {

//Attributes
private String idPlanification;
private String educationalLevel;
private String activityName;
private String ageGroup;
private int numberOfChildren;
private int estimatedTime; //In days
private LocalDate date;
private String experienceOverview;
private String integratingElement;
private String namePlanification;
private String responsibleTeacher;
private ArrayList<Scope> scopes;
private String idTeacher;
private Date day;

public Planification(String idPlanification, String namePlanification, String educationalLevel, String activityName, String ageGroup, int numberOfChildren, int estimatedTime, LocalDate date, String experienceOverview, String integratingElement, String responsibleTeacher, ArrayList<Scope> scopes, String idTeacher, java.util.Date day) {
    this.idPlanification = idPlanification;
    this.educationalLevel = educationalLevel;
    this.activityName = activityName;
    this.ageGroup = ageGroup;
    this.numberOfChildren = numberOfChildren;
    this.estimatedTime = estimatedTime;
    this.date = date;
    this.experienceOverview = experienceOverview;
    this.integratingElement = integratingElement;
    this.namePlanification = namePlanification;
    this.responsibleTeacher = responsibleTeacher;
    this.scopes = scopes;
    this.idTeacher = idTeacher;
    this.date = date;
}

public String getIdPlanification() {
    return idPlanification;
}

public void setIdPlanification(String idPlanification) {
    this.idPlanification = idPlanification;
}

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

public int getEstimatedTime() {
    return estimatedTime;
}

public void setEstimatedTime(int estimatedTime) {
    this.estimatedTime = estimatedTime;
}

public int getNumberOfChildren() {
    return numberOfChildren;
}

public void setNumberOfChildren(int numberOfChildren) {
    this.numberOfChildren = numberOfChildren;
}

public LocalDate getDate() {
    return date;
}

public void setDate(LocalDate date) {
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

public String getResponsibleTeacher() {
    return responsibleTeacher;
}

public void setResponsibleTeacher(String responsibleTeacher) {
    this.responsibleTeacher = responsibleTeacher;
}

public ArrayList<Scope> getScopes() {
    return scopes;
}

public void setScopes(ArrayList<Scope> scopes) {
    this.scopes = scopes;
}

public String getIdTeacher() {
    return idTeacher;
}

public void setIdTeacher(String idTeacher) {
    this.idTeacher = idTeacher;
}

public Date getDay() {
    return day;
}

public void setDay(Date day) {
    this.day = day;
}

public String getNamePlanification() {
    return namePlanification;
}

public void setNamePlanification(String namePlanification) {
    this.namePlanification = namePlanification;
}

}
