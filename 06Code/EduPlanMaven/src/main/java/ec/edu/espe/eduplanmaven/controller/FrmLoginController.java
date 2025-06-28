package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.FrmLogin;
import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SoftCrafters
 */
public class FrmLoginController implements ActionListener {

    private static FrmLoginController instance;

    private FrmLogin frmLogin;

    private FrmLoginController() {
        this.frmLogin = FrmLogin.getInstance();

        frmLogin.getBtmLogin().addActionListener(this);
        frmLogin.getBtmLogin().setActionCommand("Login");
        frmLogin.getBtmBack().addActionListener(this);
        frmLogin.getBtmBack().setActionCommand("Back");

    }

    public static FrmLoginController getInstance() {
        if (instance == null) {
            instance = new FrmLoginController();
        }
        return instance;
    }

    public void showLogin() {
        frmLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        switch (button) {
            case "Login" -> {
                //AQUI DEBE COMPARAR CON LA BASE DE DATOS Y LUEGO DECIR SI EL USUARIO EXISTE O ONO, si existe debe redireccionar a cada menu
                
                frmLogin.setVisible(false);
                
                FrmMenuTeacherController.getInstance().showLMenuTeacher();
                FrmMenuPrincipalController.getInstance().showLMenuPrincipal();
            }
            case "Back" -> {
                frmLogin.setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
            }
        }
    }
}
