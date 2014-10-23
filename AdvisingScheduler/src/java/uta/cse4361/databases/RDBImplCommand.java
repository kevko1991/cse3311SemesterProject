/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.SQLException;

/**
 *
 * @author Han
 */
public abstract class RDBImplCommand {
    
    Object result;
    
    public void execute() {
        try {
            connectDB();
            queryDB();
            disconnectDB();
            processResult();
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            disconnectDB();
        }
    }
    
    private void connectDB() throws SQLException {
        
    }
    
    private void disconnectDB() {
        
    }
    
    public Object getResult() {
        return result;
    }
    
    public abstract void queryDB() throws SQLException;
    public abstract void processResult();
}
