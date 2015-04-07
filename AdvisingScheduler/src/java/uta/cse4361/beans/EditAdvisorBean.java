/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.beans;

import uta.cse4361.businessobjects.AdvisorAccount;
import uta.cse4361.databases.DatabaseManager;
import uta.cse4361.interfaces.Constants;

/**
 *
 * @author Joseph
 */
public class EditAdvisorBean implements Constants{
    private String name = null;
    private String email = null;
    private String department = null;
    private int ID = 0;
    private String tempPassword = null;
    private int rank = 0;
    private int log = 0;
    /*
        -1 = Student
        0 = Advisor
        1 = Admin
    */
    
    public EditAdvisorBean(){
    
    }
    
    public String Advisor(){
        String returnMessage = SUCCESS_MESSAGE;
        
        AdvisorAccount aa = new AdvisorAccount();
        boolean a = aa.initialize(this.name, this.email, this.department, this.tempPassword, this.rank);
        if (a == false)
           return CREATE_ADVISOR_FAIL;
       DatabaseManager dm = new DatabaseManager();
       returnMessage = dm.update(aa.getEmail(), aa);
       return returnMessage;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public int getID() {
        return ID;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public int getRank() {
        return rank;
    }

    public int getLog(){
        return log;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public void setLog(int Log){
        this.log = Log;
    }
    
}
