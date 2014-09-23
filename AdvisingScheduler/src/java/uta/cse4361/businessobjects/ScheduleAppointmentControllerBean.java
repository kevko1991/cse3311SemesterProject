/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

/**
 *
 * @author Han
 */
public class ScheduleAppointmentControllerBean {
    final static String INITIALIZE_APPOINTMENT_FAIL = "Error when assign studentID, check Appointment.java class";
    
    private int apptID = 0;
    private String studentName = null;
    private String studentID = null;
    private String advisorName = null;
    private String description = null;
    private int startTime = 0;
    private int duration = 0;
    private String date = null;

    public ScheduleAppointmentControllerBean() {

    }
    
    public String scheduleAppointment() {
        Appointment a = new Appointment();
        boolean r = a.initialize(this.studentName, this.studentID, this.advisorName, this.description, this.date, this.startTime, this.duration);
        if(r == false)
            return this.INITIALIZE_APPOINTMENT_FAIL;
        //Scheduler s = new Schedule();
        String msg = ""; 
        //msg = s.schedule(a);
        return msg;
    }
    
    // Setters
    public void setApptID(int ID) {
        this.apptID = ID;
    }
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
    public void setDate(String d) {
        this.date = d;
    }
    public void setStartTime(int start) {
        this.startTime = start;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getters
    public int getApptID() {
        return this.apptID;
    }
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
    public int getStartTime() {
        return this.startTime;
    }
    public int getDuration() {
        return this.duration;
    }
    public String getDate() {
        return this.date;
    }
}
