/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.Date;

/**
 *
 * @author Han
 */
public class TimeAllocationSlotBean implements java.io.Serializable {
    final static String SUCCESS_MSG = ""; 
    final static String AVAILABLE_FLYWEIGHT_KEY = "AvailableFlyweight";
    
    private Date date;
    private int startHour = 0;
    private int endHour = 0;
    private int startMinute = 0;
    private int endMinute = 0;
    
    public TimeAllocationSlotBean(){
        
    }
    
    public String allocateTime() {
        String msg = SUCCESS_MSG;
        AppointmentFlyweightFactory aff = AppointmentFlyweightFactory.getInstance();
        msg = aff.createFlyweights(date, this.startHour, this.endHour, this.startMinute, this.endMinute, 0, AVAILABLE_FLYWEIGHT_KEY);
        return msg;
    }
    
    // Setters
    public void setDate(Date d){
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
    public Date getDate(){
        return this.date;
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
}
