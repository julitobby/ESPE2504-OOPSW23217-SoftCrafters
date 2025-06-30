package ec.edu.espe.eduplanmaven.view;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
public class PnlCreatePlan extends javax.swing.JPanel {

    private static PnlCreatePlan instance;

    private PnlCreatePlan() {
        initComponents();
    }

    public static PnlCreatePlan getInstance() {
        if (instance == null) {
            instance = new PnlCreatePlan();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        showIdTeacher2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbListTeachers2 = new javax.swing.JComboBox<>();
        showIdPlan = new javax.swing.JLabel();
        txtEducationalLevel = new javax.swing.JTextField();
        txtActivity = new javax.swing.JTextField();
        txtAgeGroup = new javax.swing.JTextField();
        SpnChildNumber = new javax.swing.JSpinner();
        SpnEstimatedTime = new javax.swing.JSpinner();
        txtGeneralDescription = new javax.swing.JTextField();
        txtIntegratorElement = new javax.swing.JTextField();
        txtNamePlanification = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        dtcPlanificationDay = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btmAddScope = new javax.swing.JButton();
        txtScopeName = new javax.swing.JTextField();
        txtSkill = new javax.swing.JTextField();
        txtNewResourceMaterial = new javax.swing.JTextField();
        btmAddResourceMaterial = new javax.swing.JButton();
        txtNewEvaluationIndicator = new javax.swing.JTextField();
        btmAddEvaluationIndicator = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtStrategyMethodologic = new javax.swing.JTextField();
        btmAddStrategyMethodologic = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btmSave = new javax.swing.JButton();

        jLabel8.setText("Descripcion General:");

        jLabel9.setText("Elemento Integrador:");

        jLabel10.setText("Nombre Planificacion:");

        jLabel1.setText("Nivel Educacional:");

        jLabel11.setText("Maestro:");

        jLabel3.setText("Actividad:");

        jLabel12.setText("Id Maestro:");

        jLabel4.setText("Grupo de Edad:");

        jLabel5.setText("Numero de Niños:");

        jLabel6.setText("Tiempo Estimado:");

        jLabel7.setText("Fecha:");

        jLabel2.setText("Id Planificación:");

        cmbListTeachers2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dadmin", "Madmin" }));

        showIdPlan.setBackground(new java.awt.Color(0, 0, 0));

        txtEducationalLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEducationalLevelActionPerformed(evt);
            }
        });

        txtActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActivityActionPerformed(evt);
            }
        });

        jLabel21.setText("horas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtGeneralDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showIdTeacher2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(showIdPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cmbListTeachers2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamePlanification))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtIntegratorElement)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtActivity)
                            .addComponent(txtAgeGroup)
                            .addComponent(SpnChildNumber)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SpnEstimatedTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addComponent(txtEducationalLevel)
                            .addComponent(dtcPlanificationDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNamePlanification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEducationalLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAgeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SpnChildNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SpnEstimatedTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(dtcPlanificationDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGeneralDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIntegratorElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbListTeachers2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addComponent(showIdTeacher2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(showIdPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel13.setText("Alcance");

        jLabel14.setText("Nombre del Alcance:");

        jLabel15.setText("Destreza:");

        jLabel16.setText("Recursos y Materiales:");

        jLabel17.setText("Indicadores de Evaluación:");

        btmAddScope.setText("Agregar Alcance");

        btmAddResourceMaterial.setText("Añadir");

        btmAddEvaluationIndicator.setText("Añadir");

        jLabel20.setText("Estrategia Metodologica:");

        btmAddStrategyMethodologic.setText("Añadir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btmAddResourceMaterial)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btmAddEvaluationIndicator)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btmAddStrategyMethodologic)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(113, 113, 113))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtScopeName, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(txtSkill)))
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNewEvaluationIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtNewResourceMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtStrategyMethodologic, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btmAddScope)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtScopeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewResourceMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btmAddResourceMaterial)
                .addGap(13, 13, 13)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewEvaluationIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btmAddEvaluationIndicator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtStrategyMethodologic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btmAddStrategyMethodologic)
                .addGap(18, 18, 18)
                .addComponent(btmAddScope)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel18.setText("Crear Planificación");

        btmSave.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(56, 56, 56)
                .addComponent(btmSave)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(btmSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEducationalLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEducationalLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEducationalLevelActionPerformed

    private void txtActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActivityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActivityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpnChildNumber;
    private javax.swing.JSpinner SpnEstimatedTime;
    private javax.swing.JButton btmAddEvaluationIndicator;
    private javax.swing.JButton btmAddResourceMaterial;
    private javax.swing.JButton btmAddScope;
    private javax.swing.JButton btmAddStrategyMethodologic;
    private javax.swing.JButton btmSave;
    private javax.swing.JComboBox<String> cmbListTeachers2;
    private com.toedter.calendar.JDateChooser dtcPlanificationDay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel showIdPlan;
    private javax.swing.JLabel showIdTeacher2;
    private javax.swing.JTextField txtActivity;
    private javax.swing.JTextField txtAgeGroup;
    private javax.swing.JTextField txtEducationalLevel;
    private javax.swing.JTextField txtGeneralDescription;
    private javax.swing.JTextField txtIntegratorElement;
    private javax.swing.JTextField txtNamePlanification;
    private javax.swing.JTextField txtNewEvaluationIndicator;
    private javax.swing.JTextField txtNewResourceMaterial;
    private javax.swing.JTextField txtScopeName;
    private javax.swing.JTextField txtSkill;
    private javax.swing.JTextField txtStrategyMethodologic;
    // End of variables declaration//GEN-END:variables

    public JSpinner getSpnChildNumber() {
        return SpnChildNumber;
    }

    public void setSpnChildNumber(JSpinner SpnChildNumber) {
        this.SpnChildNumber = SpnChildNumber;
    }

    public JSpinner getSpnEstimatedTime() {
        return SpnEstimatedTime;
    }

    public void setSpnEstimatedTime(JSpinner SpnEstimatedTime) {
        this.SpnEstimatedTime = SpnEstimatedTime;
    }

    public JButton getBtmAddEvaluationIndicator() {
        return btmAddEvaluationIndicator;
    }

    public void setBtmAddEvaluationIndicator(JButton btmAddEvaluationIndicator) {
        this.btmAddEvaluationIndicator = btmAddEvaluationIndicator;
    }

    public JButton getBtmAddResourceMaterial() {
        return btmAddResourceMaterial;
    }

    public void setBtmAddResourceMaterial(JButton btmAddResourceMaterial) {
        this.btmAddResourceMaterial = btmAddResourceMaterial;
    }

    public JButton getBtmAddScope() {
        return btmAddScope;
    }

    public void setBtmAddScope(JButton btmAddScope) {
        this.btmAddScope = btmAddScope;
    }

    public JButton getBtmAddStrategyMethodologic() {
        return btmAddStrategyMethodologic;
    }

    public void setBtmAddStrategyMethodologic(JButton btmAddStrategyMethodologic) {
        this.btmAddStrategyMethodologic = btmAddStrategyMethodologic;
    }

    public JComboBox<String> getCmbListTeachers2() {
        return cmbListTeachers2;
    }

    public void setCmbListTeachers2(JComboBox<String> cmbListTeachers2) {
        this.cmbListTeachers2 = cmbListTeachers2;
    }

    public JLabel getShowIdPlan() {
        return showIdPlan;
    }

    public void setShowIdPlan(JLabel showIdPlan) {
        this.showIdPlan = showIdPlan;
    }

    public JLabel getShowIdTeacher2() {
        return showIdTeacher2;
    }

    public void setShowIdTeacher2(JLabel showIdTeacher2) {
        this.showIdTeacher2 = showIdTeacher2;
    }

    public JTextField getTxtActivity() {
        return txtActivity;
    }

    public void setTxtActivity(JTextField txtActivity) {
        this.txtActivity = txtActivity;
    }

    public JTextField getTxtAgeGroup() {
        return txtAgeGroup;
    }

    public void setTxtAgeGroup(JTextField txtAgeGroup) {
        this.txtAgeGroup = txtAgeGroup;
    }

    public JTextField getTxtAxisTransversal() {
        return txtNamePlanification;
    }

    public void setTxtAxisTransversal(JTextField txtAxisTransversal) {
        this.txtNamePlanification = txtAxisTransversal;
    }

    public JTextField getTxtEducationalLevel() {
        return txtEducationalLevel;
    }

    public void setTxtEducationalLevel(JTextField txtEducationalLevel) {
        this.txtEducationalLevel = txtEducationalLevel;
    }

    public JTextField getTxtGeneralDescription() {
        return txtGeneralDescription;
    }

    public void setTxtGeneralDescription(JTextField txtGeneralDescription) {
        this.txtGeneralDescription = txtGeneralDescription;
    }

    public JTextField getTxtIntegratorElement() {
        return txtIntegratorElement;
    }

    public void setTxtIntegratorElement(JTextField txtIntegratorElement) {
        this.txtIntegratorElement = txtIntegratorElement;
    }

    public JTextField getTxtNewEvaluationIndicator() {
        return txtNewEvaluationIndicator;
    }

    public void setTxtNewEvaluationIndicator(JTextField txtNewEvaluationIndicator) {
        this.txtNewEvaluationIndicator = txtNewEvaluationIndicator;
    }

    public JTextField getTxtNewResourceMaterial() {
        return txtNewResourceMaterial;
    }

    public void setTxtNewResourceMaterial(JTextField txtNewResourceMaterial) {
        this.txtNewResourceMaterial = txtNewResourceMaterial;
    }

    public JTextField getTxtScopeName() {
        return txtScopeName;
    }

    public void setTxtScopeName(JTextField txtScopeName) {
        this.txtScopeName = txtScopeName;
    }

    public JTextField getTxtSkill() {
        return txtSkill;
    }

    public void setTxtSkill(JTextField txtSkill) {
        this.txtSkill = txtSkill;
    }

    public JTextField getTxtStrategyMethodologic() {
        return txtStrategyMethodologic;
    }

    public void setTxtStrategyMethodologic(JTextField txtStrategyMethodologic) {
        this.txtStrategyMethodologic = txtStrategyMethodologic;
    }

    public JButton getBtmSave() {
        return btmSave;
    }

    public void setBtmSave(JButton btmSave) {
        this.btmSave = btmSave;
    }

    public void setTxtNamePlanification(JTextField txtNamePlanification) {
        this.txtNamePlanification = txtNamePlanification;
    }

    public JTextField getTxtNamePlanification() {
        return txtNamePlanification;
    }

    public JDateChooser getDtcPlanificationDay() {
        return dtcPlanificationDay;
    }

    public void setDtcPlanificationDay(JDateChooser dtcPlanificationDay) {
        this.dtcPlanificationDay = dtcPlanificationDay;
    }
    
    public void clearForm() {
        txtNamePlanification.setText("");
        txtActivity.setText("");
        txtAgeGroup.setText("");
        txtEducationalLevel.setText("");
        txtGeneralDescription.setText("");
        txtIntegratorElement.setText("");
        txtSkill.setText("");
        txtScopeName.setText("");
        txtStrategyMethodologic.setText("");
        txtNewEvaluationIndicator.setText("");
        txtNewResourceMaterial.setText("");
        SpnChildNumber.setValue(0);
        SpnEstimatedTime.setValue(0);
        cmbListTeachers2.setSelectedIndex(0);
        showIdPlan.setText("");
        showIdTeacher2.setText("");
    }

}
