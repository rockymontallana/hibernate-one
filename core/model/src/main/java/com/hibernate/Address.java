package com.hibernate;
import java.util.*;

public class Address {
    private int streetNo;
	private String barangay;
	private String municipalityOrCity;
	private int zipcode;
    
    //Setters
    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }
    
    public void setBarangay(String barangay){
        this.barangay = barangay;
    }
    
    public void setMunicipalityOrCity(String municipalityOrCity){
        this.municipalityOrCity = municipalityOrCity;
    }
    
    public void setZipcode(int zipcode){
        this.zipcode = zipcode;
    }
    
    //Getters
    public int getStreetNo() {
        return streetNo;
    }
    
    public String getBarangay() {
        return barangay;
    }
    
    public String getMunicipalityOrCity() {
        return municipalityOrCity;
    }
    
    public int getZipcode() {
        return zipcode;
    }
}