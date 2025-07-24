package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.PnlViewPlans;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setupTable();
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
        // Configurar el modelo de la tabla con las columnas apropiadas
        String[] columnNames = {"ID", "Nombre", "Nivel Educativo", "Fecha"};
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
        if (FileManagerUser.getInstance().getCurrentLoggedUser() != null) {
            String currentTeacherId = FileManagerUser.getInstance().getCurrentLoggedUser().getId();
            List<Planification> teacherPlans = FileManagerPlanification.getInstance().findPlanificationsByTeacher(currentTeacherId);
            populateTable(teacherPlans);
        }
    }
    
    public void loadPlanificationsByResults(List<Planification> planifications) {
        // Filtrar solo las planificaciones del maestro logueado
        if (FileManagerUser.getInstance().getCurrentLoggedUser() != null) {
            String currentTeacherId = FileManagerUser.getInstance().getCurrentLoggedUser().getId();
            List<Planification> filteredPlans = planifications.stream()
                    .filter(plan -> plan.getIdTeacher().equals(currentTeacherId))
                    .toList();
            populateTable(filteredPlans);
        }
    }
    
    private void populateTable(List<Planification> planifications) {
        DefaultTableModel model = (DefaultTableModel) pnlViewPlans.getTblPlans().getModel();
        model.setRowCount(0); // Limpiar tabla
        
        for (Planification plan : planifications) {
            Object[] row = {
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
