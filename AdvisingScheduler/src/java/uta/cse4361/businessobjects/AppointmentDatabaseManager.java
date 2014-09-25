/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uta.cse4361.businessobjects;
import java.util.*;
import java.io.*;

/**
 *
 * @author Nabin
 */
public class AppointmentDatabaseManager {

    Appointment an = new Appointment();

    FileInputStream fileIn = null;
    FileOutputStream fileOut = null;
    Hashtable<Integer, Appointment> has = new Hashtable<Integer, Appointment>();

    public AppointmentDatabaseManager() {
        loadHashTable();
    }

    public void saveAppointment(Appointment an) {

        has.put(an.getApptID(), an);
        saveHashtable();
    }

    private void saveHashtable() {
        try {
            fileOut = new FileOutputStream("example.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(has);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadHashTable() {
        try {
            fileIn = new FileInputStream("example.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            has = (Hashtable) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e + "Class is unavailable.");
        } catch (FileNotFoundException e) {
            has = new Hashtable<Integer, Appointment>();
            Appointment newIdAppointment = new Appointment();
            newIdAppointment.setApptID(0);
            has.put(-1, newIdAppointment);
        } catch (IOException e) {
            System.out.println(e + "Exception occured");
        }
    }

    public Appointment getAppointment(int id) {

        loadHashTable();
        /*
        System.out.println("Printing out loaded elements...");
        for (Enumeration e = has.keys(); e.hasMoreElements();) {
            Object obj = e.nextElement();
            System.out.println("  - Element(" + obj + ") = " + has.get(obj));
        }*/
        return has.get(id);
    }

    public int getNextId() {
        Appointment nextIdAppt = has.get(-1);
        int newId = nextIdAppt.getApptID();
        nextIdAppt.setApptID(newId++);
        has.put(-1, nextIdAppt);
        return newId;

    }

}
