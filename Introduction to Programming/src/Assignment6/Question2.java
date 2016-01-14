package Assignment6;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Assignment 16 Question 2<br/>
 * The Summerville Telephone Company charges 20 cents per minute for all calls
 * outside the customer’s area code. All other calls are 15 cents per minute.
 * Design the pseudo-code for a program that accepts data about a phone call:
 * customer area code (three digits), customer phone number (seven digits),
 * called area code (three digits), called number (seven digits), and call time
 * in minutes (four digits). Display the calling number, called number, and
 * price for the call.
 *
 * @author sseidel
 */
public class Question2 {

    Scanner scanner = new Scanner(System.in);
    final double call_local = 0.15;
    final double call_distant = 0.20;

    public void run() {
        System.out.println("Please enter your 3 digit area code");
        String customerAreaCode = scanner.next();
        System.out.println("Please enter your 7 digit phone number");
        String customerPhoneNumber = scanner.next();

        System.out.println("Please enter the area code of the person you wish to call");
        String calledAreaCode = scanner.next();
        System.out.println("Please enter the 7 digit phone number of the person you wish to call");
        String calledPhoneNumber = scanner.next();

        System.out.println("Enter the call length in minutes");
        int callLength = scanner.nextInt();

        Double callcost;
        if (customerAreaCode.equals(calledAreaCode)) {
            callcost = callLength * call_local;
        } else {
            callcost = callLength * call_distant;
        }

        System.out.println("Calling: " + calledAreaCode + calledPhoneNumber + "\r\n"
                + "From: " + customerAreaCode + customerPhoneNumber + "\r\n"
                + "This call will cost you $" + new DecimalFormat("0.00").format(callcost)
        );
    }

    public static void main(String[] args) {
        new Question2().run();
    }
}
