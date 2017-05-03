package com.samistine.school.java3.dentistapp.data;

import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import java.util.Date;

/**
 *
 * @author Samuel
 */
public interface DataAccess {

    Patient getPatient(String id) throws DataAccessException;
    Patient getDentist(String id) throws DataAccessException;

    Appointments getAppointmentsWith(Dentist dentist) throws DataAccessException;

    Appointments getAppointmentsWith(Patient patient) throws DataAccessException;

    void deleteAppointmentsWith(Patient patient) throws DataAccessException;

    void setAppointment(Patient patient, Dentist dentist, Procedure procedure, Date date) throws DataAccessException;

    Procedure getProcedure(String id) throws DataAccessException;

}
