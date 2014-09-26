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

/**
 *
 * @author Frank R.
 */

public class AppointmentFlyweightFactoryTest {
    
    public AppointmentFlyweightFactoryTest() {
    }

    Date currentDate;
    
    @BeforeClass
    public static void beforeClass()
    {
        /*
        File dataFile = new File(FlyweightDatabaseManager.FDB_FILE_NAME);
        File tempDataFile = new File("backup_FDB_file");
        
        tempDataFile.delete();
        
        if(dataFile.exists())
        {
            if(!dataFile.renameTo(tempDataFile))
            {
                fail();
            }
        }
       */ 
    }
    
    @AfterClass
    public static void afterClass()
    {
        /*
        File dataFile = new File(FlyweightDatabaseManager.FDB_FILE_NAME);
        File tempDataFile = new File("backup_FDB_file");
        
        if(tempDataFile.exists())
        {
            if(!tempDataFile.renameTo(dataFile))
            {
                fail();
            }
        }
        
        File toDelete = new File("backup_FDB_file");
        toDelete.delete();
        */
    }
    
    @Before
    public void setUp()
    {
        currentDate = new Date();
    }
    
    @Test
    public void createAvailableFlyweightTest()
    {
        String result = AppointmentFlyweightFactory.getInstance().
                createFlyweights(currentDate, Flyweight.MIN_HOUR, Flyweight.MIN_HOUR + 1, 
                        Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 30, 0, AppointmentFlyweightFactory.AVAILABLE_FLYWEIGHT_KEY);
        
        assertEquals("The factory did not return success", "", result);
        
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> savedFlyweights = fdb.getDaysFlyweights(currentDate);
        
        int nextTime = savedFlyweights.get(0).getTime();
        
        assertEquals("The start hour was incorrect", Flyweight.MIN_HOUR, getHour(nextTime));
        assertEquals("The start minute was incorrect", Flyweight.MIN_MINUTE, getMinute(nextTime));
        
        for(Flyweight flyweight: savedFlyweights)
        {
            assertEquals("The time of the flyweight did not increment correctly.", nextTime, flyweight.getTime());
            assertEquals("The flyweight was not an available flyweight", false, flyweight.isAppointment());   
            
            nextTime = nextTime + AppointmentFlyweightFactory.INCREMENT_GAP;
        }
        
        assertEquals("The end time was incorrect", getTime(Flyweight.MIN_HOUR + 1, Flyweight.MIN_MINUTE + 30),nextTime);

    }
    
    @Test
    public void createAppointmentFlyweightTest()
    {
        String result = AppointmentFlyweightFactory.getInstance().
                createFlyweights(currentDate, Flyweight.MIN_HOUR, Flyweight.MIN_HOUR + 2, 
                        Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 15, AppointmentFlyweightTest.VALID_ID,
                        AppointmentFlyweightFactory.APPOINTMENT_FLYWEIGHT_KEY);
        
        assertEquals("The factory did not return success", "", result);
        
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> savedFlyweights = fdb.getDaysFlyweights(currentDate);
        
        int nextTime = savedFlyweights.get(0).getTime();
        
        assertEquals("The start hour was incorrect", Flyweight.MIN_HOUR, getHour(nextTime));
        assertEquals("The start minute was incorrect", Flyweight.MIN_MINUTE, getMinute(nextTime));
        
        for(Flyweight flyweight: savedFlyweights)
        {
            assertEquals("The time of the flyweight did not increment correctly.", nextTime, flyweight.getTime());
            assertEquals("The flyweight was not an appointment flyweight", true, flyweight.isAppointment());   
            
            nextTime = nextTime + AppointmentFlyweightFactory.INCREMENT_GAP;
        }
        
        assertEquals("The end time was incorrect", getTime(Flyweight.MIN_HOUR + 2, Flyweight.MIN_MINUTE + 15), nextTime);
    }
    
    @Test
    public void createInvalidFlyweightTest()
    {
        String result =AppointmentFlyweightFactory.getInstance().
                createFlyweights(currentDate, Flyweight.MIN_HOUR + 2, Flyweight.MIN_HOUR, 
                        Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 15, AppointmentFlyweightTest.VALID_ID, 
                        AppointmentFlyweightFactory.APPOINTMENT_FLYWEIGHT_KEY);
        
        assertEquals("An invalid hour did not produce an error", AppointmentFlyweightFactory.ILLEGAL_ARGUMENT_FAULT, result);
        
        result =AppointmentFlyweightFactory.getInstance().
                createFlyweights(currentDate, Flyweight.MIN_HOUR, Flyweight.MIN_HOUR + 2, 
                        Flyweight.MIN_MINUTE+ 15, Flyweight.MIN_MINUTE, 0, AppointmentFlyweightFactory.AVAILABLE_FLYWEIGHT_KEY);
        
        assertEquals("An invalid minute did not produce an error", AppointmentFlyweightFactory.ILLEGAL_ARGUMENT_FAULT, result);
        
        result =AppointmentFlyweightFactory.getInstance().
                createFlyweights(currentDate, Flyweight.MIN_HOUR, Flyweight.MIN_HOUR + 2, 
                        Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 15, 0, "");
        
        assertEquals("An invalid key did not produce an error", AppointmentFlyweightFactory.ILLEGAL_KEY_FAULT, result);
        
        result =AppointmentFlyweightFactory.getInstance().
                createFlyweights(currentDate, Flyweight.MIN_HOUR - 1, Flyweight.MIN_HOUR, 
                        Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 15, 0, AppointmentFlyweightFactory.AVAILABLE_FLYWEIGHT_KEY);
        
        assertEquals("An invalid flyweight time did not produce an error", AppointmentFlyweightFactory.ILLEGAL_FLYWEIGHT_FAULT, result);
        
        result =AppointmentFlyweightFactory.getInstance().
                createFlyweights(currentDate, Flyweight.MIN_HOUR, Flyweight.MIN_HOUR + 1, 
                        Flyweight.MIN_MINUTE - 15, Flyweight.MIN_MINUTE, AppointmentFlyweightTest.VALID_ID, 
                        AppointmentFlyweightFactory.APPOINTMENT_FLYWEIGHT_KEY);
        
        assertEquals("An invalid flyweight time did not produce an error", AppointmentFlyweightFactory.ILLEGAL_FLYWEIGHT_FAULT, result);
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
    
}

