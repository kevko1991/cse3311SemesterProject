/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;
import uta.cse4361.businessobjects.Slot;
import uta.cse4361.businessobjects.AvailableSlot;
import java.util.*;

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
public class SaveSlotsTest {
    
    public SaveSlotsTest() {
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
     * Test of queryDB method, of class SaveSlots.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        ArrayList<Slot> slots = new ArrayList<Slot>();
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 8, 0));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 8, 15));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 8, 30));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 8, 45));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 9, 0));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 9, 15));
        SaveSlots instance = new SaveSlots(slots);
        //instance.execute();
        instance.connectDB();
        instance.conn.setAutoCommit(false);
        instance.queryDB();
        instance.conn.rollback();
        instance.disconnectDB();
        instance.processResult();
        assertNotNull(instance.result);
    }
    

    /**
     * Test of processResult method, of class SaveSlots.
     */
    @Test
    public void testProcessResult() {
        System.out.println("processResult");
        SaveSlots instance = new SaveSlots(new ArrayList<Slot>());
        instance.processResult();
    }
    
}
