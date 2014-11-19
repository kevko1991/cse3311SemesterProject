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
public class SaveAppointmentTest {
    
    public SaveAppointmentTest() {
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
     * Test of queryDB method, of class SaveAppointment.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        String sName = "First Last";
        String sID = "1000123456";
        String sEmail = "test@test.com";
        String sMajor = "Software Engineering";
        String aName = "Advisor Name";
        String type = "Advising Type";
        String dp = "This is the test ";
        Date date = new Date();
        int sH = 13;
        int eH = 0;
        int sM = 14;
        int eM = 0;
        String expectedResult = "";
        Appointment appt = new Appointment();
        appt.initialize(sMajor, sName, sID, sEmail, aName, type, dp, date, sH, eH, sM, eM);
        SaveAppointment instance = new SaveAppointment(appt);
        instance.connectDB();
        //instance.conn.setAutoCommit(false);
        instance.queryDB();
        //instance.conn.rollback();
        instance.disconnectDB();
        
        String result = (String)instance.getResult();
        System.out.println(result);
        assertEquals(expectedResult, result);
    }
    
    
    /**
     * Test of processResult method, of class SaveAppointment.
     */
    @Test
    public void testProcessResult() {
        System.out.println("processResult");
        String expectedResult = "";
        RDBImplCommand instance = new SaveAppointment(new Appointment());
        instance.processResult();
        String result = (String)instance.getResult();
        assertEquals(expectedResult, result);
    }
}
