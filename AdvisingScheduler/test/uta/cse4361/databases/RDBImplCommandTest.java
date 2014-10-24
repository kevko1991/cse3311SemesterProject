/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;
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
public class RDBImplCommandTest{
    
    public RDBImplCommandTest() {
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
     * Test of execute method, of class RDBImplCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        RDBImplCommand instance = new RDBImplCommandImpl();
        instance.execute();
    }

    /**
     * Test of getResult method, of class RDBImplCommand.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        RDBImplCommand instance = new RDBImplCommandImpl();
        Object expResult = null;
        Object result = instance.getResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of queryDB method, of class RDBImplCommand.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        RDBImplCommand instance = new RDBImplCommandImpl();
        instance.queryDB();
    }

    /**
     * Test of processResult method, of class RDBImplCommand.
     */
    @Test
    public void testProcessResult() {
        System.out.println("processResult");
        RDBImplCommand instance = new RDBImplCommandImpl();
        instance.processResult();
    }

    public class RDBImplCommandImpl extends RDBImplCommand {

        public void queryDB() throws SQLException {
        }

        public void processResult() {
        }
    }
    
}
