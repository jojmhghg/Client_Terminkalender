/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender.GUIPart;

//import statements
import Terminkalender.LauncherInterface;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;

//create class
class CalenderFrame {
    
    private final LauncherInterface stub;
    private int sitzungsID;
    
    //define variables

    LocalDate ld = LocalDate.now();
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

    //create object of JLabel with alignment
    JLabel l = new JLabel("", JLabel.CENTER);
    //define variable
    String day = "";
    //declaration
    JFrame d;
    //create object of JButton
    JButton[] button = new JButton[49];

    public CalenderFrame(LauncherInterface stub, int sitzungsID)//create constructor 
    {
        this.stub = stub;
        this.sitzungsID = sitzungsID;
        
        //create object
        d = new JFrame();
        //set modal true
        //d.setModal(true);
        //define string
        String[] header = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
        //create JPanel object and set layout
        JPanel p1 = new JPanel(new GridLayout(7, 7));
        //set size
        p1.setPreferredSize(new Dimension(500, 500));
        //for loop condition
        for (int x = 0; x < button.length; x++) {
            //define variable
            final int selection = x;
            //create object of JButton
            button[x] = new JButton();
            //set focus painted false
            button[x].setFocusPainted(false);
            //set background colour
            button[x].setBackground(Color.white);
            //if loop condition
            if (x > 6) //add action listener
            {
                button[x].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        day = button[selection].getActionCommand();
                        //call dispose() method
                        d.dispose();
                    }
                });
            }
            if (x < 7)//if loop condition 
            {
                button[x].setText(header[x]);
                //set fore ground colour
                button[x].setForeground(Color.red);
            }
            p1.add(button[x]);//add button
        }
        //create JPanel object with grid layout
        JPanel p2 = new JPanel(new GridLayout(1, 3));

        //create object of button for previous month
        JButton previous = new JButton("<< Previous");
        //add action command
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //decrement month by 1
                month--;
                //call method
                displayDate();
            }
        });
        p2.add(previous);//add button
        p2.add(l);//add label
        //create object of button for next month
        JButton next = new JButton("Next >>");
        //add action command
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //increment month by 1
                month++;
                //call method
                displayDate();
            }
        });
        p2.add(next);// add next button
        //set border alignment
        d.add(p1, BorderLayout.CENTER);
        d.add(p2, BorderLayout.SOUTH);
        d.pack();
        //set location
        //d.setLocationRelativeTo();
        //call method
        displayDate();
        
        d.setLocationRelativeTo(null);
        //set visible true         
        d.setVisible(true);
    }
    
    
    public void displayDate() {
        for (int x = 7; x < button.length; x++)//for loop
        {
            button[x].setText("");//set text
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-YYYY");
        //create object of SimpleDateFormat 
        java.util.Calendar cal = java.util.Calendar.getInstance();
        //create object of java.util.Calendar 
        cal.set(year, month, 1); //set year, month and date
        //define variables
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        
        String twoLines = "Two\nLines";
        
        //condition
        for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) //set text
        {
            String twooLines = day + "\n\n machi \nLala";
            //String twooLines = "Two\nLines";
            button[x].setText("<html>" + twooLines.replaceAll("\\n", "<br>") + "</html>");
        }
        l.setText(sdf.format(cal.getTime()));
        //set title
        d.setTitle("Date Picker");
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
}
