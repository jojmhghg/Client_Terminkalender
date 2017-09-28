/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;

import Terminkalender.TerminInhalt;
import Terminkalender.TerminAnlegen;
import Terminkalender.BenutzerException;
import Terminkalender.GUI;
import Terminkalender.LauncherInterface;
import Terminkalender.Termin;
import Terminkalender.TerminException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author niroshan
 */
public class Hauptfenster extends javax.swing.JFrame implements ListSelectionListener {

    private final LauncherInterface stub;
    private int sitzungsID;
    //private DefaultListModel listModel;
    DefaultListModel listModel = new DefaultListModel();
    LinkedList<Termin> dieserMonat;

    /**
     * Creates new form HauptFenster
     *
     * @param stub
     * @param sitzungsID
     */
    public Hauptfenster(LauncherInterface stub, int sitzungsID) {
        initComponents();
        terminInhalt.setVisible(false);
        this.stub = stub;
        this.sitzungsID = sitzungsID;
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

    Hauptfenster() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int terminID;

    public void zeigeTerminInhalt(int day, int monat, int jahr) throws RemoteException, TerminException, BenutzerException {

        //int tag = Integer.parseInt(day);
        //JOptionPane.showMessageDialog(null, day, "InfoBox: day", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, month, "InfoBox: day", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, year, "InfoBox: day", JOptionPane.INFORMATION_MESSAGE);
        dieserMonat = stub.getTermineInMonat(monat, jahr, sitzungsID);
        //titelNachricht.setText(dieserMonat.size() + " Termine im Jahr " + jahr + " im Monat " + monat);

        DefaultListModel legen1 = new DefaultListModel();
        DefaultListModel legen2 = new DefaultListModel();
        DefaultListModel legen3 = new DefaultListModel();
        //for (int i = 0; i < 10; i++) {
        //    legen.addElement(i);
        //}
        listeNachrichtTitel.setModel(legen1);
        listNachrichtDatum.setModel(legen2);
        listNachrichtSonstige.setModel(legen3);

        StringBuilder sb = new StringBuilder();
        StringBuilder cl = new StringBuilder();
        int i = 0;

        for (Termin termin : dieserMonat) {
            //String tag = termin.getDatum().toString().substring(0, 1);

            cl.append(day);
            cl.append(".");
            cl.append(monat);
            cl.append(".");
            cl.append(jahr);

            String calenderDate = cl.toString();
            //JOptionPane.showMessageDialog(null, calenderDate, "InfoBox: stub1", JOptionPane.INFORMATION_MESSAGE);

            String tuiDate = termin.getDatum().toString();
            //JOptionPane.showMessageDialog(null, tuiDate, "InfoBox: 2 Datum", JOptionPane.INFORMATION_MESSAGE);

            if (calenderDate.equals(tuiDate)) {
                legen1.addElement(termin.getTitel());
                legen2.addElement(termin.getDatum().toString() + "  " + termin.getBeginn().toString() + " Uhr bis " + termin.getEnde().toString() + " Uhr");
                legen3.addElement(termin.getOrt());
                i++;
            }
            //JOptionPane.showMessageDialog(null, day, "InfoBox: month in forschlife", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, year, "year in forschleife", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, i, "InfoBox: for in i", JOptionPane.INFORMATION_MESSAGE);

            cl.setLength(0);

            titelNachricht.setText(i + " Termine im Jahr " + jahr + " im Monat " + monat);
        }

        terminInhalt.setVisible(true);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        abmeldenButton = new javax.swing.JButton();
        showProfilButon = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        contactUsernameField = new javax.swing.JTextField();
        showAddKontakt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        refreshContactListButton = new javax.swing.JButton();
        showRemoveKontakt = new javax.swing.JButton();
        neueTermin = new javax.swing.JButton();
        terminInhalt = new javax.swing.JPanel();
        titelNachricht = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeNachrichtTitel = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listNachrichtSonstige = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listNachrichtDatum = new javax.swing.JList<>();
        bearbeitenNachricht = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Termin Kalender");
        setSize(new java.awt.Dimension(800, 600));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kontaktliste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        showAddKontakt.setText("Hinzufügen");
        showAddKontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAddKontaktActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jList1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        refreshContactListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Terminkalender/GUIPart/if_sync-01_186384.png"))); // NOI18N
        refreshContactListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshContactListButtonActionPerformed(evt);
            }
        });

        showRemoveKontakt.setText("Entfernen");
        showRemoveKontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRemoveKontaktActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(contactUsernameField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshContactListButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(showAddKontakt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showRemoveKontakt)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(refreshContactListButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAddKontakt)
                    .addComponent(showRemoveKontakt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        neueTermin.setText("Neue Termin ");
        neueTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neueTerminActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listeNachrichtTitel);

        jScrollPane3.setViewportView(listNachrichtSonstige);

        jScrollPane4.setViewportView(listNachrichtDatum);

        bearbeitenNachricht.setText("bearbeiten");
        bearbeitenNachricht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeitenNachrichtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout terminInhaltLayout = new javax.swing.GroupLayout(terminInhalt);
        terminInhalt.setLayout(terminInhaltLayout);
        terminInhaltLayout.setHorizontalGroup(
            terminInhaltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(terminInhaltLayout.createSequentialGroup()
                .addGroup(terminInhaltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(terminInhaltLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(titelNachricht, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, terminInhaltLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(terminInhaltLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bearbeitenNachricht))
        );
        terminInhaltLayout.setVerticalGroup(
            terminInhaltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(terminInhaltLayout.createSequentialGroup()
                .addGroup(terminInhaltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(terminInhaltLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titelNachricht, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(terminInhaltLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(terminInhaltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(bearbeitenNachricht)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(neueTermin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(showProfilButon)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(abmeldenButton)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(terminInhalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(showProfilButon)
                                    .addComponent(neueTermin)
                                    .addComponent(abmeldenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(terminInhalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)))
                .addContainerGap())
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
                contactUsernameField.setText("");
            } catch (RemoteException | BenutzerException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster - Termin Kalender", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_showAddKontaktActionPerformed

    private void jList1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList1ComponentShown
        try {
            listModel.addElement(stub.getKontakte(sitzungsID));
        } catch (BenutzerException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jList1ComponentShown

    private void abmeldenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmeldenButtonActionPerformed
        ausloggen();
    }//GEN-LAST:event_abmeldenButtonActionPerformed

    private void showProfilButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showProfilButonActionPerformed
        Profil profil;
        profil = new Profil(stub, sitzungsID);
        profil.fillProfil();
        profil.setVisible(true);
    }//GEN-LAST:event_showProfilButonActionPerformed

    private void refreshContactListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshContactListButtonActionPerformed
        try {
            listModel.addElement(stub.getKontakte(sitzungsID));
        } catch (BenutzerException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Kontaktliste aktualisieren - Termin Kalender", JOptionPane.ERROR_MESSAGE);
        }
        //Andere Version
        //int i = 0;
        //        try {
        //            for (String kontakte : stub.getKontakte(sitzungsID)) {
        //                i++;
        //                listModel.addElement(i + " - " + kontakte);
        //            }
        //        } catch (BenutzerException | RemoteException ex) {
        //            Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        jList1.setModel(listModel);
    }//GEN-LAST:event_refreshContactListButtonActionPerformed

    private void neueTerminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neueTerminActionPerformed
        TerminAnlegen startTA = new TerminAnlegen(stub, sitzungsID);
        startTA.setVisible(true);
    }//GEN-LAST:event_neueTerminActionPerformed

    private void bearbeitenNachrichtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeitenNachrichtActionPerformed
        // TODO add your handling code here:
        terminID = listeNachrichtTitel.getSelectedIndex();
        terminID++;
        if (terminID > 0 && terminID <= dieserMonat.size()) {
            TerminInhalt startTI;
            try {
                startTI = new TerminInhalt(dieserMonat.get(terminID - 1).getID(), stub, sitzungsID);
                startTI.setVisible(true);
                startTI.zeigeTerminInhalt();
            } catch (RemoteException | BenutzerException | TerminException ex) {
                Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //terminAnzeigenBearbeiten(dieserMonat.get(terminID - 1).getID());
        }
        //JOptionPane.showMessageDialog(null, selectedText1, "InfoBox: num", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bearbeitenNachrichtActionPerformed

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
    @Override
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
    private javax.swing.JButton bearbeitenNachricht;
    private javax.swing.JTextField contactUsernameField;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JList<String> listNachrichtDatum;
    private javax.swing.JList<String> listNachrichtSonstige;
    private javax.swing.JList<String> listeNachrichtTitel;
    private javax.swing.JButton neueTermin;
    private javax.swing.JButton refreshContactListButton;
    private javax.swing.JButton showAddKontakt;
    private javax.swing.JButton showProfilButon;
    private javax.swing.JButton showRemoveKontakt;
    private javax.swing.JPanel terminInhalt;
    private javax.swing.JLabel titelNachricht;
    // End of variables declaration//GEN-END:variables

}
