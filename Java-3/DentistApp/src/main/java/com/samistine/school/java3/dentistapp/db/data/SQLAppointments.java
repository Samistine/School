package com.samistine.school.java3.dentistapp.db.data;

import com.samistine.school.java3.dentistapp.data.Appointments;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Samuel Seidel
 */
public final class SQLAppointments extends ArrayList<SQLAppointment> implements Appointments {

    public SQLAppointments(ResultSet rs) throws SQLException {
        while (rs.next()) {
            add(new SQLAppointment(rs));
        }
    }

}
