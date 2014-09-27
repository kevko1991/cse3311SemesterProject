/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Han
 */
public class TimeAllocationSlotBeanTest {
    
    public TimeAllocationSlotBeanTest() {
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
     * Test of allocateTime method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testAllocateTime() {
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        instance.setDate(new Date());
        instance.setStartHour(15);
        instance.setEndHour(15);
        instance.setStartMinute(30);
        instance.setEndMinute(45);
        String expResult = TimeAllocationSlotBean.SUCCESS_MSG;
        String result = instance.allocateTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testSetDate() {
        Date d = new Date();
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        instance.setDate(d);
        assertEquals(d, instance.getDate());
    }

    /**
     * Test of setStartHour method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testSetStartHour() {
        int sH = 11;
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        instance.setStartHour(sH);
        assertEquals(sH, instance.getStartHour());
    }

    /**
     * Test of setEndHour method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testSetEndHour() {
        int eH = 12;
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        instance.setEndHour(eH);
        assertEquals(eH, instance.getEndHour());
    }

    /**
     * Test of setStartMinute method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testSetStartMinute() {
        int sM = 30;
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        instance.setStartMinute(sM);
        assertEquals(sM, instance.getStartMinute());
    }

    /**
     * Test of setEndMinute method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testSetEndMinute() {
        int eM = 26;
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        instance.setEndMinute(eM);
        assertEquals(eM, instance.getEndMinute());
    }

    /**
     * Test of getDate method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testGetDate() {
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        Date expResult = new Date();
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartHour method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testGetStartHour() {
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        int expResult = 8;
        instance.setStartHour(expResult);
        int result = instance.getStartHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndHour method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testGetEndHour() {
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        int expResult = 23;
        instance.setEndHour(expResult);
        int result = instance.getEndHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartMinute method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testGetStartMinute() {
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        int expResult = 0;
        instance.setStartMinute(expResult);
        int result = instance.getStartMinute();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndMinute method, of class TimeAllocationSlotBean.
     */
    @Test
    public void testGetEndMinute() {
        TimeAllocationSlotBean instance = new TimeAllocationSlotBean();
        int expResult = 50;
        instance.setEndMinute(expResult);
        int result = instance.getEndMinute();
        assertEquals(expResult, result);
    }
    
}
