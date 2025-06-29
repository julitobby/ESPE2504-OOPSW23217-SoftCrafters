package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import ec.edu.espe.eduplanmaven.view.FrmRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author SoftCrafters
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
                FileManagerUser.getInstance().checkRegister();
            }

            case "Back" -> {
                FrmRegister.getInstance().setVisible(false);
                FrmMainMenu.getInstance().setVisible(true);
                FileManagerUser.getInstance().clearRegister();
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String rol = FrmRegister.getInstance().getCmbRol().getSelectedItem().toString();
            String idGenerado = generarIdUnico(rol);
            FrmRegister.getInstance().getShowID().setText(idGenerado);
        }

    }

    private String generarIdUnico(String rol) {
        String prefijo = "";
        if ("Maestro".equalsIgnoreCase(rol)) {
            prefijo = "MTR";
        } else if ("Director".equalsIgnoreCase(rol)) {
            prefijo = "DRT";
        }

        int numeroAleatorio = (int) (Math.random() * 900000) + 100000;

        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String fechaFormateada = fechaHoy.format(formatter);

        return prefijo + fechaFormateada + numeroAleatorio;
    }
}
