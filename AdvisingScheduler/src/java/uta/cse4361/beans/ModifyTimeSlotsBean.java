/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.beans;
import java.util.Date;
import uta.cse4361.databases.DatabaseManager;
import uta.cse4361.interfaces.Constants;
/**
 *
 * @author Nabin
 */
public class ModifyTimeSlotsBean implements Constants{
    private int startHr = 0;
    private int startMin =0;
    private int endHr =0;
    private int endMin =0;
    
    Date date = new Date();

    public ModifyTimeSlotsBean() {
    }
    public ModifyTimeSlotsBean(int StartHr, int EndHr, int StartMin, int EndMin, Date date){
        this.startHr =StartHr;
        this.endHr =EndHr;
        this.startMin =StartMin;
        this.endMin =EndMin;
        this.date=date;
        
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int getStartHr() {
        return startHr;
    }

    public int getStartMin() {
        return startMin;
    }

    public int getEndHr() {
        return endHr;
    }

    public int getEndMin() {
        return endMin;
    }

    public void setStartHr(int StartHr) {
        this.startHr = StartHr;
    }

    public void setStartMin(int StartMin) {
        this.startMin = StartMin;
    }

    public void setEndHr(int EndHr) {
        this.endHr = EndHr;
    }

    public void setEndMin(int EndMin) {
        this.endMin = EndMin;
    }

     
    
    public String modifySlot(){
         String msg = SUCCESS_MESSAGE;
         DatabaseManager dm = new DatabaseManager();
         
         msg = dm.modifySlot(date, startHr, startMin, endHr, endMin);
         
         return msg;
    }
    
    
}
