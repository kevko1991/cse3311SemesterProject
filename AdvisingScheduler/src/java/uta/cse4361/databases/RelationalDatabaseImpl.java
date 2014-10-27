/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.util.ArrayList;
import java.util.Date;
import uta.cse4361.businessobjects.Appointment;
import uta.cse4361.businessobjects.Slot;

/**
 *
 * @author Han
 */
public class RelationalDatabaseImpl implements DatabaseImpInterface{
    
    public RelationalDatabaseImpl() {
        
    }

    @Override
    public boolean isFree(Date date, int startHour, int endHour, int startMinute, int endMinute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String saveSlots(ArrayList<Slot> slots) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String saveAppointment(Appointment appt) {
        RDBImplCommand saveAppointment = new SaveAppointment(appt);
        saveAppointment.execute();
        return (String)saveAppointment.getResult();
    }

    @Override
    public String modifyAppointment(int id, Appointment appt) {
        if (appt == null) {
            //delete
        } else {
            //modify
        }
        return "";
    }

    @Override
    public String modifySlot(int slotID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Appointment> getAppointments() {
        RDBImplCommand getAppointments = new GetAppointments();
        getAppointments.execute();
        return (ArrayList<Appointment>) getAppointments.getResult();
        
    }

    @Override
    public Appointment getAppointment(int apptID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
