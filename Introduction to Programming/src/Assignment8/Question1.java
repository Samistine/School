package Assignment8;

import java.text.MessageFormat;
import java.util.Scanner;

/**
 * Assignment 8 Question 1<br/>
 * Design a program(pseudo-code & flowchart) that uses Arrays to compute the
 * average of 5 Quiz scores. Use an array to store the data for the 5 quiz
 * scores. Use a loop(for loop 1 to 5) to input the 5 quiz scores from the user.
 * Then calculate the average score and print it out.
 *
 * @author sseidel
 */
public class Question1 {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        int grades[] = new int[4];

        for (int i = 0; i < 4; i++) {
            System.out.println(MessageFormat.format("Enter your {0} grade", i + 1));
            grades[i] = scanner.nextInt();
        }

        int total = 0;
        for (int i = 0; i < grades.length; i++) {
            total += grades[i];
        }

        double average = total / (double) grades.length;
        System.out.println("Your average score is " + average);

    }

    public static void main(String[] args) {
        new Question1().run();
    }
}
