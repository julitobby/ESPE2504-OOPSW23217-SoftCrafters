package ec.edu.espe.eduplanmaven.view;

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
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdateAllPlans)
                        .addGap(228, 228, 228))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateAllPlans)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateAllPlans;
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

}
