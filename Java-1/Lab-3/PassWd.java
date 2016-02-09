/****************************************
 *      Lab 3                           *
 *      Samuel Seidel                   *
 *      February 7, 2016                *
 ****************************************/

import javax.swing.JOptionPane;

public class PassWd {

    public static void main(String[] args) {
        String password = JOptionPane.showInputDialog(null,
              "Please enter your password"
        );
        if (password.equals("1234")) {
            JOptionPane.showMessageDialog(null,
                "Welcome Valued Customer"
            );
        } else {
            JOptionPane.showMessageDialog(null,
                "Login incorrect!"
            );
        }
    }
}
