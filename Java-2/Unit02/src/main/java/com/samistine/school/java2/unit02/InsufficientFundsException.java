package com.samistine.school.java2.unit02;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit02
 * Date: Created Sep 6, 2016 7:54:36 PM
 * 
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 * 
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class InsufficientFundsException extends Exception {

    /**
     * Creates a new InsufficientFundsException exception
     * with a message explaining why the error occurred.
     *
     * @param message explaining the error that occurred.
     * @param args optional arguments to replace variables in <u>message</u>
     */
    public InsufficientFundsException(String message, Object... args) {
        super(String.format(message, args));
    }

}
