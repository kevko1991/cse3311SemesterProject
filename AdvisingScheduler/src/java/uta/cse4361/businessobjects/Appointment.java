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
public class Appointment implements java.io.Serializable {

    private int apptID = 0;
    private String studentName = null;
    private String studentID = null;
    private String advisorName = null;
    private String description = null;
    private int startTime = 0;
    private int duration = 0;
    private String date = null;

    public Appointment() {

    }
    
    public boolean initialize(String sName, String sID, String aName, String dp, String date, int sTime, int duration) {
        this.setStudentName(sName);
        if(this.setStudentID(sID) == false)
            return false;
        this.setAdvisorName(aName);
        this.setDescription(dp);
        this.setDate(date);
        this.setStartTime(sTime);
        this.setDuration(duration);
        return true;
    }
    
    // Setters
    public void setApptID(int ID) {
        this.apptID = ID;
    }
    public void setStudentName(String sName) {
        this.studentName = sName;
    }
    public boolean setStudentID(String sID) {
        if((sID.length() != 10) || (sID.indexOf(0) != 1) || (sID.indexOf(0) != 6)) {
            return false;
        }
        this.studentID = sID;
        return true;
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
    public void setDuration(int end) {
        this.duration = end;
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
