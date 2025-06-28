package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.FrmLogin;
import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import ec.edu.espe.eduplanmaven.view.FrmRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class FrmRegisterController implements ActionListener, ItemListener {

    private static FrmRegisterController instance;

    private FrmRegister frmRegister;

    private FrmRegisterController() {
        this.frmRegister = FrmRegister.getInstance();

        //Buttons
        frmRegister.getBtmRegister().addActionListener(this);
        frmRegister.getBtmRegister().setActionCommand("Register");
        frmRegister.getBtmBack().addActionListener(this);
        frmRegister.getBtmBack().setActionCommand("Back");

        //ComboBox
        frmRegister.getCmbRol().addItemListener(this);
    }

    public static FrmRegisterController getInstance() {
        if (instance == null) {
            instance = new FrmRegisterController();
        }
        return instance;
    }

    public void showRegister() {
        frmRegister.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        switch (button) {
            case "Register" -> {

                JOptionPane.showMessageDialog(frmRegister.getRootPane(), "Registro exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);

            }
            case "Back" -> {
                frmRegister.setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

}
