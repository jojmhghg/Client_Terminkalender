/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;

import Terminkalender.BenutzerException;
import Terminkalender.Datum;
import Terminkalender.LauncherInterface;
import Terminkalender.TerminException;
import Terminkalender.Zeit;
import java.awt.Color;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author niroshan
 */
public class Fenster extends javax.swing.JFrame {

    private final LauncherInterface stub;
    private int sitzungsID;

    /**
     * Creates new form Fenster
     *
     * @param stub
     */
    public Fenster(LauncherInterface stub) {
        initComponents();
        this.stub = stub;
        infoBoxPanel.setVisible(false);
        
    }

    private Fenster() {
        //initComponents();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public void zuweisen(String username, String password) throws RemoteException, TerminException, Datum.DatumException, Zeit.ZeitException {

        try{
            sitzungsID = stub.einloggen(username, password);
            if(sitzungsID < 0){
                //JOptionPane.showMessageDialog(null, "Falsches Passwort. Anmelden gescheitert!", "Anmelden", JOptionPane.ERROR_MESSAGE);
                infoBoxText.setText("Falsches Passwort. Anmelden gescheitert!");
                
                //infoBoxPanel.setBackground(new Color(153,0,51));
                infoBoxPanel.setVisible(true);
                
            
            }
            else{
                //JOptionPane.showMessageDialog(null, "Anmeldung erfolgreich!", "anmelden", JOptionPane.INFORMATION_MESSAGE);
                infoBoxText.setText("Anmeldung erfolgreich!");
                
                infoBoxPanel.setBackground(Color.green);
                infoBoxPanel.setVisible(true);
                
                this.setVisible(false);
                
                Hauptfenster start = new Hauptfenster(stub, sitzungsID, this);
                start.setVisible(true);
                start.fillContactList();
                start.fillMeldList();
                
            }  
        }
        catch(BenutzerException e){
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Anmelden", JOptionPane.ERROR_MESSAGE);
            infoBoxText.setText(e.getMessage());
            infoBoxPanel.setVisible(true);
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        regButton = new javax.swing.JButton();
        jBenutzernameField = new javax.swing.JTextField();
        jPasswortField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        infoBoxPanel = new javax.swing.JPanel();
        infoBoxText = new javax.swing.JLabel();
        pwVergessenButton = new javax.swing.JButton();
        anmeldenButton = new javax.swing.JButton();
        beendenButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Termin Kalender");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(29, 30, 66));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(46, 49, 117));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 58)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 30, 66));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kalender");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 370, 200));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Termin ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -30, 370, 200));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.activeCaption);
        jLabel2.setText("Noch kein Account ?");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 306, -1, 40));

        regButton.setBackground(new java.awt.Color(29, 30, 66));
        regButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        regButton.setForeground(new java.awt.Color(240, 240, 240));
        regButton.setText("Registrieren");
        regButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        regButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regButtonActionPerformed(evt);
            }
        });
        jPanel1.add(regButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 309, 140, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 360));

        jBenutzernameField.setBackground(new java.awt.Color(29, 30, 66));
        jBenutzernameField.setForeground(new java.awt.Color(240, 240, 240));
        jBenutzernameField.setBorder(null);
        jBenutzernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBenutzernameFieldActionPerformed(evt);
            }
        });
        jPanel2.add(jBenutzernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 190, 30));

        jPasswortField.setBackground(new java.awt.Color(29, 30, 66));
        jPasswortField.setForeground(new java.awt.Color(240, 240, 240));
        jPasswortField.setBorder(null);
        jPanel2.add(jPasswortField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Passwort");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, 18));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Benutzername");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, 18));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 190, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(46, 49, 117));
        jLabel10.setText("MADE BY ZUSE TEAM 2017");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 300, 20));

        infoBoxPanel.setBackground(new java.awt.Color(153, 0, 51));
        infoBoxPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoBoxText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        infoBoxText.setForeground(new java.awt.Color(240, 240, 240));
        infoBoxText.setText("jLabel3");
        infoBoxPanel.add(infoBoxText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        jPanel2.add(infoBoxPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 230, 40));

        pwVergessenButton.setBackground(new java.awt.Color(46, 49, 117));
        pwVergessenButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pwVergessenButton.setForeground(new java.awt.Color(240, 240, 240));
        pwVergessenButton.setText("Passwort vergessen?");
        pwVergessenButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pwVergessenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwVergessenButtonActionPerformed(evt);
            }
        });
        jPanel2.add(pwVergessenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 160, 20));

        anmeldenButton.setBackground(new java.awt.Color(46, 49, 117));
        anmeldenButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        anmeldenButton.setForeground(new java.awt.Color(240, 240, 240));
        anmeldenButton.setText("Anmelden");
        anmeldenButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        anmeldenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anmeldenButtonActionPerformed(evt);
            }
        });
        jPanel2.add(anmeldenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 160, 40));

        beendenButton.setBackground(new java.awt.Color(46, 49, 117));
        beendenButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        beendenButton.setForeground(new java.awt.Color(240, 240, 240));
        beendenButton.setText("Beenden");
        beendenButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        beendenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beendenButtonActionPerformed(evt);
            }
        });
        jPanel2.add(beendenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 330, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBenutzernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBenutzernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBenutzernameFieldActionPerformed

    private void pwVergessenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwVergessenButtonActionPerformed
        // TODO add your handling code here:
        ForgotPassword resetPW = new ForgotPassword(stub,sitzungsID);
        resetPW.setVisible(true);
    }//GEN-LAST:event_pwVergessenButtonActionPerformed

    private void beendenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beendenButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_beendenButtonActionPerformed

    private void anmeldenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anmeldenButtonActionPerformed
        // TODO add your handling code here:
                
        String username, password;

        username = this.jBenutzernameField.getText();

        password = this.jPasswortField.getText();

        try {
            this.zuweisen(username, password);
         } catch (RemoteException e) {
            JOptionPane.showInputDialog(e.getMessage());
        } catch (TerminException e) {
            JOptionPane.showInputDialog(e.getMessage());
        } catch (Datum.DatumException e) {
            JOptionPane.showInputDialog(e.getMessage());
        } catch (Zeit.ZeitException e) {
            JOptionPane.showInputDialog(e.getMessage());
        }
    }//GEN-LAST:event_anmeldenButtonActionPerformed

    private void regButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButtonActionPerformed
        // TODO add your handling code here:
        Registrieren start = new Registrieren(stub);
        start.setVisible(true);
    }//GEN-LAST:event_regButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Fenster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anmeldenButton;
    private javax.swing.JButton beendenButton;
    private javax.swing.JPanel infoBoxPanel;
    private javax.swing.JLabel infoBoxText;
    private javax.swing.JTextField jBenutzernameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswortField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton pwVergessenButton;
    private javax.swing.JButton regButton;
    // End of variables declaration//GEN-END:variables
}
