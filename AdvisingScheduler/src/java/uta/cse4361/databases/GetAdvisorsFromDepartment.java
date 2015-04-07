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
public class GetAdvisorsFromDepartment extends RDBImplCommand{
    private String department = null;
    private String sqlQuery = "SELECT * FROM ASSIGNED WHERE UserDepartment = ?";
    
    public GetAdvisorsFromDepartment(String department){
        this.department = department;
    }
    
    @Override
    public void queryDB() throws SQLException{
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, department);
            resultSet = statement.executeQuery();
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
        String name;
        String department;
        int ID;
        String assignment;
        AdvisorAccount advisor;
        result = new ArrayList<AdvisorAccount>();
        try{
            while(resultSet.next()){
                name = resultSet.getString("UserName");
                department = resultSet.getString("UserDepartment");
                ID = resultSet.getInt("UserID");
                assignment = resultSet.getString("AssignedRange");
                advisor = new AdvisorAccount();
                advisor.initialize(name, department, ID, assignment);
                ((ArrayList<AdvisorAccount>)result).add(advisor);
            }            
        }
        catch(SQLException e){
            System.out.println("Get Advisor process failed");
        }
    }            
}
            
