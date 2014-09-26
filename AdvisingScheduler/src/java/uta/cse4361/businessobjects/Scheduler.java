/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;
import java.util.*;
/**
 *
 * @author Nabin
 */
public class Scheduler {
    FlyweightDatabaseManager fdm =new FlyweightDatabaseManager();
    Date date = new Date();
    AppointmentFlyweightFactory aff =  AppointmentFlyweightFactory.getInstance();
    Appointment a =new Appointment();
    AppointmentDatabaseManager adm = new  AppointmentDatabaseManager();
    final static String SUCCESS_MSG = ""; 
    final static String TIME_IS_NOT_FREE_FAULT = "The time for the appointment is not free.";
    public Scheduler()
    {
        
    }

    
    public String schedule(Appointment a){
        String msg = SUCCESS_MSG;
        if (fdm.isFree(a.getDate(), a.getStartHour(), a.getEndHour(), a.getStartMinute(),a.getEndMinute())== true )
        {
            msg = aff.createFlyweights(a.getDate(), a.getStartHour(), a.getEndHour(),a.getStartMinute(), a.getEndMinute(), 
                    adm.getNextId(), AppointmentFlyweightFactory.APPOINTMENT_FLYWEIGHT_KEY);   
        }
        else
            msg = TIME_IS_NOT_FREE_FAULT;
        
        if(msg == SUCCESS_MSG)
        {
            adm.saveAppointment(a);
        }
        return msg;
    }
    
}
