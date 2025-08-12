package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.util.ExportExcel;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.PnlViewAllPlans;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
public class PnlViewAllPlansController implements ActionListener {
    
    private static PnlViewAllPlansController instance;
    
    private PnlViewAllPlans pnlViewAllPlans;
    

    private PnlViewAllPlansController() {
       //pnlFindPlan.getCmbListPlanification().addItem(plan.getIdPlanification());//////////////^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        this.pnlViewAllPlans = PnlViewAllPlans.getInstance();
        setupTable();
        setupEventListeners();
    loadTeacherIds();
        loadAllPlanifications(); // Carga automática al inicializar
       // PnlFindPlanController.getInstance();//////////////^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }
    
    public static PnlViewAllPlansController getInstance() {
        if (instance == null) {
            instance = new PnlViewAllPlansController();
        }
        return instance;
    }
    
    private void setupTable() {
        // Configurar el modelo de la tabla con las columnas apropiadas
    String[] columnNames = {"ID", "Nombre", "Maestro", "Nivel Educativo", "Fecha", "Nota"};
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
    pnlViewAllPlans.getBtnExportExcel().addActionListener(this);
    pnlViewAllPlans.getBtnExportExcel().setActionCommand("ExportExcel");
    }
    
    private void loadTeacherIds() {
        List<String> ids = FileManagerUser.getInstance().getAllTeacherIds();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Seleccione un maestro");
        if (ids != null) {
            for (String id : ids) {
                if (id != null && !id.isBlank()) {
                    model.addElement(id.trim());
                }
            }
        }
        pnlViewAllPlans.getCmbPlans2().setModel(model);
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
                plan.getDate() != null ? plan.getDate().toString() : "N/A",
                plan.isGraded() ? plan.getGrade() : ""
            };
            model.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case "UpdateAllPlans" -> {
                String selected = (String) pnlViewAllPlans.getCmbPlans2().getSelectedItem();
                if (selected != null && !selected.equals("Seleccione un maestro") && !selected.isBlank()) {
                    List<Planification> plans = FileManagerPlanification.getInstance().findPlanificationsByTeacher(selected.trim());
                    populateTable(plans);
                } else {
                    loadAllPlanifications();
                }
            }
            case "ExportExcel" -> {
                try {
                    ExportExcel obj = new ExportExcel();
                    obj.exportarExcel(pnlViewAllPlans.getTblAllPlans());
                } catch (java.io.IOException ex) {
                    System.out.println("Error: " + ex);
                }
            }
        }
    }
}
