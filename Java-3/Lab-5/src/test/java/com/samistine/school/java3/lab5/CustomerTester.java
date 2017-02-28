package com.samistine.school.java3.lab5;

import java.sql.SQLException;

/**
 *
 * @author Samuel
 */
public class CustomerTester {
    public static void main(String[] args) throws SQLException {
        Customer c1 = new Customer();
        System.out.println(c1);

        c1.selectDB("3001");
        System.out.println(c1);

        c1.selectDB("3002");
        System.out.println(c1);

        Customer.deleteDB("test");//Clear previous states incase

        Customer.insertDB("test", "myPass202$", "John", "Krow", "123 Elm Street", "horrors@elm.street");
        c1.selectDB("test");
        System.out.println(c1);

        Customer.deleteDB("test");
        try {
            c1.selectDB("test");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
