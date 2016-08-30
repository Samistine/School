package com.samistine.school.java2.unit01;

import java.util.Scanner;
import java.util.TreeSet;
//import javax.swing.JOptionPane;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit01
 * Date: Created Aug 30, 2016 6:44:50 PM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class TextSorter {

    public static void main(String[] args) {
        /* Scanner for getting user input */
        Scanner scanner = new Scanner(System.in);

        /* Don't allow duplicate entries (Different Casing = Different Object) */
        TreeSet<String> list = new TreeSet<>();

        /* String that holds users input */
        String input;

        /* Repeatedly process user input unless they enter "end" */
        //while (!(input = JOptionPane.showInputDialog("Enter a world. Type exit to end")).equals("end")) {
        while (!(input = scanner.next()).equals("end")) {
            list.add(input);
        }

        /* Print out entries */
        list.forEach(System.out::println);
    }

}
