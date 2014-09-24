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
        return false;
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
        return flyweightDatabase.get(date);
    }
    
    public Flyweight[] getDaysFlyweightsArray(Date date)
    {
        return (Flyweight[])flyweightDatabase.get(date).toArray();
    }
        


}
