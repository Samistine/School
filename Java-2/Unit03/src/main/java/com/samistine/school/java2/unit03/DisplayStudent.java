package com.samistine.school.java2.unit03;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
    String search_ssn;

    MenuBar menu;
    StudentPanel studentPanel;

    public DisplayStudent() throws HeadlessException {
        super.setLayout(new BorderLayout());//Orgainize content like a compass
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//If user clicks RED X allow the application to self destruct
        super.setSize(550, 250);//Give it a good default size so it's not smushed
        super.setTitle("Display Student");//Give the window a title
        centerWindow(this);//Spawn in the center of the screen

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

                    /* Ask the user to select a database */
                    database_name = JOptionPane.showInputDialog(rootPane, "What database do you wish to connect to?");

                    /* Check if user supplied database is valid */
                    if (database_name != null && !database_name.isEmpty()) {
                        /* Connect to database */
                        System.out.println("Connecting to Database: " + database_name);
                        studentPanel.statusPanel.connection.setText("Connected to " + database_name);
                    }
                });

                /* Close Button -> Click Logic */
                this.close.addActionListener(e -> {
                    System.out.println("close");

                    //Ask user if they are sure they wan't to close the connection
                    int response = JOptionPane.showConfirmDialog(DisplayStudent.this, "Are you sure you want to close the connection?", "Confirm Connection Closure", JOptionPane.YES_NO_OPTION);
                    boolean closing = response == JOptionPane.YES_OPTION;
                    System.out.println("closing:" + (closing ? "yes" : "no"));

                    //If yes then we do so
                    if (closing) {
                        database_name = null;
                        studentPanel.statusPanel.setConnectionStatus("No Connection");
                        System.out.println("Connection Closed");
                    }
                });

                /* Exit Button -> Click Logic */
                this.exit.addActionListener(e -> {
                    System.out.println("exit");
                    /* Shut down program */
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

                    if (database_name == null) {
                        //Database is null, we can't seach without being connected.
                        System.out.println(" Not connected to database, can't search");

                        /* Tell the user he can't do that unless he is connected to the database */
                        JOptionPane.showMessageDialog(
                                rootPane,
                                    "You are not connected to a database!" + System.lineSeparator() +
                                    "Please try connecting first",
                                "DisplayStudent",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        //Database is connectedl, lets search!

                        /* Ask the user for search term */
                        search_ssn = JOptionPane.showInputDialog(rootPane, "Enter Student SSN", "Search", JOptionPane.QUESTION_MESSAGE);

                        /* Begin search */
                        System.out.println(" Searching database...");

                        /* Create some test students */
                        Student[] students = {
                            new Student(900222222, "Mary", "Smith", "CIS"),
                            new Student(900222224, "Tom", "Jones", "English")
                        };

                        /* Set the total students status pane */
                        studentPanel.statusPanel.setStudents(students.length);
                        /* Clear any current data from the displayed(GUI) table */
                        studentPanel.tableManager.clear();
                        /* Add the students to the displayed(GUI) table */
                        studentPanel.tableManager.add(students);
                    }
                });

                /* Clear Button -> Click Logic */
                this.clear.addActionListener(e -> {
                    System.out.println("clear");
                    /* Clear any current data from the displayed(GUI) table */
                    studentPanel.tableManager.clear();
                    /* Set the total students status pane to 0 */
                    studentPanel.statusPanel.setStudents(0);
                });
            }
        }
    }

    class StudentPanel extends JPanel {

        /* Table manager */
        TableData<Student> tableManager = new TableData<>(
                new Column[]{
                    new Column<>(String.class, "SSN", Student::getSSN),
                    new Column<>(String.class, "First Name", Student::getFirstName),
                    new Column<>(String.class, "Last Name", Student::getLastName),
                    new Column<>(String.class, "Major", Student::getMajor)
                }
        );

        /* Panel Items */
        JScrollPane table = tableManager.toJScollableJTable();
        StatusPanel statusPanel = new StatusPanel();

        public StudentPanel(LayoutManager layout) {
            super(layout);
            //super.setBorder(new LineBorder(Color.RED)); //Fancy Border

            /* Add panel items to the display */
            super.add(table, BorderLayout.CENTER);//Using North prevents autoresizing
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
             * Fills the table with the students provided &
             * sets the "Number of Students: x" status indicator.
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

    /**
     * Center the spawn location of the window.
     *
     * @param frame
     */
    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

}
