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
 * @author Samuel Seidel
 */
public class Customer {

    private String id, password, firstName, lastName, address, email;

    public Customer(String id, String password, String firstName, String lastName, String address, String email) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    public String getId() {        return id;    }
    public String getPassword() {        return password;    }
    public String getFirstName() {        return firstName;    }
    public String getLastName() {        return lastName;    }
    public String getAddress() {        return address;    }
    public String getEmail() {        return email;    }

    public static Customer getCustomer(String id) throws SQLException {
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
