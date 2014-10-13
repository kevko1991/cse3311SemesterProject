/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.databases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import uta.cse4361.businessobjects.Slot;

/**
 *
 * @author Frank R.
 */
public class SlotDatabaseManager implements uta.cse4361.interfaces.Constants{
    
    
    private HashMap<Date, ArrayList<Slot>> flyweightDatabase;
    
    public SlotDatabaseManager()
    {
        loadDatabase();
    }
    
    private void loadDatabase()
    {
        try{
            File saveFile = new File(FDB_FILE_NAME);
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
            flyweightDatabase = (HashMap<Date, ArrayList<Slot>>) inStream.readObject();
            inStream.close();
        }
        catch(Exception e)
        {
            flyweightDatabase = new HashMap<Date,ArrayList<Slot>>();
            saveDatabase();
        }
    }
    
    private void saveDatabase()
    {
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(FDB_FILE_NAME));
            outStream.writeObject(flyweightDatabase);
            outStream.flush();
            outStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean isFree(Date date, int startHour, int endHour, int startMinute, int endMinute)
    {
        ArrayList<Slot> daysFlyweights = flyweightDatabase.get(date);
        
        boolean isFree = true;
        
        int startTime = (startHour * 60) + startMinute;
        int endTime = (endHour * 60) + endMinute;
        
        for(Slot flyweight: daysFlyweights)
        {
            if(flyweight.isAppointment())
            {
                if((flyweight.getTime() >= startTime) && (flyweight.getTime() <= endTime))
                {
                    isFree = isFree && false;
                }
            }
        }
        
        return isFree;        
    }
    
    public String saveFlyweights(ArrayList<Slot> flyweights)
    {
        if(flyweights == null || flyweights.size() == 0)
        {
            return FLYWEIGHTS_EMPTY_FAULT;
        }
        Date fwDate = flyweights.get(0).getDate();
        
        for(Slot flyweight: flyweights)
        {
            if(!flyweight.getDate().equals(fwDate))
            {
                return FLYWEIGHTS_DIFFERENT_DATE_FAULT;
            }
        }   
        
        ArrayList<Slot> currentFwList = flyweightDatabase.get(fwDate);
        if (currentFwList == null)
        {
            currentFwList = new ArrayList<Slot>();
        }
        
        for(Slot flyweight: flyweights)
        {
            currentFwList.add(flyweight);
        }
        
        Collections.sort(currentFwList);
        
        flyweightDatabase.put(fwDate, currentFwList);
        saveDatabase();
        return "";
    }
    
    public ArrayList<Slot> getDaysFlyweights(Date date)
    {
        ArrayList<Slot> daysFlyweights = flyweightDatabase.get(date);
        if(daysFlyweights == null)
        {
            daysFlyweights = new ArrayList<Slot>();
        }
        
        //Collections.sort(daysFlyweights);
        
        ArrayList<Slot> finalDaysFlyweights = new ArrayList<Slot>();
        ArrayList<Integer> appointmentTimes = new ArrayList<Integer>();
        Slot previousFlyweight = null;
        
        for(Slot currentFlyweight: daysFlyweights)
        {
            if(currentFlyweight.isAppointment())
            {
                finalDaysFlyweights.add(currentFlyweight);
                appointmentTimes.add(currentFlyweight.getTime());
            }
        }
        
        for(Slot currentFlyweight: daysFlyweights)
        {
            if(!appointmentTimes.contains(currentFlyweight.getTime()))
            {
                finalDaysFlyweights.add(currentFlyweight);
            }
        }
        
        Collections.sort(finalDaysFlyweights);
        return finalDaysFlyweights;
    }
    
    public Slot[] getDaysFlyweightsArray(Date date)
    {
        return (Slot[])getDaysFlyweights(date).toArray();
    }
    
    public ArrayList<Date> getDatesForAvailability()
    {
        ArrayList<Date> availableDates = new ArrayList<Date>();
        for(Date date: flyweightDatabase.keySet())
        {
            ArrayList<Slot> flyweights = getDaysFlyweights(date);
            
            for(Slot flyweight: flyweights)
            {
                if (!flyweight.isAppointment())
                {
                    availableDates.add(date);
                    break;
                }
            }
        }
        
        return availableDates;
    }
        
/**
 * getMaxDaysInMonth - calculates the number of a days in a certain month and year
 * @param month
 * @param year
 * @return 
 */
        public int getMaxDaysInMonth(int month, int year){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.MONTH, month+1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)-1);

        return cal.get(Calendar.DATE);
    }
    /**
     * getMonthFlyweights - Uses date to get year and month. Returns all the flyweights within the month.
     * @param date
     * @return 
     */    
    public ArrayList<Slot> getMonthFlyweights(Date date)
    {
        int day = 1;
        ArrayList<Slot> monthFlyweights = new ArrayList<Slot>(); 
        ArrayList<Slot> daysFlyweights = new ArrayList<Slot>();//flyweightDatabase.get(date);       
        Date tempDate = new Date(date.getYear(), date.getMonth(), day);
        
        do{
            tempDate.setDate(day);
            daysFlyweights = flyweightDatabase.get(tempDate);
            if(daysFlyweights == null)
            {
                
            }
            else
            {
                monthFlyweights.addAll(daysFlyweights);
            }
            day++;
        }while(day<=(getMaxDaysInMonth(date.getMonth(), 2014)));
        
        if(monthFlyweights == null)
        {
            monthFlyweights = new ArrayList<Slot>();
        }
        
        //Collections.sort(daysFlyweights);
        
        ArrayList<Slot> finalDaysFlyweights = new ArrayList<Slot>();
        ArrayList<Integer> appointmentTimes = new ArrayList<Integer>();
        
        for(Slot currentFlyweight: monthFlyweights)
        {
            if(currentFlyweight.isAppointment())
            {
                finalDaysFlyweights.add(currentFlyweight);
                appointmentTimes.add(currentFlyweight.getTime());
            }
        }
        
        for(Slot currentFlyweight: monthFlyweights)
        {
            if(!appointmentTimes.contains(currentFlyweight.getTime()))
            {
                finalDaysFlyweights.add(currentFlyweight);
            }
        }
        
        Collections.sort(finalDaysFlyweights);
        return finalDaysFlyweights;
    }
    
    public ArrayList<Slot> getYearFlyweights(Date date)
    {
        ArrayList<Slot> yearFlyweights = new ArrayList<Slot>(); 
        
        int month = 0;
//        Date tempDate = new Date(date.getYear(), month, 1);
//        Date tempDate = new Date(date.getYear(), month, date.getDate());
        for(month=0; month<12; month++)
        {
            Date tempDate = new Date(date.getYear(), month, date.getDate());
            
            if(getMonthFlyweights(tempDate) == null)
            {
                
            }
            else
            {
                yearFlyweights.addAll(getMonthFlyweights(tempDate));
            }
        }
        return yearFlyweights;
    }
}
