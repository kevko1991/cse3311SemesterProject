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
public class SchedulerTest {
    
    public SchedulerTest() {
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
     * Test of schedule method, of class Scheduler.
     */
    @Test (expected= NullPointerException.class)
    public void testSchedule() {
        Appointment a = null;
        Scheduler instance = new Scheduler();
        String expResult = "";
        String result = instance.schedule(a);
        assertEquals(expResult, result);
    }
    
}
