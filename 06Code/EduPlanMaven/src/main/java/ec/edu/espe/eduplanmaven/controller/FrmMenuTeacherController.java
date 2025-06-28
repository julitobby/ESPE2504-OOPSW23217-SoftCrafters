package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import ec.edu.espe.eduplanmaven.view.FrmMenuTeacher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class FrmMenuTeacherController implements ActionListener {
    
    private static FrmMenuTeacherController instance;
    
    private FrmMenuTeacher frmMenuTeacher;
    
    private FrmMenuTeacherController() {
        this.frmMenuTeacher = frmMenuTeacher.getInstance();
        
        frmMenuTeacher.getBtmCreatePlan().addActionListener(this);
        frmMenuTeacher.getBtmCreatePlan().setActionCommand("Create");
        frmMenuTeacher.getBtmFindPlan().addActionListener(this);
        frmMenuTeacher.getBtmFindPlan().setActionCommand("Find");
        frmMenuTeacher.getBtmLogout().addActionListener(this);
        frmMenuTeacher.getBtmLogout().setActionCommand("Logout");
        frmMenuTeacher.getBtmViewPlans().addActionListener(this);
        frmMenuTeacher.getBtmViewPlans().setActionCommand("ViewPlans");
        
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
        
        switch (button) {
            case "Create" -> {
                System.out.println("a");
            }
            case "Find" -> {
                System.out.println("b");
            }
            case "ViewPlans" -> {
                System.out.println("c");
            }
            case "Logout" -> {
                frmMenuTeacher.setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
            }
        }
        
    }
    
}
