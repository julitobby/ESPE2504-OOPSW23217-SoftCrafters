package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.Scope;
import ec.edu.espe.eduplanmaven.model.User;
import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;
import ec.edu.espe.eduplanmaven.util.FileManagerUser;
import ec.edu.espe.eduplanmaven.view.PnlCreatePlan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class PnlCreatePlanController implements ActionListener, ItemListener {

    private static PnlCreatePlanController instance;

    private PnlCreatePlan pnlCreatePlan;
    private ArrayList<String> estrategias = new ArrayList<>();
    private ArrayList<String> recursos = new ArrayList<>();
    private ArrayList<String> indicadores = new ArrayList<>();
    ArrayList<Scope> scopes = new ArrayList<>();
    private ArrayList<Scope> scopesTemp = new ArrayList<>();


    private PnlCreatePlanController() {
        this.pnlCreatePlan = PnlCreatePlan.getInstance();

        //Buttons
        pnlCreatePlan.getBtmSave().addActionListener(this);
        pnlCreatePlan.getBtmSave().setActionCommand("Save");
        pnlCreatePlan.getBtmAddResourceMaterial().addActionListener(this);
        pnlCreatePlan.getBtmAddResourceMaterial().setActionCommand("AddResourceMaterial");
        pnlCreatePlan.getBtmAddEvaluationIndicator().addActionListener(this);
        pnlCreatePlan.getBtmAddEvaluationIndicator().setActionCommand("AddEvaluationIndicator");
        pnlCreatePlan.getBtmAddStrategyMethodologic().addActionListener(this);
        pnlCreatePlan.getBtmAddStrategyMethodologic().setActionCommand("AddStrategyMethodologic");
        pnlCreatePlan.getBtmAddScope().addActionListener(this);
        pnlCreatePlan.getBtmAddScope().setActionCommand("AddScope");

        //Combobox
        pnlCreatePlan.getCmbListTeachers2().addItemListener(this);

    }

    public static PnlCreatePlanController getInstance() {
        if (instance == null) {
            instance = new PnlCreatePlanController();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        switch (button) {
            case "Save" -> {
                
            }
            case "AddResourceMaterial" -> {
                
            }
            case "AddEvaluationIndicator" -> {
                
            }
            case "AddStrategyMethodologic" -> {
                

            }
            case "AddScope" -> {
               
                }

                
    }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String lastNameTeacher = pnlCreatePlan.getCmbListTeachers2().getSelectedItem().toString();
            User user = FileManagerUser.getInstance().findTeacherByLastName(lastNameTeacher);
            pnlCreatePlan.getShowIdTeacher2().setText(user.getId());
            pnlCreatePlan.getShowIdPlan().setText(generateRandomIdPlanification());

        }
    }

    private String generateRandomIdPlanification() {
        int randomNumber = (int) (Math.random() * 900000) + 100000;
        String date = java.time.LocalDate.now().toString().replace("-", ""); // yyyyMMdd
        return "PLN" + date + randomNumber;
    }
}
