/****************************************
 *      Lab 2                           *
 *      Samuel Seidel                   *
 *      January 28, 2016                *
 ****************************************/

import javax.swing.JOptionPane;

public class Convert {

    public static void main(String[] args) {
        String sinput = JOptionPane.showInputDialog(null,
              "Please enter a Fahrenheit temperature: "
        );
        float finput = Float.parseFloat(sinput);
        
        //float cels = (5.0f/9.0f) * (finput - 32.0f);
        double cels = (5.0/9.0) * (finput - 32.0f);
        
        System.out.println("Celsius: " + cels);

    }
}
