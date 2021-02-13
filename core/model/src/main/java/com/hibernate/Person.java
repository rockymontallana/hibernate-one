package com.hibernate;
import java.util.*;
import java.io.*;

public class Person implements Serializable{
    private int personID;
    
    private String lastName;
    private String firstName;
    private String middleName;
    private String suffix;
    private String title;
    
    private String streetNo;
	private String barangay;
	private String cityOrMunicipality;
	private int zipcode;
    
    private Date birthday;
    private double gradeWeightedAverage;
    private Date dateHired;
    private boolean isCurrentlyEmployed;
    
    private List<Contact> contacts = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();
    
    public Person() {}
    
    public Person(String lastName, String firstName, String middleName, String suffix, String title, 
                  String streetNo, String barangay, String cityOrMunicipality, int zipcode, 
                  Date birthday, double gradeWeightedAverage, Date dateHired, boolean isCurrentlyEmployed) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.title = title;
        
        this.streetNo = streetNo;
        this.barangay = barangay;
        this.cityOrMunicipality = cityOrMunicipality;
        this.zipcode = zipcode;
        
        this.birthday = birthday;
        this.gradeWeightedAverage = gradeWeightedAverage;
        this.dateHired = dateHired;
        this.isCurrentlyEmployed = isCurrentlyEmployed;
    }
    
    //Setters
    public void setPersonID(int personID) {
        this.personID = personID;
    }
    
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
    
    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }
    
    public void setBarangay(String barangay){
        this.barangay = barangay;
    }
    
    public void setCityOrMunicipality(String cityOrMunicipality){
        this.cityOrMunicipality = cityOrMunicipality;
    }
    
    public void setZipcode(int zipcode){
        this.zipcode = zipcode;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public void setGradeWeightedAverage(double gradeWeightedAverage) {
        this.gradeWeightedAverage = gradeWeightedAverage;
    }
    
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }
    
    public void setIsCurrentlyEmployed(boolean isCurrentlyEmployed) {
        this.isCurrentlyEmployed = isCurrentlyEmployed;
    }
    
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    //Getters
    public int getPersonID() {
        return personID;
    }
    
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
    
    public String getStreetNo() {
        return streetNo;
    }
    
    public String getBarangay() {
        return barangay;
    }
    
    public String getCityOrMunicipality() {
        return cityOrMunicipality;
    }
    
    public int getZipcode() {
        return zipcode;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public double getGradeWeightedAverage() {
        return gradeWeightedAverage;
    }
    
    public Date getDateHired() {
        return dateHired;
    }
    
    public boolean getIsCurrentlyEmployed() {
        return isCurrentlyEmployed;
    }
    
    public List<Contact> getContacts() {
        return contacts;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
}