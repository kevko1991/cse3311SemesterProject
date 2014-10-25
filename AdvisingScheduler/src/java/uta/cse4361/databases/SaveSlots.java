/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;
import java.util.*;
import java.sql.*;
import uta.cse4361.businessobjects.AvailableSlot;
import uta.cse4361.businessobjects.Slot;
/**
 *
 * @author Han
 */

public class SaveSlots extends RDBImplCommand {
    ArrayList<Slot> slots;
    String sqlQuery = "INSERT INTO SLOT(SlotDate, SlotStartHour, SlotStartMin) VALUES (?, ?, ?)";
    
    public SaveSlots(ArrayList<Slot> slots){
        this.slots = slots;
    }
    
    public void queryDB() throws SQLException{
        try{
            for(Slot s: slots){
                statement = conn.prepareStatement(sqlQuery);
                statement.setDate(1, new java.sql.Date(s.getDate().getTime()));
                statement.setInt(2, (s.getTime()/100));
                statement.setInt(3, (s.getTime()%100));
                statement.executeUpdate();
                System.out.println("inserted data");
            }
        }
        catch (SQLException e){
            System.out.println("failed");
        } finally {
            if(statement != null){
                statement.close();
            }
        }
    }
    public void processResult(){};

}
