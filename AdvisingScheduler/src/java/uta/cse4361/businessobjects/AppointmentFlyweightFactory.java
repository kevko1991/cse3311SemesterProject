/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;

import java.util.Date;

/**
 *
 * @author Frank R.
 */
public class AppointmentFlyweightFactory {
    
    final static String APPOINTMENT_FLYWEIGHT_KEY = "AppointmentFlyweight";
    final static String AVAILABLE_FLYWEIGHT_KEY = "AvailableFlyweight";
    
    final static int INCREMENT_GAP = 15;
    
    private AppointmentFlyweightFactory() {
    }
    
    public static AppointmentFlyweightFactory getInstance() {
        return AppointmentFlyweightFactoryHolder.INSTANCE;
    }
    
    private static class AppointmentFlyweightFactoryHolder {

        private static final AppointmentFlyweightFactory INSTANCE = new AppointmentFlyweightFactory();
    }
    
    public String createFlyweights(Date date, int startHour, int endHour, int startMinute, int endMinute, String key)
    {
        return "";
    }
    
    
}
