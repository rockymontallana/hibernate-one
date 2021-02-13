package com.hibernate;
import java.util.*;
import java.io.*;

public class Role implements Serializable{
    private int roleID;
    
    String role;
    
    List<Person> persons;
    
    public Role() {}
    
    public Role(String role) {
        this.role = role;
    }
    
    //Setters
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
    //Getters
    public int getRoleID() {
        return roleID;
    }
    
    public String getRole() {
        return role;
    }
    
    public List<Person> getPersons() {
        return persons;
    }
}