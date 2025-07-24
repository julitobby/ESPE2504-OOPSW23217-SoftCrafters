package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.view.PnlFindPlan;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class PnlFindPlanController implements ItemListener {
    
    private static PnlFindPlanController instance;
    
    private PnlFindPlan pnlFindPlan;

    private PnlFindPlanController() {
        this.pnlFindPlan = PnlFindPlan.getInstance();
       
        //Combobox
        pnlFindPlan.getCmbListPlanification().addItemListener(this);
        pnlFindPlan.getCmbScopes().addItemListener(this);
        
        // Cargar automáticamente todas las planificaciones al inicializar
        loadInitialData();
    }
    
    public static PnlFindPlanController getInstance() {
        if (instance == null) {
            instance = new PnlFindPlanController();
        }
        return instance;
    }
    
    private void loadInitialData() {
        // Obtener todas las planificaciones
        List<Planification> allPlanifications = FileManagerPlanification.getInstance().getAllPlanifications();
        
        // Cargar los IDs de planificaciones en el combobox
        pnlFindPlan.getCmbListPlanification().removeAllItems();
        pnlFindPlan.getCmbListPlanification().addItem("Seleccione una planificación");
        
        for (Planification plan : allPlanifications) {
            pnlFindPlan.getCmbListPlanification().addItem(plan.getIdPlanification());
        }
        
        // Actualizar los paneles de visualización con las planificaciones encontradas
        updateViewPanels(allPlanifications);
    }
    
    private void updateViewPanels(List<Planification> planifications) {
        // Actualizar PnlViewAllPlans con todas las planificaciones
        PnlViewAllPlansController.getInstance().loadPlanificationsByResults(planifications);
        
        // Actualizar PnlViewPlans con las planificaciones del maestro logueado
        PnlViewPlansController.getInstance().loadPlanificationsByResults(planifications);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == pnlFindPlan.getCmbListPlanification()) {
                String selectedPlanId = (String) pnlFindPlan.getCmbListPlanification().getSelectedItem();
                
                if (selectedPlanId != null && !selectedPlanId.equals("Seleccione una planificación")) {
                    // Buscar la planificación seleccionada
                    Planification selectedPlan = FileManagerPlanification.getInstance().findPlanificationById(selectedPlanId);
                    
                    if (selectedPlan != null) {
                        // Actualizar los campos del formulario con los datos de la planificación
                        displayPlanificationDetails(selectedPlan);
                        
                        // También actualizar los paneles con la planificación seleccionada
                        List<Planification> singlePlan = List.of(selectedPlan);
                        updateViewPanels(singlePlan);
                    }
                }
            }
        }
    }
    
    private void displayPlanificationDetails(Planification plan) {
        // Actualizar los labels con la información de la planificación
        pnlFindPlan.getLblTransverseAxis().setText(plan.getNamePlanification());
        pnlFindPlan.getLblEducationalLevel().setText(plan.getEducationalLevel());
        pnlFindPlan.getLblActivity().setText(plan.getActivityName());
        pnlFindPlan.getLblAgeGroup().setText(plan.getAgeGroup());
        pnlFindPlan.getLblChildNumber().setText(String.valueOf(plan.getNumberOfChildren()));
        pnlFindPlan.getLblEstimatedTime().setText(String.valueOf(plan.getEstimatedTime()));
        pnlFindPlan.getLblDate().setText(plan.getDate() != null ? plan.getDate().toString() : "N/A");
        pnlFindPlan.getLblGeneralDescription().setText(plan.getExperienceOverview());
        pnlFindPlan.getLblElementIntegrate().setText(plan.getIntegratingElement());
        pnlFindPlan.getLblTeacher().setText(plan.getResponsibleTeacher());
        pnlFindPlan.getLblIdTeacher().setText(plan.getIdTeacher());
        
        // Cargar scopes en el combobox
        if (plan.getScopes() != null && !plan.getScopes().isEmpty()) {
            pnlFindPlan.getCmbScopes().removeAllItems();
            pnlFindPlan.getCmbScopes().addItem("Seleccione un scope");
            
            plan.getScopes().forEach(scope -> {
                pnlFindPlan.getCmbScopes().addItem(scope.getScopeName());
            });
        }
    }
}
