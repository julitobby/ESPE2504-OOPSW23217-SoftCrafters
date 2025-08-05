package ec.edu.espe.eduplanmaven.view;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
public class PnlViewPlans extends javax.swing.JPanel {

    private static PnlViewPlans instance;
/* 
    String teacherId = currentUser.getId();
    List<Planification> plans = FileManagerPlanification.getPlansByTeacherId(teacherId);
    */

    private PnlViewPlans() {
        initComponents();
    }

    public static PnlViewPlans getInstance() {
        if (instance == null) {
            instance = new PnlViewPlans();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlans = new javax.swing.JTable();
        btnUpdatePlans = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setText("PLANIFICACIONES");

        tblPlans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblPlans);

        btnUpdatePlans.setText("Actualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(btnUpdatePlans)
                .addGap(238, 238, 238))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdatePlans)
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdatePlans;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPlans;
    // End of variables declaration//GEN-END:variables

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JTable getTblPlans() {
        return tblPlans;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public void setTblPlans(JTable tblPlans) {
        this.tblPlans = tblPlans;
    }

    public javax.swing.JButton getBtnUpdatePlans() {
        return btnUpdatePlans;
    }

    public void setBtnUpdatePlans(javax.swing.JButton btnUpdatePlans) {
        this.btnUpdatePlans = btnUpdatePlans;
    }

}
