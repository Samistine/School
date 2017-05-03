package com.samistine.school.java3.dentistapp.db.data.users;

import com.samistine.school.java3.dentistapp.data.Appointment;
import com.samistine.school.java3.dentistapp.data.Appointments;
import com.samistine.school.java3.dentistapp.data.Procedure;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import com.samistine.school.java3.dentistapp.db.DBHandler;
import com.samistine.school.java3.dentistapp.db.SQLQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    private String id, password, firstName, lastName, email;
    private String address, insurance;

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
    public Type type() {
        return Type.PATIENT;
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

    @Override
    public void setPassword(String password) {
        if (this.password.equals(password)) return;
        boolean result = setSomeSQL("passwd", password, "setPassword", false);
        if (result) this.password = password;
    }

    @Override
    public void setFirstName(String firstName) {
        if (this.firstName.equals(firstName)) return;
        boolean result = setSomeSQL("firstName", firstName, "setFirstName", true);
        if (result) this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        if (this.lastName.equals(lastName)) return;
        boolean result = setSomeSQL("lastName", lastName, "setLastName", true);
        if (result) this.lastName = lastName;
    }

    @Override
    public void setEmail(String email) {
        if (this.email.equals(email)) return;
        boolean result = setSomeSQL("email", email, "setEmail", true);
        if (result) this.email = email;
    }

    @Override
    public void setAddress(String address) {
        if (this.address.equals(address)) return;
        boolean result = setSomeSQL("addr", address, "setAddress", true);
        if (result) this.address = address;
    }

    @Override
    public void setInsurance(String insurance) {
        if (this.insurance.equals(insurance)) return;
        boolean result = setSomeSQL("insCo", insurance, "setInsurance", true);
        if (result) this.insurance = insurance;
    }

    boolean setSomeSQL(String field, Object newValue, String debugMethodName, boolean showValue) {
        try {
            Connection connection = DBHandler.getConnection();
            PreparedStatement pstmt = connection.prepareCall(""
                    + "UPDATE Patients "
                    + " SET " + field + " = ? "
                    + "  WHERE patId = ? ");

            pstmt.setObject(1, newValue);
            pstmt.setString(2, this.id);

            int rowCount = pstmt.executeUpdate();

            Logger.getLogger(getClass().getName()).log(Level.FINEST, "SQLPatient[id: {0}]::{1}( {2}: {3} ), {4} row(s) updated",
                    new Object[]{this.id, debugMethodName, field, showValue ? newValue : "******", rowCount});
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
