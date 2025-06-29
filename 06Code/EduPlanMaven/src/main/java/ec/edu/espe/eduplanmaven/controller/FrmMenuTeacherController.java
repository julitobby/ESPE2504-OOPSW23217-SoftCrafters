package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import ec.edu.espe.eduplanmaven.view.FrmMenuTeacher;
import ec.edu.espe.eduplanmaven.view.PnlCreatePlan;
import ec.edu.espe.eduplanmaven.view.PnlFindPlan;
import ec.edu.espe.eduplanmaven.view.PnlFindPlan;
import ec.edu.espe.eduplanmaven.view.PnlViewAllPlans;
import ec.edu.espe.eduplanmaven.view.PnlViewByTeacher;
import ec.edu.espe.eduplanmaven.view.PnlViewPlans;
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
        this.frmMenuTeacher = frmMenuTeacher.getInstance();

        frmMenuTeacher.getPmlActions().setLayout(new CardLayout());
        frmMenuTeacher.getPmlActions().add(PnlCreatePlan.getInstance(), "CreatePlan");
        frmMenuTeacher.getPmlActions().add(PnlFindPlan.getInstance(), "FindPlan");
        frmMenuTeacher.getPmlActions().add(PnlViewPlans.getInstance(), "ViewPlans");

        frmMenuTeacher.getMnuCreatePlan().addActionListener(this);
        frmMenuTeacher.getMnuCreatePlan().setActionCommand("Create");
        frmMenuTeacher.getMnuFindPlan().addActionListener(this);
        frmMenuTeacher.getMnuFindPlan().setActionCommand("Find");
        frmMenuTeacher.getBtmLogout().addActionListener(this);
        frmMenuTeacher.getBtmLogout().setActionCommand("Logout");
        frmMenuTeacher.getMnuViewAllPlans().addActionListener(this);
        frmMenuTeacher.getMnuViewAllPlans().setActionCommand("ViewPlans");
        frmMenuTeacher.revalidate();
        frmMenuTeacher.repaint();
        frmMenuTeacher.pack();
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
                System.out.println("a");

            }
            case "Find" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "FindPlan");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                System.out.println("b");
            }
            case "ViewPlans" -> {
                cardLayout.show(frmMenuTeacher.getPmlActions(), "ViewPlans");
                frmMenuTeacher.revalidate();
                frmMenuTeacher.repaint();
                frmMenuTeacher.pack();
                System.out.println("c");
            }
            case "Logout" -> {
                frmMenuTeacher.setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
            }
        }

    }

}
