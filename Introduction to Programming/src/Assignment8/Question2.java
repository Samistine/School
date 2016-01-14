package Assignment8;

import java.util.Scanner;

/**
 * Assignment 8 Question 2<br/>
 * Design a program(pseudo-code & flowchart) that allows a user to enter 10
 * numbers, then displays them in the reverse order of their entry. You should
 * use an Array to store the data, and your output should go to the console
 * window. Use loops to read in the data and to output the data.
 *
 * @author sseidel
 */
public class Question2 {

    Scanner scanner = new Scanner(System.in);

    public void run() {

        System.out.println("Input 10 numbers");
        double numbers[] = new double[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextDouble();
        }

        for (int i = numbers.length - 1; i > -1; i--) {
            System.out.println("Output: " + numbers[i]);
        }
    }

    public static void main(String[] args) {
        new Question2().run();
    }

}
