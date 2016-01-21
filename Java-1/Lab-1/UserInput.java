/****************************************
 *      Lab 1                           *
 *      Samuel Seidel                   *
 *      January 21, 2016                *
 ****************************************/

import javax.swing.JOptionPane;

public class UserInput {
    public static void main (String[] args) {
        String first_name = JOptionPane.showInputDialog(null,
              "Please enter your first name: ",
              "User Input",
              JOptionPane.QUESTION_MESSAGE
        );
        System.out.println(first_name);
    }
}
