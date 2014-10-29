/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import uta.cse4361.businessobjects.AvailableSlot;
import uta.cse4361.businessobjects.Slot;

/**
 *
 * @author Andrew
 */
public class GetAvailSlotsByTime extends RDBImplCommand {
    
    int startHour;
    int startMin;
    int endHour;
    int endMin;
    java.sql.Date date;
    
    private String sqlQuery = "SELECT * FROM \"AVAILSLOT\" WHERE "
            + "(\"SlotDate\" = ? AND \"SlotStartHour\" = ? AND \"SlotStartMin\" >= ? AND \"SlotStartHour\" <> ?)" //slots during start hour
            + "OR (\"SlotDate\" = ? AND \"SlotStartHour\" > ? AND \"SlotStartHour\" < ?)"//slots between start and end hour
            + "OR (\"SlotDate\" = ? AND \"SlotStartHour\" = ? AND \"SlotStartMin\" < ? AND \"SlotStartHour\" <> ?)"// slots during end hour
            + "OR (\"SlotDate\" = ? AND \"SlotStartHour\" = ? AND \"SlotStartHour\" = ? "
            + "AND \"SlotStartMin\" >= ? AND \"SlotStartMin\" < ?)"; // slots within single hour
    
    public GetAvailSlotsByTime(java.util.Date date, int startHour, int endHour, int startMin, int endMin){
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
            statement.setInt(4, endHour);
            statement.setDate(5, date);
            statement.setInt(6, startHour);
            statement.setInt(7, endHour); //slots between start and end hour
            statement.setDate(8,date);
            statement.setInt(9, endHour);
            statement.setInt(10, endMin); // slots during end hour
            statement.setInt(11, startHour);
            statement.setDate(12, date);
            statement.setInt(13, startHour);
            statement.setInt(14, endHour); //slots that start and end within same hour
            statement.setInt(15, startMin);
            statement.setInt(16, endMin);
            resultSet = statement.executeQuery();
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
        try {
            result = new ArrayList<Slot>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                java.util.Date d = new java.util.Date(((java.sql.Date)resultSet.getDate(2)).getTime());
                int startHour = resultSet.getInt(3);
                int startMin = resultSet.getInt(4);
                Slot s = new AvailableSlot(d, startHour, startMin, id);
                ((ArrayList<Slot>) result).add(s);
            }
        } catch (SQLException e) {
            System.out.println("Get Avail Slots Failed");
            result = null;
        }
    }
    
}
