package Assignment9;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Assignment 9 Question 2<br/>
 * Design an application that will convert either “Fahrenheit to Celsius” or
 * “Celsius to Fahrenheit”. Have the user enter a 1 to convert “Fahrenheit to
 * Celsius” and a 2 for “Celsius to Fahrenheit”. If the user enters any other
 * number, output an error message. Once the user enters a 1, call a
 * Method(called FtoC()) that  does the input, calculation and output for a
 * Fahrenheit to Celsius conversion. If the user enters a 2, call a
 * Method(called CtoF()) that  does the input, calculation and output for a
 * Celsius to Fahrenheit conversion. Also write the pseudo-code.
 *
 * @author sseidel
 */
public class Question2 {

    Scanner scanner = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.0°");

    public void run() {
        System.out.println("Enter a 1 to convert “Fahrenheit to Celsius” or a 2 for “Celsius to Fahrenheit”");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                FtoC();
                break;
            case 2:
                CtoF();
                break;
            default:
                System.err.println("Invalid Option Selected");
        }
    }

    private void FtoC() {
        int input = scanner.nextInt();
        double cels = (input - 32) * (5.0 / 9.0);
        System.out.println(df.format(cels) + " Celsius");
    }

    private void CtoF() {
        int input = scanner.nextInt();
        double fahr = input * (9.0 / 5.0) + 32.0;
        System.out.println(df.format(fahr) + " Fahrenheit");
    }

    public static void main(String[] args) {
        new Question2().run();
    }

}
