package ec.edu.espe.eduplan.model;

import java.util.ArrayList;

/**
 *
 * @author SoftCrafters
 */

public class Scope {
    
    //Attributes
    private String scopeName;
    private String skill;
    private ArrayList<String> resourcesAndMaterials;
    private ArrayList<String> assessmentIndicators;
    private MethodologicalStrategy methodologicalStrategy;

    //Contructor

    public Scope() {
    }

    public Scope(String scopeName, String skill, ArrayList<String> resourcesAndMaterials, ArrayList<String> assessmentIndicators, MethodologicalStrategy methodologicalStrategy) {
        this.scopeName = scopeName;
        this.skill = skill;
        this.resourcesAndMaterials = resourcesAndMaterials;
        this.assessmentIndicators = assessmentIndicators;
        this.methodologicalStrategy = methodologicalStrategy;
    }
            
    //toString

    @Override
    public String toString() {
        return scopeName + ";" + skill + ";" + methodologicalStrategy.toString() + ";" + resourcesAndMaterials + ";" + assessmentIndicators;
    }
    
    //Getters and Setters

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public ArrayList<String> getResourcesAndMaterials() {
        return resourcesAndMaterials;
    }

    public void setResourcesAndMaterials(ArrayList<String> resourcesAndMaterials) {
        this.resourcesAndMaterials = resourcesAndMaterials;
    }

    public ArrayList<String> getAssessmentIndicators() {
        return assessmentIndicators;
    }

    public void setAssessmentIndicators(ArrayList<String> assessmentIndicators) {
        this.assessmentIndicators = assessmentIndicators;
    }

    public MethodologicalStrategy getMethodologicalStrategy() {
        return methodologicalStrategy;
    }

    public void setMethodologicalStrategy(MethodologicalStrategy methodologicalStrategy) {
        this.methodologicalStrategy = methodologicalStrategy;
    }
    
}

