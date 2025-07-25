package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.view.PnlViewAllPlans;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
public class PnlViewAllPlansController implements ActionListener {
    
    private static PnlViewAllPlansController instance;
    
    private PnlViewAllPlans pnlViewAllPlans;

    private PnlViewAllPlansController() {
        this.pnlViewAllPlans = PnlViewAllPlans.getInstance();
        setupTable();
        setupEventListeners();
        loadAllPlanifications(); // Carga automática al inicializar
    }
    
    public static PnlViewAllPlansController getInstance() {
        if (instance == null) {
            instance = new PnlViewAllPlansController();
        }
        return instance;
    }
    
    private void setupTable() {
        // Configurar el modelo de la tabla con las columnas apropiadas
        String[] columnNames = {"ID", "Nombre", "Maestro", "Nivel Educativo", "Fecha"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla de solo lectura
            }
        };
        pnlViewAllPlans.getTblAllPlans().setModel(model);
    }
    
    private void setupEventListeners() {
        pnlViewAllPlans.getBtnUpdateAllPlans().addActionListener(this);
        pnlViewAllPlans.getBtnUpdateAllPlans().setActionCommand("UpdateAllPlans");
    }
    
    public void loadAllPlanifications() {
        List<Planification> allPlans = FileManagerPlanification.getInstance().getAllPlanifications();
        populateTable(allPlans);
    }
    
    public void loadPlanificationsByResults(List<Planification> planifications) {
        populateTable(planifications);
    }
    
    private void populateTable(List<Planification> planifications) {
        DefaultTableModel model = (DefaultTableModel) pnlViewAllPlans.getTblAllPlans().getModel();
        model.setRowCount(0); // Limpiar tabla
        
        for (Planification plan : planifications) {
            Object[] row = {
                plan.getIdPlanification(),
                plan.getNamePlanification(),
                plan.getResponsibleTeacher(),
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
            case "UpdateAllPlans" -> {
                loadAllPlanifications();
            }
        }
    }
}
