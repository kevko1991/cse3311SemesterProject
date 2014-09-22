/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frank R.
 */
public class AppointmentFlyweightTest {
    
    final static int VALID_ID = 1;
    
    public AppointmentFlyweightTest() {
    }

    @Test
    public void testHasAppointment() 
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), Flyweight.MIN_HOUR, Flyweight.MIN_MINUTE);
        
        boolean hasAppt = apptF.isAppointment();
        
        assertEquals("This AppointmentFlyweight should show as having an appointment.",
                true, hasAppt);
    }
    
    @Test
    public void testGetAppointmentId()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), Flyweight.MIN_HOUR, Flyweight.MIN_MINUTE);
        
        int apptId = apptF.getAppointmentId();
        
        assertEquals("This AppointmentFlyweight should have the valid appointment Id.",
                VALID_ID, apptId);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectLowHourValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), Flyweight.MIN_HOUR - 1, Flyweight.MIN_MINUTE);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectHighHourValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), Flyweight.MAX_HOUR + 1, Flyweight.MIN_MINUTE);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectLowMinuteValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), Flyweight.MIN_HOUR, Flyweight.MIN_MINUTE - 1);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectHighMinuteValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), Flyweight.MAX_HOUR, Flyweight.MAX_MINUTE + 1);
        
        fail();
    }
}
