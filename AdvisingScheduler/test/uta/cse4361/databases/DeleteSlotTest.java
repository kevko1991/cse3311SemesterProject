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
public class DeleteSlotTest {
    
    public DeleteSlotTest() {
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
     * Test of queryDB method, of class DeleteSlot.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        Slot slot = new AvailableSlot(new Date(System.currentTimeMillis()), 8, 0, 0);
        ArrayList<Slot> slots = new ArrayList<Slot>();
        slots.add(slot);
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 8, 15, 0));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 8, 30, 0));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 8, 45, 0));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 9, 0, 0));
        slots.add(new AvailableSlot(new Date(System.currentTimeMillis()), 9, 15, 0));
        SaveSlots saveInstance = new SaveSlots(slots);
        saveInstance.execute();
        DeleteSlot deleteInstance = new DeleteSlot(new Date(System.currentTimeMillis()), 8, 0, 9, 30); // 
        deleteInstance.execute();
    }
}
