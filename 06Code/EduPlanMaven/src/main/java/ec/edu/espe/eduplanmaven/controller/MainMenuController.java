package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.*;
import ec.edu.espe.eduplanmaven.view.FrmMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class MainMenuController implements ActionListener, ItemListener {

    //Declare View
    private FrmMainMenu frmMainMenu;

    public MainMenuController(FrmMainMenu frmMainMenu) {
        this.frmMainMenu = frmMainMenu;
        //Actions
        frmMainMenu.getBtmLogin().addActionListener(this);
        frmMainMenu.getBtmRegister().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

}
