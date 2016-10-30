package com.samistine.school.java2.unit04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Samuel
 */
public final class Unit04Prog01_2 extends JPanel implements ActionListener {

    JButton openButton;
    JTextArea log;
    JFileChooser fc;

    public Unit04Prog01_2() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser(new File("."));

        //Create the open button.
        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(Unit04Prog01_2.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + System.lineSeparator());

                if (!file.exists()) {
                    log.append("Sorry, file '" + file.getName() + "' not found.");
                    return;
                }

                openFile(file);

            } else {
                log.append("Open command cancelled by user." + System.lineSeparator());
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }

    /**
     * Open the file.
     *
     * @param file file to open
     */
    void openFile(File file) {
        try (Scanner scanner = new Scanner(file)) {

            //Running total
            double numbers = 0;

            /* Iterate thru numeric entries in text file */
            while (scanner.hasNextBigDecimal()) {
                double number = scanner.nextDouble();
                /* Add the value to the running total */
                numbers += number;
            }

            /* Append To Log Window */
            log.append("Total is " + numbers + System.lineSeparator());

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file.getName() + "'");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error reading file '" + file.getName() + "'");
            ex.printStackTrace();
        }
    }

    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Unit04Prog01_2());

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        //Center
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

}
