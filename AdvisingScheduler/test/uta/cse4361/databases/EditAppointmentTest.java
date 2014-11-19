/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uta.cse4361.businessobjects.Appointment;

/**
 *
 * @author Han
 */
public class EditAppointmentTest {
    
    public EditAppointmentTest() {
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
     * Test of queryDB method, of class EditAppointment.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        String sName = "Changed Name";
        String sID = "1000654321";
        String sEmail = "test@test.com";
        String sMajor = "Software Engineering";
        String aName = "Advisor Name";
        String type = "Advising Type";
        String dp = "This is the test after edit Appointment";
        Date date = new Date(114, 10, 17);
        int sH = 13;
        int eH = 0;
        int sM = 14;
        int eM = 0;
        String expectedResult = "This is the test after edit Appointment";
        Appointment appt = new Appointment();
        appt.initialize(sMajor, sName, sID, sEmail, aName, type, dp, date, sH, eH, sM, eM);
        EditAppointment instance = new EditAppointment(1, appt);
        instance.connectDB();
        instance.queryDB();        
        Appointment newAppt = new DatabaseManager().getAppointment(1);
        String result = newAppt.getDescription();
        instance.disconnectDB();
        assertEquals(expectedResult, result);
    }

}
