package com.samistine.school.java2.unit03;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit03
 * Date: Created Sep 16, 2016 1:11:50 PM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class Student {
    private final int ssn;
    private final String first_name;
    private final String last_name;
    private final String major;

    /**
     * Construct a Student
     *
     * @param ssn Social Security number
     * @param first_name first name
     * @param last_name last name
     * @param major major
     */
    public Student(int ssn, String first_name, String last_name, String major) {
        this.ssn = ssn;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
    }

    /**
     * Get Social Security number of student.
     *
     * @return ssn
     */
    public int getSSN() {
        return ssn;
    }

    /**
     * Get the student's first name.
     *
     * @return first_name
     */
    public String getFirstName() {
        return first_name;
    }

    /**
     * Get the student's last name.
     *
     * @return first_name
     */
    public String getLastName() {
        return last_name;
    }

    /**
     * Get the student's major.
     *
     * @return first_name
     */
    public String getMajor() {
        return major;
    }
}
