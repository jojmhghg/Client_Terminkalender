/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;

import Terminkalender.TerminAnlegen;
import Terminkalender.BenutzerException;
import Terminkalender.Datum;
import Terminkalender.LauncherInterface;
import Terminkalender.Meldungen;
import Terminkalender.Termin;
import Terminkalender.TerminException;
import Terminkalender.TerminInhalt;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    DefaultListModel termineListeModel = new DefaultListModel();
    //DefaultListModel event = new DefaultListModel();
    Fenster fenster;
    LinkedList<Termin> dieserMonat;
    
    //Niros globale Variablen
    LocalDate ld = LocalDate.now();
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    JLabel l = new JLabel("", JLabel.CENTER);
    String day = "";
    JPanel d;
    JButton[] button = new JButton[42];
    int [] tagBekommen = new int[42];
    int daySelector;
   

    /**
     * Creates new form HauptFenster
     * @param stub
     * @param sitzungsID
     * @param fenster
     */
    public Hauptfenster(LauncherInterface stub,int sitzungsID, Fenster fenster) {
        initComponents();
        
        this.stub = stub;
        this.sitzungsID = sitzungsID;
        this.fenster = fenster;
        
        jList1.setModel(listModel);
        termineListe.setModel(termineListeModel);
        daySelector = 0;
        initKalender();
    }
    
    private void initKalender(){
        button[0] = day1;
        button[1] = day2;
        button[2] = day3;
        button[3] = day4;
        button[4] = day5;
        button[5] = day6;
        button[6] = day7;
        button[7] = day8;
        button[8] = day9;
        button[9] = day10;
        button[10] = day11;
        button[11] = day12;
        button[12] = day13;
        button[13] = day14;
        button[14] = day15;
        button[15] = day16;
        button[16] = day17;
        button[17] = day18;
        button[18] = day19;
        button[19] = day20;
        button[20] = day21;
        button[21] = day22;
        button[22] = day23;
        button[23] = day24;
        button[24] = day25;
        button[25] = day26;
        button[26] = day27;
        button[27] = day28;
        button[28] = day29;
        button[29] = day30;
        button[30] = day31;
        button[31] = day32;
        button[32] = day33;
        button[33] = day34;
        button[34] = day35;
        button[35] = day36;
        button[36] = day37;
        button[37] = day38;
        button[38] = day39;
        button[39] = day40;
        button[40] = day41;
        button[41] = day42;
        
        for (int x = 0; x < 42; x++) {
            final int selection = x;
            
            button[x].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        termineListeModel.clear();
                        daySelector = selection;
                        day = button[selection].getActionCommand();
                        
                        int monat1 = month + 1;
                        zeigeTerminInhalt(tagBekommen[selection], monat1, year);
                        //CalenderInhalt start = new CalenderInhalt();
                        //start.setVisible(true);
                    } catch (RemoteException | TerminException | BenutzerException ex) {
                        Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }

        displayDate();

    }
    
        public void zeigeTerminInhalt(int day, int monat, int jahr) throws RemoteException, TerminException, BenutzerException {

        //int tag = Integer.parseInt(day);
        //JOptionPane.showMessageDialog(null, day, "InfoBox: day", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, month, "InfoBox: day", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, year, "InfoBox: day", JOptionPane.INFORMATION_MESSAGE);
        dieserMonat = stub.getTermineInMonat(monat, jahr, sitzungsID);
        //titelNachricht.setText(dieserMonat.size() + " Termine im Jahr " + jahr + " im Monat " + monat);

        //for (int i = 0; i < 10; i++) {
        //    legen.addElement(i);
        //}
        termineListe.setModel(termineListeModel);


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
                termineListeModel.addElement(termin.getTitel()+ " um " + termin.getBeginn().toString());
                i++;
            }
            //JOptionPane.showMessageDialog(null, day, "InfoBox: month in forschlife", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, year, "year in forschleife", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, i, "InfoBox: for in i", JOptionPane.INFORMATION_MESSAGE);

            cl.setLength(0);

            //titelNachricht.setText(i + " Termine im Jahr " + jahr + " im Monat " + monat);
        }

        //terminInhalt.setVisible(true);

    }
    
     public void displayDate() {
        for (int x = 0; x < 42; x++)//for loop
        {
            button[x].setText("");//set text
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM YYYY");
        java.util.Calendar cal = java.util.Calendar.getInstance();
  
        cal.set(year, month, 1);

        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        StringBuilder sb = new StringBuilder();
        StringBuilder cl = new StringBuilder();

        LinkedList<Termin> dieserMonat;

        int monat = month + 1;

        try {
            dieserMonat = stub.getTermineInMonat(monat, year, sitzungsID);

            int i = 1;
            //String zusammen = " ";

            //condition
            for (int x = dayOfWeek - 1, day = 1; day <= daysInMonth; x++, day++) //set text
            {

                for (Termin termin : dieserMonat) {
                    cl.append(day);
                    cl.append(".");
                    cl.append(monat);
                    cl.append(".");
                    cl.append(year);

                    String calenderDate = cl.toString();
                    String tuiDate = termin.getDatum().toString();
 
                    if (calenderDate.equals(tuiDate)) {
                        String titel = termin.getTitel();
                        String[] parts = titel.split(" ");
                        String part1 = parts[0]; // 004
                        String cutString = part1;

                        int length = part1.length();

                        if (length > 10) {
                            cutString = part1.substring(0, 8) + "...";
                        }

                        sb.append(cutString);
                        sb.append("\n");
                    }
                    cl.setLength(0);
                    i++;
                }

                String getSt = sb.toString();
                String twooLines = day + "\n" + getSt;
                if (ld.getDayOfMonth() == day && monat == ld.getMonthValue()) {
                    button[x].setForeground(Color.red);
                }
                
                tagBekommen[x] = day;
                
                button[x].setText("<html>" + twooLines.replaceAll("\\n", "<br>") + "</html>");
                sb.setLength(0);
            }

            dateLabel.setText(sdf.format(cal.getTime()));

            //set title
            //d.setTitle("Date Picker");
        } catch (RemoteException | TerminException | BenutzerException ex) {
            Logger.getLogger(CalenderPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public String setPickedDate() {
        //if condition
        if (day.equals("")) {
            return day;
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(day));
        return sdf.format(cal.getTime());
    }
     
    
     
     /*private void zeigeTerminInhalt() throws RemoteException, TerminException, BenutzerException {
        int i = 0;
        Datum datum = null;
        try {
            for (Termin terminListe : stub.getTermineAmTag(datum, sitzungsID)) {
                i++;
                //termineListe.addElement(termineListeModel);
                termineListeModel.addElement(terminListe);
                
            }
        } catch (BenutzerException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    /**
    * Standart Konstrucktor
    */
    public Hauptfenster() {
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
    
    public void loechEvent(String eventname) {
        benachList.setModel(event);
        event.removeElement(eventname);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        benachList = new javax.swing.JList<>();
        benachaktuel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        contactUsernameField = new javax.swing.JTextField();
        showAddKontakt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        refreshContactListButton = new javax.swing.JButton();
        showRemoveKontakt = new javax.swing.JButton();
        showProfilButon = new javax.swing.JButton();
        abmeldenButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        calendarPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dienstagLabel = new javax.swing.JLabel();
        donnerstagLabel = new javax.swing.JLabel();
        mittwochLabel = new javax.swing.JLabel();
        montagLabel = new javax.swing.JLabel();
        samstagLabel = new javax.swing.JLabel();
        sonntagLabel = new javax.swing.JLabel();
        freitagLabel = new javax.swing.JLabel();
        day8 = new javax.swing.JButton();
        day3 = new javax.swing.JButton();
        day4 = new javax.swing.JButton();
        day5 = new javax.swing.JButton();
        day6 = new javax.swing.JButton();
        day2 = new javax.swing.JButton();
        day7 = new javax.swing.JButton();
        day1 = new javax.swing.JButton();
        day15 = new javax.swing.JButton();
        day29 = new javax.swing.JButton();
        day39 = new javax.swing.JButton();
        day22 = new javax.swing.JButton();
        day30 = new javax.swing.JButton();
        day23 = new javax.swing.JButton();
        day16 = new javax.swing.JButton();
        day9 = new javax.swing.JButton();
        day36 = new javax.swing.JButton();
        day37 = new javax.swing.JButton();
        day10 = new javax.swing.JButton();
        day17 = new javax.swing.JButton();
        day24 = new javax.swing.JButton();
        day31 = new javax.swing.JButton();
        day38 = new javax.swing.JButton();
        day11 = new javax.swing.JButton();
        day18 = new javax.swing.JButton();
        day25 = new javax.swing.JButton();
        day32 = new javax.swing.JButton();
        day40 = new javax.swing.JButton();
        day12 = new javax.swing.JButton();
        day19 = new javax.swing.JButton();
        day13 = new javax.swing.JButton();
        day26 = new javax.swing.JButton();
        day33 = new javax.swing.JButton();
        day34 = new javax.swing.JButton();
        day20 = new javax.swing.JButton();
        day41 = new javax.swing.JButton();
        day42 = new javax.swing.JButton();
        day27 = new javax.swing.JButton();
        day14 = new javax.swing.JButton();
        day21 = new javax.swing.JButton();
        day28 = new javax.swing.JButton();
        day35 = new javax.swing.JButton();
        newTerminButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        termineListe = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Termin Kalender");
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Benachrichtigungen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        benachList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        benachList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                benachListMouseClicked(evt);
            }
        });
        benachList.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                benachListComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(benachList);

        benachaktuel.setText("Benachrichtigung Aktualisieren");
        benachaktuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benachaktuelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(benachaktuel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(benachaktuel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        showProfilButon.setText("Zum Profil");
        showProfilButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showProfilButonActionPerformed(evt);
            }
        });

        abmeldenButton.setText("Abmelden");
        abmeldenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmeldenButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        previousButton.setText("<<");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        dateLabel.setText("Datum:");

        nextButton.setText(">>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(previousButton)
                .addGap(247, 247, 247)
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(nextButton)
                .addGap(22, 22, 22))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(previousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLabel)
                .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dienstagLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dienstagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dienstagLabel.setText("Mo");

        donnerstagLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        donnerstagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        donnerstagLabel.setText("Mi");

        mittwochLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mittwochLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mittwochLabel.setText("Di");

        montagLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        montagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        montagLabel.setText("So");
        montagLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        samstagLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        samstagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        samstagLabel.setText("Fr");

        sonntagLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sonntagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sonntagLabel.setText("Sa");

        freitagLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        freitagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        freitagLabel.setText("Do");

        day8.setBackground(new java.awt.Color(255, 255, 255));
        day8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day3.setBackground(new java.awt.Color(255, 255, 255));
        day3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day4.setBackground(new java.awt.Color(255, 255, 255));
        day4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day5.setBackground(new java.awt.Color(255, 255, 255));
        day5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        day5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day5ActionPerformed(evt);
            }
        });

        day6.setBackground(new java.awt.Color(255, 255, 255));
        day6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        day6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day6ActionPerformed(evt);
            }
        });

        day2.setBackground(new java.awt.Color(255, 255, 255));
        day2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day7.setBackground(new java.awt.Color(255, 255, 255));
        day7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day1.setBackground(new java.awt.Color(255, 255, 255));
        day1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day15.setBackground(new java.awt.Color(255, 255, 255));
        day15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day29.setBackground(new java.awt.Color(255, 255, 255));
        day29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day39.setBackground(new java.awt.Color(255, 255, 255));
        day39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day22.setBackground(new java.awt.Color(255, 255, 255));
        day22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day30.setBackground(new java.awt.Color(255, 255, 255));
        day30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day23.setBackground(new java.awt.Color(255, 255, 255));
        day23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day16.setBackground(new java.awt.Color(255, 255, 255));
        day16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        day16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day16ActionPerformed(evt);
            }
        });

        day9.setBackground(new java.awt.Color(255, 255, 255));
        day9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        day9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day9ActionPerformed(evt);
            }
        });

        day36.setBackground(new java.awt.Color(255, 255, 255));
        day36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        day36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day36ActionPerformed(evt);
            }
        });

        day37.setBackground(new java.awt.Color(255, 255, 255));
        day37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day10.setBackground(new java.awt.Color(255, 255, 255));
        day10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day17.setBackground(new java.awt.Color(255, 255, 255));
        day17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day24.setBackground(new java.awt.Color(255, 255, 255));
        day24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day31.setBackground(new java.awt.Color(255, 255, 255));
        day31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day38.setBackground(new java.awt.Color(255, 255, 255));
        day38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day11.setBackground(new java.awt.Color(255, 255, 255));
        day11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day18.setBackground(new java.awt.Color(255, 255, 255));
        day18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day25.setBackground(new java.awt.Color(255, 255, 255));
        day25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        day25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day25ActionPerformed(evt);
            }
        });

        day32.setBackground(new java.awt.Color(255, 255, 255));
        day32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day40.setBackground(new java.awt.Color(255, 255, 255));
        day40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day12.setBackground(new java.awt.Color(255, 255, 255));
        day12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day19.setBackground(new java.awt.Color(255, 255, 255));
        day19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day13.setBackground(new java.awt.Color(255, 255, 255));
        day13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day26.setBackground(new java.awt.Color(255, 255, 255));
        day26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day33.setBackground(new java.awt.Color(255, 255, 255));
        day33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day34.setBackground(new java.awt.Color(255, 255, 255));
        day34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day20.setBackground(new java.awt.Color(255, 255, 255));
        day20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day41.setBackground(new java.awt.Color(255, 255, 255));
        day41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day42.setBackground(new java.awt.Color(255, 255, 255));
        day42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day27.setBackground(new java.awt.Color(255, 255, 255));
        day27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day14.setBackground(new java.awt.Color(255, 255, 255));
        day14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day21.setBackground(new java.awt.Color(255, 255, 255));
        day21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day28.setBackground(new java.awt.Color(255, 255, 255));
        day28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        day35.setBackground(new java.awt.Color(255, 255, 255));
        day35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(day29, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(day30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(montagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(day8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(day15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(day22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(day1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(day36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dienstagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(day2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(day3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mittwochLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(day10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(day4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(donnerstagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(day39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(day40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(freitagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(day12, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(day19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(day6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(samstagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(day13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(day7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sonntagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(day42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dienstagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mittwochLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donnerstagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(freitagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(samstagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sonntagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(day8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(day15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day21, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(day22, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(day24, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(day25, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(day26, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(day27, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(day28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(day29, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day36, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(day30, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day37, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(day31, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(day32, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day39, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(day33, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(day34, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(day40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(day41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(day35, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day42, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(day23, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(day16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calendarPanelLayout.createSequentialGroup()
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        newTerminButton.setText("Neuen Termin");
        newTerminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTerminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(newTerminButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showProfilButon)
                        .addGap(17, 17, 17)
                        .addComponent(abmeldenButton))
                    .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(29, 29, 29)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(abmeldenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(showProfilButon)
                                        .addComponent(newTerminButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alle Termine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        termineListe.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        termineListe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                termineListeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                termineListeMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(termineListe);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showRemoveKontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRemoveKontaktActionPerformed
        //RemoveKontakt start = new RemoveKontakt(stub,sitzungsID);
        //start.setVisible(true);
        int selectedIndex = jList1.getSelectedIndex();
        int size = listModel.getSize();
        if (selectedIndex != -1){
            try {
                stub.removeKontakt(listModel.get(selectedIndex).toString(), sitzungsID);
                listModel.remove(selectedIndex);
                selectedIndex--;
            } catch (BenutzerException | RemoteException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Kontakt entfernen - Termin Kalender", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (size == 0){
            showRemoveKontakt.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Die Liste ist doch leer !", "Hauptfenster - Termin Kalender", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Ein Problem ist aufgetretten", "Kontakt entfernen - Termin Kalender", JOptionPane.WARNING_MESSAGE);
        }
        
        //fillList();
        
    }//GEN-LAST:event_showRemoveKontaktActionPerformed

    private void showAddKontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAddKontaktActionPerformed
        //AddKontakt start= new AddKontakt(stub,sitzungsID);
        //start.setVisible(true);
        String contact = contactUsernameField.getText();
        if (contact.length() > 0) {
            try {
                //if (contact.length() >= 0) {
                //AddKontakt add = new AddKontakt(stub,sitzungsID);
                stub.addKontakt(contact, sitzungsID);
                listModel.addElement(contact);
                contactUsernameField.setText("");
            } catch (RemoteException | BenutzerException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Kontakt hinzufügen - Termin Kalender", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Geben Sie bitte einen gültigen Benutzername an", "Hauptfenster - Termin Kalender", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_showAddKontaktActionPerformed

    private void jList1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList1ComponentShown
//        int i = 0;
//         //LinkedList<String> contactListe = stub.getKontakte(sitzungsID);
//        try {
//            for(String contactListe : stub.getKontakte(sitzungsID)){
//                i++;
//            listModel.addElement(contactListe);
//            //listModel.addElement(stub.getKontakte(sitzungsID));
//            }
//        } catch (BenutzerException | RemoteException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
//        }
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
//        try {
//            listModel.addElement(stub.getKontakte(sitzungsID));
//        } catch (BenutzerException | RemoteException ex) {
//            JOptionPane.showMessageDialog(null,ex.getMessage(), "Kontaktliste aktualisieren - Termin Kalender", JOptionPane.ERROR_MESSAGE);
//        }
        //Andere Version
        int i = 0;
                try {
                    for (String kontakte : stub.getKontakte(sitzungsID)) {
                        i++;
                        listModel.addElement(i + " - " + kontakte);
                    }
                } catch (BenutzerException | RemoteException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(), "Kontaktliste aktualisieren - Termin Kalender", JOptionPane.ERROR_MESSAGE);
                }
                jList1.setModel(listModel);
    }//GEN-LAST:event_refreshContactListButtonActionPerformed

    private void benachListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_benachListMouseClicked
        //DefaultListModel model2 = new DefaultListModel();
        //model2.addElement(benachList.getSelectedValue());  

        new EventDet(benachList.getSelectedValue(), stub, sitzungsID, benachList.getSelectedIndex()).setVisible(true);

    }//GEN-LAST:event_benachListMouseClicked
    
    private void benachaktuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benachaktuelActionPerformed
        DefaultListModel model = new DefaultListModel();
        int i=0 ;
            try {
            for (Meldungen meldung : stub.getMeldungen(sitzungsID)) {
                i++;
                if (meldung.getStatus()) {
                    model.addElement(i + "-" + meldung.getText());

                } else {
                    model.addElement(i + "-" + meldung.getText());
                }

            }
                
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Benachrichtigungen aktualisierung", JOptionPane.ERROR_MESSAGE);
            } catch (BenutzerException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Benachrichtigungen aktualisierung", JOptionPane.ERROR_MESSAGE);
            }
        
        benachList.setModel(model);
    }//GEN-LAST:event_benachaktuelActionPerformed

    private void benachListComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_benachListComponentShown
        
    }//GEN-LAST:event_benachListComponentShown

    private void day6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_day6ActionPerformed

    private void day5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_day5ActionPerformed

    private void day16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_day16ActionPerformed

    private void day9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_day9ActionPerformed

    private void day36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_day36ActionPerformed

    private void day25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_day25ActionPerformed

    private void newTerminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTerminButtonActionPerformed
        TerminAnlegen startTA = new TerminAnlegen(stub, sitzungsID, this);
        startTA.setVisible(true);
    }//GEN-LAST:event_newTerminButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        month--;
        displayDate();
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        month++;
        displayDate();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void termineListeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_termineListeMouseClicked
        try {
            final int selection = daySelector;
            int terminID = stub.getTermineAmTag(new Datum(tagBekommen[selection],month+1,year), sitzungsID).get(termineListe.getSelectedIndex()).getID();
            
            new TerminInhalt(terminID, stub, sitzungsID).setVisible(true);
        } catch (RemoteException | BenutzerException | TerminException | Datum.DatumException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_termineListeMouseClicked

    private void termineListeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_termineListeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_termineListeMouseEntered

    public void ausloggen(){
        try {
            
            stub.ausloggen(sitzungsID);
            //this.setVisible(false);
            this.dispose();
            this.fenster.setVisible(true);
            /*GUI out = new GUI();
            out.startGUI();         */
            } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     *  Fuele Kontaktliste auf
     */
    public void fillContactList() {
        int i = 0;
        try {
            for (String contactListe : stub.getKontakte(sitzungsID)) {
                i++;
                listModel.addElement(contactListe);
                //listModel.addElement(stub.getKontakte(sitzungsID));
            }
        } catch (BenutzerException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     /**
     * Fuele Meldung liste auf
     */
    public void fillMeldList() {
        DefaultListModel modelMeldung = new DefaultListModel();
        int i = 0;
        try {
            for (Meldungen meldungsListe : stub.getMeldungen(sitzungsID)) {
                i++;
                modelMeldung.addElement(meldungsListe);
            }
        } catch (BenutzerException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hauptfenster", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
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
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JTextField contactUsernameField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton day1;
    private javax.swing.JButton day10;
    private javax.swing.JButton day11;
    private javax.swing.JButton day12;
    private javax.swing.JButton day13;
    private javax.swing.JButton day14;
    private javax.swing.JButton day15;
    private javax.swing.JButton day16;
    private javax.swing.JButton day17;
    private javax.swing.JButton day18;
    private javax.swing.JButton day19;
    private javax.swing.JButton day2;
    private javax.swing.JButton day20;
    private javax.swing.JButton day21;
    private javax.swing.JButton day22;
    private javax.swing.JButton day23;
    private javax.swing.JButton day24;
    private javax.swing.JButton day25;
    private javax.swing.JButton day26;
    private javax.swing.JButton day27;
    private javax.swing.JButton day28;
    private javax.swing.JButton day29;
    private javax.swing.JButton day3;
    private javax.swing.JButton day30;
    private javax.swing.JButton day31;
    private javax.swing.JButton day32;
    private javax.swing.JButton day33;
    private javax.swing.JButton day34;
    private javax.swing.JButton day35;
    private javax.swing.JButton day36;
    private javax.swing.JButton day37;
    private javax.swing.JButton day38;
    private javax.swing.JButton day39;
    private javax.swing.JButton day4;
    private javax.swing.JButton day40;
    private javax.swing.JButton day41;
    private javax.swing.JButton day42;
    private javax.swing.JButton day5;
    private javax.swing.JButton day6;
    private javax.swing.JButton day7;
    private javax.swing.JButton day8;
    private javax.swing.JButton day9;
    private javax.swing.JLabel dienstagLabel;
    private javax.swing.JLabel donnerstagLabel;
    private javax.swing.JLabel freitagLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mittwochLabel;
    private javax.swing.JLabel montagLabel;
    private javax.swing.JButton newTerminButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton refreshContactListButton;
    private javax.swing.JLabel samstagLabel;
    private javax.swing.JButton showAddKontakt;
    private javax.swing.JButton showProfilButon;
    private javax.swing.JButton showRemoveKontakt;
    private javax.swing.JLabel sonntagLabel;
    private javax.swing.JList<String> termineListe;
    // End of variables declaration//GEN-END:variables

    
}
