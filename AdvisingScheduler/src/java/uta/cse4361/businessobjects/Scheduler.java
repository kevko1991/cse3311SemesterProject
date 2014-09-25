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
    final static String AVAILABLE_FLYWEIGHT_KEY = "AvailableFlyweight";
    public Scheduler()
    {
        
    }

    
    public String Schedule(Appointment a){
        String msg = SUCCESS_MSG;
        if (fdm.isFree(a.getDate(), a.getStartHour(), a.getEndHour(), a.getStartMinute(),a.getEndMinute())== true )
        {
            msg = aff.createFlyweights(a.getDate(), a.getStartHour(), a.getEndHour(),a.getStartMinute(), a.getEndMinute(), AVAILABLE_FLYWEIGHT_KEY);   
                adm.saveAppointment(a);
        }
        else
            msg = "";
        return msg;
    }
    
}
