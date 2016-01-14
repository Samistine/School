package Assignment9;

import java.util.Scanner;

/**
 * Assignment 9 Question 3<br/>
 * Design an application that will Calculate the area of a Shape. Have the user
 * enter a “C” to use a Circle, an “S” to use a Square and an “R” to use a
 * Rectangle. If the user enters any other letter or number, output an error
 * message. Once the user enters a “C”, call a Method(called Circle()) that 
 * does the input, calculation and output to Calculate the area of a Circle. If
 * the user enters an “S”, call a Method(called Square()) that  does the input,
 * calculation and output to Calculate the area of a Square. If the user enters
 * an “R”, call a Method(called Rectangle()) that  does the input, calculation
 * and output to Calculate the area of a Rectangle. Also write the pseudo-code.
 *
 * @author sseidel
 */
public class Question3 {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("To calculate the area of a shape, please enter a following option: ‘C’ for a Circle, ‘S’ for a Square, ‘R’ for a Rectangle");
        String option = scanner.next();
        switch (option) {
            case "C":
                Circle();
                break;
            case "S":
                Square();
                break;
            case "R":
                Rectangle();
                break;
            default:
                System.err.println("You entered an invalid option");
                break;
        }
    }

    private void Circle() {
        System.out.println("Enter the diameter of the circle");
        double radius = scanner.nextInt() / 2.0;
        double area = (radius * radius) * 3.14;
        System.out.println("The area of the circle equals: " + area);
    }

    private void Square() {
        System.out.println("Enter the length of a side of your square");
        int side = scanner.nextInt();
        int area = side * side;
        System.out.println("The area of the square equals: " + area);
    }

    private void Rectangle() {
        System.out.println("Enter the length of your rectangle");
        int length = scanner.nextInt();
        System.out.println("Enter the width of your rectangle");
        int width = scanner.nextInt();
        int area = length * width;
        System.out.println("The area of the rectangle is: " + area);
    }

    public static void main(String[] args) {
        new Question3().run();
    }
}
