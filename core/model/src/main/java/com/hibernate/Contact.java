package com.hibernate;
import java.util.*;
import java.io.*;

public class Contact implements Serializable{
    private int contactID;
    
    long landLine;
    long mobileNumber;
    
    String email;
    
    Person person;
    
    public Contact() {}
    
    public Contact(long landLine, long mobileNumber, String email) {
        this.landLine = landLine;
        this.mobileNumber = mobileNumber;
        
        this.email = email;
    }
    
    //Setters
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }
    
    public void setLandLine(long landLine) {
        this.landLine = landLine;
    }
    
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    //Getters
    public int getContactID() {
        return contactID;
    }
    public long getLandLine() {
        return landLine;
    }
    
    public long getMobileNumber() {
        return mobileNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Person getPerson() {
        return person;
    }
}