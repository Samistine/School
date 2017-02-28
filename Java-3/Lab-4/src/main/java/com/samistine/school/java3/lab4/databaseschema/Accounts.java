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
public class Accounts {
    //90000	AcctNo	VARCHAR(255)
    //3003	Cid	VARCHAR(255)
    //SAV	Type	VARCHAR(255)
    //8855.9000	Balance	DECIMAL(100)

    public static void main(String[] args) throws Exception {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://ChattBankMDB.mdb");
        Statement s = conn.createStatement();
        //ResultSet rs = conn.getMetaData().getColumns(null, null, "Customers", "%");
        ResultSet rs = s.executeQuery("SELECT * FROM Accounts");
        while (rs.next()) {
            print(rs, 1);
            print(rs, 2);
            print(rs, 3);
            print(rs, 4);
            break;
        }
    }

    static void print(ResultSet rs, int pos) throws SQLException {
        System.out.print(rs.getString(pos) + '\t');
        System.out.print(rs.getMetaData().getColumnName(pos) + '\t');
        System.out.println(rs.getMetaData().getColumnTypeName(pos) + "(" + rs.getMetaData().getPrecision(pos) + ")");
    }
}
