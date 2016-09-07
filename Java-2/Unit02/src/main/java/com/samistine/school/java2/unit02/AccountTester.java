package com.samistine.school.java2.unit02;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit02
 * Date: Created Sep 6, 2016 7:42:24 PM
 * 
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 * 
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class AccountTester {

    public static void main(String[] args) {
        /* Create first test account */
        System.out.println("Account object created with balance of 200");
        Account a1 = new Account(1, "Sam", 200);

        System.out.println("Withdrawing 100");
        try {
            a1.withdraw(100); //Attempt to withdraw 100
        } catch (InsufficientFundsException ex) { //Catch error
            print("  Error: " + ex.getMessage());
        }
        print("  %s's account balance: %s", a1.getOwner(), a1.getBalance()); //Print Balance

        System.out.println("Depositing 50");
        try {
            a1.deposit(50); // Deposit 50 
        } catch (InsufficientFundsException ex) { //Catch error
            print("  Error: " + ex.getMessage());
        }
        print("  %s's account balance: %s", a1.getOwner(), a1.getBalance()); //Print Balance

        System.out.println("Withdrawing 500");
        try {
            a1.withdraw(500); //Attempt to withdraw 500
        } catch (InsufficientFundsException ex) { //Catch error
            print("  Error: " + ex.getMessage());
        }
        print("  %s's account balance: %s", a1.getOwner(), a1.getBalance()); //Print Balance

        System.out.println("Setting balance to -100");
        try {
            a1.setBalance(-100); //Attempt to set balance to negative 100
        } catch (InsufficientFundsException ex) { //Catch error
            print("  Error: " + ex.getMessage());
        }
        print("  %s's account balance: %s", a1.getOwner(), a1.getBalance()); //Print Balance
    }

    static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
