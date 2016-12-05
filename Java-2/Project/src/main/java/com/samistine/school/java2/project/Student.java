package com.samistine.school.java2.project;

import java.io.Serializable;
import java.util.Objects;

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
public final class Student implements Serializable, Cloneable {

    private String id;
    private String firstName;
    private char mi;
    private String lastName;
    private String phone;
    private String birthDate;
    private String street;
    private String zip;
    private String deptId;

    public Student(String id, String firstName, char mi, String lastName, String phone, String birthDate, String street, String zip, String deptId) {
        this.id = id;
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.street = street;
        this.zip = zip;
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMi() {
        return mi;
    }

    public void setMi(char mi) {
        this.mi = mi;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", mi=" + mi + ", lastName=" + lastName + ", phone=" + phone + ", birthDate=" + birthDate + ", street=" + street + ", zip=" + zip + ", deptId=" + deptId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + this.mi;
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.birthDate);
        hash = 79 * hash + Objects.hashCode(this.street);
        hash = 79 * hash + Objects.hashCode(this.zip);
        hash = 79 * hash + Objects.hashCode(this.deptId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.mi != other.mi) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        if (!Objects.equals(this.deptId, other.deptId)) {
            return false;
        }
        return true;
    }

}
