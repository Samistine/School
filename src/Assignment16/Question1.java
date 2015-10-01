package Assignment16;

import java.util.Scanner;

/**
 * Assignment 16 Question 1<br/>
 * Pastoral College is a small college in the Midwest. Design the pseudo-code
 * for a program that accepts a student name, major field of study, and grade
 * point average. Display a student’s data with the message “Dean’s list” if the
 * student’s grade point average is above 3.5, “Academic probation” if the grade
 * point average is below 2.0, and no message if the grade point average is
 * between 2.0 and 3.5 inclusive.
 *
 * @author sseidel
 */
public class Question1 {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter your major field of study: ");
        String major = scanner.nextLine();

        System.out.println("Enter your GPA: ");
        double gpa = scanner.nextDouble();

        System.out.println("Student’s name: " + name);
        System.out.println("Student’s major: " + major);
        System.out.println("Student’s GPA: " + gpa);
        if (gpa > 3.5) {
            System.out.println("Dean’s List");
        }
        if (gpa < 2) {
            System.out.println("Academic probation");
        }
    }

    public static void main(String[] args) {
        new Question1().run();
    }
}
