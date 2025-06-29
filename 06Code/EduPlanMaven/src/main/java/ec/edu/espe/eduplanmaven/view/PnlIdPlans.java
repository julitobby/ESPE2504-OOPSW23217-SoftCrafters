package ec.edu.espe.eduplanmaven.view;

/**
 *
 * @author David Bonilla SoftCrafters ESPE
 */
public class PnlIdPlans extends javax.swing.JPanel {

    private static PnlIdPlans instance;

    private PnlIdPlans() {
        initComponents();
    }

    public static PnlIdPlans getInstance() {
        if (instance == null) {
            instance = new PnlIdPlans();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cmbListPlanification = new javax.swing.JComboBox<>();
        BtmFind = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(577, 450));

        jLabel2.setText("Id Planificación:");

        BtmFind.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbListPlanification, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtmFind)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbListPlanification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtmFind))
                .addGap(0, 418, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtmFind;
    private javax.swing.JComboBox<String> cmbListPlanification;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
