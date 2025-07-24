package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.User;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.util.GradingService;
import ec.edu.espe.eduplanmaven.view.PnlGradePlanification;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller for the grading planification panel
 * @author SoftCrafters
 */
public class PnlGradePlanificationController implements ActionListener, ItemListener, ChangeListener {
    
    private static PnlGradePlanificationController instance;
    private PnlGradePlanification panel;
    private GradingService gradingService;
    private List<Planification> pendingPlans;
    private Planification selectedPlan;
    
    private PnlGradePlanificationController() {
        this.panel = PnlGradePlanification.getInstance();
        this.gradingService = GradingService.getInstance();
        setupListeners();
        loadPendingPlanifications();
        updateProgress();
    }
    
    public static PnlGradePlanificationController getInstance() {
        if (instance == null) {
            instance = new PnlGradePlanificationController();
        }
        return instance;
    }
    
    private void setupListeners() {
        panel.getCmbPendingPlans().addItemListener(this);
        panel.getSliderGrade().addChangeListener(this);
        panel.getBtnGrade().addActionListener(this);
        panel.getBtnCancel().addActionListener(this);
    }
    
    private void loadPendingPlanifications() {
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        if (currentUser == null) {
            JOptionPane.showMessageDialog(panel, "No hay usuario logueado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Only teachers can grade planifications
        if ("Director".equalsIgnoreCase(currentUser.getRol())) {
            JOptionPane.showMessageDialog(panel, "Solo los maestros pueden calificar planificaciones", 
                                        "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        pendingPlans = gradingService.getPendingGrades(currentUser.getId());
        
        // Debug: Mostrar información sobre las planificaciones
        List<Planification> allPlans = FileManagerPlanification.getInstance().findPlanificationsByTeacher(currentUser.getId());
        System.out.println("=== DEBUG CALIFICACIONES ===");
        System.out.println("Usuario actual: " + currentUser.getId() + " (" + currentUser.getRol() + ")");
        System.out.println("Total planificaciones del maestro: " + allPlans.size());
        System.out.println("Planificaciones pendientes de calificar: " + pendingPlans.size());
        
        for (int i = 0; i < Math.min(5, allPlans.size()); i++) {
            Planification plan = allPlans.get(i);
            System.out.println(String.format("Plan %d: %s - Calificada: %s (Nota: %d)", 
                i+1, plan.getNamePlanification(), plan.isGraded(), plan.getGrade()));
        }
        System.out.println("==============================");
        
        panel.getCmbPendingPlans().removeAllItems();
        panel.getCmbPendingPlans().addItem("Seleccione una planificación pendiente");
        
        if (pendingPlans.isEmpty()) {
            panel.getCmbPendingPlans().addItem("No hay planificaciones pendientes");
            panel.getBtnGrade().setEnabled(false);
            
            // DEBUG: Ofrecer resetear calificaciones si no hay pendientes
            int option = JOptionPane.showConfirmDialog(panel, 
                "No hay planificaciones pendientes. ¿Desea resetear todas las calificaciones para testing?", 
                "Debug - Sin Planificaciones Pendientes", 
                JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.YES_OPTION) {
                FileManagerPlanification.getInstance().resetAllGradesToPending();
                loadPendingPlanifications(); // Recargar después del reset
                return;
            }
        } else {
            for (Planification plan : pendingPlans) {
                String displayText = String.format("%s - %s (Semana %d)", 
                    plan.getIdPlanification(), 
                    plan.getNamePlanification(),
                    plan.getWeekOfMonth());
                panel.getCmbPendingPlans().addItem(displayText);
            }
            panel.getBtnGrade().setEnabled(true);
        }
    }
    
    private void updateProgress() {
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        if (currentUser == null) return;
        
        LocalDate now = LocalDate.now();
        List<Planification> monthlyPlans = gradingService.getPlanificationsByMonth(
            currentUser.getId(), now.getMonthValue(), now.getYear());
        
        if (monthlyPlans.isEmpty()) {
            panel.getProgressCompletion().setValue(0);
            panel.getLblCompletionText().setText("No hay planificaciones este mes");
            return;
        }
        
        int gradedCount = 0;
        for (Planification plan : monthlyPlans) {
            if (plan.isGraded()) gradedCount++;
        }
        
        int percentage = (gradedCount * 100) / monthlyPlans.size();
        panel.getProgressCompletion().setValue(percentage);
        panel.getLblCompletionText().setText(String.format(
            "Progreso del mes: %d/%d planificaciones calificadas (%d%%)", 
            gradedCount, monthlyPlans.size(), percentage));
    }
    
    private void displayPlanificationDetails(Planification plan) {
        if (plan == null) {
            panel.getTxtPlanDetails().setText("Seleccione una planificación para ver los detalles");
            return;
        }
        
        StringBuilder details = new StringBuilder();
        details.append("ID: ").append(plan.getIdPlanification()).append("\n");
        details.append("Nombre: ").append(plan.getNamePlanification()).append("\n");
        details.append("Nivel Educativo: ").append(plan.getEducationalLevel()).append("\n");
        details.append("Actividad: ").append(plan.getActivityName()).append("\n");
        details.append("Grupo de Edad: ").append(plan.getAgeGroup()).append("\n");
        details.append("Número de Niños: ").append(plan.getNumberOfChildren()).append("\n");
        details.append("Tiempo Estimado: ").append(plan.getEstimatedTime()).append(" días\n");
        details.append("Fecha: ").append(plan.getDate()).append("\n");
        details.append("Semana del Mes: ").append(plan.getWeekOfMonth()).append("\n\n");
        details.append("Descripción: ").append(plan.getExperienceOverview()).append("\n\n");
        details.append("Elemento Integrador: ").append(plan.getIntegratingElement());
        
        panel.getTxtPlanDetails().setText(details.toString());
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == panel.getCmbPendingPlans() && e.getStateChange() == ItemEvent.SELECTED) {
            int selectedIndex = panel.getCmbPendingPlans().getSelectedIndex();
            
            if (selectedIndex > 0 && selectedIndex <= pendingPlans.size()) {
                selectedPlan = pendingPlans.get(selectedIndex - 1);
                displayPlanificationDetails(selectedPlan);
                panel.getBtnGrade().setEnabled(true);
            } else {
                selectedPlan = null;
                displayPlanificationDetails(null);
                panel.getBtnGrade().setEnabled(false);
            }
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == panel.getSliderGrade()) {
            int grade = panel.getSliderGrade().getValue();
            panel.getLblGradeValue().setText(String.valueOf(grade));
            
            // Update color based on performance level
            if (grade >= 90) {
                panel.getLblGradeValue().setForeground(java.awt.Color.GREEN);
            } else if (grade >= 80) {
                panel.getLblGradeValue().setForeground(java.awt.Color.BLUE);
            } else if (grade >= 70) {
                panel.getLblGradeValue().setForeground(java.awt.Color.ORANGE);
            } else if (grade >= 60) {
                panel.getLblGradeValue().setForeground(java.awt.Color.YELLOW);
            } else {
                panel.getLblGradeValue().setForeground(java.awt.Color.RED);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.getBtnGrade()) {
            gradeSelectedPlanification();
        } else if (e.getSource() == panel.getBtnCancel()) {
            resetForm();
        }
    }
    
    private void gradeSelectedPlanification() {
        if (selectedPlan == null) {
            JOptionPane.showMessageDialog(panel, "Seleccione una planificación para calificar", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int grade = panel.getSliderGrade().getValue();
        
        int confirm = JOptionPane.showConfirmDialog(panel, 
            String.format("¿Está seguro de calificar '%s' con %d puntos?", 
                         selectedPlan.getNamePlanification(), grade),
            "Confirmar Calificación", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = gradingService.gradePlanification(selectedPlan.getIdPlanification(), grade);
            
            if (success) {
                JOptionPane.showMessageDialog(panel, 
                    String.format("Planificación calificada exitosamente con %d puntos", grade),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
                // Refresh the view
                loadPendingPlanifications();
                updateProgress();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(panel, 
                    "Error al calificar la planificación. Intente nuevamente.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void resetForm() {
        panel.getCmbPendingPlans().setSelectedIndex(0);
        panel.getSliderGrade().setValue(80);
        panel.getTxtPlanDetails().setText("Seleccione una planificación para ver los detalles");
        selectedPlan = null;
    }
    
    /**
     * Public method to refresh the panel (called when switching to this panel)
     */
    public void refreshPanel() {
        loadPendingPlanifications();
        updateProgress();
        resetForm();
    }
}
