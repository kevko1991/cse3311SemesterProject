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
        SaveSlots saveInstance = new SaveSlots(slots);
        saveInstance.execute();
        DeleteSlot deleteInstance = new DeleteSlot(((ArrayList<Integer>)saveInstance.getResult()).get(0).intValue());
        
        deleteInstance.execute();
    }

    /**
     * Test of processResult method, of class DeleteSlot.
     */
    @Test
    public void testProcessResult() {
        System.out.println("processResult");
        DeleteSlot instance = new DeleteSlot(0);
        instance.processResult();
        assertNotNull(instance.getResult());
    }
    
}
