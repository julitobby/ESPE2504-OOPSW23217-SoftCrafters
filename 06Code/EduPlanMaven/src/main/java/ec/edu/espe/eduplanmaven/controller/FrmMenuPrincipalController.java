package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import ec.edu.espe.eduplanmaven.view.FrmMenuPrincipal;
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

        frmMenuPrincipal.getBtmFindTeacher().addActionListener(this);
        frmMenuPrincipal.getBtmFindTeacher().setActionCommand("FindTeacher");
        frmMenuPrincipal.getBtmFindPlan().addActionListener(this);
        frmMenuPrincipal.getBtmFindPlan().setActionCommand("FindPlan");
        frmMenuPrincipal.getBtmLogout().addActionListener(this);
        frmMenuPrincipal.getBtmLogout().setActionCommand("Logout");
        frmMenuPrincipal.getBtmViewPlans().addActionListener(this);
        frmMenuPrincipal.getBtmViewPlans().setActionCommand("ViewPlans");

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
        
        switch (button) {
            case "FindTeacher" -> {
                System.out.println("a");
            }
            case "FindPlan" -> {
                System.out.println("b");
            }
            case "ViewPlans" -> {
                System.out.println("c");
            }
            case "Logout" -> {
                frmMenuPrincipal.setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
            }
        }
        
    }

}
