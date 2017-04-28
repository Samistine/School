
import com.samistine.school.java3.dentistapp.data.Appointment;
import com.samistine.school.java3.dentistapp.data.Procedure;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import com.samistine.school.java3.dentistapp.db.DBHandler;
import com.samistine.school.java3.dentistapp.db.SQLQueries;
import java.sql.SQLException;

/**
 *
 * @author Samuel
 */
public class TestDatabase {
    public static void main(String[] args) throws SQLException {
        //Dentist dentist = SQLQueries.getDentist("D202");
        testDentist("D202");
    }

    static void testDentist(String id) throws SQLException {
        Dentist dentist = SQLQueries.getDentist(id);

        System.out.println("### Testing Dentist ###");
        System.out.println("  Id:         " + dentist.getId());
        System.out.println("  Password:   " + dentist.getPassword());
        System.out.println("  First Name: " + dentist.getFirstName());
        System.out.println("  Last Name:  " + dentist.getLastName());
        System.out.println("  Office:     " + dentist.getOffice());
        System.out.println("  Password:   " + dentist.getEmail());
        System.out.println("  Appointments:  ");
        for (Appointment appointment : dentist.appointments()) {
            System.out.println("    " + appointment.getDate());
            System.out.println("      Patient: ");
            Patient patient = appointment.getPatient();
            System.out.println("        Id:         " + patient.getId());
            System.out.println("        Password:   " + patient.getPassword());
            System.out.println("        First Name: " + patient.getFirstName());
            System.out.println("        Last Name:  " + patient.getLastName());
            System.out.println("        Address:    " + patient.getAddress());
            System.out.println("        Email:      " + patient.getEmail());
            System.out.println("      Procedure: ");
            Procedure procedure = appointment.getProcedure();
            System.out.println("        Code: " + procedure.getCode());
            System.out.println("        Name: " + procedure.getName());
            System.out.println("        Desc: " + procedure.getDescription());
            System.out.println("        Cost: " + procedure.getCost());
            System.out.println("");
        }

    }
}
