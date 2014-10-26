/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.beans;

import java.util.Date;
import uta.cse4361.businessobjects.Appointment;
import uta.cse4361.databases.DatabaseManager;
import uta.cse4361.interfaces.Constants;

/**
 *
 * @author Frank R.
 */
public class ModifyAppointmentBean implements Constants 
{
    private int appointmentId = 0;
    private String studentName = null;
    private String studentId = null;
    private String advisorName = null;
    private String description = null;
    private String type = null;
    private int startHour = 0;
    private int startMinute = 0;
    private int endHour = 0;
    private int endMinute = 0;
    private Date date = null;

    public ModifyAppointmentBean() {

    }
    
    public String scheduleAppointment() {
        String returnMessage = SUCCESS_MESSAGE;
        Appointment appointment = new Appointment();
        DatabaseManager databaseManager = new DatabaseManager();
        
        boolean result = appointment.initialize(this.studentName, this.studentId,
                this.advisorName, this.type, this.description, this.date, 
                this.startHour, this.endHour, 
                this.startMinute, this.endMinute);
        if(result == false)
        {
            returnMessage = INITIALIZE_APPOINTMENT_FAIL;
        }
        else
        {
            returnMessage = databaseManager.modifyAppointment(this.appointmentId, appointment);
        }
        return returnMessage;
    }
    
    // Setters
    public void setAppointmentId(int newAppointmentId)
    {
        this.appointmentId = newAppointmentId;
    }
    
    public void setStudentName(String newStudnetName) {
        this.studentName = newStudnetName;
    }
    public void setStudentId(String newStudentId) {
        this.studentId = newStudentId;
    }
    public void setAdvisorName(String newAdvisorName) {
        this.advisorName = newAdvisorName;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public void setDate(Date newDate) {
        this.date = newDate;
    }
    public void setStartHour(int newStartHour) {
        this.startHour = newStartHour;
    }
    public void setEndHour(int newEndHour) {
        this.endHour = newEndHour;
    }
    public void setStartMinute(int newStartMinute) {
        this.startMinute = newStartMinute;
    }
    public void setEndMinute(int newEndMinute) {
        this.endMinute = newEndMinute;
    }

    // Getters
    public int getAppointmentId()
    {
        return this.appointmentId;
    }
    public String getStudentName() {
        return this.studentName;
    }
    public String getStudentId() {
        return this.studentId;
    }
    public String getAdvisorName() {
        return this.advisorName;
    }
    public String getType() {
        return this.type;
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
