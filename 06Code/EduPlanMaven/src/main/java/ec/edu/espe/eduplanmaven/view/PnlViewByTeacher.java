package ec.edu.espe.eduplanmaven.view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
/* 
int idProfesor = SessionManager.getTeacherId();
for (int i = 0; i < cmbListTeachers1.getItemCount(); i++) {
    Object item = cmbListTeachers1.getItemAt(i);
    if (item.toString().contains(String.valueOf(idProfesor))) {
        cmbListTeachers1.setSelectedIndex(i);
        break;
    }
}
*/
public class PnlViewByTeacher extends javax.swing.JPanel {

    private static PnlViewByTeacher instance;

    private PnlViewByTeacher() {
        
        initComponents();

    configureFixedListSizes();

    }

    public static PnlViewByTeacher getInstance() {
        if (instance == null) {
            instance = new PnlViewByTeacher();
        }
        return instance;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        cmbListTeachers1 = new javax.swing.JComboBox<>();
        BtmFind1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblEducationalLevel1 = new javax.swing.JLabel();
        lblActivity1 = new javax.swing.JLabel();
        lblAgeGroup1 = new javax.swing.JLabel();
        lblChildNumber1 = new javax.swing.JLabel();
        lblEstimatedTime1 = new javax.swing.JLabel();
        lblDate1 = new javax.swing.JLabel();
        lblElementIntegrate1 = new javax.swing.JLabel();
        lblNamePlanification = new javax.swing.JLabel();
        lblNamePlanifications = new javax.swing.JLabel();
        lblEducationalLevel = new javax.swing.JLabel();
        lblActivity = new javax.swing.JLabel();
        lblAgeGroup = new javax.swing.JLabel();
        lblNumberOfChildrens = new javax.swing.JLabel();
        lblEstimatedTime = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        lblIntegratingElement = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        cmbScopes = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        LstResourcesMaterials1 = new javax.swing.JList<>();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        LstEvaluationIndicators1 = new javax.swing.JList<>();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        LstMethodologicalStrategies1 = new javax.swing.JList<>();
        lblScopeName1 = new javax.swing.JLabel();
        lblSkill1 = new javax.swing.JLabel();
        lblNameScope = new javax.swing.JLabel();
        lblSkill = new javax.swing.JLabel();
        cmbPlans1 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblIdTeacher1 = new javax.swing.JLabel();

        jLabel19.setText("Maestro:");

        BtmFind1.setText("Buscar");

        jLabel20.setText("Descripcion General:");

        jLabel21.setText("Elemento Integrador:");

        jLabel22.setText("Nombre Planificación:");

        jLabel23.setText("Nivel Educacional:");

        jLabel25.setText("Actividad:");

        jLabel27.setText("Grupo de Edad:");

        jLabel28.setText("Numero de Niños:");

        jLabel29.setText("Tiempo Estimado:");

        jLabel30.setText("Fecha:");

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        jScrollPane1.setViewportView(txaDescription);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel21))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblIntegratingElement)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblElementIntegrate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblDay)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblEstimatedTime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEstimatedTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblNumberOfChildrens)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblChildNumber1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblAgeGroup)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblAgeGroup1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblActivity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblActivity1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblEducationalLevel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEducationalLevel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblNamePlanifications)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNamePlanification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel20))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblNamePlanification)
                    .addComponent(lblNamePlanifications))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblEducationalLevel1)
                    .addComponent(lblEducationalLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblActivity1)
                    .addComponent(lblActivity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblAgeGroup1)
                    .addComponent(lblAgeGroup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblChildNumber1)
                    .addComponent(lblNumberOfChildrens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lblEstimatedTime1)
                    .addComponent(lblEstimatedTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lblDate1)
                    .addComponent(lblDay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblElementIntegrate1)
                    .addComponent(lblIntegratingElement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel31.setText("Alcances");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 6, -1, -1));

        jPanel4.add(cmbScopes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 34, 258, -1));

        jLabel32.setText("Nombre del Alcance:");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 74, -1, -1));

        jLabel33.setText("Destreza:");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 96, -1, -1));

        jLabel34.setText("Recursos y Materiales:");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 118, -1, -1));

        jScrollPane4.setViewportView(LstResourcesMaterials1);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 140, -1, 59));

        jLabel35.setText("Indicadores de Evaluación:");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 205, -1, -1));

        jScrollPane5.setViewportView(LstEvaluationIndicators1);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 227, -1, 58));

        jLabel36.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel36.setText("Estrategia Metodologica");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 303, -1, -1));

        jScrollPane6.setViewportView(LstMethodologicalStrategies1);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 325, -1, 60));
        jPanel4.add(lblScopeName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 74, 67, -1));
        jPanel4.add(lblSkill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 96, 116, -1));
        jPanel4.add(lblNameScope, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 74, -1, -1));
        jPanel4.add(lblSkill, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 96, -1, -1));

        jLabel37.setText("Planificación:");

        jLabel26.setText("Id Maestro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel19)
                        .addGap(37, 37, 37)
                        .addComponent(cmbListTeachers1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(BtmFind1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel37)
                        .addGap(12, 12, 12)
                        .addComponent(cmbPlans1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel26)
                        .addGap(24, 24, 24)
                        .addComponent(lblIdTeacher1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addComponent(cmbListTeachers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtmFind1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel37))
                    .addComponent(cmbPlans1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(lblIdTeacher1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtmFind1;
    private javax.swing.JList<String> LstEvaluationIndicators1;
    private javax.swing.JList<String> LstMethodologicalStrategies1;
    private javax.swing.JList<String> LstResourcesMaterials1;
    private javax.swing.JComboBox<String> cmbListTeachers1;
    private javax.swing.JComboBox<String> cmbPlans1;
    private javax.swing.JComboBox<String> cmbScopes;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblActivity;
    private javax.swing.JLabel lblActivity1;
    private javax.swing.JLabel lblAgeGroup;
    private javax.swing.JLabel lblAgeGroup1;
    private javax.swing.JLabel lblChildNumber1;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblEducationalLevel;
    private javax.swing.JLabel lblEducationalLevel1;
    private javax.swing.JLabel lblElementIntegrate1;
    private javax.swing.JLabel lblEstimatedTime;
    private javax.swing.JLabel lblEstimatedTime1;
    private javax.swing.JLabel lblIdTeacher1;
    private javax.swing.JLabel lblIntegratingElement;
    private javax.swing.JLabel lblNamePlanification;
    private javax.swing.JLabel lblNamePlanifications;
    private javax.swing.JLabel lblNameScope;
    private javax.swing.JLabel lblNumberOfChildrens;
    private javax.swing.JLabel lblScopeName1;
    private javax.swing.JLabel lblSkill;
    private javax.swing.JLabel lblSkill1;
    private javax.swing.JTextArea txaDescription;
    // End of variables declaration//GEN-END:variables

    public JButton getBtmFind1() {
        return BtmFind1;
    }

    public void setBtmFind1(JButton BtmFind1) {
        this.BtmFind1 = BtmFind1;
    }

    public JList<String> getLstEvaluationIndicators1() {
        return LstEvaluationIndicators1;
    }

    public void setLstEvaluationIndicators1(JList<String> LstEvaluationIndicators1) {
        this.LstEvaluationIndicators1 = LstEvaluationIndicators1;
    }

    public JList<String> getLstMethodologicalStrategies1() {
        return LstMethodologicalStrategies1;
    }

    public void setLstMethodologicalStrategies1(JList<String> LstMethodologicalStrategies1) {
        this.LstMethodologicalStrategies1 = LstMethodologicalStrategies1;
    }

    public JList<String> getLstResourcesMaterials1() {
        return LstResourcesMaterials1;
    }

    public void setLstResourcesMaterials1(JList<String> LstResourcesMaterials1) {
        this.LstResourcesMaterials1 = LstResourcesMaterials1;
    }

    public JComboBox<String> getCmbListTeachers1() {
        return cmbListTeachers1;
    }

    public void setCmbListTeachers1(JComboBox<String> cmbListTeachers1) {
        this.cmbListTeachers1 = cmbListTeachers1;
    }

    public JComboBox<String> getCmbPlans1() {
        return cmbPlans1;
    }

    public void setCmbPlans1(JComboBox<String> cmbPlans1) {
        this.cmbPlans1 = cmbPlans1;
    }

    public JComboBox<String> getCmbScopes() {
        return cmbScopes;
    }

    public void setCmbScopes(JComboBox<String> cmbScopes) {
        this.cmbScopes = cmbScopes;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public void setjScrollPane6(JScrollPane jScrollPane6) {
        this.jScrollPane6 = jScrollPane6;
    }

    public JLabel getLblActivity1() {
        return lblActivity1;
    }

    public void setLblActivity1(JLabel lblActivity1) {
        this.lblActivity1 = lblActivity1;
    }

    public JLabel getLblAgeGroup1() {
        return lblAgeGroup1;
    }

    public void setLblAgeGroup1(JLabel lblAgeGroup1) {
        this.lblAgeGroup1 = lblAgeGroup1;
    }

    public JLabel getLblChildNumber1() {
        return lblChildNumber1;
    }

    public void setLblChildNumber1(JLabel lblChildNumber1) {
        this.lblChildNumber1 = lblChildNumber1;
    }

    public JLabel getLblDate1() {
        return lblDate1;
    }

    public void setLblDate1(JLabel lblDate1) {
        this.lblDate1 = lblDate1;
    }

    public JLabel getLblEducationalLevel1() {
        return lblEducationalLevel1;
    }

    public void setLblEducationalLevel1(JLabel lblEducationalLevel1) {
        this.lblEducationalLevel1 = lblEducationalLevel1;
    }

    public JLabel getLblElementIntegrate1() {
        return lblElementIntegrate1;
    }

    public void setLblElementIntegrate1(JLabel lblElementIntegrate1) {
        this.lblElementIntegrate1 = lblElementIntegrate1;
    }

    public JLabel getLblEstimatedTime1() {
        return lblEstimatedTime1;
    }

    public void setLblEstimatedTime1(JLabel lblEstimatedTime1) {
        this.lblEstimatedTime1 = lblEstimatedTime1;
    }

    public JTextArea getTxaDescription() {
        return txaDescription;
    }

    public JLabel getLblIdTeacher1() {
        return lblIdTeacher1;
    }

    public void setLblIdTeacher1(JLabel lblIdTeacher1) {
        this.lblIdTeacher1 = lblIdTeacher1;
    }

    public JLabel getLblScopeName1() {
        return lblScopeName1;
    }

    public void setLblScopeName1(JLabel lblScopeName1) {
        this.lblScopeName1 = lblScopeName1;
    }

    public JLabel getLblSkill1() {
        return lblSkill1;
    }

    public void setLblSkill1(JLabel lblSkill1) {
        this.lblSkill1 = lblSkill1;
    }

    public JLabel getLblTransverseAxis1() {
        return lblNamePlanification;
    }

    public void setLblTransverseAxis1(JLabel lblTransverseAxis1) {
        this.lblNamePlanification = lblTransverseAxis1;
    }

    public JLabel getLblNameScope() {
        return lblNameScope;
    }

    public JLabel getLblSkill() {
        return lblSkill;
    }

    private void configureFixedListSizes() {
        lockScrollPaneSize(jScrollPane4, 258, 59);
        lockScrollPaneSize(jScrollPane5, 258, 58);
        lockScrollPaneSize(jScrollPane6, 258, 60);
        LstResourcesMaterials1.setVisibleRowCount(4);
        LstEvaluationIndicators1.setVisibleRowCount(4);
        LstMethodologicalStrategies1.setVisibleRowCount(4);

        LstResourcesMaterials1.setFixedCellHeight(18);
        LstEvaluationIndicators1.setFixedCellHeight(18);
        LstMethodologicalStrategies1.setFixedCellHeight(18);
        jScrollPane4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void lockScrollPaneSize(JScrollPane pane, int width, int height) {
        Dimension d = new Dimension(width, height);
        pane.setPreferredSize(d);
        pane.setMinimumSize(d);
        pane.setMaximumSize(d);
    }
}
