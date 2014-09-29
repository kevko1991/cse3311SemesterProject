/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

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

/**
 *
 * @author Frank R.
 */
public class FlyweightDatabaseManager {
    
    final static String FDB_FILE_NAME = "FDB_file";
    final static String FLYWEIGHTS_EMPTY_FAULT = "There were no flyweights created to send to the database.";
    final static String FLYWEIGHTS_DIFFERENT_DATE_FAULT = "The flyweights submitted have different dates";
    private HashMap<Date, ArrayList<Flyweight>> flyweightDatabase;
    
    public FlyweightDatabaseManager()
    {
        loadDatabase();
    }
    
    private void loadDatabase()
    {
        try{
            File saveFile = new File(FDB_FILE_NAME);
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
            flyweightDatabase = (HashMap<Date, ArrayList<Flyweight>>) inStream.readObject();
            inStream.close();
        }
        catch(Exception e)
        {
            flyweightDatabase = new HashMap<Date,ArrayList<Flyweight>>();
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
        ArrayList<Flyweight> daysFlyweights = flyweightDatabase.get(date);
        
        boolean isFree = true;
        
        int startTime = (startHour * 60) + startMinute;
        int endTime = (endHour * 60) + endMinute;
        
        for(Flyweight flyweight: daysFlyweights)
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
    
    public String saveFlyweights(ArrayList<Flyweight> flyweights)
    {
        if(flyweights == null || flyweights.size() == 0)
        {
            return FLYWEIGHTS_EMPTY_FAULT;
        }
        Date fwDate = flyweights.get(0).getDate();
        
        for(Flyweight flyweight: flyweights)
        {
            if(!flyweight.getDate().equals(fwDate))
            {
                return FLYWEIGHTS_DIFFERENT_DATE_FAULT;
            }
        }   
        
        ArrayList<Flyweight> currentFwList = flyweightDatabase.get(fwDate);
        if (currentFwList == null)
        {
            currentFwList = new ArrayList<Flyweight>();
        }
        
        for(Flyweight flyweight: flyweights)
        {
            currentFwList.add(flyweight);
        }
        
        Collections.sort(currentFwList);
        
        flyweightDatabase.put(fwDate, currentFwList);
        saveDatabase();
        return "";
    }
    
    public ArrayList<Flyweight> getDaysFlyweights(Date date)
    {
        ArrayList<Flyweight> daysFlyweights = flyweightDatabase.get(date);
        if(daysFlyweights == null)
        {
            daysFlyweights = new ArrayList<Flyweight>();
        }
        
        //Collections.sort(daysFlyweights);
        
        ArrayList<Flyweight> finalDaysFlyweights = new ArrayList<Flyweight>();
        ArrayList<Integer> appointmentTimes = new ArrayList<Integer>();
        Flyweight previousFlyweight = null;
        
        for(Flyweight currentFlyweight: daysFlyweights)
        {
            if(currentFlyweight.isAppointment())
            {
                finalDaysFlyweights.add(currentFlyweight);
                appointmentTimes.add(currentFlyweight.getTime());
            }
        }
        
        for(Flyweight currentFlyweight: daysFlyweights)
        {
            if(!appointmentTimes.contains(currentFlyweight.getTime()))
            {
                finalDaysFlyweights.add(currentFlyweight);
            }
        }
        
        Collections.sort(finalDaysFlyweights);
        return finalDaysFlyweights;
    }
    
    public Flyweight[] getDaysFlyweightsArray(Date date)
    {
        return (Flyweight[])getDaysFlyweights(date).toArray();
    }
    
    public ArrayList<Date> getDatesForAvailability()
    {
        ArrayList<Date> availableDates = new ArrayList<Date>();
        for(Date date: flyweightDatabase.keySet())
        {
            ArrayList<Flyweight> flyweights = getDaysFlyweights(date);
            
            for(Flyweight flyweight: flyweights)
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
        

        public int getMaxDaysInMonth(int month, int year){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.MONTH, month+1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)-1);

        return cal.get(Calendar.DATE);
    }
        
    public ArrayList<Flyweight> getMonthFlyweights(Date date)
    {
        int day = 28;
        ArrayList<Flyweight> monthFlyweights = new ArrayList<Flyweight>(); 
        ArrayList<Flyweight> daysFlyweights = new ArrayList<Flyweight>();//flyweightDatabase.get(date);       
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
            monthFlyweights = new ArrayList<Flyweight>();
        }
        
        //Collections.sort(daysFlyweights);
        
        ArrayList<Flyweight> finalDaysFlyweights = new ArrayList<Flyweight>();
        ArrayList<Integer> appointmentTimes = new ArrayList<Integer>();
        
        for(Flyweight currentFlyweight: monthFlyweights)
        {
            if(currentFlyweight.isAppointment())
            {
                finalDaysFlyweights.add(currentFlyweight);
                appointmentTimes.add(currentFlyweight.getTime());
            }
        }
        
        for(Flyweight currentFlyweight: monthFlyweights)
        {
            if(!appointmentTimes.contains(currentFlyweight.getTime()))
            {
                finalDaysFlyweights.add(currentFlyweight);
            }
        }
        
        Collections.sort(finalDaysFlyweights);
        return finalDaysFlyweights;
    }
}
