/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Frank R.
 */
public abstract class Flyweight implements Serializable, Comparable<Flyweight>, uta.cse4361.interfaces.Constants
{
    
    
    
    private int appointmentId;
    
    private boolean hasAppointment;
    
    private Date date;
    
    private int time;
    
    public Flyweight(boolean newHasAppointment, int newAppointmentId, Date newDate, int newHour, int newMinute)
            throws IllegalArgumentException
    {
        hasAppointment = newHasAppointment;
        appointmentId = newAppointmentId;
        date = newDate;
        
        boolean validTime = this.setTime(newHour, newMinute);
        
        if (validTime == false)
        {
            throw new IllegalArgumentException("The hour and minute provided were not within the ranges defined as valid.\n"
                    + "MAX_HOUR = " + Flyweight.MAX_HOUR
                    + ", MIN_HOUR = " + Flyweight.MIN_HOUR
                    + ", MAX_MINUTE = " + Flyweight.MAX_MINUTE
                    + ", MIN_MINUTE = " + Flyweight.MIN_MINUTE);
        }
    }
    
    public boolean isAppointment()
    {
        return hasAppointment;
    }
    
    public int getAppointmentId()
    {
        return appointmentId;
    }
    
    public int getTime()
    {
        return time;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    private void setDate(Date newDate)
    {
        date = newDate;
    }
    
    private void setTime(int newTime)
    {
        time = newTime;
    }
    
    private boolean setTime(int hour, int minute)
    {
        boolean isAccurate = true;
        
        if ((hour < MIN_HOUR) || (hour > MAX_HOUR))
        {
            isAccurate = isAccurate && false;
        }
        
        if ((minute < MIN_MINUTE) || (minute > MAX_MINUTE))
        {
            isAccurate = isAccurate && false;
        }
        
        if(isAccurate)
        {
            setTime((hour * 60) + minute);
        }
        
        return isAccurate;
    }
    
    @Override
    public int compareTo(Flyweight another) {
        Flyweight toCompare = another;
        int compare = 0;
        compare = this.getTime() - another.getTime();
        return compare;
    }
}
