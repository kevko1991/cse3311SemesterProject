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
        instance.queryDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processResult method, of class GetAppointments.
     */
    @Test
    public void testProcessResult() {
        System.out.println("processResult");
        GetAppointments instance = new GetAppointments();
        instance.processResult();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
