package com.samistine.school.java3.lab5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Seidel
 */
public final class Customer {

    private static final Logger LOGGER = Logger.getLogger(Customer.class.getName());

    static final String SQL_SELECT = "SELECT * FROM Customers WHERE CustID=?";
    static final String SQL_DELETE = "DELETE   FROM Customers WHERE CustID=?";
    static final String SQL_INSERT = "INSERT   INTO Customers "
            + "(CustID, CustPassword, CustFirstName, CustLastName, CustAddress, CustEmail) "
            + "VALUES (?,?,?,?,?,?)";

    private final String id;
    private String password, firstName, lastName, address, email;
    private List<Account> accounts;

    public Customer(String id, String password, String firstName, String lastName, String address, String email, List<Account> accounts) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.accounts = accounts;
    }

    public Customer(String id, String password, String firstName, String lastName, String address, String email) {
        this(id, password, firstName, lastName, address, email, Collections.emptyList());
    }

    public Customer() {
        this("", "", "", "", "", "");
    }

// <editor-fold defaultstate="collapsed" desc=" Getters ">
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
// </editor-fold>

    public static Customer getCustomer(String custID) throws SQLException {
        LOGGER.log(Level.FINEST, "selectDB( {0} )", custID);
        PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_SELECT);
        pstmt.setString(1, custID);

        ResultSet rs = pstmt.executeQuery();

        //if (!rs.next()) throw new SQLException("No customer was found in the database for the id of " + custID);
        if (!rs.next()) return null;
        if (!rs.isLast()) throw new Error("Oh no! More than a single customer was returned when querying the id of " + custID);

        String customerID = rs.getString("CustID");
        String customerPassword = rs.getString("CustPassword");
        String customerFirstName = rs.getString("CustFirstName");
        String customerLastName = rs.getString("CustLastName");
        String customerAddress = rs.getString("CustAddress");
        String customerEmail = rs.getString("CustEmail");
        if (!customerID.equalsIgnoreCase(custID)) throw new Error(
                    "[Something doesn't seem right] "
                    + "Upon querying for Customer '" + custID + "' "
                    + "we received '" + customerID + "'. "
                    + "They don't seem to match :/");

        List<Account> accounts = Account.getAccountsForCustomer(customerID);
        Customer customer = new Customer(customerID, customerPassword, customerFirstName, customerLastName, customerAddress, customerEmail, accounts);
        return customer;
    }

    public static void insertDB(
            String custID, String custPassword, String custFirstName, String custLastName,
            String custAddress, String custEmail) throws SQLException {
        LOGGER.log(Level.FINEST, "insertDB( {0} )", custID);

        final PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_INSERT);
        pstmt.setString(1, custID);
        pstmt.setString(2, custPassword);
        pstmt.setString(3, custFirstName);
        pstmt.setString(4, custLastName);
        pstmt.setString(5, custAddress);
        pstmt.setString(6, custEmail);

        int rows = pstmt.executeUpdate();
        LOGGER.log(Level.FINE, "insertDB( {0} ): Inserted {1} rows", new Object[]{custID, rows});
    }

    public static void deleteDB(String custID) throws SQLException {
        LOGGER.log(Level.FINEST, "deleteDB( {0} )", custID);

        final PreparedStatement pstmt = SQL.getConnection().prepareStatement(SQL_DELETE);
        pstmt.setString(1, custID);

        int rows = pstmt.executeUpdate();
        LOGGER.log(Level.FINE, "deleteDB( {0} ): Deleted {1} rows", new Object[]{custID, rows});
    }

    @Override
    public String toString() {
        String accountPrettyPrint = "[]";
        if (!accounts.isEmpty()) {
            StringJoiner sj = new StringJoiner("\n\t\t", "[\n\t\t", "\n\t]");
            accounts.stream()
                    .map(Account::toString)
                    .forEach(sj::add);
            accountPrettyPrint = sj.toString();
        }

        return "Customer {"
                + "\n\t id        : " + id
                + "\n\t password  : " + password
                + "\n\t firstName : " + firstName
                + "\n\t lastName  : " + lastName
                + "\n\t address   : " + address
                + "\n\t email     : " + email
                + "\n\t accounts  : " + accountPrettyPrint
                + "\n}";
    }

}
