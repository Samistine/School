package com.samistine.school.java3.lab5;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 *
 * @author Samuel
 */
public class AccountTester {
    public static void main(String[] args) throws SQLException {
        Account c1 = new Account();
        System.out.println(c1);

        Collections.list(LogManager.getLogManager().getLoggerNames()).stream()
                .map(loggerName -> LogManager.getLogManager().getLogger(loggerName))
                .forEach(logger -> logger.setLevel(Level.ALL));

        c1.selectDB("90000");
        System.out.println(c1);

        c1.selectDB("90001");
        System.out.println(c1);

        c1.selectDB("90002");
        System.out.println(c1);

        c1.selectDB("90003");
        System.out.println(c1);

        Account.deleteDB("test");//Clear previous states incase

        Account.insertDB("test", "OwnerID", "A Savings Account", BigDecimal.ONE);
        c1.selectDB("test");
        System.out.println(c1);

        Account.deleteDB("test");
        try {
            c1.selectDB("test");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
