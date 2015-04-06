/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import uta.cse4361.businessobjects.AdvisorAccount;

/**
 *
 * @author Ross
 */
public class SaveAdvisorAssignments extends RDBImplCommand{
    private ArrayList<AdvisorAccount> advisors;
    private String sqlQuery = "UPDATE ASSIGNED SET AssignedRange = ? WHERE UserID = ?";
    
    public SaveAdvisorAssignments(ArrayList<AdvisorAccount> advisors){
        this.advisors = advisors;
    }
    
    @Override
    public void queryDB() throws SQLException{
        try{            
            for(AdvisorAccount aa: advisors){
                statement = conn.prepareStatement(sqlQuery);
                statement.setString(1, aa.getAssignment());
                statement.setInt(2, aa.getID());
                statement.executeUpdate();
            }
            processResult();
        }
        catch (SQLException e) {
            System.out.println("GetAdvisorsFromDepartment failed");
            conn.close();
        } finally {
            statement.close();
        }
    }
    
    @Override
    public void processResult(){
        result = "";
    }
}
