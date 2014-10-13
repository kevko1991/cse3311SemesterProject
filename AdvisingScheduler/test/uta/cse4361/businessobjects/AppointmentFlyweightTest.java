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
public class AppointmentFlyweightTest implements uta.cse4361.interfaces.Constants{
    
    
    
    public AppointmentFlyweightTest() {
    }

    @Test
    public void testHasAppointment() 
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), MIN_HOUR, MIN_MINUTE);
        
        boolean hasAppt = apptF.isAppointment();
        
        assertEquals("This AppointmentFlyweight should show as having an appointment.",
                true, hasAppt);
    }
    
    @Test
    public void testGetAppointmentId()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), MIN_HOUR, MIN_MINUTE);
        
        int apptId = apptF.getAppointmentId();
        
        assertEquals("This AppointmentFlyweight should have the valid appointment Id.",
                VALID_ID, apptId);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectLowHourValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), MIN_HOUR - 1, MIN_MINUTE);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectHighHourValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), MAX_HOUR + 1, MIN_MINUTE);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectLowMinuteValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), MIN_HOUR, MIN_MINUTE - 1);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectHighMinuteValue()
    {
        AppointmentFlyweight apptF = new AppointmentFlyweight(VALID_ID, new Date(), MAX_HOUR, MAX_MINUTE + 1);
        
        fail();
    }
}
