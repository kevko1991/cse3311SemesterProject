/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Han
 */
public abstract class RDBImplCommand {

    protected Object result;
    protected Connection conn;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

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

    protected void connectDB() throws SQLException {
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/advising;create=true;user=advising;password=advising");
    }

    protected void disconnectDB() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public Object getResult() {
        return result;
    }

    public abstract void queryDB() throws SQLException;

    public abstract void processResult();
}
