package Assignment16;

import java.util.Scanner;

/**
 * Assignment 16 Question 4<br/>
 * Design an application that will Calculate the area of a Shape. Have the user
 * enter a “C” to use a Circle, an “S” to use a Square and an “R” to use a
 * Rectangle. If the user enters any other letter or number, output an error
 * message. Once the user enters a “C”, do the input, calculation and output to
 * Calculate the area of a Circle. If the user enters an “S”, do the input,
 * calculation and output to Calculate the area of a Square. If the user enters
 * an “R”, do the input, calculation and output to Calculate the area of a
 * Rectangle. Also write the pseudo-code.
 *
 * @author sseidel
 */
public class Question4 {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        double area;
        System.out.println("To calculate the area of a shape, please enter a following option: ‘C’ for a Circle, ‘S’ for a Square, ‘R’ for a Rectangle");
        String option = scanner.next();
        if (option.equals("S") || option.equals("R")) {
            int length;
            int width;
            if (option.equals("S")) {
                System.out.println("Enter the length of a side of your square");
                length = scanner.nextInt();
                width = length;
            } else {
                System.out.println("Enter the length of your rectangle");
                length = scanner.nextInt();
                System.out.println("Enter the width of your rectangle");
                width = scanner.nextInt();
            }
            area = length * width;
        } else if (option.equals("C")) {
            System.out.println("Enter the circumferance of the circle");
            int circ = scanner.nextInt();
            int radius = circ / 2;
            area = radius * radius * 3.14;
        } else {
            System.err.println("You entered an invalid option");
            return;
        }
        System.out.println("The area of the shape equals: " + area);
    }

    public static void main(String[] args) {
        Question4 program = new Question4();
        program.run();
    }
}
