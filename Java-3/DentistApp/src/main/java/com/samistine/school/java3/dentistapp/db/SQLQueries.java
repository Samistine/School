package com.samistine.school.java3.dentistapp.db;

import com.samistine.school.java3.dentistapp.data.Appointments;
import com.samistine.school.java3.dentistapp.data.Procedure;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import com.samistine.school.java3.dentistapp.db.data.SQLAppointment;
import com.samistine.school.java3.dentistapp.db.data.SQLAppointments;
import com.samistine.school.java3.dentistapp.db.data.users.SQLDentist;
import com.samistine.school.java3.dentistapp.db.data.users.SQLPatient;
import com.samistine.school.java3.dentistapp.db.data.SQLProcedure;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Seidel
 */
public final class SQLQueries {
    
    private static final Logger LOGGER = Logger.getLogger(SQLQueries.class.getName());
    
    public static Patient getPatient(String id) throws SQLException {
        LOGGER.log(Level.FINEST, "getPatient( {0} )", id);
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" SELECT * FROM Patients WHERE patId=? ");
        pstmt.setString(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (!rs.next()) return null;
        if (!rs.isLast()) throw new Error("Oh no! More than a single patient was returned when querying the id of " + id);
        
        return new SQLPatient(rs);
    }
    
    public static Dentist getDentist(String id) throws SQLException {
        LOGGER.log(Level.FINEST, "getDentist( {0} )", id);
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" SELECT * FROM Dentists WHERE id=? ");
        pstmt.setString(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (!rs.next()) return null;
        if (!rs.isLast()) throw new Error("Oh no! More than a single dentist was returned when querying the id of " + id);
        
        return new SQLDentist(rs);
    }
    
    public static List<Dentist> getDentists() throws SQLException {
        LOGGER.log(Level.FINEST, "getDentists()");
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" SELECT * FROM Dentists ");
        
        ResultSet rs = pstmt.executeQuery();
        List<Dentist> dentists = new ArrayList<>();
        
        while (rs.next()) {
            SQLDentist dentist = new SQLDentist(rs);
            dentists.add(dentist);
        }
        
        return dentists;
    }
    
    public static Appointments getAppointmentsWith(Dentist dentist) throws SQLException {
        LOGGER.log(Level.FINEST, "getAppointmentsWith( dentId: {0} )", dentist.getId());
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" SELECT * FROM Appointments WHERE dentId=? ");
        pstmt.setString(1, dentist.getId());
        
        ResultSet rs = pstmt.executeQuery();
        
        return new SQLAppointments(rs);
    }
    
    public static Appointments getAppointmentsWith(Patient patient) throws SQLException {
        LOGGER.log(Level.FINEST, "getAppointmentsWith( patId: {0} )", patient.getId());
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" SELECT * FROM Appointments WHERE patId=? ");
        pstmt.setString(1, patient.getId());
        
        ResultSet rs = pstmt.executeQuery();
        
        return new SQLAppointments(rs);
    }
    
    public static void deleteAppointmentsWith(Patient patient) throws SQLException {
        LOGGER.log(Level.FINEST, "deleteAppointmentsWith( patId: {0} )", patient.getId());
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" DELETE FROM Appointments WHERE patId=? ");
        pstmt.setString(1, patient.getId());
        
        int rowCount = pstmt.executeUpdate();
        
        LOGGER.log(Level.FINEST, "deleteAppointmentsWith( patId: {0} ), {1} row(s) updated", new Object[]{patient.getId(), rowCount});
    }
    
    public static void setAppointment(Patient patient, Dentist dentist, Procedure procedure, Date date) throws SQLException {
        LOGGER.log(Level.FINEST, "setAppointment( patient: {0}, dentist: {1}, procedure: {2}, date: {3} )",
                new Object[]{patient.getId(), dentist.getId(), procedure.getCode(), date});
        
        deleteAppointmentsWith(patient);
        
        Connection connection = DBHandler.getConnection();
//        NamedParameterStatement pstmt = new NamedParameterStatement(connection, ""
//                + "INSERT INTO Appointments (apptDateTime, patId, dentId, procCode) "
//                + " VALUES (:date, :patient, :dentist, :procedure) "
//                + "  ON DUPLICATE KEY UPDATE    "
//                + "   apptDateTime  = :date,    "
//                + "   patId         = :patient, "
//                + "   dentId        = :dentist, "
//                + "   procCode      = :procedure");
//        pstmt.setString("date", SQLAppointment.DF_FORMAT.format(date));
//        pstmt.setString("patient", patient.getId());
//        pstmt.setString("dentist", dentist.getId());
//        pstmt.setString("procedure", procedure.getCode());

        PreparedStatement pstmt = connection.prepareCall(""
                + "INSERT INTO Appointments (apptDateTime, patId, dentId, procCode) "
                + " VALUES (?, ?, ?, ?) ");
        pstmt.setString(1, SQLAppointment.DF_FORMAT.format(date).replace("AM", "am").replace("PM", "pm"));
        pstmt.setString(2, patient.getId());
        pstmt.setString(3, dentist.getId());
        pstmt.setString(4, procedure.getCode());
        
        int rowCount = pstmt.executeUpdate();
        
        LOGGER.log(Level.FINEST, "setAppointment( patient: {0}, dentist: {1}, procedure: {2}, date: {3} ), {4} row(s) updated",
                new Object[]{patient.getId(), dentist.getId(), procedure.getCode(), date, rowCount});
    }
    
    public static Procedure getProcedure(String id) throws SQLException {
        LOGGER.log(Level.FINEST, "getProcedure( {0} )", id);
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" SELECT * FROM Procedures WHERE procCode=? ");
        pstmt.setString(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (!rs.next()) return null;
        if (!rs.isLast()) throw new Error("Oh no! More than a single procedure was returned when querying the id of " + id);
        
        return new SQLProcedure(rs);
    }
    
    public static List<Procedure> getProcedures() throws SQLException {
        LOGGER.log(Level.FINEST, "getProcedures()");
        Connection connection = DBHandler.getConnection();
        PreparedStatement pstmt = connection.prepareCall(" SELECT * FROM Procedures ");
        
        ResultSet rs = pstmt.executeQuery();
        List<Procedure> procedures = new ArrayList<>();
        
        while (rs.next()) {
            SQLProcedure procedure = new SQLProcedure(rs);
            procedures.add(procedure);
        }
        
        return procedures;
    }
    
}
