/****************************************
 *      Lab 3                           *
 *      Samuel Seidel                   *
 *      February 7, 2016                *
 ****************************************/

import javax.swing.JOptionPane;

public class Login {

    public static void main(String[] args) {
        
        String userid = JOptionPane.showInputDialog(null,
            "Please enter your userid"
        );
        
        String password = JOptionPane.showInputDialog(null,
            "Please enter your password"
        );
        
        // If the userid is "admin" and the password is "ctc", 
        //then print a message that says "Admin User Logged In".
        if (userid.equals("admin") && password.equals("ctc")) {
            JOptionPane.showMessageDialog(null, "Admin User Logged In");
        }
        
        //If the password is not "ctc", 
        //print "Admin Login Password is incorrect!".
        if (!password.equals("ctc")) {
            JOptionPane.showMessageDialog(null, "Admin Login Password is incorrect!");
        }
        
    }
}
