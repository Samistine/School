package com.samistine.school.java3.dentistapp.data;

import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import java.util.Date;

/**
 * Represents an appointment a dentist and a patient mutually have.
 *
 * @author Samuel Seidel
 */
public interface Appointment {

    /**
     * Date of appointment.
     *
     * @return date
     */
    Date getDate();

    /**
     * Patient involved
     *
     * @return patient
     */
    Patient getPatient();

    /**
     * Dentist involved
     *
     * @return
     */
    Dentist getDentist();

    /**
     * Scheduled Procedure
     *
     * @return procedure
     */
    Procedure getProcedure();

}
