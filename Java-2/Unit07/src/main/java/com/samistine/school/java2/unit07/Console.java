/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.school.java2.unit07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author samistine
 */
public class Console {

    public static void main(String[] args) {
        new Console().toString();
    }

    public JFrame frame;
    public JTextPane console;
    public JTextField input;
    public JScrollPane scrollpane;

    public StyledDocument document;

    boolean trace = false;

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public Console() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        }

        Font font = new Font("Courier New", Font.PLAIN, 14);

        frame = new JFrame("Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        console = new JTextPane();
        console.setEditable(false);
        console.setFont(font);
        console.setOpaque(false);

        input = new JTextField();
        input.setEditable(true);
        input.setFont(font);
        input.setForeground(Color.WHITE);
        input.setCaretColor(Color.WHITE);
        input.setOpaque(false);
        input.setBackground(new Color(0, 0, 0, 150));
        input.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

        scrollpane = new JScrollPane(console);
        scrollpane.setOpaque(false);
        scrollpane.getViewport().setOpaque(false);

        frame.add(input, BorderLayout.SOUTH);
        frame.add(scrollpane, BorderLayout.CENTER);
        frame.setSize(660, 350);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        document = console.getStyledDocument();

        input.addActionListener((event) -> {
            String text = input.getText();
            if (text.length() > 0) {
                println(text);
                //doCommand(text);
//                scrollBottom();
                input.setText(null);
                try {
                    queue.put(text);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void scrollTop() {
        console.setCaretPosition(0);
    }

    public void scrollBottom() {
        console.setCaretPosition(console.getDocument().getLength());
    }

    public void println(String s) {
        println(s, false);
    }

    public void println(String s, boolean trace) {
        println(s, trace, new Color(255, 255, 255));
    }

    public void println(String s, boolean trace, Color color) {
        Style style = console.addStyle("Style", null);
        StyleConstants.setForeground(style, color);
        if (trace) {
            Throwable t = new Throwable();
            StackTraceElement[] elements = t.getStackTrace();
            String caller = elements[0].getClassName();
            s = caller + " -> " + s;
        }
        try {
            document.insertString(document.getLength(), s + "\n", style);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
        scrollBottom();
    }

    public String nextLine() throws InterruptedException {
        return queue.take();
    }

    public Optional<Long> nextLineAsLong() throws InterruptedException {
        String line = nextLine();
        try {
            return Optional.of(Long.valueOf(line));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

}
