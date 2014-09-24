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

    private static int apptID = 0;
    private String studentName = null;
    private String studentID = null;
    private String advisorName = null;
    private String description = null;
    private int startHour = 0;
    private int startMinute = 0;
    private int endHour = 0;
    private int endMinute = 0;
    private String date = null;

    public Appointment() {

    }
    
    public boolean initialize(String sName, String sID, String aName, String dp, String date, int sH, int eH, int sM, int eM) {
        this.setStudentName(sName);
        if(this.setStudentID(sID) == false)
            return false;
        this.setAdvisorName(aName);
        this.setDescription(dp);
        this.setDate(date);
        this.setStartHour(sH);
        this.setEndHour(eH);
        this.setStartMinute(sM);
        this.setEndMinute(eM);
        return true;
    }
    
    // Setters
    public void setApptID() {
        this.apptID++;
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
    public String getDate() {
        return this.date;
    }
}
