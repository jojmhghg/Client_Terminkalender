/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;



import Terminkalender.Anfrage;
import Terminkalender.BenutzerException;
import Terminkalender.Meldungen;

import java.util.LinkedList;

import javax.swing.DefaultListModel;


import Terminkalender.LauncherInterface;
import Terminkalender.TerminException;
import java.awt.MenuComponent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author med
 */
public class EventDet extends javax.swing.JFrame {
    private final LauncherInterface stub;
    private int sitzungsID;
    //private String username;
    /**
     * Creates new form AddKontakt
     * @param stub
     * @param sitzungsID
     */
    public EventDet(LauncherInterface stub, int sitzungsID) {
         initComponents();
        this.stub = stub;
        this.sitzungsID= sitzungsID;
    }
    /**
     *
     * @param event
     */
    public EventDet(DefaultListModel event,LauncherInterface stub) {
        initComponents();
        eventList.setModel(event);
        this.stub=stub;
    }

    private EventDet() {
        initComponents();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private void terminAnnehmen() throws SQLException, BenutzerException, RemoteException, TerminException{
        int eingabe = eventList.getSelectedIndex();
        stub.terminAnnehmen(((Anfrage) stub.getMeldungen(sitzungsID).get(eingabe - 1)).getTermin().getID(), sitzungsID);
        stub.deleteMeldung(eingabe - 1, sitzungsID);
    }
    public void terminAblehnen() throws RemoteException, BenutzerException, TerminException{
        try {
            int eingabe = eventList.getSelectedIndex();
            stub.terminAblehnen(((Anfrage) stub.getMeldungen(sitzungsID).get(eingabe - 1)).getTermin().getID(), sitzungsID);
            stub.deleteMeldung(eingabe - 1, sitzungsID);
        } catch (SQLException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
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

        annehmButton = new javax.swing.JButton();
        ablehnButton = new javax.swing.JButton();
        loechButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventList = new javax.swing.JList<>();

        setTitle("Benachrichtigung Event");
        setBackground(new java.awt.Color(153, 153, 153));

        annehmButton.setText("Annehmen");
        annehmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annehmButtonActionPerformed(evt);
            }
        });

        ablehnButton.setText("Ablehnen");
        ablehnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ablehnButtonActionPerformed(evt);
            }
        });

        loechButton.setText("Löschen");
        loechButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loechButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(eventList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(annehmButton)
                        .addGap(18, 18, 18)
                        .addComponent(ablehnButton)
                        .addGap(41, 41, 41)
                        .addComponent(loechButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annehmButton)
                    .addComponent(ablehnButton)
                    .addComponent(loechButton))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void annehmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annehmButtonActionPerformed
        try {
            int eingabe = eventList.getSelectedIndex();
            stub.terminAnnehmen(((Anfrage) stub.getMeldungen(sitzungsID).get(eingabe)).getTermin().getID(), sitzungsID);
            stub.deleteMeldung(eingabe , sitzungsID);
        } catch (TerminException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BenutzerException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_annehmButtonActionPerformed
        DefaultListModel md = new DefaultListModel();
    private void loechButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loechButtonActionPerformed
        try {
            int eingabe = eventList.getSelectedIndex();
            System.out.println(eingabe);
            // md.removeElementAt(index);
            stub.deleteMeldung(eingabe , sitzungsID);
        } catch (RemoteException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BenutzerException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_loechButtonActionPerformed

    private void ablehnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ablehnButtonActionPerformed
        try {
            int eingabe = eventList.getSelectedIndex();
            stub.terminAblehnen(((Anfrage) stub.getMeldungen(sitzungsID).get(eingabe)).getTermin().getID(), sitzungsID);
            stub.deleteMeldung(eingabe , sitzungsID);
        } catch (SQLException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BenutzerException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TerminException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ablehnButtonActionPerformed

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
                new EventDet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ablehnButton;
    private javax.swing.JButton annehmButton;
    private javax.swing.JList<String> eventList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loechButton;
    // End of variables declaration//GEN-END:variables
}
