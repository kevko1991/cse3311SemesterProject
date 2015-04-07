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
    private String email;
    private String sqlQuery = "UPDATE USER SET UserPassword = ?, FirstLog = ? WHERE UserEmail = ?";
    public UpdateAdvisor(String email, AdvisorAccount adv){
        this.email = email;
        this.aa = adv;
    }
    
    @Override
    public void queryDB() throws SQLException {
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, aa.getTempPassword());
            statement.setInt(2, aa.getLog());
            statement.setString(3, aa.getEmail());
            statement.executeUpdate();
            processResult();
        }
        catch(SQLException e){
            //System.out.println("UpdateAdvisor Failed");
            e.printStackTrace();
            conn.close();
        } finally {
            statement.close();
        }
    }

    @Override
    public void processResult() {
        result = "";
    }
    
}
