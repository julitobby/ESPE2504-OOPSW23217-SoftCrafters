package ec.edu.espe.eduplanmaven.view;

/**
 *
 * @author SoftCrafters ESPE
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    private static FrmMenuPrincipal instance;

    private FrmMenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public static FrmMenuPrincipal getInstance() {
        if (instance == null) {
            instance = new FrmMenuPrincipal();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PmlTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        showTitleNamePrincipal = new javax.swing.JLabel();
        PmlActions = new javax.swing.JPanel();
        BtmFindTeacher = new javax.swing.JButton();
        BtmFindPlan = new javax.swing.JButton();
        BtmViewPlans = new javax.swing.JButton();
        PmlLogout = new javax.swing.JPanel();
        BtmLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EduPlan para Director");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido Director");

        javax.swing.GroupLayout PmlTitleLayout = new javax.swing.GroupLayout(PmlTitle);
        PmlTitle.setLayout(PmlTitleLayout);
        PmlTitleLayout.setHorizontalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlTitleLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showTitleNamePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PmlTitleLayout.setVerticalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PmlTitleLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(showTitleNamePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BtmFindTeacher.setText("Buscar Maestro");

        BtmFindPlan.setText("Buscar Planificación");

        BtmViewPlans.setText("Ver Planificaciones");

        javax.swing.GroupLayout PmlActionsLayout = new javax.swing.GroupLayout(PmlActions);
        PmlActions.setLayout(PmlActionsLayout);
        PmlActionsLayout.setHorizontalGroup(
            PmlActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PmlActionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PmlActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtmFindPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmFindTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmViewPlans, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(123, 123, 123))
        );
        PmlActionsLayout.setVerticalGroup(
            PmlActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtmFindTeacher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtmFindPlan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtmViewPlans)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtmLogout.setText("Cerrar Sesión");

        javax.swing.GroupLayout PmlLogoutLayout = new javax.swing.GroupLayout(PmlLogout);
        PmlLogout.setLayout(PmlLogoutLayout);
        PmlLogoutLayout.setHorizontalGroup(
            PmlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PmlLogoutLayout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(BtmLogout)
                .addGap(141, 141, 141))
        );
        PmlLogoutLayout.setVerticalGroup(
            PmlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlLogoutLayout.createSequentialGroup()
                .addComponent(BtmLogout)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PmlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PmlActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(PmlLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PmlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PmlActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PmlLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtmFindPlan;
    private javax.swing.JButton BtmFindTeacher;
    private javax.swing.JButton BtmLogout;
    private javax.swing.JButton BtmViewPlans;
    private javax.swing.JPanel PmlActions;
    private javax.swing.JPanel PmlLogout;
    private javax.swing.JPanel PmlTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel showTitleNamePrincipal;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtmFindPlan() {
        return BtmFindPlan;
    }

    public void setBtmFindPlan(javax.swing.JButton BtmFindPlan) {
        this.BtmFindPlan = BtmFindPlan;
    }

    public javax.swing.JButton getBtmFindTeacher() {
        return BtmFindTeacher;
    }

    public void setBtmFindTeacher(javax.swing.JButton BtmFindTeacher) {
        this.BtmFindTeacher = BtmFindTeacher;
    }

    public javax.swing.JButton getBtmLogout() {
        return BtmLogout;
    }

    public void setBtmLogout(javax.swing.JButton BtmLogout) {
        this.BtmLogout = BtmLogout;
    }

    public javax.swing.JButton getBtmViewPlans() {
        return BtmViewPlans;
    }

    public void setBtmViewPlans(javax.swing.JButton BtmViewPlans) {
        this.BtmViewPlans = BtmViewPlans;
    }

    public javax.swing.JLabel getShowTitleNamePrincipal() {
        return showTitleNamePrincipal;
    }

    public void setShowTitleNamePrincipal(javax.swing.JLabel showTitleNamePrincipal) {
        this.showTitleNamePrincipal = showTitleNamePrincipal;
    }


}
