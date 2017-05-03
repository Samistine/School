package com.samistine.school.java3.dentistapp.data.users;

import com.samistine.school.java3.dentistapp.data.Appointment;
import com.samistine.school.java3.dentistapp.data.Procedure;
import java.util.Date;

/**
 *
 * @author Samuel Seidel
 */
public interface Patient extends User {

    /**
     * Get the address of the patient.
     *
     * @return address
     */
    String getAddress();

    /**
     * Get the insurance of the patient.
     *
     * @return patient
     */
    String getInsurance();

    /**
     * Get the appointment the patient may have.
     * <b> null </b> if the patient has no appointment
     *
     * @return
     */
    Appointment getAppointment();

    void setAddress(String address);

    void setInsurance(String insurance);

    /**
     * Adds, or updates if existing, an appointment for the patient.
     *
     * @param dentist to schedule with
     * @param procedure to have
     * @param date to happen on
     */
    void setAppointment(Dentist dentist, Procedure procedure, Date date);

    /**
     * Delete any existing appointment.
     */
    void deleteAppointment();
}
