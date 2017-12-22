/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;

import Terminkalender.BenutzerException;
import Terminkalender.LauncherInterface;
import java.rmi.RemoteException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * Klasse Profil, die ein Benutzer Profil anzeigt
 * @author Edwrard Nana
 */
public class YourProfil extends javax.swing.JFrame {

    private final LauncherInterface stub;
    private int sitzungsID;
    private String neuerNachname;
    private String neuerVorname;
    private String neueEmail;
    private String altesPW;
    private String neuesPW;

    /**
     * Creates new form Profil
     *
     * @param stub
     * @param sitzungsID
     */
    public YourProfil(LauncherInterface stub, int sitzungsID) {
        initComponents();
        this.stub = stub;
        this.sitzungsID = sitzungsID;
    }

    private YourProfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        vornameField = new javax.swing.JTextField();
        nachnameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        altesPWField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        neuesPWField = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        acceptButton = new javax.swing.JButton();
        abbrButton = new javax.swing.JButton();

        setTitle("Profil - Termin Kalender");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(29, 30, 66));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Benutzername");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 102, 31));

        usernameField.setEditable(false);
        usernameField.setBackground(new java.awt.Color(29, 30, 66));
        usernameField.setForeground(new java.awt.Color(240, 240, 240));
        usernameField.setBorder(null);
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        jPanel3.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 156, 31));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Vorname");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 102, 33));

        vornameField.setBackground(new java.awt.Color(29, 30, 66));
        vornameField.setForeground(new java.awt.Color(240, 240, 240));
        vornameField.setBorder(null);
        jPanel3.add(vornameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 156, 31));

        nachnameField.setBackground(new java.awt.Color(29, 30, 66));
        nachnameField.setForeground(new java.awt.Color(240, 240, 240));
        nachnameField.setBorder(null);
        jPanel3.add(nachnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 156, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Nachname");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 102, 33));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("E-Mail Adresse");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 102, -1));

        emailField.setBackground(new java.awt.Color(29, 30, 66));
        emailField.setForeground(new java.awt.Color(240, 240, 240));
        emailField.setBorder(null);
        jPanel3.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 156, 31));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("altes Passwort");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, 33));

        altesPWField.setBackground(new java.awt.Color(29, 30, 66));
        altesPWField.setForeground(new java.awt.Color(240, 240, 240));
        altesPWField.setBorder(null);
        jPanel3.add(altesPWField, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 220, 150, 33));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("neues Passwort");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, 33));

        neuesPWField.setBackground(new java.awt.Color(29, 30, 66));
        neuesPWField.setForeground(new java.awt.Color(240, 240, 240));
        neuesPWField.setBorder(null);
        jPanel3.add(neuesPWField, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 270, 150, 34));

        jPanel2.setBackground(new java.awt.Color(46, 49, 117));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Terminkalender/GUIPart/if_Account_1891016.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, 173));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Mein Profil");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 350));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 190, 10));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 190, 10));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 190, 10));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 190, 10));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 190, 10));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 190, 10));

        acceptButton.setBackground(new java.awt.Color(46, 49, 117));
        acceptButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        acceptButton.setForeground(new java.awt.Color(240, 240, 240));
        acceptButton.setText("Bestätigen");
        acceptButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });
        jPanel3.add(acceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 140, 30));

        abbrButton.setBackground(new java.awt.Color(46, 49, 117));
        abbrButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        abbrButton.setForeground(new java.awt.Color(240, 240, 240));
        abbrButton.setText("Abbrechen");
        abbrButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        abbrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abbrButtonActionPerformed(evt);
            }
        });
        jPanel3.add(abbrButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        //Not in use 
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        neuerNachname = nachnameField.getText();
        neuerVorname = vornameField.getText();
        neueEmail = emailField.getText();
        altesPW = altesPWField.getText();
        neuesPW = neuesPWField.getText();
        
       // Benutzer pw = new Benutzer();
        //altesPW = pw.getPasswort();
        try {
            if (neuerNachname.length() != 0 && neuerNachname != (stub.getNachname(sitzungsID))) {
                stub.changeNachname(neuerNachname, sitzungsID);
            }
            if (neueEmail.length() != 0 && neueEmail != (stub.getEmail(sitzungsID))) {
                stub.changeEmail(neueEmail, sitzungsID);
            }
            if (neuerVorname.length() != 0 && neueEmail != (stub.getEmail(sitzungsID))) {
                stub.changeVorname(neuerVorname, sitzungsID);
            }
            if (altesPW.length() != 0 && neuesPW.length() != 0) {
                stub.changePasswort(altesPW, neuesPW, sitzungsID);
            } /*else {
                stub.changeNachname(neuerNachname, sitzungsID);
                stub.changeEmail(neueEmail, sitzungsID);
                stub.changeVorname(neuerVorname, sitzungsID);
            }*/
        JOptionPane.showMessageDialog(rootPane, " Ihr Profil wurde aktualisiert", "Profil Änderung" , INFORMATION_MESSAGE);
        dispose();
        } catch (RemoteException | BenutzerException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,ex.getMessage(), "Profil ändern - Termin Kalender", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void abbrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abbrButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_abbrButtonActionPerformed

    /**
     * fuelle die Felder von der Profil Seite
     */
    public void fillProfil(){
        try {
            usernameField.setText(stub.getUsername(sitzungsID));
            vornameField.setText(stub.getVorname(sitzungsID));
            nachnameField.setText(stub.getNachname(sitzungsID));
            emailField.setText(stub.getEmail(sitzungsID));
            //altesPWField.setText(stub.get(sitzungsID));
            
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Profil ändern - Termin Kalender", JOptionPane.ERROR_MESSAGE);
        } catch (BenutzerException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Profil ändern - Termin Kalender", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YourProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YourProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YourProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YourProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YourProfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abbrButton;
    private javax.swing.JButton acceptButton;
    private javax.swing.JPasswordField altesPWField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField nachnameField;
    private javax.swing.JPasswordField neuesPWField;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextField vornameField;
    // End of variables declaration//GEN-END:variables
}
