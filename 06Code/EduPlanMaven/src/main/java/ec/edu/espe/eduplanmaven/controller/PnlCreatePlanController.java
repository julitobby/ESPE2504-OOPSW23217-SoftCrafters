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
                String idPlanification = pnlCreatePlan.getShowIdPlan().getText();
                String namePlanification = pnlCreatePlan.getTxtNamePlanification().getText();
                String educationalLevel = pnlCreatePlan.getTxtEducationalLevel().getText();
                String activityName = pnlCreatePlan.getTxtActivity().getText();
                String ageGroup = pnlCreatePlan.getTxtAgeGroup().getText();
                int numberOfChildren = (int) pnlCreatePlan.getSpnChildNumber().getValue();
                int estimatedTime = (int) pnlCreatePlan.getSpnEstimatedTime().getValue();
                LocalDate date = LocalDate.now();
                String experienceOverview = pnlCreatePlan.getTxtGeneralDescription().getText();
                String integratingElement = pnlCreatePlan.getTxtIntegratorElement().getText();
                String responsibleTeacher = pnlCreatePlan.getCmbListTeachers2().getSelectedItem().toString();
                ArrayList<Scope> scopes = new ArrayList<>(); 
                String idTeacher = pnlCreatePlan.getShowIdTeacher2().getText();
                Date day = pnlCreatePlan.getDtcPlanificationDay().getDate();


                Planification planification = new Planification(
                        idPlanification,
                        namePlanification,
                        educationalLevel,
                        activityName,
                        ageGroup,
                        numberOfChildren,
                        estimatedTime,
                        date,
                        experienceOverview,
                        integratingElement,
                        responsibleTeacher,
                        new ArrayList<>(scopesTemp),
                        idTeacher,
                        day
                );
                boolean exito = FileManagerPlanification.getInstance().savePlanification(planification);

                if (exito) {
                    JOptionPane.showMessageDialog(null, "¡Planificación guardada con éxito!");
                    PnlCreatePlan.getInstance().clearForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar la planificación.");
                }
            }
            case "AddResourceMaterial" -> {
                String recurso = pnlCreatePlan.getTxtNewResourceMaterial().getText().trim();
                if (!recurso.isEmpty()) {
                    recursos.add(recurso);
                    pnlCreatePlan.getTxtNewResourceMaterial().setText("");
                }
                break;

            }
            case "AddEvaluationIndicator" -> {
                String indicador = pnlCreatePlan.getTxtNewEvaluationIndicator().getText().trim();
                if (!indicador.isEmpty()) {
                    indicadores.add(indicador);
                    pnlCreatePlan.getTxtNewEvaluationIndicator().setText(""); // Limpiar el campo
                }
                break;
            }
            case "AddStrategyMethodologic" -> {
                String estrategia = pnlCreatePlan.getTxtStrategyMethodologic().getText().trim();
                if (!estrategia.isEmpty()) {
                    estrategias.add(estrategia);
                    pnlCreatePlan.getTxtStrategyMethodologic().setText("");
                }
                break;

            }
            case "AddScope" -> {
                String nombreScope = pnlCreatePlan.getTxtScopeName().getText().trim();
                String skill = pnlCreatePlan.getTxtSkill().getText().trim();

                if (nombreScope.isEmpty() || skill.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, llena los campos requeridos para el alcance.");
                    return;
                }

                Scope nuevoScope = new Scope(
                        nombreScope,
                        skill,
                        new ArrayList<>(estrategias),
                        new ArrayList<>(recursos),
                        new ArrayList<>(indicadores)
                );

                scopesTemp.add(nuevoScope);

                estrategias.clear();
                recursos.clear();
                indicadores.clear();

                pnlCreatePlan.getTxtScopeName().setText("");
                pnlCreatePlan.getTxtSkill().setText("");

                JOptionPane.showMessageDialog(null, "¡Alcance agregado correctamente!");

                break;

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
