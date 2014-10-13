/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;
import java.util.*;
import uta.cse4361.databases.AppointmentDatabaseManager;
import uta.cse4361.databases.FlyweightDatabaseManager;
/**
 *
 * @author Nabin
 */
public class Scheduler implements uta.cse4361.interfaces.Constants{
    FlyweightDatabaseManager fdm =new FlyweightDatabaseManager();
    Date date = new Date();
    AppointmentFlyweightFactory aff =  AppointmentFlyweightFactory.getInstance();
    Appointment a =new Appointment();
    AppointmentDatabaseManager adm = new  AppointmentDatabaseManager();

    
    public Scheduler()
    {
        
    }

    
    public String schedule(Appointment a){
        String msg = SUCCESS_MESSAGE;
        if (fdm.isFree(a.getDate(), a.getStartHour(), a.getEndHour(), a.getStartMinute(),a.getEndMinute())== true )
        {
            msg = aff.createFlyweights(a.getDate(), a.getStartHour(), a.getEndHour(),a.getStartMinute(), a.getEndMinute(), 
                    adm.getNextId(), AppointmentFlyweightFactory.APPOINTMENT_FLYWEIGHT_KEY);   
        }
        else
            msg = TIME_IS_NOT_FREE_FAULT;
        
        if(msg == SUCCESS_MESSAGE)
        {
            adm.saveAppointment(a);
        }
        return msg;
    }
    
}
