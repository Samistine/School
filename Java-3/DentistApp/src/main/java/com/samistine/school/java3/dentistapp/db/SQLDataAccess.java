package com.samistine.school.java3.dentistapp.db;

import com.samistine.school.java3.dentistapp.data.Appointments;
import com.samistine.school.java3.dentistapp.data.DataAccess;
import com.samistine.school.java3.dentistapp.data.DataAccessException;
import com.samistine.school.java3.dentistapp.data.Procedure;
import com.samistine.school.java3.dentistapp.data.users.Dentist;
import com.samistine.school.java3.dentistapp.data.users.Patient;
import java.util.Date;

/**
 *
 * @author Samuel
 */
public class SQLDataAccess implements DataAccess {
    @Override
    public Patient getPatient(String id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Patient getDentist(String id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Appointments getAppointmentsWith(Dentist dentist) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Appointments getAppointmentsWith(Patient patient) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void deleteAppointmentsWith(Patient patient) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setAppointment(Patient patient, Dentist dentist, Procedure procedure, Date date) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Procedure getProcedure(String id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
