/****************************************
 *      Lab 9                           *
 *      Samuel Seidel                   *
 *      April 21, 2016                  *
 ****************************************/
import javax.swing.*;
import java.awt.*;

public class MainGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainGUI");
        frame.setLayout(new FlowLayout());
        JButton button = new JButton("Hello");
        frame.add(button);
        frame.setLocation(512, 512);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}