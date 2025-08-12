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
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
public class PnlViewPlansController implements ActionListener {
    
    private static PnlViewPlansController instance;
    
    private PnlViewPlans pnlViewPlans;

    private PnlViewPlansController() {
        this.pnlViewPlans = PnlViewPlans.getInstance();
        setupEventListeners();
    loadPlanificationsByTeacher();
    }
    
    public static PnlViewPlansController getInstance() {
        if (instance == null) {
            instance = new PnlViewPlansController();
        }
        return instance;
    }
    
    private void setupTable() {
        String[] columnNames = new String[]{"ID", "Nombre", "Nivel Educativo", "Fecha"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    pnlViewPlans.getTblPlans().setModel(model);
    pnlViewPlans.getTblPlans().setAutoCreateRowSorter(true);
    }
    
    private void setupEventListeners() {
        pnlViewPlans.getBtnUpdatePlans().addActionListener(this);
        pnlViewPlans.getBtnUpdatePlans().setActionCommand("UpdatePlans");
    }
    
    public void loadPlanificationsByTeacher() {
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        
    if (currentUser != null) {
            setupTable();
            String currentTeacherId = currentUser.getId() != null ? currentUser.getId().trim() : "";
            List<Planification> planifications = new ArrayList<>();
            if (!currentTeacherId.isEmpty()) {
                List<Planification> direct = FileManagerPlanification.getInstance().findPlanificationsByTeacher(currentTeacherId);
                if (direct != null) {
                    planifications.addAll(direct);
                }
                if (planifications.isEmpty()) {
                    List<Planification> all = FileManagerPlanification.getInstance().getAllPlanifications();
                    for (Planification p : all) {
                        String tid = p.getIdTeacher() != null ? p.getIdTeacher().trim() : "";
                        if (!tid.isEmpty() && tid.equals(currentTeacherId)) {
                            planifications.add(p);
                        }
                    }
                }
            }
            populateTable(planifications);
        } else {
            DefaultTableModel model = (DefaultTableModel) pnlViewPlans.getTblPlans().getModel();
            model.setRowCount(0);
        }
    }
    
    public void loadPlanificationsByResults(List<Planification> planifications) {
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        
    if (currentUser != null) {
            setupTable();
            String currentTeacherId = currentUser.getId() != null ? currentUser.getId().trim() : "";
            List<Planification> finalPlanifications = planifications.stream()
                .filter(plan -> {
                    String tid = plan.getIdTeacher() != null ? plan.getIdTeacher().trim() : "";
                    return !tid.isEmpty() && tid.equals(currentTeacherId);
                })
                .collect(Collectors.toList());
            
            populateTable(finalPlanifications);
        } else {
            DefaultTableModel model = (DefaultTableModel) pnlViewPlans.getTblPlans().getModel();
            model.setRowCount(0);
        }
    }
    
    private void populateTable(List<Planification> planifications) {
        DefaultTableModel model = (DefaultTableModel) pnlViewPlans.getTblPlans().getModel();
    model.setRowCount(0);
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
