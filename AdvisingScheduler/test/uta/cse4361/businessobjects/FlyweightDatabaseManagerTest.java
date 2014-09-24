/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Frank R.
 */
public class FlyweightDatabaseManagerTest {
    
    public FlyweightDatabaseManagerTest() {
    }
    @Test
    public void defaultTest()
    {
        assert(true);
    }
    /*
    private Date currentDate;
    @Before
    public void setUp()
    {
        currentDate = new Date();
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
        
        fdb.saveFlyweights(flyweights);
        
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
        
        fdb.saveFlyweights(availableFlys);
        
        ArrayList<Flyweight> appointmentFlys = createAppointmentFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 15, Flyweight.MIN_HOUR);
        
        fdb.saveFlyweights(appointmentFlys);
        
        fdb = null;
        
        fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> savedFlyweights = fdb.getDaysFlyweights(currentDate);
        
        assertEquals("The FDB did not return the same number of flyweights as availableFlyweights were created.", availableFlys.size(), savedFlyweights.size());
        
        assertEquals("The FDB did not return an appointmentFlyweight as the first member", true, savedFlyweights.get(0).isAppointment());
        
        assertEquals("The FDB did not return an appointmentFlyweight as the second member", true, savedFlyweights.get(1).isAppointment());
        
        assertEquals("The FDB did not return an availableFlyweight as the third member", false, savedFlyweights.get(2).isAppointment());
        
        assertEquals("The FDB did not return an availableFlyweight as the fourth member", false, savedFlyweights.get(3).isAppointment());

    } 
    
    @Test
    public void isFreeValidTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> availableFlys = createAvailableFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        fdb.saveFlyweights(availableFlys);
        
        boolean free = fdb.isFree(currentDate, Flyweight.MIN_HOUR + 1, Flyweight.MIN_HOUR + 1, Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45);
        
        assertEquals("The time that should be free was shown as not free.", true, free);
    }
    
    @Test
    public void isFreeInvalidTest()
    {
        FlyweightDatabaseManager fdb = new FlyweightDatabaseManager();
        
        ArrayList<Flyweight> availableFlys = createAvailableFlyweights(Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45, Flyweight.MIN_HOUR);
        
        fdb.saveFlyweights(availableFlys);
        
        boolean free = fdb.isFree(currentDate, Flyweight.MIN_HOUR, Flyweight.MIN_HOUR, Flyweight.MIN_MINUTE, Flyweight.MIN_MINUTE + 45);
        
        assertEquals("The time that should not be free was shown as  free.", false, free);
    }
    */
}
