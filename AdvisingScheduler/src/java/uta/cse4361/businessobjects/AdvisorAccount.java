
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
    private String assignment;
    /*
        -1 = Student
        0 = Advisor
        1 = Admin
    */
    private int FirstLog = 1;
    
    public AdvisorAccount(){
        
    }
    
    public boolean initialize(String name, String email, String department, String tempPassword, int rank){
        boolean result = true;
        
        if(name != null && !name.isEmpty() && 
                email != null && !email.isEmpty() && 
                department != null && !department.isEmpty() && 
                tempPassword != null && !tempPassword.isEmpty())
        {
            this.name = name;
            this.email = email;
            this.department = department;
            this.tempPassword = hashPassword(tempPassword);
            this.rank = rank;
            
            return result;
        }
        else
        {
            result = false;
        }
        
        return result;
    }
    
    public boolean initialize(String name, String email, String department, int ID, int rank){
        boolean result = true;
        
        if(name != null && !name.isEmpty() && 
                email != null && !email.isEmpty() && 
                department != null && !department.isEmpty())
        {
            this.name = name;
            this.email = email;
            this.department = department;
            this.rank = rank;
            
            if(rank == 0){
                this.FirstLog = 1;
            }
            else{
                this.FirstLog = 0;
            }
        }
        else{
            result = false;
        }
        
        return result;
    }
    
    public boolean initialize(String name, String department, int ID, String assignment){
        boolean result = true;
        
        if(name != null && !name.isEmpty() && 
                department != null && !department.isEmpty())
        {
            this.name = name;
            this.department = department;
            this.ID = ID;
            this.assignment = assignment;
        }
        else
        {
            result = false;
        }
        
        return result;
    }
    
    public static String hashPassword(String tempPassword)
    {
        int hash = tempPassword.hashCode();
        return Integer.toString(hash);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAssignment(String assignment){
        this.assignment = assignment;
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
        this.tempPassword = hashPassword(tempPassword);
    }
    
    public void setRank(int rank){
        this.rank = rank;
    }
    
    public void setLog(int Log){
        this.FirstLog = Log;
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
    
    public int getLog(){
        return this.FirstLog;
    }
    
    public String getAssignment(){
        return assignment;
    }
}
