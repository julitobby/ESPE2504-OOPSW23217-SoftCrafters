package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.User;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.PnlFindPlan;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import ec.edu.espe.eduplanmaven.model.Scope;
public class PnlFindPlanController implements ItemListener {
    
    private static PnlFindPlanController instance;
    
    private PnlFindPlan pnlFindPlan;
    private Planification currentPlan;

    private PnlFindPlanController() {
        this.pnlFindPlan = PnlFindPlan.getInstance();
       
        pnlFindPlan.getCmbListPlanification().addItemListener(this);
        pnlFindPlan.getCmbScopes().addItemListener(this);

        loadInitialData();
    }
    
    public static PnlFindPlanController getInstance() {
        if (instance == null) {
            instance = new PnlFindPlanController();
        }
        return instance;
    }
    
    private void loadInitialData() {
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        List<Planification> planifications;
        
        if (currentUser != null) {
            if ("Director".equalsIgnoreCase(currentUser.getRol())) {
                planifications = FileManagerPlanification.getInstance().getAllPlanifications();
            } else {
                planifications = FileManagerPlanification.getInstance().findPlanificationsByTeacher(currentUser.getId());
            }
        } else {
            planifications = new ArrayList<>();
        }
        
        pnlFindPlan.getCmbListPlanification().removeAllItems();
        pnlFindPlan.getCmbListPlanification().addItem("Seleccione una planificación");
        
        for (Planification plan : planifications) {
            pnlFindPlan.getCmbListPlanification().addItem(plan.getIdPlanification());
        }
        
        updateViewPanels(planifications);
    }
    
    private void updateViewPanels(List<Planification> planifications) {
        PnlViewAllPlansController.getInstance().loadPlanificationsByResults(planifications);
    PnlViewPlansController.getInstance().loadPlanificationsByResults(planifications);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == pnlFindPlan.getCmbListPlanification()) {
                String selectedPlanId = (String) pnlFindPlan.getCmbListPlanification().getSelectedItem();
                
                if (selectedPlanId != null && !selectedPlanId.equals("Seleccione una planificación")) {
                    Planification selectedPlan = FileManagerPlanification.getInstance().findPlanificationById(selectedPlanId);
                    
                    if (selectedPlan != null) {
                        displayPlanificationDetails(selectedPlan);
                        List<Planification> singlePlan = List.of(selectedPlan);
                        PnlViewAllPlansController.getInstance().loadPlanificationsByResults(singlePlan);
                        PnlViewPlansController.getInstance().loadPlanificationsByResults(singlePlan);
                    }
                } else {
                    clearScopeDetails();
                }
            } else if (e.getSource() == pnlFindPlan.getCmbScopes()) {
                String selected = (String) pnlFindPlan.getCmbScopes().getSelectedItem();
                if (selected != null && currentPlan != null && !selected.equals("Seleccione un scope")) {
                    int index = pnlFindPlan.getCmbScopes().getSelectedIndex() - 1;
                    if (index >= 0 && index < currentPlan.getScopes().size()) {
                        Scope scope = currentPlan.getScopes().get(index);
                        applyScope(scope);
                    }
                } else {
                    clearScopeDetails();
                }
            }
        }
    }
    
    private void displayPlanificationDetails(Planification plan) {
        currentPlan = plan;
        pnlFindPlan.getLblTransverseAxis().setText(plan.getNamePlanification());
        pnlFindPlan.getLblEducationalLevel().setText(plan.getEducationalLevel());
        pnlFindPlan.getLblActivity().setText(plan.getActivityName());
        pnlFindPlan.getLblAgeGroup().setText(plan.getAgeGroup());
        pnlFindPlan.getLblChildNumber().setText(String.valueOf(plan.getNumberOfChildren()));
        pnlFindPlan.getLblEstimatedTime().setText(String.valueOf(plan.getEstimatedTime()));
        pnlFindPlan.getLblDate().setText(plan.getDate() != null ? plan.getDate().toString() : "N/A");
    pnlFindPlan.getLblGeneralDescription().setText("");
    pnlFindPlan.getTxaGeneralDescription().setText(plan.getExperienceOverview() != null ? plan.getExperienceOverview() : "");
        pnlFindPlan.getLblElementIntegrate().setText(plan.getIntegratingElement());
        pnlFindPlan.getLblTeacher().setText(plan.getResponsibleTeacher());
        pnlFindPlan.getLblIdTeacher().setText(plan.getIdTeacher());
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Seleccione un scope");
        if (plan.getScopes() != null) {
            for (Scope s : plan.getScopes()) {
                String name = s.getScopeName();
                model.addElement(name != null && !name.isBlank() ? name : "Alcance");
            }
        }
        pnlFindPlan.getCmbScopes().setModel(model);
        clearScopeDetails();
    }

    private void applyScope(Scope scope) {
        pnlFindPlan.getLblScopeName().setText(scope.getScopeName() != null ? scope.getScopeName() : "");
        pnlFindPlan.getLblSkill().setText(scope.getSkill() != null ? scope.getSkill() : "");
        DefaultListModel<String> mRec = new DefaultListModel<>();
        if (scope.getResourcesAndMaterials() != null) {
            for (String it : scope.getResourcesAndMaterials()) mRec.addElement(it);
        }
        pnlFindPlan.getLstResourcesMaterials().setModel(mRec);
        DefaultListModel<String> mInd = new DefaultListModel<>();
        if (scope.getAssessmentIndicators() != null) {
            for (String it : scope.getAssessmentIndicators()) mInd.addElement(it);
        }
        pnlFindPlan.getLstEvaluationIndicators().setModel(mInd);
        DefaultListModel<String> mStr = new DefaultListModel<>();
        if (scope.getMethodologicalStrategy() != null) {
            for (String it : scope.getMethodologicalStrategy()) mStr.addElement(it);
        }
        pnlFindPlan.getLstMethodologicalStrategies().setModel(mStr);
    }

    private void clearScopeDetails() {
        pnlFindPlan.getLblScopeName().setText("");
        pnlFindPlan.getLblSkill().setText("");
        pnlFindPlan.getLstResourcesMaterials().setModel(new DefaultListModel<>());
        pnlFindPlan.getLstEvaluationIndicators().setModel(new DefaultListModel<>());
        pnlFindPlan.getLstMethodologicalStrategies().setModel(new DefaultListModel<>());
    }
}
