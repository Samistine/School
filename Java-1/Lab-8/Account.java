/****************************************
 *      Lab 7                           *
 *      Samuel Seidel                   *
 *      March 10, 2016                  *
 ****************************************/

public class Account {

    private int acctNo;
    private String owner;
    private double balance;

    public Account() {
        //this(0, "", 0.0);
        this.acctNo = 0;
        this.owner = "";
        this.balance = 0.0;
    }
    public Account(int acctNo, String owner, double balance) {
        this.acctNo = acctNo;
        this.owner = owner;
        this.balance = balance;
    }

    public int getAcctNo() {return this.acctNo;}
    public String getOwner() {return this.owner;}
    public double getBalance() {return this.balance;}

    public void setAcctNo(int acctNo) {this.acctNo = acctNo;}
    public void setOwner(String owner) {this.owner = owner;}
    public void setBalance(double balance) {this.balance = balance;}

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Account{" + "acctNo=" + acctNo + ", owner=\"" + owner + "\", balance=$" + balance + "}";
    }

    public static void main(String[] args) {
        Account account1 = new Account(66, "Sam Seidel", 1000.01);
        account1.display();
    }
}
