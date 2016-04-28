/****************************************
 *      Lab 11                          *
 *      Samuel Seidel                   *
 *      April 28, 2016                  *
 ****************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        this.setTitle("MyFrame");
        this.setLocation(512, 512);
        this.setSize(300, 300);
        this.setLayout(new FlowLayout());

        JMenuBar menu_bar = new JMenuBar() {{
            JMenu menu_file = new JMenu("File") {{
                JMenuItem btn_open  = new JMenuItem("Open");
                JMenuItem btn_close = new JMenuItem("Close");
                JMenuItem btn_exit  = new JMenuItem("Exit"){{
                    this.addActionListener( ae -> System.exit(0) );
                }};

                this.add(btn_open);
                this.add(btn_close);
                this.add(btn_exit);
            }};

            JMenu menu_help = new JMenu("Help");

            this.add(menu_file);
            this.add(menu_help);
        }};

        JButton button_find  = new JButton("Find");
        JButton button_clear = new JButton("Clear");
        JButton button_exit  = new JButton("Exit") {{
            this.addActionListener( ae -> System.exit(0) );
        }};

        this.setJMenuBar(menu_bar);
        this.add(button_find);
        this.add(button_clear);
        this.add(button_exit);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }

}