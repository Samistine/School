package com.samistine.school.java3.dentistapp.data.users;

import com.samistine.school.java3.dentistapp.data.Appointments;

/**
 *
 * @author Samuel Seidel
 */
public interface Dentist extends User {

    /**
     * Get the office the dentist works at.
     *
     * @return office
     */
    String getOffice();

    /**
     * Get the appointments the dentist has scheduled.
     *
     * @return appointments
     */
    Appointments appointments();
}
