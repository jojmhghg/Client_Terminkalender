/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;

import Terminkalender.BenutzerException;
import Terminkalender.GUI;
import Terminkalender.LauncherInterface;
import Terminkalender.Meldungen;
import Terminkalender.TUI;
import java.awt.Color;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author niroshan
 */
public class Hauptfenster extends javax.swing.JFrame {

    private final LauncherInterface stub;
    private int sitzungsID;
    // private String  username;
    //private DefaultListModel listModel;
    DefaultListModel listModel = new DefaultListModel();

    /**
     * Creates new form HauptFenster
     *
     * @param stub
     * @param sitzungsID
     */
    public Hauptfenster(LauncherInterface stub, int sitzungsID) {
        initComponents();
        this.stub = stub;
        this.sitzungsID = sitzungsID;
        // this.username = username;
        //        listModel = new DefaultListModel();
        //Create the list and put it in a scroll pane.
        //jList1 = new JList(listModel);
        //jList1.setModel((ListModel<String>) stub.getKontakte(sitzungsID));
        //for (String kontakt : stub.getKontakte(sitzungsID)) {
        //kontakt = new ListModel ();
        //  jList1.setModel(listModel);
        //}
        jList1.setModel(listModel);

    }

    private Hauptfenster() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @author Edwrard Nana
     */
    public class MyListModel extends AbstractListModel {

        private final LinkedList<String> list;

        public MyListModel(LinkedList<String> list) {
            this.list = list;
        }

        @Override
        public Object getElementAt(int index) {
            return list.get(index);
        }

        @Override
        public int getSize() {
            return list.size();
        }

    }

    DefaultListModel event = new DefaultListModel();

    public void AddEvent(String eventname) {
        benachList.setModel(event);
        event.addElement(eventname);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        showAddKontakt = new javax.swing.JButton();
        showRemoveKontakt = new javax.swing.JButton();
        contactUsernameField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        abmeldenButton = new javax.swing.JButton();
        showProfilButon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        benachList = new javax.swing.JList<>();
        benachaktuel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Termin Kalender");
        setSize(new java.awt.Dimension(800, 600));

        jList1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jList1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Kontaktliste");

        showAddKontakt.setText("Hinzufügen");
        showAddKontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAddKontaktActionPerformed(evt);
            }
        });

        showRemoveKontakt.setText("Entfernen");
        showRemoveKontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRemoveKontaktActionPerformed(evt);
            }
        });

        abmeldenButton.setText("Abmelden");
        abmeldenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmeldenButtonActionPerformed(evt);
            }
        });

        showProfilButon.setText("Zum Profil");
        showProfilButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showProfilButonActionPerformed(evt);
            }
        });

        benachList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Benachrichtigung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 153, 51)))); // NOI18N
        benachList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                benachListMouseClicked(evt);
            }
        });
        benachList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                benachListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(benachList);

        benachaktuel.setText("Benachrichtigung Aktualisieren");
        benachaktuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benachaktuelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(showAddKontakt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showRemoveKontakt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(benachaktuel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contactUsernameField)))
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showProfilButon)
                        .addGap(17, 17, 17)
                        .addComponent(abmeldenButton))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(abmeldenButton)
                            .addComponent(showProfilButon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contactUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showAddKontakt)
                            .addComponent(showRemoveKontakt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(benachaktuel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showRemoveKontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRemoveKontaktActionPerformed
        RemoveKontakt start = new RemoveKontakt(stub, sitzungsID);
        start.setVisible(true);
        //fillList();

    }//GEN-LAST:event_showRemoveKontaktActionPerformed

    private void showAddKontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAddKontaktActionPerformed
        //AddKontakt start= new AddKontakt(stub,sitzungsID);
        //start.setVisible(true);
        String contact = contactUsernameField.getText();
        if (contact.length() >= 0) {
            try {
                //AddKontakt add = new AddKontakt(stub,sitzungsID);
                stub.addKontakt(contact, sitzungsID);
                listModel.addElement(contact);
            } catch (RemoteException | BenutzerException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_showAddKontaktActionPerformed

    private void jList1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList1ComponentShown
        try {
            stub.getKontakte(sitzungsID);
        } catch (BenutzerException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jList1ComponentShown

    private void abmeldenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmeldenButtonActionPerformed
        ausloggen();
    }//GEN-LAST:event_abmeldenButtonActionPerformed

    private void showProfilButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showProfilButonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showProfilButonActionPerformed

    private void benachaktuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benachaktuelActionPerformed
        DefaultListModel model = new DefaultListModel();
        int i = 0;
        try {
            for (Meldungen meldung : stub.getMeldungen(sitzungsID)) {
                i++;
                /**
                 * if(meldung.getText().length() > 20){ model.addElement(i +" "+
                 * meldung.getText().substring(0, 20)); } else{
                 * model.addElement(i +" "+ meldung.getText()); } 
                *
                 */
                if (meldung.getStatus()) {
                    model.addElement(i + " " + meldung.getText() + "gelesen");

                } else {
                    model.addElement(i + " " + meldung.getText() + "\n ungelesen");

                }
                // String msg = meldung.getText();
                // new EventDet(msg).setVisible(true);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BenutzerException ex) {
            Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
        }

        benachList.setModel(model);
    }//GEN-LAST:event_benachaktuelActionPerformed

    private void benachListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_benachListMouseClicked
        DefaultListModel model2 = new DefaultListModel();
        model2.addElement(benachList.getSelectedValue());
        benachList.setModel(model2);
       
        new EventDet(model2).setVisible(true);

        // String selected=benachList.getSelectedValue().toString();
        //event.set(selected);
        // Meldungen meldung = null ;
        //String msg = meldung.getText();
        // EventDet event = new EventDet();
        //event.setVisible(true);

    }//GEN-LAST:event_benachListMouseClicked

    private void benachListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_benachListValueChanged

    }//GEN-LAST:event_benachListValueChanged

    public void ausloggen() {
        try {
            stub.ausloggen(sitzungsID);
            GUI out = new GUI();
            out.startGUI();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }

//    final void fillList() {
//        listModel = new DefaultListModel();
//        listModel.addElement("Jane Doe");
//        listModel.addElement("John Smith");
//        listModel.addElement("Kathy Green");
//        
//        //Create the list and put it in a scroll pane.
//        jList1 = new JList(listModel);
//        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        jList1.setSelectedIndex(0);
//        jList1.addListSelectionListener(this);
//        jList1.setVisibleRowCount(5);
//        JScrollPane listScrollPane = new JScrollPane(jList1);
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (jList1.getSelectedIndex() == -1) {
                //No selection, disable add button.
                showAddKontakt.setEnabled(false);

            } else {
                //Selection, enable the remove button.
                showRemoveKontakt.setEnabled(true);
            }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hauptfenster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abmeldenButton;
    private javax.swing.JList<String> benachList;
    private javax.swing.JButton benachaktuel;
    private javax.swing.JTextField contactUsernameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton showAddKontakt;
    private javax.swing.JButton showProfilButon;
    private javax.swing.JButton showRemoveKontakt;
    // End of variables declaration//GEN-END:variables

}
