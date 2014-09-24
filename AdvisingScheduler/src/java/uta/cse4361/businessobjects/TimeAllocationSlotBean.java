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
    private int startTime = 0;
    private int endTime = 0;
    
    public TimeAllocationSlotBean(){
        
    }
    
    public String allocateTime() {
        String msg = SUCCESS_MSG;
        AppointmentFlyweightFactory aff = AppointmentFlyweightFactory.getInstance();
        msg = aff.createFlyweights(date, this.startTime, this.endTime, AVAILABLE_FLYWEIGHT_KEY);
        return msg;
    }
    
    // Setters
    public void setStartTime(int sTime) {
        this.startTime = sTime;
    }
    public void setEndTime(int eTime) {
        this.endTime = eTime;
    }
    
    // Getters
    public int getStartTime() {
        return this.startTime;
    }
    public int getEndTime() {
        return this.endTime;
    }
}
