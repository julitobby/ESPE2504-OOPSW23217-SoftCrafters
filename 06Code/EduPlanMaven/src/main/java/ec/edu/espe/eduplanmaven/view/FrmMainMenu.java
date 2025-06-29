package ec.edu.espe.eduplanmaven.view;

import javax.swing.JButton;

/**
 *
 * @author SoftCrafters ESPE
 */
public class FrmMainMenu extends javax.swing.JFrame {

    private static FrmMainMenu instance;

    private FrmMainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public static FrmMainMenu getInstance() {
        if (instance == null) {
            instance = new FrmMainMenu();
        }
        return instance;
    }

    public void showMainMenu(FrmMainMenu frmMainMenu) {
        new javax.swing.Timer(2000, e -> {
            frmMainMenu.setVisible(true);
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PmlMain = new javax.swing.JPanel();
        PmlOptions = new javax.swing.JPanel();
        BtmLogin = new javax.swing.JButton();
        BtmRegister = new javax.swing.JButton();
        PmlTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PmlExit = new javax.swing.JPanel();
        BtmExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EduPlan v2.0");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PmlMain.setBackground(new java.awt.Color(255, 255, 255));

        PmlOptions.setBackground(new java.awt.Color(255, 255, 255));

        BtmLogin.setText("Iniciar Sesion");

        BtmRegister.setText("Registrarse");

        javax.swing.GroupLayout PmlOptionsLayout = new javax.swing.GroupLayout(PmlOptions);
        PmlOptions.setLayout(PmlOptionsLayout);
        PmlOptionsLayout.setHorizontalGroup(
            PmlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PmlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtmRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PmlOptionsLayout.setVerticalGroup(
            PmlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlOptionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtmLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtmRegister))
        );

        PmlTitle.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\david\\Documents\\GitHub - University\\ESPE2504-OOPSW23217-SoftCrafters\\06Code\\EduPlanMaven\\src\\main\\java\\ec\\edu\\espe\\eduplanmaven\\resources\\LogoEP.png")); // NOI18N

        javax.swing.GroupLayout PmlTitleLayout = new javax.swing.GroupLayout(PmlTitle);
        PmlTitle.setLayout(PmlTitleLayout);
        PmlTitleLayout.setHorizontalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlTitleLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PmlTitleLayout.setVerticalGroup(
            PmlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PmlExit.setBackground(new java.awt.Color(255, 255, 255));

        BtmExit.setText("Salir");
        BtmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PmlExitLayout = new javax.swing.GroupLayout(PmlExit);
        PmlExit.setLayout(PmlExitLayout);
        PmlExitLayout.setHorizontalGroup(
            PmlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlExitLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BtmExit, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        PmlExitLayout.setVerticalGroup(
            PmlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlExitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtmExit)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PmlMainLayout = new javax.swing.GroupLayout(PmlMain);
        PmlMain.setLayout(PmlMainLayout);
        PmlMainLayout.setHorizontalGroup(
            PmlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlMainLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(PmlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PmlOptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PmlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PmlExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        PmlMainLayout.setVerticalGroup(
            PmlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PmlMainLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(PmlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PmlOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PmlExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PmlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PmlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CODE OF ACTIONS

    private void BtmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtmExitActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtmExit;
    private javax.swing.JButton BtmLogin;
    private javax.swing.JButton BtmRegister;
    private javax.swing.JPanel PmlExit;
    private javax.swing.JPanel PmlMain;
    private javax.swing.JPanel PmlOptions;
    private javax.swing.JPanel PmlTitle;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtmLogin() {
        return BtmLogin;
    }

    public JButton getBtmRegister() {
        return BtmRegister;
    }

}
