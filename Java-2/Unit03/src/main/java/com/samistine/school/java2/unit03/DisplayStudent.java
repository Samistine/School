package com.samistine.school.java2.unit03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit03
 * Date: Created Sep 13, 2016 7:18:53 PM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class DisplayStudent extends JFrame {

    String database_name;

    MenuBar menu;
    StudentPanel studentPanel;

    public DisplayStudent() throws HeadlessException {
        super.setLayout(new BorderLayout());//Orgainize content like a compass
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//If user clicks RED X allow the application to self destruct
        super.setSize(600, 400);//Give it a good default size so it's not smushed

        /* Create new menu item instances */
        this.menu = new MenuBar();
        this.studentPanel = new StudentPanel(new BorderLayout());

        /* Add the menu items to this frame */
        super.setJMenuBar(menu);
        super.add(studentPanel, BorderLayout.CENTER);
    }

    class MenuBar extends JMenuBar {

        /* Menus */
        FileMenu fileMenu = new FileMenu();
        EditMenu editMenu = new EditMenu();

        public MenuBar() {
            /* Add the menus to the menu bar :P */
            super.add(fileMenu);
            super.add(editMenu);
        }

        class FileMenu extends JMenu {

            /* Menu Items */
            JMenuItem connect = new JMenuItem("Connect");
            JMenuItem close = new JMenuItem("Close");
            JMenuItem exit = new JMenuItem("Exit");

            public FileMenu() {
                /* Set the name of this menu */
                super("File");

                /* Keyboard Shortcuts */
                super.setMnemonic('f');
                this.connect.setMnemonic('c');
                this.close.setMnemonic('l');
                this.exit.setMnemonic('x');

                /* Add the menu items to the menu :P */
                super.add(connect);
                super.add(close);
                super.add(exit);

                /* Connect Button -> Click Logic */
                this.connect.addActionListener(e -> {
                    System.out.println("connect");
                    database_name = JOptionPane.showInputDialog("What database do you wish to connect to?");
                    if (database_name != null && !database_name.isEmpty()) {
                        System.out.println("Connecting to Database: " + database_name);
                        studentPanel.statusPanel.connection.setText("Connected to " + database_name);
                    }
                });

                /* Close Button -> Click Logic */
                this.close.addActionListener(e -> {
                    System.out.println("close");
                    //Ask user if they are sure they wan't to close the connection
                    int response = JOptionPane.showConfirmDialog(DisplayStudent.this, "Are you sure you want to close the connection?", "Confirm Connection Closure", JOptionPane.YES_NO_OPTION);
                    //If yes then we do so
                    if (response == JOptionPane.YES_OPTION) {
                        
                    }
                });

                /* Exit Button -> Click Logic */
                this.exit.addActionListener(e -> {
                    System.out.println("exit");
                    System.exit(0);
                });
            }
        }
        class EditMenu extends JMenu {

            /* Menu Items */
            JMenuItem search = new JMenuItem("Search");
            JMenuItem clear = new JMenuItem("Clear");

            public EditMenu() {
                /* Set the name of this menu */
                super("Edit");

                /* Keyboard Shortcuts */
                super.setMnemonic('e');
                this.search.setMnemonic('s');
                this.clear.setMnemonic('c');

                /* Add the menu items to the menu :P */
                super.add(search);
                super.add(clear);

                /* Search Button -> Click Logic */
                this.search.addActionListener(e -> {
                    System.out.println("search");
                });

                /* Clear Button -> Click Logic */
                this.clear.addActionListener(e -> {
                    System.out.println("clear");
                });
            }
        }
    }

    class StudentPanel extends JPanel {

        /* Panel Items */
        StatusPanel statusPanel = new StatusPanel();
        JTextArea textBox;

        public StudentPanel(LayoutManager layout) {
            super(layout);
            super.setBorder(new LineBorder(Color.RED));
            this.textBox = new JTextArea(
                    "\012\012\012\012\012"
            );

            /* Add items to panel */
            super.add(textBox, BorderLayout.NORTH);
            super.add(statusPanel, BorderLayout.SOUTH);
        }

        class StatusPanel extends JPanel {
            /* Status Labels */
            JLabel connection = new JLabel("No Connection");
            JLabel objectsInDB = new JLabel("Number of Students: 0");

            public StatusPanel() {
                /* Use border layout for simplistity */
                super(new BorderLayout());

                /* Add status indicators to the bar/panel */
                super.add(connection, BorderLayout.WEST);
                super.add(objectsInDB, BorderLayout.EAST);
            }

            /**
             * Set the connection message to be displayed to the user.
             *
             * @param statusMsg message to set
             */
            void setConnectionStatus(String statusMsg) {
                connection.setText(statusMsg);
            }

            /**
             * Set the indicator to show the user how many students are in the database.
             *
             * @param amnt amount of students to set
             */
            void setStudents(int amnt) {
                objectsInDB.setText("Number of Students: " + amnt);
            }

        }
    }

    public static void main(String[] args) {
        new DisplayStudent().setVisible(true);
    }

}