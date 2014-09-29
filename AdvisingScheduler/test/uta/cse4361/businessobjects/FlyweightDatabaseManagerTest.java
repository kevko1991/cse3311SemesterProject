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
public class FlyweightDatabaseManagerTest {
    
    public FlyweightDatabaseManagerTest() {
    }
    
    private Date currentDate;
    @Before
    public void setUp()
    {
        currentDate = new Date();
        File dataFile = new File(FlyweightDatabaseManager.FDB_FILE_NAME);
        dataFile.delete();
    }
    
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

    private ArrayList<Flyweight> createAvailableFlyweights(int startTime, int endTime, int hour)
    {
        ArrayList<Flyweight> flyweights = new ArrayList<Flyweight>();
        
        for(int i = startTime; i < endTime; 
                i = i + AppointmentFlyweightFactory.INCREMENT_GAP)
        {
            AvailableFlyweight af = new AvailableFlyweight(currentDate, hour, i);
            flyweights.add(af);
        }
        return flyweights;
    }
    
    private ArrayList<Flyweight> createAppointmentFlyweights(int startTime, int endTime, int hour)
    {
        ArrayList<Flyweight> flyweights = new ArrayList<Flyweight>();
        
        for(int i = startTime; i <= endTime; 
                i = i + AppointmentFlyweightFactory.INCREMENT_GAP)
        {
            AppointmentFlyweight af = new AppointmentFlyweight(AppointmentFlyweightTest.VALID_ID, currentDate, hour, i);
            flyweights.add(af);
        }
        return flyweights;
    }
    
    @Test
    public void addFlyweightsTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> flyweights = createAvailableFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        String result = fdb.saveFlyweights(flyweights);
        assertEquals("Did not get valid return from saving", "", result);
        
        fdb = null;
        
        fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> savedFlyweights = fdb.getDaysFlyweights(currentDate);
        
        assertEquals("The number of flyweights saved and returned deviated.", flyweights.size(), savedFlyweights.size());

    }  
    
    @Test
    public void addMixedFlyweightsTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> availableFlys = createAvailableFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        String result = fdb.saveFlyweights(availableFlys);
        assertEquals("Did not get valid return from saving", "", result);
        
        ArrayList<Flyweight> appointmentFlys = createAppointmentFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 15, Flyweight.MIN_HOUR);
        
        fdb.saveFlyweights(appointmentFlys);
        
        fdb = null;
        
        fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> savedFlyweights = fdb.getDaysFlyweights(currentDate);
        
        assertEquals("The FDB did not return the same number of flyweights as availableFlyweights were created.", availableFlys.size(), savedFlyweights.size());
        
        for(int i = 0; i < availableFlys.size(); i++)
        {
            if (i < appointmentFlys.size())
            {
                assertEquals("The FDB did not return an appointmentFlyweight as the member", true, savedFlyweights.get(i).isAppointment());
            }
            else
            {
                assertEquals("The FDB did not return an availableFlyweight as the  member", false, savedFlyweights.get(i).isAppointment());
            }
        }
        
        



    } 
    
    @Test
    public void isFreeValidTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> availableFlys = createAvailableFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        String result = fdb.saveFlyweights(availableFlys);
        assertEquals("Did not get valid return from saving", "", result);
        
        boolean free = fdb.isFree(currentDate, Flyweight.MIN_HOUR + 1, Flyweight.MIN_HOUR + 1, Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45);
        
        assertEquals("The time that should be free was shown as not free.", true, free);
    }
    
    @Test
    public void isFreeInvalidTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> appointmentFlys = createAppointmentFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        String result = fdb.saveFlyweights(appointmentFlys);
        assertEquals("Did not get valid return from saving", "", result);
        
        boolean free = fdb.isFree(currentDate, Flyweight.MIN_HOUR, Flyweight.MIN_HOUR, Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45);
        
        assertEquals("The time that should not be free was shown as  free.", false, free);
    }
    
    @Test
    public void getDatesFreeTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> availableFlys = createAvailableFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        String result = fdb.saveFlyweights(availableFlys);
        assertEquals("Did not get valid return from saving", "", result);
        
        ArrayList<Date> dates = fdb.getDatesForAvailability();
        
        assertEquals("There is only one available date", 1, dates.size());
        
    }
    
    @Test
    public void emptyFlyweightsTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> availableFlys = new ArrayList<Flyweight>();
        
        String result = fdb.saveFlyweights(availableFlys);
        assertEquals("The error message did not indicate the list was empty", FlyweightDatabaseManager.FLYWEIGHTS_EMPTY_FAULT, result);
        
        availableFlys = null;
        
        result = fdb.saveFlyweights(availableFlys);
        assertEquals("The error message did not indicate the list was empty", FlyweightDatabaseManager.FLYWEIGHTS_EMPTY_FAULT, result);
        
    }
    
    @Test
    public void badDateFlyweights()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> availableFlys = createAvailableFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        availableFlys.add(new AvailableFlyweight(new Date(5, 5, 5), Flyweight.MIN_MINUTE, Flyweight.MIN_HOUR));
        
        String result = fdb.saveFlyweights(availableFlys);
        assertEquals("The error message did not indicate the list had different days", FlyweightDatabaseManager.FLYWEIGHTS_DIFFERENT_DATE_FAULT, result);
    }
    
    @Test
    public void getEmptyFlyweightList()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> savedFlyweights = fdb.getDaysFlyweights(currentDate);
        
        assertEquals("The list should be empty", 0, savedFlyweights.size());
    }
    
}
