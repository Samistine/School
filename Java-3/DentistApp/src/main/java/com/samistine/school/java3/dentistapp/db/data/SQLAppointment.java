package com.samistine.school.java3.dentistapp.db.data;

import com.samistine.school.java3.dentistapp.data.Appointment;
import com.samistine.school.java3.dentistapp.data.Procedure;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import com.samistine.school.java3.dentistapp.db.SQLQueries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Seidel
 */
public final class SQLAppointment implements Appointment {

    public static final DateFormat DF_FORMAT = new SimpleDateFormat("MMM d, yyyy, ha");
    public static final DateFormat DF_PARSE = new SimpleDateFormat("MMM d, yyyy, h a");

    private final Date date;
    private final String patId, dentId, procCode;

    public SQLAppointment(ResultSet rs) throws SQLException {
        Date lDate;
        try {
            lDate = DF_PARSE.parse(rs.getString("apptDateTime").replaceAll("(\\d)am", "$1 AM").replaceAll("(\\d)pm", "$1 PM"));
        } catch (ParseException ex) {
            Logger.getLogger(SQLAppointment.class.getName()).log(Level.SEVERE, null, ex);
            lDate = new Date(0);
        }

        this.date = lDate;
        this.patId = rs.getString("patId");
        this.dentId = rs.getString("dentId");
        this.procCode = rs.getString("procCode");
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public Patient getPatient() {
        try {
            return SQLQueries.getPatient(patId);
        } catch (SQLException ex) {
            Logger.getLogger(SQLAppointment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Dentist getDentist() {
        try {
            return SQLQueries.getDentist(dentId);
        } catch (SQLException ex) {
            Logger.getLogger(SQLAppointment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Procedure getProcedure() {
        try {
            return SQLQueries.getProcedure(procCode);
        } catch (SQLException ex) {
            Logger.getLogger(SQLAppointment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
