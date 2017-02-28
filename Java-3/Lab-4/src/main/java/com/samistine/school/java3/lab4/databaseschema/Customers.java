package com.samistine.school.java3.lab4.databaseschema;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Samuel
 */
public class Customers {
    //3001		CustID		VARCHAR(255)
    //1234		CustPassword	VARCHAR(255)
    //Billy		CustFirstName	VARCHAR(255)
    //Carter		CustLastName	VARCHAR(255)
    //Georgia		CustAddress	VARCHAR(255)
    //bc@yahoo.com	CustEmail	VARCHAR(255)

    public static void main(String[] args) throws Exception {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://ChattBankMDB.mdb");
        Statement s = conn.createStatement();
        //ResultSet rs = conn.getMetaData().getColumns(null, null, "Customers", "%");
        ResultSet rs = s.executeQuery("SELECT * FROM CUSTOMERS");
        while (rs.next()) {
            print(rs, 1);
            print(rs, 2);
            print(rs, 3);
            print(rs, 4);
            print(rs, 5);
            print(rs, 6);
            break;
        }
    }

    static void print(ResultSet rs, int pos) throws SQLException {
        System.out.print(rs.getString(pos) + '\t');
        System.out.print(rs.getMetaData().getColumnName(pos) + '\t');
        System.out.println(rs.getMetaData().getColumnTypeName(pos) + "(" + rs.getMetaData().getPrecision(pos) + ")");
    }
}
