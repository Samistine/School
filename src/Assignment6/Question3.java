package Assignment6;

import java.util.Scanner;

/**
 * Assignment 16 Question 3<br/>
 * Design an application that will convert either Fahrenheit to Celsius or
 * Celsius to Fahrenheit. Have the user enter a 1 to convert Fahrenheit to
 * Celsius and a 2 for Celsius to Fahrenheit. If the user enters any other
 * number, output an error message. Once the user enters a 1, do the input,
 * calculation and output for a Fahrenheit to Celsius conversion. If the user
 * enters a 2, do the input, calculation and output for a Celsius to Fahrenheit
 * conversion. Also write the pseudo-code.
 *
 * @author sseidel
 */
public class Question3 {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        double conversion;

        System.out.println("Enter 1 for conversions to Celsius, Enter 2 for conversions to Fahrenheit");
        int option = scanner.nextInt();

        System.out.println("Enter the current temperature");
        int input = scanner.nextInt();

        if (option == 1) {
            //Convert to Celsius
            conversion = (input - 32.0) * 5.0 / 9.0;
        } else if (option == 2) {
            //Convert to Fahrenheit
            conversion = input * 9.0 / 5.0 + 32.0;
        } else {
            System.err.println("Invalid option entered");
            return;
        }

        System.out.println("The converted temperature equals: " + conversion);
    }

    public static void main(String[] args) {
        new Question3().run();
    }
}
