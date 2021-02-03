package com.hibernate;
import java.util.*;

public class Contact {
    private int landLine;
    private int mobileNumber;
    private String email;
    
    //Setters
    public void setLandLine(int landLine) {
        this.landLine = landLine;
    }
    
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    //Getters
    public int getLandLine() {
        return landLine;
    }
    
    public int getMobileNumber() {
        return mobileNumber;
    }
    
    public String getEmail() {
        return email;
    }
}