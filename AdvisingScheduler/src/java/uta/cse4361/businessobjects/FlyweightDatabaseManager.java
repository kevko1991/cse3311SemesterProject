/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Frank R.
 */
public class FlyweightDatabaseManager {
    
    public FlyweightDatabaseManager()
    {
        
    }
    
    public boolean isFree(Date date, int startHour, int endHour, int startMinute, int endMinute)
    {
        return false;
    }
    
    public String saveFlyweights(ArrayList<Flyweight> flyweights)
    {
        return "";
    }
    
    public ArrayList<Flyweight> getDaysFlyweights(Date date)
    {
        return new ArrayList<Flyweight> ();
    }
    
    public Flyweight[] getDaysFlyweightsArray(Date date)
    {
        return new Flyweight[1];
    }
        


}
