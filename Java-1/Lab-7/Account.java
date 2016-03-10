/****************************************
 *      Lab 7                           *
 *      Samuel Seidel                   *
 *      March 10, 2016                  *
 ****************************************/

public class Account {

    private int acctNo;
    private String owner;
    private double balance;

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
        Account account1 = new Account();
        account1.setAcctNo(66);
        account1.setOwner("Sam Seidel");
        account1.setBalance(1000.01);
        account1.display();
    }
}
