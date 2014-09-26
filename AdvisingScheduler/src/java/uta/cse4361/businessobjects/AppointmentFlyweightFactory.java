/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Frank R.
 */
public class AppointmentFlyweightFactory {
    
    final static String APPOINTMENT_FLYWEIGHT_KEY = "AppointmentFlyweight";
    final static String AVAILABLE_FLYWEIGHT_KEY = "AvailableFlyweight";
    
    final static String ILLEGAL_ARGUMENT_FAULT = "The times that you selected are not valid (i.e. the end hour was before the start hour)";
    final static String ILLEGAL_KEY_FAULT = "The type of flyweight you were attempting to create was not valid.";
    final static String ILLEGAL_FLYWEIGHT_FAULT = "The flyweights could not be created.";
    
    final static int INCREMENT_GAP = 15;
    
    private int nextHour;
    private int nextMinute;
    
    private AppointmentFlyweightFactory() {
    }
    
    public static AppointmentFlyweightFactory getInstance() {
        return AppointmentFlyweightFactoryHolder.INSTANCE;
    }

    private int determineNumberOfFlyweights(int startHour, int endHour, int startMinute, int endMinute) {
        
        int hours = endHour - startHour;
        int numOfFlyweights = hours * (60 / INCREMENT_GAP);
        int minutes = endMinute - startMinute;
        numOfFlyweights = numOfFlyweights + (minutes / INCREMENT_GAP);
        return numOfFlyweights;
    }

    private void updateTimes() 
    {
        nextMinute = nextMinute + INCREMENT_GAP;
        
        if (nextMinute >= 60)
        {
            nextMinute = 0;
            nextHour++;
        }
        
    }
    
    private static class AppointmentFlyweightFactoryHolder {

        private static final AppointmentFlyweightFactory INSTANCE = new AppointmentFlyweightFactory();
    }
    
    public String createFlyweights(Date date, int startHour, int endHour, int startMinute, int endMinute, int apptId, String key)
    {
                
        if((startHour > endHour) || (startMinute > endMinute))
        {
            return ILLEGAL_ARGUMENT_FAULT;
        }
        
        int numberOfFlyweights = determineNumberOfFlyweights(startHour, endHour, startMinute, endMinute);
        
        ArrayList<Flyweight> flyweightsToSave = new ArrayList<Flyweight>();
        
        nextHour = startHour;
        nextMinute = startMinute;
        
        if(key.equals(APPOINTMENT_FLYWEIGHT_KEY))
        {
            for(int i = 0; i < numberOfFlyweights; i++)
            {
                try
                {
                    flyweightsToSave.add(new AppointmentFlyweight(apptId, date, nextHour, nextMinute));
                }
                catch (IllegalArgumentException e)
                {
                    return ILLEGAL_FLYWEIGHT_FAULT;
                }
                updateTimes();
            }
        }
        else if(key.equals(AVAILABLE_FLYWEIGHT_KEY))
        {
            for(int i = 0; i < numberOfFlyweights; i++)
            {
                try
                {
                    flyweightsToSave.add(new AvailableFlyweight(date, nextHour, nextMinute));
                }
                catch (IllegalArgumentException e)
                {
                    return ILLEGAL_FLYWEIGHT_FAULT;
                }
                updateTimes();
            }
        }
        else
        {
            return ILLEGAL_KEY_FAULT;
        }
        
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        return fdb.saveFlyweights(flyweightsToSave);
    }
    
    
}
