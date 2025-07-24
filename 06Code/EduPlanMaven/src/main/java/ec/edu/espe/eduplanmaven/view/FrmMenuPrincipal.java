package ec.edu.espe.eduplanmaven.view;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author SoftCrafters ESPE
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    private static FrmMenuPrincipal instance;

    private FrmMenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        PmlActions.setLayout(new java.awt.CardLayout());
        this.showTitleNamePrincipal.setVerticalAlignment(SwingConstants.CENTER);
        this.showTitleNamePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        this.jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        this.jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
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
        BtmLogout = new javax.swing.JButton();
        PmlActions = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnuViewAllPlans = new javax.swing.JMenuItem();
        MnuViewPlansForTeacher = new javax.swing.JMenuItem();
        MnuIdByPlan = new javax.swing.JMenuItem();
        jMenuReporting = new javax.swing.JMenu();
        MnuMonthlyReportsDirector = new javax.swing.JMenuItem();
        MnuTeacherPerformance = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EduPlan para Director");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido Director");

        showTitleNamePrincipal.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N

        BtmLogout.setText("Cerrar Sesión");

        javax.swing.GroupLayout PmlTitleLayout = new javax.swing.GroupLayout(PmlTitle);
        PmlTitle.setLayout(PmlTitleLayout);
        PmlTitleLayout.setHorizontalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlTitleLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showTitleNamePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtmLogout)
                .addGap(31, 31, 31))
        );
        PmlTitleLayout.setVerticalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtmLogout)
                    .addComponent(jLabel1)
                    .addComponent(showTitleNamePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PmlActions.setPreferredSize(new java.awt.Dimension(265, 450));

        javax.swing.GroupLayout PmlActionsLayout = new javax.swing.GroupLayout(PmlActions);
        PmlActions.setLayout(PmlActionsLayout);
        PmlActionsLayout.setHorizontalGroup(
            PmlActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        PmlActionsLayout.setVerticalGroup(
            PmlActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        jMenu1.setText("Planificaciones");

        MnuViewAllPlans.setText("Ver todas las planificaciones");
        jMenu1.add(MnuViewAllPlans);

        MnuViewPlansForTeacher.setText("Ver planificaciones por docente");
        jMenu1.add(MnuViewPlansForTeacher);

        MnuIdByPlan.setText("Buscar Planificación");
        jMenu1.add(MnuIdByPlan);

        jMenuBar1.add(jMenu1);

        jMenuReporting.setText("Reportes y Análisis");

        MnuMonthlyReportsDirector.setText("Reportes Mensuales Globales");
        jMenuReporting.add(MnuMonthlyReportsDirector);

        MnuTeacherPerformance.setText("Rendimiento por Docente");
        jMenuReporting.add(MnuTeacherPerformance);

        jMenuBar1.add(jMenuReporting);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PmlActions, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jSeparator1))
                            .addComponent(PmlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PmlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PmlActions, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
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
    private javax.swing.JButton BtmLogout;
    private javax.swing.JMenuItem MnuIdByPlan;
    private javax.swing.JMenuItem MnuViewAllPlans;
    private javax.swing.JMenuItem MnuViewPlansForTeacher;
    private javax.swing.JMenuItem MnuMonthlyReportsDirector;
    private javax.swing.JMenuItem MnuTeacherPerformance;
    private javax.swing.JPanel PmlActions;
    private javax.swing.JPanel PmlTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuReporting;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel showTitleNamePrincipal;
    // End of variables declaration//GEN-END:variables


    public javax.swing.JButton getBtmLogout() {
        return BtmLogout;
    }

    public void setBtmLogout(javax.swing.JButton BtmLogout) {
        this.BtmLogout = BtmLogout;
    }

    public javax.swing.JLabel getShowTitleNamePrincipal() {
        return showTitleNamePrincipal;
    }

    public void setShowTitleNamePrincipal(javax.swing.JLabel showTitleNamePrincipal) {
        this.showTitleNamePrincipal = showTitleNamePrincipal;
    }

    public JPanel getPmlActions() {
        return PmlActions;
    }

    public void setPmlActions(JPanel PmlActions) {
        this.PmlActions = PmlActions;
    }

    public JMenuItem getMnuViewAllPlans() {
        return MnuViewAllPlans;
    }

    public void setMnuViewAllPlans(JMenuItem MnuViewAllPlans) {
        this.MnuViewAllPlans = MnuViewAllPlans;
    }

    public JMenuItem getMnuViewPlansForTeacher() {
        return MnuViewPlansForTeacher;
    }

    public void setMnuViewPlansForTeacher(JMenuItem MnuViewPlansForTeacher) {
        this.MnuViewPlansForTeacher = MnuViewPlansForTeacher;
    }

    public JMenuItem getMnuIdByPlan() {
        return MnuIdByPlan;
    }

    public void setMnuIdByPlan(JMenuItem MnuIdByPlan) {
        this.MnuIdByPlan = MnuIdByPlan;
    }

    public JMenuItem getMnuMonthlyReportsDirector() {
        return MnuMonthlyReportsDirector;
    }

    public void setMnuMonthlyReportsDirector(JMenuItem MnuMonthlyReportsDirector) {
        this.MnuMonthlyReportsDirector = MnuMonthlyReportsDirector;
    }

    public JMenuItem getMnuTeacherPerformance() {
        return MnuTeacherPerformance;
    }

    public void setMnuTeacherPerformance(JMenuItem MnuTeacherPerformance) {
        this.MnuTeacherPerformance = MnuTeacherPerformance;
    }
    
    

}
