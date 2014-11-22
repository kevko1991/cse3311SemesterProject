/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import uta.cse4361.databases.DatabaseManager;

/**
 *
 * @author Frank R.
 */

public class SlotFactoryTest implements uta.cse4361.interfaces.Constants{
    
    public SlotFactoryTest() {
    }

    Date currentDate;
    
    @Before
    public void setUp()
    {
        currentDate = new Date();
    }
    /*
    @Test
    public void createAvailableFlyweightTest()
    {
        String result = SlotFactory.getInstance().
                createSlots(currentDate, MIN_HOUR, MIN_HOUR + 1, 
                        MIN_MINUTE, MIN_MINUTE + 30, AVAILABLE_FLYWEIGHT_WITH_SAVE_KEY);
        
        assertEquals("The factory did not return success", "", result);
        
        DatabaseManager dbMgr = new DatabaseManager();
        
        ArrayList<Slot> savedFlyweights = dbMgr.getSlots();
        
        int nextTime = savedFlyweights.get(0).getTime();
        
        assertEquals("The start hour was incorrect", MIN_HOUR, getHour(nextTime));
        assertEquals("The start minute was incorrect", MIN_MINUTE, getMinute(nextTime));
        
        for(Slot flyweight: savedFlyweights)
        {
            assertEquals("The time of the flyweight did not increment correctly.", nextTime, flyweight.getTime());
            assertEquals("The flyweight was not an available flyweight", false, flyweight.isAppointment());   
            
            nextTime = nextTime + INCREMENT_GAP;
        }
        
        assertEquals("The end time was incorrect", getTime(MIN_HOUR + 1, MIN_MINUTE + 30),nextTime);

    }
    
    @Test
    public void createAppointmentFlyweightTest()
    {
        ArrayList<Slot> createdSlots = SlotFactory.getInstance().
                generateSlots(currentDate, MIN_HOUR, MIN_HOUR + 2, 
                        MIN_MINUTE, MIN_MINUTE + 15, VALID_ID,
                        APPOINTMENT_FLYWEIGHT_KEY);
        
        
        int nextTime = createdSlots.get(0).getTime();
        
        assertEquals("The start hour was incorrect", MIN_HOUR, getHour(nextTime));
        assertEquals("The start minute was incorrect", MIN_MINUTE, getMinute(nextTime));
        
        for(Slot flyweight: createdSlots)
        {
            assertEquals("The time of the flyweight did not increment correctly.", nextTime, flyweight.getTime());
            assertEquals("The flyweight was not an appointment flyweight", true, flyweight.isAppointment());   
            
            nextTime = nextTime + INCREMENT_GAP;
        }
        
        assertEquals("The end time was incorrect", getTime(MIN_HOUR + 2, MIN_MINUTE + 15), nextTime);
    }
    
    @Test
    public void createInvalidFlyweightTest()
    {
        String result =SlotFactory.getInstance().
                createSlots(currentDate, MIN_HOUR + 2, MIN_HOUR, 
                        MIN_MINUTE, MIN_MINUTE + 15, 
                        AVAILABLE_FLYWEIGHT_WITH_SAVE_KEY);
        
        assertEquals("An invalid hour did not produce an error", ILLEGAL_ARGUMENT_FAULT, result);
        
        result =SlotFactory.getInstance().
                createSlots(currentDate, MIN_HOUR, MIN_HOUR, 
                        MIN_MINUTE+ 15, MIN_MINUTE, AVAILABLE_FLYWEIGHT_WITH_SAVE_KEY);
        
        assertEquals("An invalid minute did not produce an error", ILLEGAL_ARGUMENT_FAULT, result);
        
        result =SlotFactory.getInstance().
                createSlots(currentDate, MIN_HOUR, MIN_HOUR + 2, 
                        MIN_MINUTE, MIN_MINUTE + 15, "");
        
        assertEquals("An invalid key did not produce an error", ILLEGAL_KEY_FAULT, result);
        
        result =SlotFactory.getInstance().
                createSlots(currentDate, MIN_HOUR - 1, MIN_HOUR, 
                        MIN_MINUTE, MIN_MINUTE + 15, AVAILABLE_FLYWEIGHT_WITH_SAVE_KEY);
        
        assertEquals("An invalid flyweight time did not produce an error", ILLEGAL_FLYWEIGHT_FAULT, result);
        
        result =SlotFactory.getInstance().
                createSlots(currentDate, MIN_HOUR, MIN_HOUR + 1, 
                        MIN_MINUTE - 15, MIN_MINUTE,  
                        AVAILABLE_FLYWEIGHT_WITH_SAVE_KEY);
        
        assertEquals("An invalid flyweight time did not produce an error", ILLEGAL_FLYWEIGHT_FAULT, result);
    }

    private int getHour(int time) 
    {
        return time / 60;
    }
    
    private int getTime(int hour, int minute)
    {
        return ((hour * 60) + minute);
    }
    
    private int getMinute(int time)
    {
        return time % 60;
    }
    */
}

