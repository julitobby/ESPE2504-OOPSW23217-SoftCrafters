package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.MonthlyReport;
import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.User;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.util.GradingService;
import ec.edu.espe.eduplanmaven.view.PnlMonthlyReports;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller for the monthly reports panel
 * @author SoftCrafters
 */
public class PnlMonthlyReportsController implements ActionListener {
    
    private static PnlMonthlyReportsController instance;
    private PnlMonthlyReports panel;
    private GradingService gradingService;
    
    private PnlMonthlyReportsController() {
        this.panel = PnlMonthlyReports.getInstance();
        this.gradingService = GradingService.getInstance();
        setupListeners();
        setCurrentDate();
    }
    
    public static PnlMonthlyReportsController getInstance() {
        if (instance == null) {
            instance = new PnlMonthlyReportsController();
        }
        return instance;
    }
    
    private void setupListeners() {
        panel.getBtnGenerateReport().addActionListener(this);
    }
    
    private void setCurrentDate() {
        java.time.LocalDate now = java.time.LocalDate.now();
        panel.getCmbYear().setSelectedItem(String.valueOf(now.getYear()));
        panel.getCmbMonth().setSelectedIndex(now.getMonthValue() - 1);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.getBtnGenerateReport()) {
            generateReport();
        }
    }
    
    private void generateReport() {
        User currentUser = FileManagerUser.getInstance().getCurrentLoggedUser();
        if (currentUser == null) {
            JOptionPane.showMessageDialog(panel, "No hay usuario logueado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Get selected year and month
        int year = Integer.parseInt((String) panel.getCmbYear().getSelectedItem());
        int month = panel.getCmbMonth().getSelectedIndex() + 1;
        
        String teacherId;
        if ("Director".equalsIgnoreCase(currentUser.getRol())) {
            // For directors, show a dialog to select teacher or all teachers
            String[] options = {"Todos los maestros", "Seleccionar maestro específico"};
            int choice = JOptionPane.showOptionDialog(panel, 
                "¿Qué reporte desea generar?", 
                "Seleccionar Alcance", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, options, options[0]);
            
            if (choice == 0) {
                // TODO: Implement all teachers report
                JOptionPane.showMessageDialog(panel, "Funcionalidad de todos los maestros pendiente de implementar", 
                                            "En desarrollo", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                // TODO: Implement teacher selection dialog
                JOptionPane.showMessageDialog(panel, "Selección de maestro específico pendiente de implementar", 
                                            "En desarrollo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } else {
            teacherId = currentUser.getId();
        }
        
        // Generate the report
        MonthlyReport report = gradingService.generateMonthlyReport(teacherId, month, year);
        displayReport(report);
    }
    
    private void displayReport(MonthlyReport report) {
        // Clear previous data
        DefaultTableModel model = panel.getTableModel();
        model.setRowCount(0);
        
        // Update statistics labels
        String monthName = (String) panel.getCmbMonth().getSelectedItem();
        String year = (String) panel.getCmbYear().getSelectedItem();
        
        if (report.getPlanifications().isEmpty()) {
            panel.getLblMonthlyAverage().setText("Promedio Mensual: No hay datos");
            panel.getLblPerformanceLevel().setText("Nivel de Desempeño: N/A");
            panel.getLblCompletionStatus().setText("Estado: Sin planificaciones");
            panel.getProgressBar().setValue(0);
            panel.getProgressBar().setString("0%");
            panel.getTxtSummary().setText(String.format(
                "No se encontraron planificaciones para %s %s.\n\n" +
                "Asegúrese de que:\n" +
                "1. Existan planificaciones creadas para este período\n" +
                "2. Las planificaciones tengan asignado el mes y año correctos",
                monthName, year));
            return;
        }
        
        // Update statistics
        panel.getLblMonthlyAverage().setText(String.format("Promedio Mensual: %.1f", report.getMonthlyAverage()));
        panel.getLblPerformanceLevel().setText("Nivel: " + report.getPerformanceLevel());
        panel.getLblCompletionStatus().setText(String.format("Estado: %d/4 planificaciones", 
                                                              report.getPlanifications().size()));
        
        // Update progress bar
        double completion = report.getCompletionPercentage();
        panel.getProgressBar().setValue((int) completion);
        panel.getProgressBar().setString(String.format("%.0f%%", completion));
        
        // Populate table
        for (Planification plan : report.getPlanifications()) {
            Object[] row = {
                "Semana " + plan.getWeekOfMonth(),
                plan.getIdPlanification(),
                plan.getNamePlanification(),
                plan.isGraded() ? String.valueOf(plan.getGrade()) : "Sin calificar",
                plan.isGraded() ? "Calificada" : "Pendiente"
            };
            model.addRow(row);
        }
        
        // Generate summary text
        generateSummaryText(report, monthName, year);
    }
    
    private void generateSummaryText(MonthlyReport report, String monthName, String year) {
        StringBuilder summary = new StringBuilder();
        summary.append(String.format("=== REPORTE MENSUAL - %s %s ===\n\n", monthName.toUpperCase(), year));
        
        List<Planification> plans = report.getPlanifications();
        int gradedCount = (int) plans.stream().mapToLong(p -> p.isGraded() ? 1 : 0).sum();
        
        summary.append(String.format("📊 ESTADÍSTICAS GENERALES:\n"));
        summary.append(String.format("• Total de planificaciones: %d\n", plans.size()));
        summary.append(String.format("• Planificaciones calificadas: %d\n", gradedCount));
        summary.append(String.format("• Planificaciones pendientes: %d\n", plans.size() - gradedCount));
        summary.append(String.format("• Porcentaje de completitud: %.1f%%\n\n", report.getCompletionPercentage()));
        
        if (gradedCount > 0) {
            summary.append(String.format("📈 RENDIMIENTO ACADÉMICO:\n"));
            summary.append(String.format("• Promedio mensual: %.1f/100\n", report.getMonthlyAverage()));
            summary.append(String.format("• Nivel de desempeño: %s\n\n", report.getPerformanceLevel()));
            
            // Individual planification details
            summary.append("📋 DETALLE POR SEMANA:\n");
            for (Planification plan : plans) {
                summary.append(String.format("• Semana %d: %s - ", 
                                            plan.getWeekOfMonth(), 
                                            plan.getNamePlanification()));
                if (plan.isGraded()) {
                    summary.append(String.format("Calificación: %d\n", plan.getGrade()));
                } else {
                    summary.append("Pendiente de calificar\n");
                }
            }
        } else {
            summary.append("⚠️  OBSERVACIONES:\n");
            summary.append("No hay planificaciones calificadas para este mes.\n");
            summary.append("Se recomienda calificar las planificaciones completadas.\n");
        }
        
        panel.getTxtSummary().setText(summary.toString());
    }
    
    /**
     * Public method to refresh the panel (called when switching to this panel)
     */
    public void refreshPanel() {
        setCurrentDate();
        // Clear previous data
        DefaultTableModel model = panel.getTableModel();
        model.setRowCount(0);
        panel.getLblMonthlyAverage().setText("Promedio Mensual: --");
        panel.getLblPerformanceLevel().setText("Nivel de Desempeño: --");
        panel.getLblCompletionStatus().setText("Estado de Completitud: --");
        panel.getProgressBar().setValue(0);
        panel.getProgressBar().setString("0%");
        panel.getTxtSummary().setText("Seleccione un mes y año para generar el reporte");
    }
}
