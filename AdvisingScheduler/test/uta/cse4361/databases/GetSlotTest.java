/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import com.mockrunner.jdbc.BasicJDBCTestCaseAdapter;
import com.mockrunner.jdbc.PreparedStatementResultSetHandler;
import com.mockrunner.jdbc.StatementResultSetHandler;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uta.cse4361.businessobjects.Slot;

/**
 *
 * @author Andrew
 */
public class GetSlotTest extends BasicJDBCTestCaseAdapter{
    
    private void prepareResultSet(){

        MockConnection connection = getJDBCMockObjectFactory().getMockConnection();
        PreparedStatementResultSetHandler resultSetHandler = connection.getPreparedStatementResultSetHandler();

        MockResultSet result = resultSetHandler.createResultSet();
        result.addRow(new String[] {"1", "2014-11-14", "8", "15"});

        resultSetHandler.prepareGlobalResultSet(result);
    }

    
    public GetSlotTest() {
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
     * Test of queryDB method, of class GetAllSlots.
     */
    @Test
    public void testQueryDB() throws Exception {
        System.out.println("queryDB");
        prepareResultSet();
        GetSlot instance = new GetSlot();
        instance.execute();
        assertNotNull(instance.getResult());
        ArrayList<Slot> pulledSlots = (ArrayList<Slot>) instance.getResult();
        assertEquals(8, pulledSlots.get(0).getHour());
    }
    
}
