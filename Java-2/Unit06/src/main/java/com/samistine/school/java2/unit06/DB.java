package com.samistine.school.java2.unit06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlDataSourceFactory;

//Singleton
public class DB {
    
    private static DB INSTANCE;
    
    public synchronized static DB getInstance() {
        if (INSTANCE == null) INSTANCE = new DB();
        return INSTANCE;
    }
    
    private MysqlDataSource ds;
    
    DB() {
        try {
            // Load the JDBC driver 
            Class.forName("com.mysql.jdbc.Driver"); 
            System.out.println("Driver loaded"); 
            
            this.ds = new MysqlDataSource();
            ds.setUrl("jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false");
            ds.setUser("scott");
            ds.setPassword("tiger");
            try {
                ds.getConnection()
                    .close();
                System.out.println("Database connected"); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        INSTANCE = this;
    }
    
    public DataSource getDataSource() { return ds; }



}
