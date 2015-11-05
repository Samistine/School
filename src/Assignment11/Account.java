package Assignment11;

/**
 * Assignment 11 Question 1
 * <p>
 * Modify
 * {@link Assignment10.Account the Account class that you built in Assignment #8}.
 * Add to the pseudo-code that you wrote in Assignment #8. Add 2 Constructors to
 * this class. The first Constructor should be the “no args” constructor. This
 * constructor should take no arguments and initialize all the properties to 0
 * or “”(empty string). The second constructor should accept 3 arguments, one
 * for AcctNo, one for owner and one for balance. This data being passed in
 * should be put into the properties of this object.
 *
 * @author sseidel
 */
public class Account {

    private String accountNumber;
    private String owner;
    private float balance;

    public Account() {
        //this("", "", 0); 'This way also works'
        this.accountNumber = "";
        this.owner = "";
        this.balance = 0;
    }

    public Account(String accountNumber, String owner, float balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public float getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
