package com.samistine.school.java3.lab4;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public final class Account {
    
    private static final Logger LOGGER = Logger.getLogger(Account.class.getName());
    
    static final String SQL_SELECT = "SELECT * FROM Accounts WHERE AcctNo=?";
    static final String SQL_DELETE = "DELETE   FROM Accounts WHERE AcctNo=?";
    static final String SQL_INSERT = "INSERT   INTO Accounts "
            + "(AcctNo, Cid, Type, Balance) "
            + "VALUES (?,?,?,?)";
    
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
    
    public static void insertDB(String acctNo, String custID, String acctType, BigDecimal acctBalance) throws SQLException {
        LOGGER.log(Level.FINEST, "insertDB( {0} )", acctNo);
        
        final PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_INSERT);
        pstmt.setString(1, acctNo);
        pstmt.setString(2, custID);
        pstmt.setString(3, acctType);
        pstmt.setBigDecimal(4, acctBalance);
        
        int rows = pstmt.executeUpdate();
        LOGGER.log(Level.FINE, "insertDB( {0} ): Inserted {1} rows", new Object[]{acctNo, rows});
    }
    
    public static void deleteDB(String accountNumber) throws SQLException {
        LOGGER.log(Level.FINEST, "deleteDB( {0} )", accountNumber);
        
        final PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_DELETE);
        pstmt.setString(1, accountNumber);
        
        int rows = pstmt.executeUpdate();
        LOGGER.log(Level.FINE, "deleteDB( {0} ): Deleted {1} rows", new Object[]{accountNumber, rows});
    }
    
    @Override
    public String toString() {
        return "Account{" + "number=" + number + ", customerID=" + customerID + ", type=" + type + ", balance=" + balance + '}';
    }
    
}
