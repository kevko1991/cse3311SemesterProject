/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nabin
 */
public class AppointmentDatabaseManagerTest {
    
    public AppointmentDatabaseManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveAppointment method, of class AppointmentDatabaseManager.
     */
    @Test (expected= NullPointerException.class)
    public void testSaveAppointment() {
        System.out.println("saveAppointment");
        Appointment an = null;
        AppointmentDatabaseManager instance = new AppointmentDatabaseManager();
        instance.saveAppointment(an);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppointment method, of class AppointmentDatabaseManager.
     */
    @Test 
    public void testGetAppointment() {
        int id = 1;
        AppointmentDatabaseManager instance = new AppointmentDatabaseManager();
        Appointment expResult = null;
        Appointment result = instance.getAppointment(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNextId method, of class AppointmentDatabaseManager.
     */
    @Test 
    public void testGetNextId() {
        AppointmentDatabaseManager instance = new AppointmentDatabaseManager();
        int expResult = 1;
        int result = instance.getNextId();
        assertEquals(expResult, result);
        
    }
    
}
