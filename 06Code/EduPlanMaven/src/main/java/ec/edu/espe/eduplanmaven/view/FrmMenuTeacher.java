package ec.edu.espe.eduplanmaven.view;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author SoftCrafters ESPE
 */
public class FrmMenuTeacher extends javax.swing.JFrame {

    private static FrmMenuTeacher instance;

    private FrmMenuTeacher() {
        initComponents();
        this.setLocationRelativeTo(null);
        PmlActions.setLayout(new java.awt.CardLayout());
        this.showTitleNameTeacher.setVerticalAlignment(SwingConstants.CENTER);
        this.showTitleNameTeacher.setHorizontalAlignment(SwingConstants.CENTER);
        this.jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        this.jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static FrmMenuTeacher getInstance() {
        if (instance == null) {
            instance = new FrmMenuTeacher();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PmlTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        showTitleNameTeacher = new javax.swing.JLabel();
        BtmLogout = new javax.swing.JButton();
        PmlActions = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnuCreatePlan = new javax.swing.JMenuItem();
        MnuFindPlan = new javax.swing.JMenuItem();
        MnuViewAllPlans = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EduPlan para Maestros");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido Maestro");

        showTitleNameTeacher.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N

        BtmLogout.setText("Cerrar Sesión");

        javax.swing.GroupLayout PmlTitleLayout = new javax.swing.GroupLayout(PmlTitle);
        PmlTitle.setLayout(PmlTitleLayout);
        PmlTitleLayout.setHorizontalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlTitleLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(showTitleNameTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtmLogout)
                .addGap(16, 16, 16))
        );
        PmlTitleLayout.setVerticalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlTitleLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(showTitleNameTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtmLogout, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout PmlActionsLayout = new javax.swing.GroupLayout(PmlActions);
        PmlActions.setLayout(PmlActionsLayout);
        PmlActionsLayout.setHorizontalGroup(
            PmlActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PmlActionsLayout.setVerticalGroup(
            PmlActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );

        jMenu1.setText("Ver");

        MnuCreatePlan.setText("Crear Planificación");
        jMenu1.add(MnuCreatePlan);

        MnuFindPlan.setText("Buscar Planificación");
        jMenu1.add(MnuFindPlan);

        MnuViewAllPlans.setText("Ver todas mis Planificaciones");
        jMenu1.add(MnuViewAllPlans);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PmlActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PmlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jSeparator1)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PmlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PmlActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(FrmMenuTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtmLogout;
    private javax.swing.JMenuItem MnuCreatePlan;
    private javax.swing.JMenuItem MnuFindPlan;
    private javax.swing.JMenuItem MnuViewAllPlans;
    private javax.swing.JPanel PmlActions;
    private javax.swing.JPanel PmlTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel showTitleNameTeacher;
    // End of variables declaration//GEN-END:variables




    public javax.swing.JButton getBtmLogout() {
        return BtmLogout;
    }

    public void setBtmLogout(javax.swing.JButton BtmLogout) {
        this.BtmLogout = BtmLogout;
    }


    public javax.swing.JLabel getShowTitleNameTeacher() {
        return showTitleNameTeacher;
    }

    public void setShowTitleNameTeacher(javax.swing.JLabel showTitleNameTeacher) {
        this.showTitleNameTeacher = showTitleNameTeacher;
    }

    public JMenuItem getMnuCreatePlan() {
        return MnuCreatePlan;
    }

    public void setMnuCreatePlan(JMenuItem MnuCreatePlan) {
        this.MnuCreatePlan = MnuCreatePlan;
    }

    public JMenuItem getMnuFindPlan() {
        return MnuFindPlan;
    }

    public void setMnuFindPlan(JMenuItem MnuFindPlan) {
        this.MnuFindPlan = MnuFindPlan;
    }

    public JMenuItem getMnuViewAllPlans() {
        return MnuViewAllPlans;
    }

    public void setMnuViewAllPlans(JMenuItem MnuViewAllPlans) {
        this.MnuViewAllPlans = MnuViewAllPlans;
    }

    public JPanel getPmlActions() {
        return PmlActions;
    }

    public void setPmlActions(JPanel PmlActions) {
        this.PmlActions = PmlActions;
    }

    
    
}
