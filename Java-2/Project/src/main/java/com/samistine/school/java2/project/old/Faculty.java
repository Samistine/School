package com.samistine.school.java2.project.old;

import java.sql.Connection;
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
        //Save to database, overrides existing entry on duplicate key(SSN)
        saveToDB();
    }

    public Faculty(String ssn) throws SQLException, IllegalArgumentException {
        this.ssn = ssn;
        loadFromDB();
    }
    
    //delete the object in the underlying database
    public void deleteDB() throws SQLException {
        deleteDB(ssn);
    }
    
    //Update database with current values
    public void updateDB() throws SQLException {
        saveToDB();
    }

    /**
     * Discards any data and gets the state directly from the database using the
     * faculty's ssn.
     * 
     * @throws Exception 
     */
    void loadFromDB() throws SQLException {
        try (
        //Get the connection to the database
        final Connection conn = DB.getInstance().connect();
        //Create a prepared statement
        final PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Faculty WHERE ssn = ?")) {
            //Set the last and only argument to the ssn from the method call
            pstmt.setString(1, ssn);
            
            try (
            //Execute the prepared statement
            final ResultSet rs = pstmt.executeQuery()) {
                //Check whether we got any results back, we're expecting one or none.
                if (rs.next()) {
                    this.ssn = rs.getString("ssn");
                    this.firstName = rs.getString("firstName");
                    this.mi = rs.getString("mi").charAt(0);
                    this.lastName = rs.getString("lastName");
                    this.phone = rs.getString("phone");
                    this.email = rs.getString("email");
                    this.office = rs.getString("office");
                    this.startTime = rs.getString("startTime");
                    this.rank = rs.getString("rank");
                    this.salary = rs.getDouble("salary");
                    this.deptId = rs.getString("deptId");
                } else {
                    //We got nothing, return null
                    throw new IllegalArgumentException("There is not an entry for ssn: " + ssn);
                }
            }
        }
    }
    
    /**
     * Inserts or updates the database with and for the following faculty object
     */
    void saveToDB() throws SQLException {
        //SQL Code
        final String sql = "" +
        "INSERT INTO Faculty (ssn, firstName, mi, lastName, phone, email, office, startTime, rank, salary, deptId) "+
        "VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "+
        "ON DUPLICATE KEY UPDATE "+
        "  ssn           = VALUES(ssn),"+
        "  firstName     = VALUES(firstName),"+
        "  mi            = VALUES(mi),"+
        "  lastName      = VALUES(lastName),"+
        "  phone         = VALUES(phone),"+
        "  email         = VALUES(email),"+
        "  office        = VALUES(office),"+
        "  startTime     = VALUES(startTime),"+
        "  rank          = VALUES(office),"+
        "  salary        = VALUES(salary),"+
        "  deptId        = VALUES(deptId)";
        
        try (
        //Get the connection to the database
         final Connection conn = DB.getInstance().connect();//connect
        //Create a prepared statement
         final PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //Set pstmt args below
            pstmt.setString(1, this.ssn);
            pstmt.setString(2, this.firstName);
            pstmt.setString(3, String.valueOf(this.mi));//char
            pstmt.setString(4, this.lastName);
            pstmt.setString(5, this.phone);
            pstmt.setString(6, this.email);
            pstmt.setString(7, this.office);
            pstmt.setString(8, this.startTime);
            pstmt.setString(9, this.rank);
            pstmt.setDouble(10, this.salary);
            pstmt.setString(11, this.deptId);
            //Execute
            pstmt.execute();//execute
        }
    }
    
    /**
     * Delete rows from Faculty for the specified ssn
     */
    public static void deleteDB(String ssn) throws SQLException {
        try (
         final Connection conn = DB.getInstance().connect();//connect
         final PreparedStatement stmt = conn.prepareCall("DELETE FROM Faculty where ssn = ?");) {
            stmt.setString(1, ssn);
            stmt.execute();//execute
        }
    }
}