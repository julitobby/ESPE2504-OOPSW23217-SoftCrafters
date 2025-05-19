package ec.edu.espe.eduplan.model;

/**
 *
 * @author SoftCrafters
 */

public class Skill {
    
    //Attributes
    
    private String methodologicalStrategies;
    private String planningStatus;
    private String resourceAndMaterial;
    private String evaluationCriteria;
    
    //Constructor
    
    public Skill(String methodologicalStrategies, String planningStatus, String resourceAndMaterial, String evaluationCriteria) {
        this.methodologicalStrategies = methodologicalStrategies;
        this.planningStatus = planningStatus;
        this.resourceAndMaterial = resourceAndMaterial;
        this.evaluationCriteria = evaluationCriteria;
    }
    
    //toString
    
    @Override
    public String toString() {
        return planningStatus + ";" + methodologicalStrategies + ";" + resourceAndMaterial + ";" + evaluationCriteria + "\n" ;
    }
    
    //Getters and Setters
    
    public String getMethodologicalStrategies() {
        return methodologicalStrategies;
    }
    
    public void setMethodologicalStrategies(String methodologicalStrategies) {
        this.methodologicalStrategies = methodologicalStrategies;
    }
    
    public String getPlanningStatus() {
        return planningStatus;
    }
    
    public void setPlanningStatus(String planningStatus) {
        this.planningStatus = planningStatus;
    }
    
    public String getResourceAndMaterial() {
        return resourceAndMaterial;
    }
    
    public void setResourceAndMaterial(String resourceAndMaterial) {
        this.resourceAndMaterial = resourceAndMaterial;
    }
    
    public String getEvaluationCriteria() {
        return evaluationCriteria;
    }
    
    public void setEvaluationCriteria(String evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }
    
    
}
