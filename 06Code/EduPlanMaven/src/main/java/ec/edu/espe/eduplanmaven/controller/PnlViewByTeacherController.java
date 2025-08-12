package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.Scope;
import ec.edu.espe.eduplanmaven.model.User;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.PnlViewByTeacher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
public class PnlViewByTeacherController implements ActionListener {

    private static PnlViewByTeacherController instance;

    private final PnlViewByTeacher view;
    private List<Planification> currentPlans = new ArrayList<>();
    private Planification selectedPlan = null;

    private PnlViewByTeacherController() {
        this.view = PnlViewByTeacher.getInstance();
        wireEvents();
        loadTeachers();
    }

    public static synchronized PnlViewByTeacherController getInstance() {
        if (instance == null) {
            instance = new PnlViewByTeacherController();
        }
        return instance;
    }

    private void wireEvents() {
        view.getCmbListTeachers1().addActionListener(this);
        view.getCmbListTeachers1().setActionCommand("TeacherChanged");

        view.getCmbPlans1().addActionListener(this);
        view.getCmbPlans1().setActionCommand("PlanChanged");

        view.getCmbScopes().addActionListener(this);
        view.getCmbScopes().setActionCommand("ScopeChanged");

        view.getBtmFind1().addActionListener(this);
        view.getBtmFind1().setActionCommand("Refresh");
    }

    private void loadTeachers() {
        List<String> teacherIds = FileManagerUser.getInstance().getAllTeacherIds();

        DefaultComboBoxModel<String> teachersModel = new DefaultComboBoxModel<>();
        for (String id : teacherIds) {
            teachersModel.addElement(id);
        }
        view.getCmbListTeachers1().setModel(teachersModel);

        User current = FileManagerUser.getInstance().getCurrentLoggedUser();
        if (current != null && current.getRol() != null && current.getRol().equalsIgnoreCase("Maestro")) {
            String id = current.getId();
            view.getCmbListTeachers1().setSelectedItem(id);
            view.getLblIdTeacher1().setText(id);
            loadPlansForTeacher(id);
        } else if (!teacherIds.isEmpty()) {
            view.getCmbListTeachers1().setSelectedIndex(0);
            String id = teacherIds.get(0);
            view.getLblIdTeacher1().setText(id);
            loadPlansForTeacher(id);
        }
    }

    private void loadPlansForTeacher(String teacherId) {
        currentPlans = FileManagerPlanification.getInstance().findPlanificationsByTeacher(teacherId);
        DefaultComboBoxModel<String> plansModel = new DefaultComboBoxModel<>();
        for (Planification p : currentPlans) {
            plansModel.addElement(p.getIdPlanification());
        }
        view.getCmbPlans1().setModel(plansModel);

        if (!currentPlans.isEmpty()) {
            view.getCmbPlans1().setSelectedIndex(0);
            onPlanSelected(currentPlans.get(0));
        } else {
            clearPlanDetails();
        }
    }

    private void onPlanSelected(Planification plan) {
        selectedPlan = plan;
        if (plan == null) {
            clearPlanDetails();
            return;
        }

        view.getLblIdTeacher1().setText(plan.getIdTeacher() != null ? plan.getIdTeacher() : "");
        view.getLblTransverseAxis1().setText(plan.getNamePlanification() != null ? plan.getNamePlanification() : "");
        view.getLblEducationalLevel1().setText(safe(plan.getEducationalLevel()));
        view.getLblActivity1().setText(safe(plan.getActivityName()));
        view.getLblAgeGroup1().setText(safe(plan.getAgeGroup()));
        view.getLblChildNumber1().setText(String.valueOf(plan.getNumberOfChildren()));
        view.getLblEstimatedTime1().setText(String.valueOf(plan.getEstimatedTime()));
    view.getLblDate1().setText(plan.getDate() != null ? plan.getDate().toString() : "");
    view.getTxaDescription().setText(safe(plan.getExperienceOverview()));
        view.getLblElementIntegrate1().setText(safe(plan.getIntegratingElement()));

        DefaultComboBoxModel<String> scopesModel = new DefaultComboBoxModel<>();
        ArrayList<Scope> scopes = plan.getScopes();
        if (scopes != null) {
            for (int i = 0; i < scopes.size(); i++) {
                Scope sc = scopes.get(i);
                String label = (i + 1) + " - " + (sc.getScopeName() != null ? sc.getScopeName() : "Alcance");
                scopesModel.addElement(label);
            }
        }
        view.getCmbScopes().setModel(scopesModel);

        if (scopes != null && !scopes.isEmpty()) {
            view.getCmbScopes().setSelectedIndex(0);
            updateScopeDetails(scopes.get(0));
        } else {
            clearScopeDetails();
        }
    }

    private void updateScopeDetails(Scope sc) {
        if (sc == null) {
            clearScopeDetails();
            return;
        }
        view.getLblNameScope().setText(safe(sc.getScopeName()));
        view.getLblSkill().setText(safe(sc.getSkill()));
    view.getLblNameScope().setToolTipText(safe(sc.getScopeName()));
    view.getLblSkill().setToolTipText(safe(sc.getSkill()));

        DefaultListModel<String> lmRec = new DefaultListModel<>();
        if (sc.getResourcesAndMaterials() != null) {
            for (String s : sc.getResourcesAndMaterials()) lmRec.addElement(s);
        }
        view.getLstResourcesMaterials1().setModel(lmRec);

        DefaultListModel<String> lmInd = new DefaultListModel<>();
        if (sc.getAssessmentIndicators() != null) {
            for (String s : sc.getAssessmentIndicators()) lmInd.addElement(s);
        }
        view.getLstEvaluationIndicators1().setModel(lmInd);

        DefaultListModel<String> lmEst = new DefaultListModel<>();
        if (sc.getMethodologicalStrategy() != null) {
            for (String s : sc.getMethodologicalStrategy()) lmEst.addElement(s);
        }
        view.getLstMethodologicalStrategies1().setModel(lmEst);
    }

    private void clearPlanDetails() {
        view.getLblTransverseAxis1().setText("");
        view.getLblEducationalLevel1().setText("");
        view.getLblActivity1().setText("");
        view.getLblAgeGroup1().setText("");
        view.getLblChildNumber1().setText("");
        view.getLblEstimatedTime1().setText("");
    view.getLblDate1().setText("");
    view.getTxaDescription().setText("");
        view.getLblElementIntegrate1().setText("");

        view.getCmbScopes().setModel(new DefaultComboBoxModel<>());
        clearScopeDetails();
    }

    private void clearScopeDetails() {
        view.getLblNameScope().setText("");
        view.getLblSkill().setText("");
    view.getLblNameScope().setToolTipText(null);
    view.getLblSkill().setToolTipText(null);
        view.getLstResourcesMaterials1().setModel(new DefaultListModel<>());
        view.getLstEvaluationIndicators1().setModel(new DefaultListModel<>());
        view.getLstMethodologicalStrategies1().setModel(new DefaultListModel<>());
    }

    private String safe(String v) { return v == null ? "" : v; }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "TeacherChanged" -> {
                Object sel = view.getCmbListTeachers1().getSelectedItem();
                String teacherId = sel != null ? sel.toString() : null;
                view.getLblIdTeacher1().setText(teacherId != null ? teacherId : "");
                if (teacherId != null && !teacherId.isEmpty()) {
                    loadPlansForTeacher(teacherId);
                } else {
                    view.getCmbPlans1().setModel(new DefaultComboBoxModel<>());
                    clearPlanDetails();
                }
            }
            case "PlanChanged" -> {
                Object sel = view.getCmbPlans1().getSelectedItem();
                if (sel == null) { clearPlanDetails(); break; }
                String planId = sel.toString();
                Planification plan = currentPlans.stream()
                        .filter(p -> planId.equals(p.getIdPlanification()))
                        .findFirst().orElse(null);
                onPlanSelected(plan);
            }
            case "ScopeChanged" -> {
                int idx = view.getCmbScopes().getSelectedIndex();
                if (selectedPlan != null && selectedPlan.getScopes() != null && idx >= 0 && idx < selectedPlan.getScopes().size()) {
                    updateScopeDetails(selectedPlan.getScopes().get(idx));
                }
            }
            case "Refresh" -> {
                loadTeachers();
            }
        }
    }
}
