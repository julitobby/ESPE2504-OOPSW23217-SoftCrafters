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
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        
        List<Planification> planifications;
        
        if (currentUser != null) {
            if ("Director".equalsIgnoreCase(currentUser.getRol())) {
                // Si es Director, mostrar todas las planificaciones
                planifications = FileManagerPlanification.getInstance().getAllPlanifications();
                System.out.println("PnlFindPlan - Usuario Director: " + currentUser.getId() + 
                                 " cargando TODAS las planificaciones: " + planifications.size());
            } else {
                // Si es Maestro, mostrar solo sus planificaciones
                planifications = FileManagerPlanification.getInstance().findPlanificationsByTeacher(currentUser.getId());
                System.out.println("PnlFindPlan - Usuario Maestro: " + currentUser.getId() + 
                                 " cargando SUS planificaciones: " + planifications.size());
            }
        } else {
            planifications = new ArrayList<>();
            System.out.println("PnlFindPlan - No hay usuario logueado, lista vacía");
        }
        
        // Cargar los IDs de planificaciones en el combobox (filtradas por rol)
        pnlFindPlan.getCmbListPlanification().removeAllItems();
        pnlFindPlan.getCmbListPlanification().addItem("Seleccione una planificación");
        
        for (Planification plan : planifications) {
            pnlFindPlan.getCmbListPlanification().addItem(plan.getIdPlanification());
        }
        
        // Actualizar los paneles de visualización con las planificaciones encontradas
        updateViewPanels(planifications);
    }
    
    private void updateViewPanels(List<Planification> planifications) {
        // Ambos paneles usan exactamente las mismas planificaciones filtradas por rol
        // que se cargan en el combobox
        PnlViewAllPlansController.getInstance().loadPlanificationsByResults(planifications);
        PnlViewPlansController.getInstance().loadPlanificationsByResults(planifications);
        
        // Debug: mostrar cuántas planificaciones se están cargando
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        if (currentUser != null) {
            System.out.println("PnlFindPlan - Cargando " + planifications.size() + 
                             " planificaciones para usuario: " + currentUser.getId() + 
                             " (Rol: " + currentUser.getRol() + ")");
        }
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
                        
                        // Para PnlViewAllPlans: mostrar solo la planificación seleccionada
                        List<Planification> singlePlan = List.of(selectedPlan);
                        PnlViewAllPlansController.getInstance().loadPlanificationsByResults(singlePlan);
                        
                        // Para PnlViewPlans: aplicar filtrado por rol sobre la planificación seleccionada
                        PnlViewPlansController.getInstance().loadPlanificationsByResults(singlePlan);
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
        
        // Cargar scopes en el combobox - temporalmente deshabilitado para evitar errores
        pnlFindPlan.getCmbScopes().removeAllItems();
        pnlFindPlan.getCmbScopes().addItem("Seleccione un scope");
        // TODO: Implementar carga de scopes cuando se arregle la conversión en FileManagerPlanification
    }
}
