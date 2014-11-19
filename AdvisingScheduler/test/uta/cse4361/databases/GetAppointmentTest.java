/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

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
public class GetAppointmentTest {
    
    public GetAppointmentTest() {
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
     * Test of queryDB method, of class GetAppointment.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        int expectedID = 1;
        RDBImplCommand instance = new GetAppointment(expectedID);
        instance.connectDB();
        instance.conn.setAutoCommit(false);
        instance.queryDB();
        instance.conn.rollback();
        instance.disconnectDB();
        Appointment newAppt = (Appointment)instance.getResult();
        System.out.println(newAppt.getStudentEmail());
        assertEquals(expectedID, newAppt.getApptID());
    }
    
}
