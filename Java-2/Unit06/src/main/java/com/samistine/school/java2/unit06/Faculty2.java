package com.samistine.school.java2.unit06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit06
 * Date: Created Nov 13, 2016 12:57:50 PM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source other than my own.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class Faculty {
    
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public String getSSN(){ return ssn; }
    public void setSSN(String ssn){ this.ssn = ssn; }
    //
    public String getFirstName(){ return firstName; }
    public void setFirstName(String firstName){ this.firstName = firstName; }
    //
    public char getMiddleInitial() { return mi; }
    public void setMiddleInitial(char mi) { this.mi = mi; }
    //
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    //
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    //
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    //
    public String getOffice() { return this.office; }
    public void setOffice(String office) { this.office = office; }
    //
    public String getStartTime(){ return startTime; }
    public void setStartTime( String startTime ) { this.startTime = startTime; }
    //
    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }
    //
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    //
    public String getDepartmentID() { return deptId; }
    public void setDepartmentID(String deptId) { this.deptId = deptId; }
    
    private String ssn;
    private String firstName;
    private char mi;
    private String lastName;
    private String phone;
    private String email; 
    private String office;
    private String startTime;
    private String rank;
    private double salary;
    private String deptId;
    
    //noargs - useless DO NOT USE
    public Faculty() {}
    
    //Inserts if doesn't exists, else updates - undortunate side effect
    public Faculty(String ssn, String firstName, char mi, String lastName,
    String phone, String email, String office, String startTime,
    String rank, double salary, String deptId) throws SQLException {
        this.ssn = ssn;
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.office = office;
        this.startTime = startTime;
        this.rank = rank;
        this.salary = salary;
        this.deptId = deptId;
        Faculty.toDB(this);
    }

    public Faculty(String ssn) throws SQLException, IllegalArgumentException {
        Faculty facultyDB;
        try (
        //Get the connection to the database
        final Connection conn = DB.connect();
        //Create a prepared statement
        final PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Faculty WHERE ssn = ?")) {
            //Set the last and only argument to the ssn from the method call
            pstmt.setString(1, ssn);
            
            try (
            //Execute the prepared statement
            final ResultSet rs = pstmt.executeQuery()) {
                //Check whether we got any results back, we're expecting one or none.
                if (rs.next()) {
                    //We got one, lets convert it to a POJO and return it.
                    facultyDB = fromDB(rs);
                } else {
                    //We got nothing, return null
                    throw new IllegalArgumentException("There is not an entry for ssn: " + ssn);
                }
            }
        }
        this.ssn = facultyDB.getSSN();
        this.firstName = facultyDB.getFirstName();
        this.mi = facultyDB.getMiddleInitial();
        this.lastName = facultyDB.getLastName();
        this.phone = facultyDB.getPhone();
        this.email = facultyDB.getEmail();
        this.office = facultyDB.getOffice();
        this.startTime = facultyDB.getStartTime();
        this.rank = facultyDB.getRank();
        this.salary = facultyDB.getSalary();
        this.deptId = facultyDB.getDepartmentID();
    }
    
    //delete the object in the underlying database
    public void deleteDB() throws SQLException {
        deleteDB(ssn);
    }
    
    //Update database with current values
    public void updateDB() throws SQLException {
        toDB(this);
    }

    //Print out, ide does not have auto toString
    void print() {
        System.out.println("Printing Faculty Fields");
        for (java.lang.reflect.Field field : getClass().getDeclaredFields()) {
            try {
                //field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(this);
                System.out.printf("%s, Field value: %s%n", name, value);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Done \r\n");
    }


    /*
     * Convert from resultset
     */
    static Faculty fromDB(ResultSet rs) throws SQLException {
        //Translate Fields below
        final String ssn = rs.getString("ssn");
        final String firstName = rs.getString("firstName");
        final char mi = rs.getString("mi").charAt(0);
        final String lastName = rs.getString("lastName");
        final String phone = rs.getString("phone");
        final String email = rs.getString("email");
        final String office = rs.getString("office");
        final String startTime = rs.getString("startTime");
        final String rank = rs.getString("rank");
        final double salary = rs.getDouble("salary");
        final String deptId = rs.getString("deptId");

        return new Faculty(ssn, firstName, mi, lastName, phone, email, office, startTime, rank, salary, deptId);
    }
    
    /**
     * Inserts or updates the database with and for the following faculty object
     */
    static void toDB(Faculty pojo) throws SQLException {
        //SQL Code
        String sql = "INSERT INTO Faculty" +
        "  (ssn, firstName, mi, lastName, phone, email, office, startTime, rank, salary, deptId)"+
        "VALUES" +
        "  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
        "ON DUPLICATE KEY UPDATE"+
        "  ssn     = VALUES(ssn),"+
        "  firstName     = VALUES(firstName),"+
        "  mi     = VALUES(mi),"+
        "  lastName     = VALUES(lastName),"+
        "  phone     = VALUES(phone),"+
        "  email     = VALUES(email),"+
        "  office     = VALUES(office),"+
        "  startTime     = VALUES(startTime),"+
        "  rank     = VALUES(office),"+
        "  salary     = VALUES(salary),"+
        "  deptId = VALUES(deptId)";
        
        try (
        //Get the connection to the database
        final Connection conn = DB.connect();//connect
        //Create a prepared statement
        final PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //Set pstmt args below
            pstmt.setString(1, pojo.getSSN());
            pstmt.setString(2, pojo.getFirstName());
            pstmt.setString(3, pojo.getMiddleInitial() + "");
            pstmt.setString(4, pojo.getLastName());
            pstmt.setString(5, pojo.getPhone());
            pstmt.setString(6, pojo.getEmail());
            pstmt.setString(7, pojo.getOffice());
            pstmt.setString(8, pojo.getStartTime());
            pstmt.setString(9, pojo.getRank());
            pstmt.setDouble(10, pojo.getSalary());
            pstmt.setString(11, pojo.getDepartmentID());
            pstmt.execute();//execute
        }
    }
    
    /**
     * Delete rows from Faculty for the specified ssn
     */
    public static void deleteDB(String ssn) throws SQLException {
        try (
        Connection conn = DB.connect();//connect
        PreparedStatement stmt = conn.prepareCall("DELETE FROM Faculty where ssn = ?");) {
            stmt.setString(1, ssn);
            stmt.execute();//execute
        }
    }
}

//Inlined for delivery to blackboard
class DB {
    
//    private static DB INSTANCE;
//    
//    public synchronized static DB getInstance() {
//        if (INSTANCE == null) INSTANCE = new DB();
//        return INSTANCE;
//    }
    
    static String url = "jdbc:mysql://node3.codenvy.io:32904/javabook?autoReconnect=true&useSSL=false";
     //String url = "jdbc:mysql://localhost/javabook?autoReconnect=true&useSSL=false";
    static String username = "scott";
    static String password = "tiger";
    
    private static Connection db;
    
    
    public static Connection connect() throws SQLException {
        if (!isConnected()) {
            if (db != null) {
                System.out.println("unexpectedly disconnected from database");
                db = null;
            }
            db = DriverManager.getConnection(url, username, password);
            db.setAutoCommit(true);
            //db.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            System.out.println("connected to database");
        }
        return db;
    }

    //See if we need to reconnect
    public static boolean isConnected() {
        try {
            return (db != null) && (!db.isClosed()) && db.isValid(1);
        } catch (Exception se) { //Changed from SQLException to all exceptions
            se.printStackTrace();
            return false;
        }
    }

}