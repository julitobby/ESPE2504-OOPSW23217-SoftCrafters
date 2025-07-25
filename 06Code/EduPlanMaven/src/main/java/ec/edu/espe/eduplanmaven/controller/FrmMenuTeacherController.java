package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import ec.edu.espe.eduplanmaven.view.FrmMenuTeacher;
import ec.edu.espe.eduplanmaven.view.PnlCreatePlan;
import ec.edu.espe.eduplanmaven.view.PnlFindPlan;
import ec.edu.espe.eduplanmaven.view.PnlViewAllPlans;
import ec.edu.espe.eduplanmaven.view.PnlViewPlans;
import ec.edu.espe.eduplanmaven.view.PnlGradePlanification;
import ec.edu.espe.eduplanmaven.view.PnlMonthlyReports;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SoftCrafters
 */
public class FrmMenuTeacherController implements ActionListener {

    private static FrmMenuTeacherController instance;

    private FrmMenuTeacher frmMenuTeacher;

    private FrmMenuTeacherController() {
        this.frmMenuTeacher = FrmMenuTeacher.getInstance();

        frmMenuTeacher.getPmlActions().setLayout(new CardLayout());
        frmMenuTeacher.getPmlActions().add(PnlCreatePlan.getInstance(), "CreatePlan");
        frmMenuTeacher.getPmlActions().add(PnlFindPlan.getInstance(), "FindPlan");
        frmMenuTeacher.getPmlActions().add(PnlViewPlans.getInstance(), "ViewPlans");
        frmMenuTeacher.getPmlActions().add(PnlViewAllPlans.getInstance(), "ViewAllPlans");
        frmMenuTeacher.getPmlActions().add(PnlGradePlanification.getInstance(), "GradePlanification");
        frmMenuTeacher.getPmlActions().add(PnlMonthlyReports.getInstance(), "MonthlyReports");

        frmMenuTeacher.getMnuCreatePlan().addActionListener(this);
        frmMenuTeacher.getMnuCreatePlan().setActionCommand("Create");
        frmMenuTeacher.getMnuFindPlan().addActionListener(this);
        frmMenuTeacher.getMnuFindPlan().setActionCommand("Find");
        frmMenuTeacher.getBtmLogout().addActionListener(this);
        frmMenuTeacher.getBtmLogout().setActionCommand("Logout");
        frmMenuTeacher.getMnuViewAllPlans().addActionListener(this);
        frmMenuTeacher.getMnuViewAllPlans().setActionCommand("ViewPlans");
        
        // Agregar listeners para nuevas funcionalidades de calificación
        frmMenuTeacher.getMnuGradePlanification().addActionListener(this);
        frmMenuTeacher.getMnuGradePlanification().setActionCommand("GradePlanification");
        frmMenuTeacher.getMnuMonthlyReports().addActionListener(this);
        frmMenuTeacher.getMnuMonthlyReports().setActionCommand("MonthlyReports");
        
        // Verificar si hay otro botón para ver todas las planificaciones
        if (frmMenuTeacher.getMnuViewAllPlans() != null) {
            frmMenuTeacher.getMnuViewAllPlans().addActionListener(this);
            frmMenuTeacher.getMnuViewAllPlans().setActionCommand("ViewAllPlans");
        }
        
        frmMenuTeacher.revalidate();
        frmMenuTeacher.repaint();
        frmMenuTeacher.pack();
        
        PnlCreatePlanController.getInstance();
    }

    public static FrmMenuTeacherController getInstance() {
        if (instance == null) {
            instance = new FrmMenuTeacherController();
        }
        return instance;
    }

    public void showLMenuTeacher() {
        frmMenuTeacher.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        CardLayout cardLayout = (CardLayout) frmMenuTeacher.getPmlActions().getLayout();
        
        switch (button) {
            case "Create" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "CreatePlan");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                PnlCreatePlanController.getInstance();
                System.out.println("a");

            }
            case "Find" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "FindPlan");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                PnlFindPlanController.getInstance(); // Inicializar controlador que carga automáticamente
                System.out.println("b");
            }
            case "ViewPlans" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "ViewPlans");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                PnlViewPlansController.getInstance(); // Inicializar controlador que carga automáticamente
                System.out.println("c");
            }
            case "ViewAllPlans" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "ViewAllPlans");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                PnlViewAllPlansController.getInstance(); // Inicializar controlador que carga automáticamente
                System.out.println("d");
            }
            case "GradePlanification" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "GradePlanification");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                PnlGradePlanificationController.getInstance(); // Inicializar controlador de calificaciones
                System.out.println("e - Abriendo panel de calificaciones");
            }
            case "MonthlyReports" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "MonthlyReports");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                PnlMonthlyReportsController.getInstance(); // Inicializar controlador de reportes
                System.out.println("f - Abriendo panel de reportes mensuales");
            }
            case "Logout" -> {
                FileManagerUser.getInstance().logout(); // Limpiar la sesión
                frmMenuTeacher.setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
            }
        }

    }

}
