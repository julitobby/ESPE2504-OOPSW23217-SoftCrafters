package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.util.FileManagerUser;
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
                String username = frmLogin.getTxtUser().getText();
                String password = frmLogin.getPwdPassword().getText();
                FileManagerUser.getInstance().loginUser(username, password);
            }
            case "Back" -> {
                frmLogin.setVisible(false);
                frmLogin.getTxtUser().setText("");
                frmLogin.getPwdPassword().setText("");
                FrmMainMenu.getInstance().setVisible(true);
            }
        }
    }
}
