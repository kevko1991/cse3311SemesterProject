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
    
    int startHour;
    int startMin;
    int endHour;
    int endMin;
    java.sql.Date date;
    
    private String sqlQuery = "DELETE FROM \"SLOT\" WHERE "
            + "(\"SlotDate\" = ? AND \"SlotStartHour\" = ? AND \"SlotStartMin\" >= ? )" //slots during start hour
            + "OR (\"SlotDate\" = ? AND \"SlotStartHour\" > ? AND \"SlotStartHour\" < ?)"//slots between start and end hour
            + "OR (\"SlotDate\" = ? AND \"SlotStartHour\" = ? AND \"SlotStartMin\" < ?)"; // slots during end hour
    public DeleteSlot(java.util.Date date, int startHour, int endHour, int startMin, int endMin){
        this.startHour = startHour;
        this.startMin = startMin;
        this.endHour = endHour;
        this.endMin = endMin;
        this.date = new java.sql.Date(date.getTime());
    }
    
    public void queryDB() throws SQLException{
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setDate(1, date);
            statement.setInt(2, startHour);
            statement.setInt(3, startMin); //slots during start hour
            statement.setDate(4, date);
            statement.setInt(5, startHour);
            statement.setInt(6, endHour); //slots between start and end hour
            statement.setDate(7,date);
            statement.setInt(8, endHour);
            statement.setInt(9, endMin); // slots during end hour
            statement.executeUpdate();
            processResult();
        }
        catch (SQLException e){
            System.out.println("failed");
            e.printStackTrace();
            conn.close();
        } finally {
            if(statement != null){
                statement.close();
            }
        }
    }
    
    public void processResult(){
            result = "";
    }
}