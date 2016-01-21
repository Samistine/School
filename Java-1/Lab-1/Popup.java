/****************************************
 *      Lab 1                           *
 *      Samuel Seidel                   *
 *      January 21, 2016                *
 ****************************************/

import javax.swing.JOptionPane;

public class Popup {
    public static void main (String[] args) {
       JOptionPane.showMessageDialog(null,
              "The Falcons are going to win the Super Bowl in 2016!!",
              "Go Braves",
              JOptionPane.INFORMATION_MESSAGE
       );
    }
}
