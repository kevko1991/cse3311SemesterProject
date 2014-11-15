/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

/**
 *
 * @author Andrew
 */
public class AdvisorAccount {
    
    private String name;
    private String email;
    private String department;
    private int ID;
    private String tempPassword;
    private int rank;
    
    public AdvisorAccount(){
        
    }
    
    public boolean initialize(String name, String email, String department, String tempPassword, int rank){
        this.name = name;
        this.email = email;
        this.department = department;
        this.tempPassword = tempPassword;
        this.rank = rank;
        return true;
    }
    
    public boolean initialize(String name, String email, String department, int ID, int rank){
        this.name = name;
        this.email = email;
        this.department = department;
        this.ID = ID;
        this.rank = rank;
        return true;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setDepartment(String department){
        this.department = department;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public void setTempPassword(String tempPassword){
        this.tempPassword = tempPassword;
    }
    
    public void setRank(int rank){
        this.rank = rank;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getDepartment(){
        return department;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getTempPassword(){
        return tempPassword;
    }
    
    public int getRank(){
        return rank;
    }
}
