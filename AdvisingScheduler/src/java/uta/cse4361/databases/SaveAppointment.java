/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;
import uta.cse4361.businessobjects.Appointment;

/**
 *
 * @author Han
 */
public class SaveAppointment extends RDBImplCommand{
    
    Appointment appointment;
    String sqlQuery = "INSERT INTO \"APPOINTMENT\"(\"ApptDate\", \"ApptStartHour\", \"ApptStartMin\", \"ApptEndHour\", \"ApptEndMinute\", "
                                + "\"ApptType\", \"Description\", \"StudentID\", \"StudentName\", \"AdvisorName\") "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    public SaveAppointment(Appointment appt) {
        super();
        this.appointment = appt;
    }
    @Override
    public void queryDB() throws SQLException {
        try{
            result = new String();
            statement = conn.prepareStatement(sqlQuery);
            statement.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
            statement.setInt(2, appointment.getStartHour());
            statement.setInt(3, appointment.getStartMinute());
            statement.setInt(4, appointment.getEndHour());
            statement.setInt(5, appointment.getEndMinute());
            statement.setString(6, appointment.getType());
            statement.setString(7, appointment.getDescription());
            statement.setString(8, appointment.getStudentID());
            statement.setString(9, appointment.getStudentName());
            statement.setString(10, appointment.getAdvisorName());
            statement.executeUpdate();
            result = "";
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

    @Override
    public void processResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
