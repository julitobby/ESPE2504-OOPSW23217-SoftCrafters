package ec.edu.espe.eduplanmaven.view;

import javax.swing.JComboBox;
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllPlans = new javax.swing.JTable();
        btnUpdateAllPlans = new javax.swing.JButton();
        cmbPlans2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnExportExcel = new javax.swing.JButton();

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

        jLabel2.setText("ID Maestro:");

        btnExportExcel.setText("Exportar a Excel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPlans2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateAllPlans)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportExcel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlans2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnUpdateAllPlans)
                    .addComponent(btnExportExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnUpdateAllPlans;
    private javax.swing.JComboBox<String> cmbPlans2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    public javax.swing.JButton getBtnExportExcel() {
        return btnExportExcel;
    }

    public void setBtnExportExcel(javax.swing.JButton btnExportExcel) {
        this.btnExportExcel = btnExportExcel;
    }
    public JComboBox<String> getCmbPlans2() {
        return cmbPlans2;
    }

    public void setCmbPlans2(JComboBox<String> cmbPlans2) {
        this.cmbPlans2 = cmbPlans2;
    }
    
}
