package com.samistine.school.java2.unit06;

public class FacultyTester2 {
    public static void main(String[] args) throws Exception {
        //Preload
        try {
            Class.forName("com.samistine.school.java2.unit06.Faculty");
            Class.forName("com.samistine.school.java2.unit06.Faculty2");
            Class.forName("com.samistine.school.java2.unit06.DB");
        } catch (Exception ex) {
            System.err.println("Couldn't preload");
            ex.printStackTrace();
        }
        
        long begin = System.currentTimeMillis();
        //First Test
        print(new Faculty2("111221110"));

        //Second Test
        Faculty2 sam = new Faculty2(
        "9999", "Samuel", 'R', "Seidel", "8000000001", "samuel@samistine.com", 
        "Computers", "2011-11-11", "Professor", 100_000_000, "22");
        
        sam.setFirstName("Devon");
        sam.updateDB();
        
        print(new Faculty2("9999"));
        
        sam.deleteDB();
        
        try {
            print(new Faculty2("9999"));
        } catch (IllegalArgumentException ex) {
            System.out.println("Works");
        }
        
        final long now = System.currentTimeMillis();
        System.out.println();
        System.out.println("Total Time: " + (now-begin) + "ms");
    }
    
    //Print object that doesn't implement toString
    public static void print(Object o) {
        System.out.println("Printing Faculty2 Fields");
        for (java.lang.reflect.Field field : o.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(o);
                System.out.printf(" %s: %s%n", name, value);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Done \r\n");
    }
}
