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
     private int StartHr = 0;
    private int StartMin =0;
    private int EndHr =0;
    private int EndMin =0;
    
    Date date = new Date();

    public ModifyTimeSlotsBean() {
    }
    public ModifyTimeSlotsBean(int StartHr, int EndHr, int StartMin, int EndMin, Date date){
        this.StartHr =StartHr;
        this.EndHr =EndHr;
        this.StartMin =StartMin;
        this.EndMin =EndMin;
        this.date=date;
        
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int getStartHr() {
        return StartHr;
    }

    public int getStartMin() {
        return StartMin;
    }

    public int getEndHr() {
        return EndHr;
    }

    public int getEndMin() {
        return EndMin;
    }

    public void setStartHr(int StartHr) {
        this.StartHr = StartHr;
    }

    public void setStartMin(int StartMin) {
        this.StartMin = StartMin;
    }

    public void setEndHr(int EndHr) {
        this.EndHr = EndHr;
    }

    public void setEndMin(int EndMin) {
        this.EndMin = EndMin;
    }

     
    
    public String modifySlot(){
         String msg = SUCCESS_MESSAGE;
         DatabaseManager dm = new DatabaseManager();
         
         msg = dm.modifySlot(date, StartHr, StartMin, EndHr, EndMin);
         
         return msg;
    }
    
    
}
