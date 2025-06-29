package ec.edu.espe.eduplanmaven.model;

import java.util.ArrayList;

/**
 *
 * @author SoftCrafters
 */

public class Scope {
    
    private String scopeName;
    private String skill; 
    private ArrayList<String> methodologicalStrategy;
    private ArrayList<String> resourcesAndMaterials;
    private ArrayList<String> assessmentIndicators;

    public Scope(String scopeName, String skill, ArrayList<String> methodologicalStrategy, ArrayList<String> resourcesAndMaterials, ArrayList<String> assessmentIndicators) {
        this.scopeName = scopeName;
        this.skill = skill;
        this.methodologicalStrategy = methodologicalStrategy;
        this.resourcesAndMaterials = resourcesAndMaterials;
        this.assessmentIndicators = assessmentIndicators;
    }

    
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

    public ArrayList<String> getMethodologicalStrategy() {
        return methodologicalStrategy;
    }

    public void setMethodologicalStrategy(ArrayList<String> methodologicalStrategy) {
        this.methodologicalStrategy = methodologicalStrategy;
    }

    
}

