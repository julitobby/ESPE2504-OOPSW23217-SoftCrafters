package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author SoftCrafters
 */
public class MainMenuController implements ActionListener {

    private static MainMenuController instance;
    private FrmMainMenu frmMainMenu;

    private static final String btmLogin = "Login";
    private static final String btmRegister = "Register";

    private MainMenuController() {
        this.frmMainMenu = FrmMainMenu.getInstance();
        frmMainMenu.getBtmLogin().addActionListener(this);
        frmMainMenu.getBtmRegister().addActionListener(this);
        frmMainMenu.getBtmLogin().setActionCommand(btmLogin);
        frmMainMenu.getBtmRegister().setActionCommand(btmRegister);
    }

    public static MainMenuController getInstance() {
        if (instance == null) {
            instance = new MainMenuController();
        }
        return instance;
    }

    public void showMainMenu() {
        javax.swing.Timer timer = new javax.swing.Timer(2000, e -> {
            frmMainMenu.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        switch (button) {
            case btmLogin -> {
                FrmLoginController.getInstance().showLogin();
                frmMainMenu.setVisible(false);
            }
            case btmRegister -> {
                FrmRegisterController.getInstance().showRegister();
                frmMainMenu.setVisible(false);
            }
        }
    }
}
