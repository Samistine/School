package com.samistine.school.java3.lab4;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.impl.SimpleLog;

/**
 *
 * @author Samuel
 */
public final class SQL {

    private static final Logger LOGGER = Logger.getLogger(Account.class.getName());

    private static SQL INSTANCE = new SQL();

    private Connection conn;
    private SQL() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            /* often not required for Java 6 and later (JDBC 4.x) */
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        org.apache.commons.logging.Log l = new SimpleLog("test");
        LOGGER.info(new File(".").getAbsolutePath());
        try {
            conn = DriverManager.getConnection("jdbc:ucanaccess://ChattBankMDB.mdb");
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return INSTANCE.conn;
    }

}
