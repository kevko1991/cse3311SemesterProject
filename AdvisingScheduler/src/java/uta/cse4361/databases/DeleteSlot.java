/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import uta.cse4361.businessobjects.Slot;

/**
 *
 * @author Han
 */
public class DeleteSlot extends RDBImplCommand{
    
    int slotID;
    private String sqlQuery = "DELETE FROM \"SLOT\" WHERE \"SlotID\" = ?";

    public DeleteSlot(int id){
        slotID = id;
    }
    
    public void queryDB() throws SQLException{
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setInt(1, slotID);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("failed");
            conn.close();
        } finally {
            if(statement != null){
                statement.close();
            }
        }
    }
    
    public void processResult(){
            result = "true";
    }
}
