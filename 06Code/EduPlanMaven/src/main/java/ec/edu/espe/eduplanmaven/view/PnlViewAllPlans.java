package ec.edu.espe.eduplanmaven.view;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
public class PnlViewAllPlans extends javax.swing.JPanel {
    

    private static PnlViewAllPlans instance;

    private PnlViewAllPlans() {
        initComponents();
    }

    public static PnlViewAllPlans getInstance() {
        if (instance == null) {
            instance = new PnlViewAllPlans();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllPlans = new javax.swing.JTable();
        btnUpdateAllPlans = new javax.swing.JButton();
        cmbPlans2 = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setText("PLANIFICACIONES");

        tblAllPlans.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblAllPlans);

        btnUpdateAllPlans.setText("Actualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(btnUpdateAllPlans)
                .addGap(228, 228, 228))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbPlans2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPlans2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateAllPlans)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateAllPlans;
    private javax.swing.JComboBox<String> cmbPlans2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAllPlans;
    // End of variables declaration//GEN-END:variables

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JTable getTblAllPlans() {
        return tblAllPlans;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public void setTblAllPlans(JTable tblAllPlans) {
        this.tblAllPlans = tblAllPlans;
    }

    public javax.swing.JButton getBtnUpdateAllPlans() {
        return btnUpdateAllPlans;
    }

    public void setBtnUpdateAllPlans(javax.swing.JButton btnUpdateAllPlans) {
        this.btnUpdateAllPlans = btnUpdateAllPlans;
    }
    public JComboBox<String> getCmbPlans2() {
        return cmbPlans2;
    }

    public void setCmbPlans2(JComboBox<String> cmbPlans2) {
        this.cmbPlans2 = cmbPlans2;
    }
    
}
