


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.impl.SimpleLog;

/**
 *
 * @author Samuel
 */
public class Customer {

    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public Customer(String id, String password, String firstName, String lastName, String address, String email) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
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
// </editor-fold>

    public static Customer getCustomer(String id) throws SQLException {
        org.apache.commons.logging.Log l = new SimpleLog("test");
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Samuel\\Documents\\School\\Java-3\\Lab-3\\ChattBankMDB.mdb");
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Customers WHERE CustID=?");
        pstmt.setString(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) return null;
        if (!rs.isLast()) throw new RuntimeException("Oh no! More than a single customer was returned when querying the id of " + id);

        String customerID = rs.getString("CustID");
        String customerPassword = rs.getString("CustPassword");
        String customerFirstName = rs.getString("CustFirstName");
        String customerLastName = rs.getString("CustLastName");
        String customerAddress = rs.getString("CustAddress");
        String customerEmail = rs.getString("CustEmail");

        Customer customer = new Customer(customerID, customerPassword, customerFirstName, customerLastName, customerAddress, customerEmail);
        return customer;
    }

    static {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            /* often not required for Java 6 and later (JDBC 4.x) */
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
