package Assignment9;

import java.util.Scanner;

/**
 * Assignment 9 Question 1<br/>
 * Create the pseudo-code/flowchart for an application class named Monogram. Its
 * main() method inputs three variables that hold your first, middle, and last
 * initials, respectively. Create a method(called Monogram()) to which you pass
 * the three initials and that displays the initials twice—once in the order of
 * first, middle, and last, and a second time in traditional monogram style
 * (first, last, middle). Main inputs the data, you pass it to the Monogram
 * Function, which will output the data.
 *
 * @author sseidel
 */
public class Question1 {

    Scanner scanner = new Scanner(System.in);

    /*Main*/
    public void run() {
        System.out.println("Input first initial");
        String first = scanner.nextLine();

        System.out.println("Input middle initial");
        String middle = scanner.nextLine();

        System.out.println("Input last initial");
        String last = scanner.nextLine();

        Monogram(first, middle, last);
    }

    private void Monogram(String first, String middle, String last) {
        System.out.println(first + ", " + middle + ", " + last);
        System.out.println(first + ", " + last + ", " + middle);
    }

    public static void main(String[] args) {
        new Question1().run();
    }
}
