/****************************************
 *      Lab 4                           *
 *      Samuel Seidel                   *
 *      February 11, 2016               *
 ****************************************/

import javax.swing.JOptionPane;

public class MilesToKilos {

    public static void main(String[] args) {
        
        System.out.println("Miles     Kilometers");
        
        for (int miles = 1; miles <= 100; miles++) {
            float km = miles * 1.609f;
            System.out.printf("%3d       %7.3f%n", miles, km);
        }
        
    }
}
