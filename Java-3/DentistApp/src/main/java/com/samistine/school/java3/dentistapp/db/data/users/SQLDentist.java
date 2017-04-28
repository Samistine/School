package com.samistine.school.java3.dentistapp.db.data.users;

import com.samistine.school.java3.dentistapp.data.Appointments;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.db.SQLQueries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Seidel
 */
public final class SQLDentist implements Dentist {

    private final String id, password, firstName, lastName, email;
    private final String office;

    public SQLDentist(ResultSet rs) throws SQLException {
        this.id = rs.getString("id");
        this.password = rs.getString("passwd");
        this.firstName = rs.getString("firstName");
        this.lastName = rs.getString("lastName");
        this.email = rs.getString("email");

        this.office = rs.getString("office");
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
    public String getOffice() {
        return office;
    }

    @Override
    public Appointments appointments() {
        try {
            return SQLQueries.getAppointmentsWith(this);
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
