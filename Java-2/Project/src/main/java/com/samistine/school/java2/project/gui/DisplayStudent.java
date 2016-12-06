package com.samistine.school.java2.project.gui;

import com.samistine.school.java2.project.buisness.Student;
import com.samistine.school.java2.project.data.StudentDAO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.util.Collection;
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

    StudentDAO studentDAO = new StudentDAO();

    String search_ssn;

    MenuBar menubar;
    StudentPanel studentPanel;
    StatusPanel statusPanel;

    public DisplayStudent() throws HeadlessException {
        //super("Display Student");
        super.setLayout(new BorderLayout());//Orgainize content like a compass
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//If user clicks RED X allow the application to self destruct
        super.setSize(550, 250);//Give it a good default size so it's not smushed
        super.setTitle("Display Student");//Give the window a title
        super.setLocationRelativeTo(null);//Spawn in the center of the screen

        /* Create new menu item instances */
        this.menubar = new MenuBar();
        this.studentPanel = new StudentPanel(new BorderLayout());
        this.statusPanel = new StatusPanel();

        /* Add the menu items to this frame */
        super.setJMenuBar(menubar);
        super.add(studentPanel, BorderLayout.CENTER);
        super.add(statusPanel, BorderLayout.SOUTH);
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
            JMenuItem exit = new JMenuItem("Exit");

            public FileMenu() {
                /* Set the name of this menu */
                super("File");

                /* Keyboard Shortcuts */
                super.setMnemonic('f');
                this.exit.setMnemonic('x');

                /* Add the menu items to the menu :P */
                super.add(exit);

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
                    /* Ask the user for search term */
                    search_ssn = JOptionPane.showInputDialog(rootPane, "Please enter a search string", "Student Search", JOptionPane.QUESTION_MESSAGE);
                    
                    //Handle case where user close search dialog
                    if (search_ssn == null) return; 
                    
                    if (!search_ssn.matches("^[0-9,%]*$")) {
                        JOptionPane.showConfirmDialog(rootPane,
                                "Input can only contain numbers and wildcards e.g. '%'",
                                "Invalid Input",JOptionPane.DEFAULT_OPTION , JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    /* Set the total students status pane */
                    statusPanel.setStudents(0);
                    /* Clear any current data from the displayed(GUI) table */
                    studentPanel.manager().clear();

                    /* Begin search */
                    System.out.println(" Searching database...");

                    /* Query DB */
                    Collection<Student> students = studentDAO.selectStudents(search_ssn);
                    
                    if (students != null) {
                        /* Add the students to the displayed(GUI) table */
                        studentPanel.manager().add(students);
                        /* Set the total students status pane */
                        statusPanel.setStudents(students.size());
                    } else {
                         JOptionPane.showConfirmDialog(rootPane,
                                "There were no students found for " + search_ssn,
                                "No Results Found",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                        
                    }
                });

                /* Clear Button -> Click Logic */
                this.clear.addActionListener(e -> {
                    System.out.println("clear");
                    /* Clear any current data from the displayed(GUI) table */
                    studentPanel.manager().clear();
                    /* Set the total students status pane to 0 */
                    statusPanel.setStudents(0);
                });
            }
        }
    }

    class StudentPanel extends JPanel {

        /* Table manager */
        TableData<Student> tableManager = new TableData<>(
                new Column[]{
                    new Column<>(String.class, "ID", Student::getId),
                    new Column<>(String.class, "First Name", Student::getFirstName),
                    new Column<>(String.class, "Last Name", Student::getLastName),
                    new Column<>(String.class, "Major", Student::getDeptId)
                }
        );

        /* Panel Items */
        JScrollPane table = tableManager.toJScollableJTable();

        public StudentPanel(LayoutManager layout) {
            super(layout);
            //super.setBorder(new LineBorder(Color.RED)); //Fancy Border

            /* Add panel items to the display */
            super.add(table, BorderLayout.CENTER);//Using North prevents autoresizing
            //super.add(statusPanel, BorderLayout.SOUTH);
        }

        public TableData<Student> manager() {
            return tableManager;
        }
    }

    class StatusPanel extends JPanel {

        /* Status Labels */
        JLabel label = new JLabel("Number of Students:");
        JLabel count = new JLabel("0");

        public StatusPanel() {
            /* Use border layout for simplistity */
            super(new BorderLayout());

            /* Display elements panel from left to right */
            JPanel elements = new JPanel(new FlowLayout());
            elements.add(label);
            elements.add(count);

            /* Add elements panel to the bottom bar with right alignment */
            super.add(elements, BorderLayout.EAST);
        }

        /**
         * Fills the table with the students provided & sets the "Number of
         * Students: x" status indicator.
         *
         * @param amnt amount of students to set
         */
        void setStudents(int amnt) {
            count.setText(String.valueOf(amnt));
        }
    }

    public static void main(String[] args) {
        new DisplayStudent().setVisible(true);
    }

}
