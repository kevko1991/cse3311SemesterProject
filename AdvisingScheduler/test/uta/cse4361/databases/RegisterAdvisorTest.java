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
import uta.cse4361.businessobjects.AdvisorAccount;

/**
 *
 * @author Andrew
 */
public class RegisterAdvisorTest {
    
    public RegisterAdvisorTest() {
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
     * Test of queryDB method, of class RegisterAdvisor.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        AdvisorAccount aa = new AdvisorAccount();
        aa.initialize("admin", "admin@mavs.uta.edu", "CSE", "password", 1);
        RegisterAdvisor instance = new RegisterAdvisor(aa);
        instance.connectDB();
        instance.conn.setAutoCommit(false);
        instance.queryDB();
        instance.conn.rollback();
        instance.disconnectDB();
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(instance.getResult());
    }
    
}
