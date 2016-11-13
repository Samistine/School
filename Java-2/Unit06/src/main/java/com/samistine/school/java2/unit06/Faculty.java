package com.samistine.school.java2.unit06;

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
 * 2. I have not copied the code from a student or any source.
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
    
    public Faculty() {}
    
    public Faculty(String ssn, String firstName, char mi, String lastName,
    String phone, String email, String office, String startTime,
    String rank, double salary, String deptId) {
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
    }
    
    public Faculty(String ssn) throws SQLException {
        
    }


}
