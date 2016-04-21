/****************************************
 *      Lab 9                           *
 *      Samuel Seidel                   *
 *      April 21, 2016                  *
 ****************************************/
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        this.setTitle("MyFrame");
        this.setLocation(512, 512);
        this.setSize(300, 300);
        this.setLayout(new FlowLayout());

        JButton button_find  = new JButton("Find");
        JButton button_clear = new JButton("Clear");
        JButton button_exit  = new JButton("Exit");

        this.add(button_find);
        this.add(button_clear);
        this.add(button_exit);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }

}