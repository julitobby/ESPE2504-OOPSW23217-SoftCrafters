package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import ec.edu.espe.eduplanmaven.view.FrmMenuPrincipal;
import ec.edu.espe.eduplanmaven.view.PnlFindPlan;
import ec.edu.espe.eduplanmaven.view.PnlViewAllPlans;
import ec.edu.espe.eduplanmaven.view.PnlViewByTeacher;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class FrmMenuPrincipalController implements ActionListener {

    private static FrmMenuPrincipalController instance;

    private FrmMenuPrincipal frmMenuPrincipal;

    private FrmMenuPrincipalController() {
        this.frmMenuPrincipal = frmMenuPrincipal.getInstance();

        frmMenuPrincipal.getPmlActions().setLayout(new CardLayout());
        frmMenuPrincipal.getPmlActions().add(PnlFindPlan.getInstance(), "FindPlan");
        frmMenuPrincipal.getPmlActions().add(PnlViewByTeacher.getInstance(), "ViewByTeacher");
        frmMenuPrincipal.getPmlActions().add(PnlViewAllPlans.getInstance(), "ViewAllPlans");

        frmMenuPrincipal.getBtmLogout().addActionListener(this);
        frmMenuPrincipal.getBtmLogout().setActionCommand("Logout");
        frmMenuPrincipal.getMnuViewAllPlans().addActionListener(this);
        frmMenuPrincipal.getMnuViewAllPlans().setActionCommand("ViewPlans");
        frmMenuPrincipal.getMnuViewPlansForTeacher().addActionListener(this);
        frmMenuPrincipal.getMnuViewPlansForTeacher().setActionCommand("ViewByTeacher");
        frmMenuPrincipal.getMnuIdByPlan().addActionListener(this);
        frmMenuPrincipal.getMnuIdByPlan().setActionCommand("FindPlan");
        frmMenuPrincipal.revalidate();
        frmMenuPrincipal.repaint();
        frmMenuPrincipal.pack();
    }

    public static FrmMenuPrincipalController getInstance() {
        if (instance == null) {
            instance = new FrmMenuPrincipalController();
        }
        return instance;
    }

    public void showLMenuPrincipal() {
        frmMenuPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        CardLayout cardLayout = (CardLayout) frmMenuPrincipal.getPmlActions().getLayout();

        switch (button) {

            case "ViewByTeacher" -> {
                cardLayout.show(frmMenuPrincipal.getPmlActions(), "ViewAllPlans");
                frmMenuPrincipal.revalidate();
                frmMenuPrincipal.repaint();
                frmMenuPrincipal.pack();
                System.out.println("b");
            }
            case "ViewPlans" -> {
                cardLayout.show(frmMenuPrincipal.getPmlActions(), "ViewByTeacher");
                frmMenuPrincipal.revalidate();
                frmMenuPrincipal.repaint();
                frmMenuPrincipal.pack();
                System.out.println("c");
            }
            case "FindPlan" -> {
                cardLayout.show(frmMenuPrincipal.getPmlActions(), "FindPlan");
                frmMenuPrincipal.revalidate();
                frmMenuPrincipal.repaint();
                frmMenuPrincipal.pack();
                System.out.println("b");
            }
            case "Logout" -> {
                frmMenuPrincipal.setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
            }
        }

    }

}
