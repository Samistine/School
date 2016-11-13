package com.samistine.school.java2.unit06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class FacultyDB {

    public Faculty getFacultyBySSN(String ssn) throws SQLException {
        try (
        //Get a connection to the database
        final Connection conn = DB.getInstance().getDataSource().getConnection();
        //Create a prepared statement
        final PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM FACULTY WHERE ssn = ?")) {
            //Set the last and only argument to the ssn from the method call
            pstmt.setString(0, ssn);
            
            try (
            //Execute the prepared statement
            final ResultSet rs = pstmt.executeQuery()) {
                //Check whether we got any results back, we're expecting one or none.
                if (rs.next()) {
                    //We got one, lets convert it to a POJO and return it.
                    return fromDB(rs);
                } else {
                    //We got nothing, return null
                    return null;
                }
            }
            
        }
    }

    Faculty fromDB(ResultSet rs) throws SQLException {
        final String ssn = rs.getString("ssn");
        final String firstName = rs.getString("firstName");
        final char mi = rs.getObject("char", java.lang.Character.class);
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
    
    void toDB(Faculty pojo) {
        
    }


}
