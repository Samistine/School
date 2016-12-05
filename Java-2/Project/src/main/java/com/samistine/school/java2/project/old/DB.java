/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.school.java2.project.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author paperspace
 */
//Inlined for delivery to blackboard
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
