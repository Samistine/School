package com.samistine.school.java2.unit06;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        FacultyDB db = new FacultyDB();
        db.getFacultyBySSN("");
    }
}
