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
public class AvailableFlyweightTest implements uta.cse4361.interfaces.Constants{
    
    public AvailableFlyweightTest() {
    }

    @Test
    public void testHasAppointment() 
    {
        AvailableFlyweight availableF = new AvailableFlyweight(new Date(), MIN_HOUR, MIN_MINUTE);
        
        boolean hasAppt = availableF.isAppointment();
        
        assertEquals("This AvailableFlyweight should not show as having an appointment.",
                false, hasAppt);
    }
    
    @Test
    public void testGetAppointmentId()
    {
        AvailableFlyweight availableF = new AvailableFlyweight(new Date(), MIN_HOUR, MIN_MINUTE);
        
        int apptId = availableF.getAppointmentId();
        
        assertEquals("This AvailableFlyweight should have the invalid appointment Id.",
                ILLEGAL_APPT_ID, apptId);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectLowHourValue()
    {
        AvailableFlyweight availableF = new AvailableFlyweight(new Date(), MIN_HOUR - 1, MIN_MINUTE);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectHighHourValue()
    {
        AvailableFlyweight availableF = new AvailableFlyweight(new Date(), MAX_HOUR + 1, MIN_MINUTE);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectLowMinuteValue()
    {
        AvailableFlyweight availableF = new AvailableFlyweight(new Date(), MIN_HOUR, MIN_MINUTE - 1);
        
        fail();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIncorrectHighMinuteValue()
    {
        AvailableFlyweight availableF = new AvailableFlyweight(new Date(), MAX_HOUR, MAX_MINUTE + 1);
        
        fail();
    }
}
