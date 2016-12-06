package com.samistine.school.java2.project.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Project
 * Date: Created December 5, 2016 11:07:00 AM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source other than my own.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
class DB {
    
    private static DB INSTANCE = new DB();
    public static DB getInstance() {
        return INSTANCE;
    }
    
    //static String url = "jdbc:mysql://node3.codenvy.io:32904/javabook?autoReconnect=true&useSSL=false";
    String url = "jdbc:mysql://localhost/javabook?autoReconnect=true&useSSL=false";
    String username = "scott";
    String password = "tiger";
    
    private Connection conn;

    public Connection connect() throws SQLException {
        if (!isConnected()) {
            if (conn != null) {
                //System.out.println("unexpectedly disconnected from database");
                conn = null;
            }
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(true);
            //db.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            System.out.println("connected to database");
        }
        return conn;
    }

    //See if we need to reconnect
    public boolean isConnected() {
        try {
            return (conn != null) && (!conn.isClosed()) && conn.isValid(1);
        } catch (Exception se) { //Changed from SQLException to all exceptions
            se.printStackTrace();
            return false;
        }
    }

}
