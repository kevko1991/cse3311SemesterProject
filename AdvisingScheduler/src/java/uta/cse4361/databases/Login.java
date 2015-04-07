/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

/**
 *
 * @author Joseph
 */
public class Login {
    private int ID;
    private int rank;
    private int firstLog;

    public Login(){
        
    }
    
    public void initialize(int userID, int userRank, int userLog){
        this.ID = userID;
        this.firstLog = userLog;
        this.rank = userRank;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public int getLog(){
        return this.firstLog;
    }
    
    public int getRank(){
        return this.rank;
    }
    
    public void setID(int newID){
        this.ID = newID;
    }
    
    public void setLog(int newLog){
        this.firstLog = newLog;
    }
    
    public void setRank(int newRank){
        this.rank = newRank;
    }
}
