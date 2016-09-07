package com.samistine.school.java2.unit02;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit02
 * Date: Created Sep 6, 2016 7:38:43 PM
 * 
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 * 
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class Account {

    /** Account Number **/
    private int acctNo;
    /** Account Owner **/
    private String owner;
    /** Account Balance **/
    private int balance;

    /**
     * Default no-args constructor
     */
    public Account() {
    }

    /**
     * @param acctNo the account number
     * @param owner owner of the account
     * @param balance the balance
     */
    public Account(int acctNo, String owner, int balance) {
        this.acctNo = acctNo;
        this.owner = owner;
        this.balance = balance;
    }

    /**
     * Get the account's account number
     *
     * @return acctNo
     */
    public int getAcctNo() {
        return acctNo;
    }

    /**
     * Set the account's account number.
     *
     * @param acctNo new account number
     */
    public void setAcctNo(int acctNo) {
        this.acctNo = acctNo;
    }

    /**
     * Get the account holder's name.
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set the account holder's name.
     *
     * @param owner new name
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get the current balance of the account.
     *
     * @return balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Set the balance of the account.
     *
     * @param balance new balance
     * @throws InsufficientFundsException if a negative number is specified for <u>balance</u>
     */
    public void setBalance(int balance) throws InsufficientFundsException {
        if (balance < 0) throw new InsufficientFundsException("Account can not be set to a negative value");
        this.balance = balance;
    }

    /**
     * Deposit money into the account.
     *
     * @param amount to add
     * @throws InsufficientFundsException if a negative number is specified for <u>deposit</u>
     */
    public void deposit(int amount) throws InsufficientFundsException {
        if (amount < 0) throw new InsufficientFundsException("Logic Error: You can't deposit a negative amount");
        this.balance += amount;
    }

    /**
     * Withdraw money from the account.
     *
     * @param amount to subtract
     * @throws InsufficientFundsException if the resulting balance after subtracting <u>amount</u> would be less than zero
     */
    public void withdraw(int amount) throws InsufficientFundsException {
        if (balance - amount < 0) throw new InsufficientFundsException("Overdrawn");
        this.balance -= amount;
    }

}
