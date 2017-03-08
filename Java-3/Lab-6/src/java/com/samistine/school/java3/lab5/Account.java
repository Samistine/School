package com.samistine.school.java3.lab5;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.NamedParameterStatement;

/**
 *
 * @author Samuel
 */
public final class Account {

    private static final Logger LOGGER = Logger.getLogger(Account.class.getName());

    static final String SQL_SELECT_BYCID = "SELECT * FROM Accounts WHERE Cid=?";

    static final String SQL_SELECT = "SELECT * FROM Accounts WHERE AcctNo=?";
    static final String SQL_DELETE = "DELETE   FROM Accounts WHERE AcctNo=?";
    static final String SQL_INSERT = "INSERT   INTO Accounts "
            + "(AcctNo, Cid, Type, Balance) "
            + "VALUES (?,?,?,?)";

    static final String SQL_UPDATE_DEPOSIT = "UPDATE Accounts "
            + "SET Balance = Balance + ? "
            + "WHERE AcctNo=?";
    static final String SQL_UPDATE_WITHDRAW = "UPDATE Accounts "
            + "SET Balance = Balance - ? "
            + "WHERE AcctNo=?";

    static final String SQL_SELECT_VAR = "SELECT * from Accounts"
            + " WHERE (AcctNo = :number OR :number = '')"
            + " AND (Cid = :customerID OR :customerID = '')"
            + " AND (Type = :type OR :type = '')"
            + " AND (Balance >= :balanceMin)"
            + " AND (Balance <= :balanceMax)";

    private String number;
    private String customerID;
    private String type;
    private BigDecimal balance;

//<editor-fold defaultstate="collapsed" desc=" Getters ">
    public String getNumber() {
        return number;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }
//</editor-fold>
    Account(String number, String customerID, String type, BigDecimal balance) {
        this.number = number;
        this.customerID = customerID;
        this.type = type;
        this.balance = balance;
    }
    Account() {

    }

    public void deposit(double amount) throws SQLException {
        PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_UPDATE_DEPOSIT);
        pstmt.setDouble(1, amount);
        pstmt.setString(2, number);

        int rows = pstmt.executeUpdate();

        LOGGER.log(Level.FINE, "Account[{0}]::deposit( {1} ): {2} rows updated", new Object[]{number, amount, rows});
    }

    public void withdraw(double amount) throws SQLException {
        PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_UPDATE_WITHDRAW);
        pstmt.setDouble(1, amount);
        pstmt.setString(2, number);

        int rows = pstmt.executeUpdate();

        LOGGER.log(Level.FINE, "Account[{0}]::withdraw( {1} ): {2} rows updated", new Object[]{number, amount, rows});
    }

    // <editor-fold defaultstate="collapsed" desc=" this::selectDB & Account::getAccountsForCustomer">
    /**
     * Get from database and set fields to the new Account's columns.
     * If you think this code style is "different". Please look at Instructions.md in the Java3/Lab-4 folder
     *
     * @param acctNo to lookup in database
     * @throws SQLException
     */
    public void selectDB(String acctNo) throws SQLException {
        LOGGER.log(Level.FINEST, "selectDB( {0} )", acctNo);
        PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_SELECT);
        pstmt.setString(1, acctNo);

        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) throw new SQLException("No account was found in the database for the id of " + acctNo);
        if (!rs.isLast()) throw new Error("Oh no! More than a single account was returned when querying the id of " + acctNo);

        String accountNumber = rs.getString("AcctNo");
        String accountOwnerCustomerID = rs.getString("Cid");
        String accountType = rs.getString("Type");
        BigDecimal accountBalance = rs.getBigDecimal("Balance");
        if (!accountNumber.equalsIgnoreCase(acctNo)) throw new Error(
                    "[Something doesn't seem right] "
                    + "Upon querying for Account '" + acctNo + "' "
                    + "we received '" + accountNumber + "'. "
                    + "They don't seem to match :/");
        //Thoughts for seperating assignment (Samuel Seidel)
        //Seperate all gets from assignment to class variables to prevent seeing half-changes
        //e.g.  rs.getString("CustFirstName") throws error leaving instance showing partial valid data
        this.number = accountNumber;
        this.customerID = accountOwnerCustomerID;
        this.type = accountType;
        this.balance = accountBalance;
    }

    public static List<Account> getAccountsForCustomer(String custID) throws SQLException {
        PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_SELECT_BYCID);
        pstmt.setString(1, custID);

        ResultSet rs = pstmt.executeQuery();

        ArrayList accounts = new ArrayList();

        while (rs.next()) {
            String accountNumber = rs.getString("AcctNo");
            String accountOwnerCustomerID = rs.getString("Cid");
            String accountType = rs.getString("Type");
            BigDecimal accountBalance = rs.getBigDecimal("Balance");

            EDGE_HANDLING:
            {
                if (!accountOwnerCustomerID.equalsIgnoreCase(custID)) throw new Error(
                            "[Something doesn't seem right] "
                            + "Please Check account no. '" + accountNumber + "'. "
                            + "Upon querying for Accounts with an owner of '" + custID + "' "
                            + "we received one with the owner set to '" + accountOwnerCustomerID + "'. "
                            + "They don't seem to match :/");
            }

            Account account = new Account(accountNumber, accountOwnerCustomerID, accountType, accountBalance);
            accounts.add(account);
        }

        LOGGER.log(Level.FINE, "Account.getAccountsForCustomer( {1} ): {2} Accounts Returned", new Object[]{custID, accounts.size()});
        return accounts;
    }
// </editor-fold>

    public static void insertDB(String acctNo, String custID, String acctType, BigDecimal acctBalance) throws SQLException {
        PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_INSERT);
        pstmt.setString(1, acctNo);
        pstmt.setString(2, custID);
        pstmt.setString(3, acctType);
        pstmt.setBigDecimal(4, acctBalance);

        int rows = pstmt.executeUpdate();
        LOGGER.log(Level.FINE, "insertDB( {0} ): {1} rows inserted", new Object[]{acctNo, rows});
    }

    public static void deleteDB(String accountNumber) throws SQLException {
        PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_DELETE);
        pstmt.setString(1, accountNumber);

        int rows = pstmt.executeUpdate();
        LOGGER.log(Level.FINE, "deleteDB( {0} ): {1} rows deleted", new Object[]{accountNumber, rows});
    }

    public static List<Account> getAccounts(Optional<String> acctNo, Optional<String> customerID, Optional<String> acctType,
            BigDecimal acctBalanceMin, BigDecimal acctBalanceMax) throws SQLException {
        NamedParameterStatement pstmt = new NamedParameterStatement(SQL.getConnection(), SQL_SELECT_VAR);
        pstmt.setString("number", acctNo.orElse(""));
        pstmt.setString("customerID", customerID.orElse(""));
        pstmt.setString("type", acctType.orElse(""));
        pstmt.setBigDecimal("balanceMin", acctBalanceMin);
        pstmt.setBigDecimal("balanceMax", acctBalanceMax);

        ResultSet rs = pstmt.executeQuery();

        ArrayList accounts = new ArrayList();

        while (rs.next()) {
            String accountNumber = rs.getString("AcctNo");
            String accountOwnerCustomerID = rs.getString("Cid");
            String accountType = rs.getString("Type");
            BigDecimal accountBalance = rs.getBigDecimal("Balance");

            Account account = new Account(accountNumber, accountOwnerCustomerID, accountType, accountBalance);
            accounts.add(account);
        }

        // LOGGER.log(Level.FINE, "Account.getAccountsForCustomer( {1} ): {2} Accounts Returned", new Object[]{custID, accounts.size()});
        return accounts;
    }

    @Override
    public String toString() {
        return "Account{" + "number=" + number + ", customerID=" + customerID + ", type=" + type + ", balance=" + balance + '}';
    }

}
