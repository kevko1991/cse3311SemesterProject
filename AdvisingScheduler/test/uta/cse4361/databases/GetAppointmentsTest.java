/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.util.ArrayList;
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
public class GetAppointmentsTest {
    
    public GetAppointmentsTest() {
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
     * Test of queryDB method, of class GetAppointments.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        GetAppointments instance = new GetAppointments();
        instance.connectDB();
        instance.queryDB();
        instance.disconnectDB();
        ArrayList<Appointment> appts = (ArrayList<Appointment>)instance.getResult();
        for (Appointment a: appts) {
            System.out.println(a.getAdvisorName());
        }
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(appts.size()!=0);
    }
    
}
