package com.samistine.school.java2.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author samistine
 */
public final class StudentDAO {
    
    Connection getConnection() throws SQLException {
        return DB.getInstance().connect();
    }

    /**
     * This method is intended to insert the fields of a student object into the
     * database creating a new row in the Student table.
     *
     * @param aStudent - A Student object reference for the student to be
     * inserted into the database.
     * @return true if student is inserted, false if it was not.
     */
    public boolean insertStudent(Student aStudent) {
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareCall("INSERT INTO student "
                        + "("
                        + " id,"
                        + " firstName,"
                        + " mi,"
                        + " lastName,"
                        + " phone,"
                        + " birthDate,"
                        + " street,"
                        + " zip,"
                        + " deptId"
                        + ")"
                        + "VALUES (?,?,?,?,?,?,?,?,?)")) {

            /* Set Params */
            pstmt.setString(1, aStudent.getId());
            pstmt.setString(2, aStudent.getFirstName());
            pstmt.setString(3, String.valueOf(aStudent.getMi()));
            pstmt.setString(4, aStudent.getLastName());
            pstmt.setString(5, aStudent.getPhone());
            pstmt.setString(6, aStudent.getBirthDate());
            pstmt.setString(7, aStudent.getStreet());
            pstmt.setString(8, aStudent.getZip());
            pstmt.setString(9, aStudent.getDeptId());

            /* Execute Insert */
            int rowsUpdated = pstmt.executeUpdate();

            /* A value of 1 means one row was inserted which is what we want */
            boolean success = (rowsUpdated == 1);

            /* Return */
            return success;
        } catch (SQLException ex) {
            /* An error occured, print stacktrace, return false, and move on */
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * This method is intended to delete a row from the Student table. The user
     * supplies a string containing the exact stuId for the row to be deleted.
     * The method will delete the matching row from the Student table and return
     * true if successful, false if row not found.
     *
     * @param stuId The exact key for the row to be deleted
     * @return true means row deleted, false means row not found or other SQL
     * error.
     */
    public boolean deleteStudent(String stuId) {
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareCall("DELETE FROM student WHERE id=?")) {

            /* Set Param */
            pstmt.setString(1, stuId);

            /* Execute Delete */
            int rowsModified = pstmt.executeUpdate();

            /* A value of 1 means one row was de,eted which is what we want */
            boolean success = (rowsModified == 1);

            /* Return */
            return success;
        } catch (SQLException ex) {
            /* An error occured, print stacktrace, return false, and move on */
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * This method is used to find one particular student in the Student table
     * in the database. The user supplies a string containing the exact stuId
     * for the row to be retrieved. The method finds the row, creates a Student
     * object and populates it's fields with the data from the matching row.
     *
     * @param stuId The exact key for the row to be retrieved
     * @return A Student object reference or null if the row does not exist.
     */
    public Student findStudent(String stuId) {
        Collection<Student> students = selectStudents(stuId);
        if (students == null) {
            //No student was found
            return null;
        }
        
        if (students.size() > 1) {
            throw new NullPointerException("Multiple results were found");
        }
        
        return students.iterator().next();
    }

    /**
     * This method is used to update an existing Student row in the Student
     * table in the database. The user provides a Student object reference. The
     * Student object contains the updated data. All fields (except stuId) are
     * then used to update the matching row in the Student table in the
     * database.
     *
     * @param aStudent - The student object containing the data to update the
     * corresponding row in the database.
     *
     * @return true means update was successful, false means update failed. This
     * usually means the stuId was not found.
     */
    public boolean updateStudent(Student aStudent) {
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareCall("UPDATE student SET "
                        + "firstName=?,"
                        + "mi=?,"
                        + "lastName=?,"
                        + "phone=?,"
                        + "birthDate=?,"
                        + "street=?,"
                        + "zip=?,"
                        + "deptId=?"
                        + " WHERE id=?")) {

            /* Set Params */
            pstmt.setString(1, aStudent.getFirstName());
            pstmt.setString(2, String.valueOf(aStudent.getMi()));
            pstmt.setString(3, aStudent.getLastName());
            pstmt.setString(4, aStudent.getPhone());
            pstmt.setString(5, aStudent.getBirthDate());
            pstmt.setString(6, aStudent.getStreet());
            pstmt.setString(7, aStudent.getZip());
            pstmt.setString(8, aStudent.getDeptId());
            
            pstmt.setString(9, aStudent.getId());

            /* Execute Insert */
            int rowsUpdated = pstmt.executeUpdate();

            /* A value of 1 means one row was inserted which is what we want */
            boolean success = (rowsUpdated == 1);

            /* Return */
            return success;
        } catch (SQLException ex) {
            /* An error occured, print stacktrace, return false, and move on */
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * This method is used to get a number of Student records back from the
     * database in the form of a Collection of Student objects. The user
     * provides a String that normally contains part of an stuId and a wild card
     * character, a "%". The method returns an ArrayList containing Student
     * objects containing data from the matching rows, one Student object per
     * row. If the Collection reference returned is null, no matching students
     * were found in the database.
     *
     * @param stuId - A String that is assumed to contain part of an stuId and a
     * wild card character.
     *
     * @return A Collection reference containing some number of Student objects,
     * or null if none were found.
     */
    public Collection<Student> selectStudents(String stuId) {
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareCall("SELECT * FROM student WHERE id=?")) {

            /* Set Param */
            pstmt.setString(1, stuId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                /* Holding Collection */
                Collection<Student> students = new ArrayList<>();
                
                while (rs.next()) {
                    String id = rs.getString("id");
                    String firstName = rs.getString("firstName");
                    char mi = rs.getString("mi").charAt(0);
                    String lastName = rs.getString("lastName");
                    String phone = rs.getString("phone");
                    String birthDate = rs.getString("birthDate");
                    String street = rs.getString("street");
                    String zip = rs.getString("zip");
                    String deptId = rs.getString("deptId");

                    //Create Student
                    Student student = new Student(
                            id,
                            firstName,
                            mi,
                            lastName,
                            phone,
                            birthDate,
                            street,
                            zip,
                            deptId
                    );

                    //Add student to collection
                    students.add(student);
                }
                
                if (students.isEmpty()) {
                    return null;
                }

                //Return found students
                return students;
                
            }
        } catch (SQLException ex) {
            /* An error occured, print stacktrace, return null, and move on */
            ex.printStackTrace();
            return null;
        }
    }
    
}
