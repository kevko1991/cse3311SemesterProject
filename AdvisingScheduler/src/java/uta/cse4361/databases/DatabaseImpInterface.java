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

public interface DatabaseImpInterface {
    public boolean isFree(Date date, int startHour, int endHour, int startMinute, int endMinute);
    public String saveSlots(ArrayList<Slot> slots);
    public String saveAppointment(Appointment appt);
    public ArrayList<Appointment> getAppointments();
    public Appointment getAppointment(int apptID);
    public String modifyAppointment(int id, Appointment appt);
    public String modifySlot(int slotID);
}
