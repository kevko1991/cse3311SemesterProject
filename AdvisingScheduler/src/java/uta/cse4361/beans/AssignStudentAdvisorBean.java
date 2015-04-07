/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.beans;

import java.util.ArrayList;
import uta.cse4361.businessobjects.AdvisorAccount;
import uta.cse4361.databases.DatabaseManager;

/**
 *
 * @author Ross
 */
public class AssignStudentAdvisorBean {
    private static final String SUCCESS = "Advisor settings successfully applied";
    private static final String OVERLAP = "Ranges overlap - please check your input";
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String message = "";
    private ArrayList<AdvisorAccount> advisors;
    private String[] expandedRanges;
    
    public AssignStudentAdvisorBean(){
    
    }
    
    public AssignStudentAdvisorBean(ArrayList<AdvisorAccount> advisors){
        this.advisors = advisors;
        this.expandedRanges = new String[advisors.size()];
    }
    
    public String execute(){
        if(isOverlapping(advisors)){
            message = OVERLAP;
        }
        else{
            DatabaseManager dm = new DatabaseManager();
            dm.saveAdvisorAssignments(advisors);
            message = SUCCESS;
        }
            
        return message;
    }
    
    private boolean isOverlapping(ArrayList<AdvisorAccount> advisors){
        if(false){
            return true;
        }
        else
            return false;
   
    }
    
    private void expandRanges(){
        char start, end;
        String[] split;
        for(AdvisorAccount aa: advisors){
            start = aa.getAssignment().charAt(0);
            end = aa.getAssignment().charAt(2);
        }
    }
    
    
}
