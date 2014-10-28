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

/**
 *
 * @author Andrew
 */
public class GetAvailSlotsByTimeTest {
    
    public GetAvailSlotsByTimeTest() {
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
     * Test of queryDB method, of class GetAvailSlotsByTime.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        GetAvailSlotsByTime instance = new GetAvailSlotsByTime(new Date(System.currentTimeMillis()), 8, 9, 0, 30);;
        instance.execute();
    }
    
}
