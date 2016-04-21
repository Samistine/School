/****************************************
 *      Lab 9                           *
 *      Samuel Seidel                   *
 *      April 21, 2016                  *
 ****************************************/
import javax.swing.*;
import java.awt.*;

public class ExitPanel extends JPanel {

    JButton button_exit   = new JButton("Exit");
    JButton button_pushme = new JButton("Push Me");

    public ExitPanel() {
        this.add(button_exit);
        this.add(button_pushme);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ExitPanel::main()");
        JPanel panel = new ExitPanel();

        frame.add(panel);

        frame.setLocation(512, 512);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}