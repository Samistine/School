package com.samistine.school.java2.unit06;

public class FacultyTester {
    public static void main(String[] args) throws Exception {
        //First Test
        new Faculty("111221110").print();

        //Second Test
        Faculty sam = new Faculty(
        "9999", "Samuel", 'R', "Seidel", "8000000001", "samuel@samistine.com", 
        "Computers", "2011-11-11", "Professor", 100_000_000, "22");
        
        sam.setFirstName("Devon");
        sam.updateDB();
        
        sam.deleteDB();
        
        try {
            new Faculty("9999").print();
        } catch (IllegalArgumentException ex) {
            System.out.println("Works");
        }        
        
    }
    
}
