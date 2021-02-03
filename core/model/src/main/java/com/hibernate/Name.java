package com.hibernate;
import java.util.*;

public class Name {
    private String lastName;
    private String firstName;
    private String middleName;
    private String suffix;
    private String title;
    
    //Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    //Getters
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public String getSuffix() {
        return suffix;
    }
    
    public String getTitle() {
        return title;
    }
}