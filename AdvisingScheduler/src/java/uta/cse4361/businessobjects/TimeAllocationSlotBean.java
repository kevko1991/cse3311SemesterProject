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
public class TimeAllocationSlotBean {
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
        msg = aff.createFlyweights(date, this.startHour, this.startHour, this.startMinute, this.endMinute, AVAILABLE_FLYWEIGHT_KEY);
        return msg;
    }
    
    // Setters
    public void setStartHour(int sH) {
        this.startHour = sH;
    }
    public void setEndHour(int eH) {
        this.startHour = eH;
    }
    public void setStartMinute(int sM) {
        this.startHour = sM;
    }
    public void setEndMinute(int eM) {
        this.endMinute = eM;
    }
    
    // Getters
    public int getStartHour() {
        return this.startHour;
    }
    public int getEndHour() {
        return this.endHour;
    }
    public int getStartMinute() {
        return this.endHour;
    }
    public int getEndMinute() {
        return this.endHour;
    }
}
