/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.beans;

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
public class ScheduleAppointmentControllerBeanTest {

    private final String sName = "First Last";
    private final String sID = "1000123456";
    private final String wrongID = "30123";
    private final String aName = "Advisor Name";
    private final String dp = "This is a description test";
    private final Date d = new Date();
    private final int sH = 11;
    private final int eH = 13;
    private final int sM = 0;
    private final int eM = 33;

    public ScheduleAppointmentControllerBeanTest() {
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
     * Test of scheduleAppointment method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testScheduleAppointmentFail() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setStudentID(wrongID);
        instance.setStudentName(sName);
        instance.setAdvisorName(aName);
        instance.setDate(d);
        instance.setDescription(dp);
        instance.setStartHour(sH);
        instance.setEndHour(eH);
        instance.setStartMinute(sM);
        instance.setEndMinute(eM);
        String expResult = ScheduleAppointmentControllerBean.INITIALIZE_APPOINTMENT_FAIL;
        String result = instance.scheduleAppointment();
        assertEquals(expResult, result);
    }

    @Test
    public void testScheduleAppointmentSuccess() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        AppointmentFlyweightFactory aff = AppointmentFlyweightFactory.getInstance();
        AppointmentDatabaseManager adm = new AppointmentDatabaseManager();
        aff.createFlyweights(d, sH, eH, sM, eM, adm.getNextId(), AppointmentFlyweightFactory.AVAILABLE_FLYWEIGHT_KEY);
        instance.setStudentID(sID);
        instance.setStudentName(sName);
        instance.setAdvisorName(aName);
        instance.setDate(d);
        instance.setDescription(dp);
        instance.setStartHour(sH);
        instance.setEndHour(eH);
        instance.setStartMinute(sM);
        instance.setEndMinute(eM);
        String expResult = ScheduleAppointmentControllerBean.SUCCESS_MESSAGE;
        String result = instance.scheduleAppointment();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStudentName method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetStudentName() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setStudentName(sName);
        assertEquals(sName, instance.getStudentName());
    }

    /**
     * Test of setStudentID method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetStudentID() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setStudentID(sID);
        assertEquals(sID, instance.getStudentID());
    }

    /**
     * Test of setAdvisorName method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetAdvisorName() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setAdvisorName(aName);
        assertEquals(aName, instance.getAdvisorName());
    }

    /**
     * Test of setDescription method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetDescription() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setDescription(dp);
        assertEquals(dp, instance.getDescription());
    }

    /**
     * Test of setDate method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetDate() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setDate(d);
        assertEquals(d, instance.getDate());
    }

    /**
     * Test of setStartHour method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetStartHour() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setStartHour(sH);
        assertEquals(sH, instance.getStartHour());
    }

    /**
     * Test of setEndHour method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetEndHour() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setEndHour(eH);
        assertEquals(eH, instance.getEndHour());
    }

    /**
     * Test of setStartMinute method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetStartMinute() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setStartMinute(sM);
        assertEquals(sM, instance.getStartMinute());
    }

    /**
     * Test of setEndMinute method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testSetEndMinute() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        instance.setEndMinute(eM);
        assertEquals(eM, instance.getEndMinute());
    }

    /**
     * Test of getStudentName method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetStudentName() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        String expResult = "First Last";
        instance.setStudentName(expResult);
        String result = instance.getStudentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudentID method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetStudentID() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        String expResult = "1000111122";
        instance.setStudentID(expResult);
        String result = instance.getStudentID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdvisorName method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetAdvisorName() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        String expResult = "Advisor Name";
        instance.setAdvisorName(expResult);
        String result = instance.getAdvisorName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetDescription() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        String expResult = "The test of description";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartHour method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetStartHour() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        int expResult = 3;
        instance.setStartHour(expResult);
        int result = instance.getStartHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndHour method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetEndHour() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        int expResult = 5;
        instance.setEndHour(expResult);
        int result = instance.getEndHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartMinute method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetStartMinute() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        int expResult = 27;
        instance.setStartMinute(expResult);
        int result = instance.getStartMinute();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndMinute method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetEndMinute() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        int expResult = 51;
        instance.setEndMinute(expResult);
        int result = instance.getEndMinute();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class ScheduleAppointmentControllerBean.
     */
    @Test
    public void testGetDate() {
        ScheduleAppointmentControllerBean instance = new ScheduleAppointmentControllerBean();
        Date expResult = new Date();
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }
}
