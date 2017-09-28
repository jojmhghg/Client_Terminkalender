package Terminkalender;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Terminkalender.BenutzerException;
import Terminkalender.Datum;
import Terminkalender.LauncherInterface;
import Terminkalender.Teilnehmer;
import Terminkalender.TerminException;
import Terminkalender.Zeit;
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
public class TerminInhaltBearbeiten extends javax.swing.JFrame {

    private final LauncherInterface stub;
    private final int sitzungsID;
    private int terminID;
    private Integer tag1S;
    private Integer minute1S;
    private Integer minute2S;
    private Integer stunde1S;
    private Integer stunde2S;
    private Integer monat1S;
    private Integer jahr1S;

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
    public TerminInhaltBearbeiten(int terminID, LauncherInterface stub, int sitzungsID) throws RemoteException, BenutzerException, TerminException {
        initComponents();

        this.terminID = terminID;
        this.stub = stub;
        this.sitzungsID = sitzungsID;

        //zeigeTerminInhalt();
    }

    private TerminInhaltBearbeiten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //.setModel(legen1);
    public void bearbeiteTerminInhalt() throws RemoteException, BenutzerException, TerminException, SQLException, Datum.DatumException, Zeit.ZeitException {
        boolean teilnehmerBOOLEAN = false;
        DefaultListModel legen1 = new DefaultListModel();
        teilnehmerliste.setModel(legen1);

        for (Teilnehmer tn : stub.getTermin(terminID, sitzungsID).getTeilnehmerliste()) {
            if (tn.getUsername().equals(stub.getUsername(sitzungsID))) {
                teilnehmerBOOLEAN = tn.checkIstTeilnehmer();
            }
        }
        tag1.setSelectedItem(stub.getTermin(terminID, sitzungsID).getDatum().toString().substring(0, 1));
        monat1.setSelectedItem(stub.getTermin(terminID, sitzungsID).getDatum().toString().substring(3, 4));
        jahr1.setSelectedItem(stub.getTermin(terminID, sitzungsID).getDatum().toString().substring(6, 9));
        //tag2S = Integer.valueOf((String)tag2.getSelectedItem());
        minute1.setSelectedItem(stub.getTermin(terminID, sitzungsID).getBeginn().toString().substring(3, 4));
        stunde1.setSelectedItem(stub.getTermin(terminID, sitzungsID).getBeginn().toString().substring(0, 1));
        
        minute2.setSelectedItem(stub.getTermin(terminID, sitzungsID).getEnde().toString().substring(3, 4));
        stunde2.setSelectedItem(stub.getTermin(terminID, sitzungsID).getEnde().toString().substring(0, 1));
        
        //monat2S = Integer.valueOf((String)monat2.getSelectedItem());
        

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
        } else {
            notiz.setText(stub.getTermin(terminID, sitzungsID).getNotiz() + "(5)");
        }
        ort.setText(stub.getTermin(terminID, sitzungsID).getOrt());

        terminsteller.setText(stub.getTermin(terminID, sitzungsID).getOwner());
        //System.out.println("Termin löschen");
        //System.out.println("zurück(0)");
        //System.out.print("Eingabe: ");
        notiz.setText(stub.getTermin(terminID, sitzungsID).getNotiz());

        for (Teilnehmer teilnehmer : stub.getTermin(terminID, sitzungsID).getTeilnehmerliste()) {
            //getteilnehmer.setText(teilnehmer.getUsername());

            if (teilnehmer.checkIstTeilnehmer()) {
                legen1.addElement(teilnehmer.getUsername() + " (nimmt Teil)");
            } else {
                legen1.addElement(teilnehmer.getUsername() + " (noch offen)");
            }
        }
        if (!teilnehmerBOOLEAN) {
            //bearbeiten.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        startZeit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        endZeit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teilnehmerliste = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        terminsteller = new javax.swing.JLabel();
        tag1 = new javax.swing.JComboBox<>();
        monat1 = new javax.swing.JComboBox<>();
        jahr1 = new javax.swing.JComboBox<>();
        stunde1 = new javax.swing.JComboBox<>();
        minute1 = new javax.swing.JComboBox<>();
        stunde2 = new javax.swing.JComboBox<>();
        minute2 = new javax.swing.JComboBox<>();
        ort = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        datum = new javax.swing.JLabel();
        startingtime = new javax.swing.JLabel();
        endingtime = new javax.swing.JLabel();
        titel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notiz = new javax.swing.JTextArea();
        speichern = new javax.swing.JButton();
        abbrechen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Datum");

        start.setText("Start Zeit");

        jLabel2.setText("End Zeit");

        jLabel3.setText("Ort");

        jLabel4.setText("Teilnehmer");

        jScrollPane1.setViewportView(teilnehmerliste);

        jLabel5.setText("Terminsteller");

        terminsteller.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        tag1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        tag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tag1ActionPerformed(evt);
            }
        });

        monat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));

        jahr1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));

        stunde1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", " " }));

        minute1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        stunde2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", " " }));

        minute2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));
        minute2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minute2ActionPerformed(evt);
            }
        });

        ort.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        ort.setText("jTextField1");

        jScrollPane3.setViewportView(jList1);

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        datum.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        datum.setText("jLabel7");

        startingtime.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        startingtime.setText("startZeit");

        endingtime.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        endingtime.setText("End");

        titel.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        titel.setText("jTextField1");

        jLabel6.setText("Notiz");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jahr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(start)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(startingtime)
                                                .addComponent(stunde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(22, 22, 22)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(endingtime)
                                                    .addComponent(jLabel2)
                                                    .addComponent(stunde2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(minute1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addComponent(minute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datum)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(ort, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(terminsteller, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(74, 74, 74)
                .addComponent(endZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(titel, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(titel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(start)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datum)
                    .addComponent(startingtime)
                    .addComponent(endingtime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(endZeit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(startZeit, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addGap(10, 10, 10)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jahr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stunde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minute1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stunde2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(25, 25, 25)
                                .addComponent(jButton2)))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(terminsteller, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addComponent(jLabel6)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        notiz.setColumns(20);
        notiz.setRows(5);
        jScrollPane2.setViewportView(notiz);

        speichern.setText("speichern");
        speichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichernActionPerformed(evt);
            }
        });

        abbrechen.setText("abbrechen");
        abbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abbrechenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(speichern)
                        .addGap(26, 26, 26)
                        .addComponent(abbrechen))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abbrechen)
                    .addComponent(speichern))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tag1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tag1ActionPerformed

    private void minute2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minute2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minute2ActionPerformed

    private void speichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichernActionPerformed

        try {
            tag1S = Integer.valueOf((String) tag1.getSelectedItem());
            //tag2S = Integer.valueOf((String)tag2.getSelectedItem());
            minute1S = Integer.valueOf((String) minute1.getSelectedItem());
            minute2S = Integer.valueOf((String) minute2.getSelectedItem());
            stunde1S = Integer.valueOf((String) stunde1.getSelectedItem());
            stunde2S = Integer.valueOf((String) stunde2.getSelectedItem());
            monat1S = Integer.valueOf((String) monat1.getSelectedItem());
            //monat2S = Integer.valueOf((String)monat2.getSelectedItem());
            jahr1S = Integer.valueOf((String) jahr1.getSelectedItem());

            stub.changeTermintitel(terminID, titel.getText(), sitzungsID);
            stub.changeTermindatum(terminID, new Datum(tag1S, monat1S, jahr1S), sitzungsID);
            stub.changeTerminbeginn(terminID, new Zeit(stunde1S, minute1S), sitzungsID);
            stub.changeTerminbeginn(terminID, new Zeit(stunde2S, minute2S), sitzungsID);
            stub.changeTerminort(terminID, ort.getText(), sitzungsID);
            stub.changeTerminnotiz(terminID, notiz.getText(), sitzungsID);
        } catch (BenutzerException | RemoteException | TerminException | SQLException | Datum.DatumException | Zeit.ZeitException ex) {
            Logger.getLogger(TerminInhaltBearbeiten.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_speichernActionPerformed

    private void abbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abbrechenActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_abbrechenActionPerformed

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
            java.util.logging.Logger.getLogger(TerminInhaltBearbeiten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerminInhaltBearbeiten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerminInhaltBearbeiten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerminInhaltBearbeiten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TerminInhaltBearbeiten().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abbrechen;
    private javax.swing.JLabel datum;
    private javax.swing.JLabel endZeit;
    private javax.swing.JLabel endingtime;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jahr1;
    private javax.swing.JComboBox<String> minute1;
    private javax.swing.JComboBox<String> minute2;
    private javax.swing.JComboBox<String> monat1;
    private javax.swing.JTextArea notiz;
    private javax.swing.JTextField ort;
    private javax.swing.JButton speichern;
    private javax.swing.JLabel start;
    private javax.swing.JLabel startZeit;
    private javax.swing.JLabel startingtime;
    private javax.swing.JComboBox<String> stunde1;
    private javax.swing.JComboBox<String> stunde2;
    private javax.swing.JComboBox<String> tag1;
    private javax.swing.JList<String> teilnehmerliste;
    private javax.swing.JLabel terminsteller;
    private javax.swing.JTextField titel;
    // End of variables declaration//GEN-END:variables
}
