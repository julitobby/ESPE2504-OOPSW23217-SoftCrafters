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
// New attributes for grading system
private int grade; // Calificación del 1-100
private boolean isGraded; // Si ya fue calificada
private int weekOfMonth; // Semana del mes (1-4)
private int month; // Mes (1-12)
private int year; // Año

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
    this.day = day;
    
    // Inicializar campos de calificación con valores por defecto válidos
    this.grade = 1; // Valor mínimo válido para evitar errores de validación
    this.isGraded = false;
    
    // Calcular automáticamente fecha-related fields desde LocalDate primero, luego Date
    if (this.date != null) {
        this.month = this.date.getMonthValue();
        this.year = this.date.getYear();
        this.weekOfMonth = calculateWeekOfMonth(this.date);
    } else if (this.day != null) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(this.day);
        this.month = cal.get(java.util.Calendar.MONTH) + 1; // Calendar.MONTH es 0-based
        this.year = cal.get(java.util.Calendar.YEAR);
        this.weekOfMonth = calculateWeekOfMonth(cal);
    } else {
        this.month = 1;
        this.year = 2025; // Usar año actual
        this.weekOfMonth = 1;
    }
}

/**
 * Calcula la semana del mes (1-4) basado en una fecha LocalDate
 */
private int calculateWeekOfMonth(LocalDate date) {
    int dayOfMonth = date.getDayOfMonth();
    return Math.min(4, ((dayOfMonth - 1) / 7) + 1);
}

/**
 * Calcula la semana del mes (1-4) basado en un Calendar
 */
private int calculateWeekOfMonth(java.util.Calendar cal) {
    int dayOfMonth = cal.get(java.util.Calendar.DAY_OF_MONTH);
    return Math.min(4, ((dayOfMonth - 1) / 7) + 1);
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

// Getters and setters for grading system
public int getGrade() {
    return grade;
}

public void setGrade(int grade) {
    if (grade >= 1 && grade <= 100) {
        this.grade = grade;
        this.isGraded = true;
    } else {
        throw new IllegalArgumentException("La calificación debe estar entre 1 y 100");
    }
}

public boolean isGraded() {
    return isGraded;
}

public void setGraded(boolean graded) {
    this.isGraded = graded;
}

public int getWeekOfMonth() {
    return weekOfMonth;
}

public void setWeekOfMonth(int weekOfMonth) {
    if (weekOfMonth >= 1 && weekOfMonth <= 4) {
        this.weekOfMonth = weekOfMonth;
    } else {
        throw new IllegalArgumentException("La semana del mes debe estar entre 1 y 4");
    }
}

public int getMonth() {
    return month;
}

public void setMonth(int month) {
    if (month >= 1 && month <= 12) {
        this.month = month;
    } else {
        throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
    }
}

public int getYear() {
    return year;
}

public void setYear(int year) {
    this.year = year;
}

}
