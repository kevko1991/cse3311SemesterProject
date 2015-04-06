/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;
import uta.cse4361.businessobjects.AdvisorAccount;

/**
 *
 * @author Joseph
 * 
 * This is a class I am creating to  try and update advisor data in the database.
 */
public class UpdateAdvisor extends RDBImplCommand{

    private AdvisorAccount aa;
    private int ID;
    private String sqlQuery = "UPDATE USER SET UserEmail = ?, UserPassword = ?,"
            + " UserName = ?, UserDepartment = ?, UserRank = ? WHERE UserID = ?";
    public UpdateAdvisor(AdvisorAccount aa){
        this.aa = aa;
        this.ID = aa.getID();
    }
    
    @Override
    public void queryDB() throws SQLException {
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, aa.getEmail());
            statement.setString(2, aa.getTempPassword());
            statement.setString(3, aa.getName());
            statement.setString(4, aa.getDepartment());
            statement.setInt(5, aa.getRank());
            statement.setInt(6, aa.getID());
            statement.executeUpdate();
            processResult();
        }
        catch(SQLException e){
        System.out.println("UpdateAdvisor Failed");
            conn.close();
        } finally {
            statement.close();
        }
    }

    @Override
    public void processResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
