/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;



import Terminkalender.Anfrage;
import Terminkalender.BenutzerException;

import javax.swing.DefaultListModel;
import java.awt.*;
import Terminkalender.LauncherInterface;
import Terminkalender.TerminException;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author med
 */
public class EventDet extends javax.swing.JFrame {
    private final LauncherInterface stub;
    private final int sitzungsID;
    private final int index;
    String eventText;
    
    /**
     *
     * @param event
     * @param stub
     * @param sitzungsID
     * @param index
     */
    public EventDet(String event, LauncherInterface stub, int sitzungsID, int index) {
        this.stub=stub;
        this.sitzungsID = sitzungsID;
        this.eventText = event;
        this.index = index;
        
        initComponents();
        eventLabel.setText(eventText);
        
    }
   
    private void terminAnnehmen() throws SQLException, BenutzerException, RemoteException, TerminException{
        stub.terminAnnehmen(((Anfrage) stub.getMeldungen(sitzungsID).get(index)).getTermin().getID(), sitzungsID);
    }
    
    public void terminAblehnen() throws RemoteException, BenutzerException, TerminException, SQLException{
        stub.terminAblehnen(((Anfrage) stub.getMeldungen(sitzungsID).get(index)).getTermin().getID(), sitzungsID);
    }
    
    /**
     *methode zum schliessen von vorherige fenster
     */
    public void fensterClose(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        annehmButton = new javax.swing.JButton();
        ablehnButton = new javax.swing.JButton();
        loechButton = new javax.swing.JButton();
        eventLabel = new javax.swing.JLabel();

        setTitle("Benachrichtigung Event");
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 300));
        setSize(new java.awt.Dimension(500, 250));

        annehmButton.setText("Annehmen");
        annehmButton.setAlignmentY(0.0F);
        annehmButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        annehmButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                annehmButtonStateChanged(evt);
            }
        });
        annehmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annehmButtonActionPerformed(evt);
            }
        });

        ablehnButton.setText("Ablehnen");
        ablehnButton.setAlignmentY(0.0F);
        ablehnButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ablehnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ablehnButtonActionPerformed(evt);
            }
        });

        loechButton.setText("Löschen");
        loechButton.setAlignmentY(0.0F);
        loechButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loechButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loechButtonActionPerformed(evt);
            }
        });

        eventLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        eventLabel.setForeground(new java.awt.Color(153, 153, 255));
        eventLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventLabel.setAlignmentY(0.0F);
        eventLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nachricht", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(102, 102, 255))); // NOI18N
        eventLabel.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        eventLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eventLabel.setMaximumSize(new java.awt.Dimension(0, 50));
        eventLabel.setMinimumSize(new java.awt.Dimension(0, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(annehmButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ablehnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loechButton)
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eventLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(eventLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annehmButton)
                    .addComponent(ablehnButton)
                    .addComponent(loechButton))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void annehmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annehmButtonActionPerformed
        try {
            terminAnnehmen();
            fensterClose();
            JOptionPane.showMessageDialog(null, "Einladung wurde Angennomen");
        } catch (TerminException | SQLException | RemoteException | BenutzerException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_annehmButtonActionPerformed
        DefaultListModel md = new DefaultListModel();
    private void loechButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loechButtonActionPerformed
        try {
            stub.deleteMeldung(index , sitzungsID);
             fensterClose();
            JOptionPane.showMessageDialog(null, "Deine Benachrichtigung Wurde gelöscht");
        } catch (RemoteException | BenutzerException | SQLException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_loechButtonActionPerformed

    private void ablehnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ablehnButtonActionPerformed
        try {
            terminAblehnen();
            fensterClose();
            stub.deleteMeldung(index , sitzungsID);
            JOptionPane.showMessageDialog(null, "Einladung abgelehnt");
        } catch (SQLException | RemoteException | BenutzerException | TerminException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ablehnButtonActionPerformed

    private void annehmButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_annehmButtonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_annehmButtonStateChanged

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
            java.util.logging.Logger.getLogger(EventDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ablehnButton;
    private javax.swing.JButton annehmButton;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JButton loechButton;
    // End of variables declaration//GEN-END:variables
}
