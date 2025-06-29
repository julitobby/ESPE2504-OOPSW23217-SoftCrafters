package ec.edu.espe.eduplanmaven.view;

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
