/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.beans;

import static java.lang.System.out;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import uta.cse4361.businessobjects.AdvisorAccount;
import uta.cse4361.databases.DatabaseManager;
import uta.cse4361.databases.RelationalDatabaseImpl;
import uta.cse4361.interfaces.Constants;

/**
 *
 * @author Nabin
 */
public class CreateAdvisorAccountBean implements Constants{
    private String name = null;
    private String email= null;
    private String department = null;
    private int ID= 0;
    private String tempPassword = null;
    private int rank = 0;
    private int FirstLog = 1;

    public CreateAdvisorAccountBean() {
    }

    
    public String Advisor(){
       String returnMessage = SUCCESS_MESSAGE;
       
       //The tempPassword code below is for creating an Alphanumeric temporary password.
       
       char[] CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
       int length = 8;
       
       this.tempPassword = createPassword(CHARSET, length);
       System.out.println(tempPassword);
       
       AdvisorAccount AA = new AdvisorAccount();
       boolean a = AA.initialize(this.name, this.email, this.department, this.tempPassword, this.rank);
       if (a == false)
           return this.CREATE_ADVISOR_FAIL;
       DatabaseManager dm = new DatabaseManager();
       returnMessage = dm.register(AA);
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
    
    //This function will create a password based on a character set and desired length.
    
    public String createPassword(char[] charset, int length){
        String pass = "";
        int i = 0;
        
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (i = 0; i < result.length; i++) {
            // picks a random index out of character set > random character
            int randomCharIndex = random.nextInt(charset.length);
            result[i] = charset[randomCharIndex];
        }
        
        for(i=0; i<result.length; i++){
            pass += result[i];
        }
        System.out.println(pass);
        
        return pass;
    }
}
