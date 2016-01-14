package Assignment7;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Secondhand Rose Resale Shop is having a seven-day sale during which the price
 * of any unsold item drops 10 percent each day. For example, an item that costs
 * $10.00 on the first day costs 10 percent less, or $9.00, on the second day.
 * On the third day, the same item is 10 percent less than $9.00, or $8.10.
 * Design the pseudo-code/flowchart using Visual Logic that allows a user to
 * input a price. Output is the price of each item on each day, one through
 * seven.
 *
 * @author sseidel
 */
public class Question4 {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Type a price");
        double price = scanner.nextDouble();
        for (int day = 1; day <= 7; day++) {
            System.out.println("Day " + day + ": " + new DecimalFormat("$0.00").format(price));
            price = price - (price * .10);
        }
    }

    public static void main(String[] args) {
        new Question4().run();
    }
}
