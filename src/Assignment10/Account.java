package Assignment10;

import java.util.UUID;

/**
 * Assignment 10 Question 1<br/>
 * Design a class named Account. The Account class should have 3 properties; an
 * AcctNo, an owner, and a balance. Determine the data types for each property,
 * then create the class diagram and write the pseudo-code that defines the
 * class.
 *
 * @author sseidel
 */
public class Account {

    private UUID accountNumber;
    private String owner;
    private float balance;

    public Account(UUID accountNumber, String owner, float balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public float getBalance() {
        return balance;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
