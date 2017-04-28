package com.samistine.school.java3.dentistapp.db.data.users;

import com.samistine.school.java3.dentistapp.data.Appointment;
import com.samistine.school.java3.dentistapp.data.Appointments;
import com.samistine.school.java3.dentistapp.data.Procedure;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import com.samistine.school.java3.dentistapp.db.SQLQueries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Seidel
 */
public final class SQLPatient implements Patient {

    private final String id, password, firstName, lastName, email;
    private final String address, insurance;

    public SQLPatient(ResultSet rs) throws SQLException {
        this.id = rs.getString("patId");
        this.password = rs.getString("passwd");
        this.firstName = rs.getString("firstName");
        this.lastName = rs.getString("lastName");
        this.email = rs.getString("email");

        this.address = rs.getString("addr");
        this.insurance = rs.getString("insCo");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getInsurance() {
        return insurance;
    }

    @Override
    public Appointment getAppointment() {
        try {
            Appointments appointmentsWith = SQLQueries.getAppointmentsWith(this);
            if (appointmentsWith.isEmpty()) return null;
            if (appointmentsWith.size() > 1) throw new RuntimeException("Impossible, patient has more than one appointment.");
            return appointmentsWith.iterator().next();
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void setAppointment(Dentist dentist, Procedure procedure, Date date) {
        try {
            SQLQueries.setAppointment(this, dentist, procedure, date);
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteAppointment() {
        try {
            SQLQueries.deleteAppointmentsWith(this);
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

}
