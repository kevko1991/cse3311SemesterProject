/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.beans;

import java.util.Date;
import uta.cse4361.businessobjects.Appointment;
import uta.cse4361.businessobjects.Scheduler;
import uta.cse4361.interfaces.Constants;

/**
 *
 * @author Han
 */
public class ScheduleAppointmentControllerBean implements Constants{
    
    
    private String studentName = null;
    private String studentID = null;
    private String advisorName = null;
    private String description = null;
    private int startHour = 0;
    private int startMinute = 0;
    private int endHour = 0;
    private int endMinute = 0;
    private Date date = null;

    public ScheduleAppointmentControllerBean() {

    }
    
    public String scheduleAppointment() {
        String msg = SUCCESS_MESSAGE;
        Appointment a = new Appointment();
        boolean r = a.initialize(this.studentName, this.studentID, this.advisorName, this.description, this.date, this.startHour, this.endHour, this.startMinute, this.endMinute);
        if(r == false)
            return this.INITIALIZE_APPOINTMENT_FAIL;
        Scheduler s = new Scheduler();
        msg = s.schedule(a);
        return msg;
    }
    
    // Setters
    public void setStudentName(String sName) {
        this.studentName = sName;
    }
    public void setStudentID(String sID) {
        this.studentID = sID;
    }
    public void setAdvisorName(String aName) {
        this.advisorName = aName;
    }
    public void setDescription(String dp) {
        this.description = dp;
    }
    public void setDate(Date d) {
        this.date = d;
    }
    public void setStartHour(int sH) {
        this.startHour = sH;
    }
    public void setEndHour(int eH) {
        this.endHour = eH;
    }
    public void setStartMinute(int sM) {
        this.startMinute = sM;
    }
    public void setEndMinute(int eM) {
        this.endMinute = eM;
    }

    // Getters
    public String getStudentName() {
        return this.studentName;
    }
    public String getStudentID() {
        return this.studentID;
    }
    public String getAdvisorName() {
        return this.advisorName;
    }
    public String getDescription() {
        return this.description;
    }
    public int getStartHour() {
        return this.startHour;
    }
    public int getEndHour() {
        return this.endHour;
    }
    public int getStartMinute() {
        return this.startMinute;
    }
    public int getEndMinute() {
        return this.endMinute;
    }
    public Date getDate() {
        return this.date;
    }
}
