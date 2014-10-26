/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;
import uta.cse4361.businessobjects.Appointment;

/**
 *
 * @author Han
 */
public class SaveAppointment extends RDBImplCommand{
    
    Appointment appointment;
    
    public SaveAppointment(Appointment appt) {
        super();
        this.appointment = appt;
    }
    @Override
    public void queryDB() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
