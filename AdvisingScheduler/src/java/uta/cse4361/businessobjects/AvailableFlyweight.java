/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.Date;

/**
 *
 * @author The Doctor
 */
public class AvailableFlyweight extends Flyweight{
    
    public AvailableFlyweight(Date newDate, int newHour, int newMinute) throws IllegalArgumentException
    {
        super(false, Flyweight.ILLEGAL_APPT_ID, newDate, newHour, newMinute);
 
    }
    

    
}
