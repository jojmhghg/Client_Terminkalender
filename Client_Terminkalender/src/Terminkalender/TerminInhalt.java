package Terminkalender;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Terminkalender.BenutzerException;
import Terminkalender.LauncherInterface;
import Terminkalender.Teilnehmer;
import Terminkalender.TerminException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author niroshan
 */
public class TerminInhalt extends javax.swing.JFrame {

    private final LauncherInterface stub;
    private final int sitzungsID;
    private int terminID;
    DefaultListModel teilnehmerListeModel = new DefaultListModel();

    /**
     * Creates new form CalenderInhalt
     *
     * @param terminID
     * @param stub
     * @param sitzungsID
     * @throws java.rmi.RemoteException
     * @throws Terminkalender.BenutzerException
     * @throws Terminkalender.TerminException
     */
    public TerminInhalt(int terminID, LauncherInterface stub, int sitzungsID) throws RemoteException, BenutzerException, TerminException {
        initComponents();

        this.terminID = terminID;
        this.stub = stub;
        this.sitzungsID = sitzungsID;
        datum.setText(stub.getTermin(terminID, sitzungsID).getDatum().toString());
        titel.setText(stub.getTermin(terminID, sitzungsID).getTitel());
        startZeit.setText(stub.getTermin(terminID, sitzungsID).getBeginn().toString() + " Uhr");
        endZeit.setText(stub.getTermin(terminID, sitzungsID).getEnde().toString() + " Uhr");
        ort.setText(stub.getTermin(terminID, sitzungsID).getOrt());
        terminersteller.setText(stub.getTermin(terminID, sitzungsID).getOwner());
        teilnehmerliste.setModel(teilnehmerListeModel);
        notiz.setText(stub.getTermin(terminID, sitzungsID).getNotiz());
        fillTeilnehmerlist();

    }
    
    private void fillTeilnehmerlist() throws RemoteException, BenutzerException, TerminException{
        teilnehmerListeModel.clear();
        for(Teilnehmer teilnehmer : stub.getTermin(terminID, sitzungsID).getTeilnehmerliste()){
            if(teilnehmer.checkIstTeilnehmer()){
                teilnehmerListeModel.addElement(teilnehmer.getUsername() + " (nimmt Teil)" );
            }
            else{
                teilnehmerListeModel.addElement(teilnehmer.getUsername() + " (offen)");
            }
            
        }
    }

    private TerminInhalt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //.setModel(legen1);
    
    
    public void zeigeTerminInhalt() throws RemoteException, BenutzerException, TerminException {
        boolean teilnehmerBoolean = false;
        DefaultListModel legen1 = new DefaultListModel();
        teilnehmerliste.setModel(legen1);

        for (Teilnehmer tn : stub.getTermin(terminID, sitzungsID).getTeilnehmerliste()) {
            if (tn.getUsername().equals(stub.getUsername(sitzungsID))) {
                teilnehmerBoolean = tn.checkIstTeilnehmer();
            }
        }

        
            titel.setText(stub.getTermin(terminID, sitzungsID).getTitel());
            JOptionPane.showMessageDialog(null, stub.getTermin(terminID, sitzungsID).getTitel(), "InfoBox: titel", JOptionPane.INFORMATION_MESSAGE);
            datum.setText(stub.getTermin(terminID, sitzungsID).getDatum().toString());
            
            startZeit.setText(stub.getTermin(terminID, sitzungsID).getBeginn().toString());
            endZeit.setText(stub.getTermin(terminID, sitzungsID).getEnde().toString());
            
            if (stub.getTermin(terminID, sitzungsID).getNotiz().length() > 20) {
                notiz.setText(stub.getTermin(terminID, sitzungsID).getNotiz().substring(0, 20) + "...(5)");
            } 
            
            if (stub.getTermin(terminID, sitzungsID).getEditierbar()) {
                //TODO SETBUTTON
                System.out.println("Bearbeitungsrecht: Jeder");
            }
            
            else {
                notiz.setText(stub.getTermin(terminID, sitzungsID).getNotiz() + "(5)");
            }
            ort.setText(stub.getTermin(terminID, sitzungsID).getOrt());
                      
            terminersteller.setText(stub.getTermin(terminID, sitzungsID).getOwner());
            //System.out.println("Termin löschen");
            //System.out.println("zurück(0)");
            //System.out.print("Eingabe: ");
            notiz.setText(stub.getTermin(terminID, sitzungsID).getNotiz());
            
            for(Teilnehmer teilnehmer : stub.getTermin(terminID, sitzungsID).getTeilnehmerliste()){
                //getteilnehmer.setText(teilnehmer.getUsername());
                
                
                if(teilnehmer.checkIstTeilnehmer()){
                    legen1.addElement(teilnehmer.getUsername() + " (nimmt Teil)");
                }
                else{
                    legen1.addElement(teilnehmer.getUsername() + " (noch offen)");
                }
            }
        if (!teilnehmerBoolean) {
            bearbeiten.setVisible(false);
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

        jPanel1 = new javax.swing.JPanel();
        titel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        datum = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        startZeit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        endZeit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ort = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teilnehmerliste = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        terminersteller = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notiz = new javax.swing.JTextArea();
        bearbeiten = new javax.swing.JButton();
        abbrechen = new javax.swing.JButton();
        addTeilnehmerTextField = new javax.swing.JTextField();
        addTeilnehmerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titel.setFont(new java.awt.Font("Noto Sans", 0, 36)); // NOI18N
        titel.setText("Titel");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Datum");

        datum.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        datum.setText("datum");

        start.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        start.setText("Start Zeit");

        startZeit.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        startZeit.setText("startZeit");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("End Zeit");

        endZeit.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        endZeit.setText("endZeit");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ort");

        ort.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        ort.setText("Ort");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Teilnehmer");

        teilnehmerliste.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(teilnehmerliste);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Terminersteller");

        terminersteller.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        terminersteller.setText("ersteller");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Notizen");

        notiz.setEditable(false);
        notiz.setColumns(20);
        notiz.setRows(5);
        jScrollPane2.setViewportView(notiz);

        bearbeiten.setText("bearbeiten");
        bearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeitenActionPerformed(evt);
            }
        });

        abbrechen.setText("abbrechen");
        abbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abbrechenActionPerformed(evt);
            }
        });

        addTeilnehmerTextField.setToolTipText("");
        addTeilnehmerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeilnehmerTextFieldActionPerformed(evt);
            }
        });

        addTeilnehmerButton.setText("+");
        addTeilnehmerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeilnehmerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bearbeiten)
                        .addGap(52, 52, 52)
                        .addComponent(abbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addGap(270, 270, 270))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(132, 339, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(titel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(startZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(endZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ort, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(terminersteller, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(93, 143, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(addTeilnehmerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addTeilnehmerButton))
                                    .addComponent(jLabel4))
                                .addGap(0, 9, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(titel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(startZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ort, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(terminersteller, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addTeilnehmerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addTeilnehmerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bearbeiten)
                    .addComponent(abbrechen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abbrechenActionPerformed
        this.dispose();
    }//GEN-LAST:event_abbrechenActionPerformed

    private void bearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeitenActionPerformed
/*        try {
            // TODO add your handling code here:
            TerminInhaltBearbeiten tIB = new TerminInhaltBearbeiten(terminID, stub, sitzungsID);
            this.dispose();
            tIB.setVisible(true);
            tIB.bearbeiteTerminInhalt();
        } catch (RemoteException | BenutzerException | TerminException | SQLException | Datum.DatumException | Zeit.ZeitException ex) {
            Logger.getLogger(TerminInhalt.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_bearbeitenActionPerformed

    private void addTeilnehmerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeilnehmerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTeilnehmerTextFieldActionPerformed

    private void addTeilnehmerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeilnehmerButtonActionPerformed
        String username = addTeilnehmerTextField.getText();
        if (username.length() > 0) {
            try {
                stub.addTerminteilnehmer(terminID, username, sitzungsID);
                fillTeilnehmerlist();
                addTeilnehmerTextField.setText("");
                
            } catch (RemoteException | BenutzerException | SQLException | TerminException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Teilnehmer hinzufügen - Terminansicht", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }//GEN-LAST:event_addTeilnehmerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TerminInhalt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerminInhalt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerminInhalt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerminInhalt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TerminInhalt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abbrechen;
    private javax.swing.JButton addTeilnehmerButton;
    private javax.swing.JTextField addTeilnehmerTextField;
    private javax.swing.JButton bearbeiten;
    private javax.swing.JLabel datum;
    private javax.swing.JLabel endZeit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea notiz;
    private javax.swing.JLabel ort;
    private javax.swing.JLabel start;
    private javax.swing.JLabel startZeit;
    private javax.swing.JList<String> teilnehmerliste;
    private javax.swing.JLabel terminersteller;
    private javax.swing.JLabel titel;
    // End of variables declaration//GEN-END:variables
}
