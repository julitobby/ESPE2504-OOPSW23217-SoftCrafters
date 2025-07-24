package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.User;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.PnlViewPlans;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
public class PnlViewPlansController implements ActionListener {
    
    private static PnlViewPlansController instance;
    
    private PnlViewPlans pnlViewPlans;

    private PnlViewPlansController() {
        this.pnlViewPlans = PnlViewPlans.getInstance();
        setupEventListeners();
        loadPlanificationsByTeacher(); // Carga automática al inicializar
    }
    
    public static PnlViewPlansController getInstance() {
        if (instance == null) {
            instance = new PnlViewPlansController();
        }
        return instance;
    }
    
    private void setupTable() {
        // Para PnlViewPlans: siempre es para mostrar planificaciones del maestro logueado
        // Sin información de otros maestros (tabla simplificada)
        String[] columnNames = new String[]{"ID", "Nombre", "Nivel Educativo", "Fecha"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla de solo lectura
            }
        };
        pnlViewPlans.getTblPlans().setModel(model);
    }
    
    private void setupEventListeners() {
        pnlViewPlans.getBtnUpdatePlans().addActionListener(this);
        pnlViewPlans.getBtnUpdatePlans().setActionCommand("UpdatePlans");
    }
    
    public void loadPlanificationsByTeacher() {
        System.out.println("=== EJECUTANDO loadPlanificationsByTeacher ===");
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        
        if (currentUser != null) {
            System.out.println("🔍 Usuario logueado: " + currentUser.getUsername() + " (ID: '" + currentUser.getId() + "')");
            
            // Configurar la tabla 
            setupTable();
            
            String currentTeacherId = currentUser.getId();
            
            // Obtener SOLO las planificaciones del maestro logueado
            List<Planification> planifications = FileManagerPlanification.getInstance().findPlanificationsByTeacher(currentTeacherId);
            
            System.out.println("📊 Planificaciones encontradas para " + currentTeacherId + ": " + planifications.size());
            
            // Mostrar las planificaciones filtradas en la tabla
            populateTable(planifications);
            
            System.out.println("✅ Tabla actualizada con " + planifications.size() + " planificaciones");
        } else {
            System.out.println("❌ ERROR: No hay usuario logueado");
            // Limpiar la tabla si no hay usuario logueado
            DefaultTableModel model = (DefaultTableModel) pnlViewPlans.getTblPlans().getModel();
            model.setRowCount(0);
        }
        System.out.println("=== FIN loadPlanificationsByTeacher ===");
    }
    
    public void loadPlanificationsByResults(List<Planification> planifications) {
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        
        if (currentUser != null) {
            // Configurar la tabla
            setupTable();
            
            // PnlViewPlans SIEMPRE filtra por el maestro logueado
            // No importa qué planificaciones reciba, solo muestra las del usuario actual
            String currentTeacherId = currentUser.getId();
            
            List<Planification> finalPlanifications = planifications.stream()
                    .filter(plan -> plan.getIdTeacher().equals(currentTeacherId))
                    .toList();
            
            populateTable(finalPlanifications);
        } else {
            // Limpiar la tabla si no hay usuario logueado
            DefaultTableModel model = (DefaultTableModel) pnlViewPlans.getTblPlans().getModel();
            model.setRowCount(0);
        }
    }
    
    private void populateTable(List<Planification> planifications) {
        DefaultTableModel model = (DefaultTableModel) pnlViewPlans.getTblPlans().getModel();
        model.setRowCount(0); // Limpiar tabla
        
        // PnlViewPlans siempre usa formato simplificado (sin información de maestro)
        for (Planification plan : planifications) {
            Object[] row = new Object[]{
                plan.getIdPlanification(),
                plan.getNamePlanification(),
                plan.getEducationalLevel(),
                plan.getDate() != null ? plan.getDate().toString() : "N/A"
            };
            
            model.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case "UpdatePlans" -> {
                loadPlanificationsByTeacher();
            }
        }
    }
}
