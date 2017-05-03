package com.samistine.school.java3.dentistapp.db.data.users;

import com.samistine.school.java3.dentistapp.data.Appointments;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.db.DBHandler;
import com.samistine.school.java3.dentistapp.db.SQLQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Seidel
 */
public final class SQLDentist implements Dentist {

    private String id, password, firstName, lastName, email;
    private String office;

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
    public Type type() {
        return Type.DENTIST;
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
    public void setOffice(String office) {
        if (this.office.equals(office)) return;
        boolean result = setSomeSQL("office", office, "setOffice", true);
        if (result) this.office = office;
    }

    boolean setSomeSQL(String field, Object newValue, String debugMethodName, boolean showValue) {
        try {
            Connection connection = DBHandler.getConnection();
            PreparedStatement pstmt = connection.prepareCall(""
                    + "UPDATE Dentists "
                    + " SET " + field + " = ? "
                    + "  WHERE id = ? ");

            pstmt.setObject(1, newValue);
            pstmt.setString(2, this.id);

            int rowCount = pstmt.executeUpdate();

            Logger.getLogger(getClass().getName()).log(Level.FINEST, "SQLDentist[id: {0}]::{1}( {2}: {3} ), {4} row(s) updated",
                    new Object[]{this.id, debugMethodName, field, showValue ? newValue : "******", rowCount});
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Dentist)) return false;

        final Dentist other = (Dentist) obj;
        return Objects.equals(this.id, other.getId());
    }

}
