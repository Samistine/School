package Assignment9;

import java.util.Scanner;

/**
 * Assignment 9 Question 4<br/>
 * Create the pseudo-code/flowchart for an application that contains a main()
 * method that continuously prompts the user for a number of dollars until the
 * user enters 0. The main method passes the amount to a conversion method that
 * displays the breakdown of the passed amount into the fewest bills; in other
 * words, it calculates the number of 20s, 10s, 5s, and 1s needed.
 *
 * @author sseidel
 */
public class Question4 {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Enter in a dollar amount");
        for (int input = scanner.nextInt(); input != 0; input = scanner.nextInt()) {
            calculateBills(input);
        }
    }

    private void calculateBills(int money) {
        int twenties = money / 20;
        money = money % 20;
        int tens = money / 10;
        money = money % 10;
        int fives = money / 5;
        money = money % 5;
        int ones = money;

        StringBuilder b = new StringBuilder();
        if (twenties > 0) {
            b.append(twenties).append(twenties == 1 ? " Twenty " : " Twenties ");
        }
        if (tens > 0) {
            b.append(tens).append(" Ten ");
        }
        if (fives > 0) {
            b.append(fives).append(" Five ");
        }
        if (ones > 0) {
            b.append(ones).append(ones == 1 ? " One " : " Ones ");
        }
        System.out.println(b.toString());
    }

    public static void main(String[] args) {
        new Question4().run();
    }
}
