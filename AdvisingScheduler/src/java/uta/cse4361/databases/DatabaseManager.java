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
public class DatabaseManager {
    DatabaseImpInterface imp = new RelationalDatabaseImpl();
    
    public boolean isFree(Date date, int startHour, int endHour, int startMinute, int endMinute) {
        
        return true;
    }
    public String saveSlots(ArrayList<Slot> slots) {
        
        return "";
    }
    public String saveAppointment(Appointment appt) {
        
        return "";
    }
    public void modifyAppointment(int id, Appointment appt) {
        imp.modifyAppointment(id, appt);
    }
    public void modifySlot(int slotID) {
        
    }
}
