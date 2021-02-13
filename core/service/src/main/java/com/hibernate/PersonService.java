package com.hibernate;

import java.util.List;
//import java.io.*;
//
//import java.util.List; 
//import java.util.Date; 
//import java.util.Iterator; 
//import org.hibernate.HibernateException; 
//import org.hibernate.Session; 
//import org.hibernate.Transaction; 
//import org.hibernate.SessionFactory; 
//import org.hibernate.cfg.Configuration;

public class PersonService {
    private static PersonDAOImp personDAOImp;
    
    public PersonService() {
        personDAOImp = new PersonDAOImp();
    }
    
    public void createPerson(Person person) {
        personDAOImp.openCurrentSessionwithTransaction();
        personDAOImp.createPerson(person);
        personDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public Person findById(int personID) {
        personDAOImp.openCurrentSessionwithTransaction();
        Person person = personDAOImp.findById(personID);
        personDAOImp.closeCurrentSessionwithTransaction();
        
        return person;
    }
    
    public void deletePerson(Integer personID) {
        personDAOImp.openCurrentSessionwithTransaction();
        Person person = personDAOImp.findById(personID);
        personDAOImp.deletePerson(person);
        personDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public void updatePerson(Person person) {
        personDAOImp.openCurrentSessionwithTransaction();
        personDAOImp.updatePerson(person);
        personDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public List<Person> findAllPersonByGWA() {
        personDAOImp.openCurrentSession();
        List<Person> persons = personDAOImp.findAllPersonByGWA();
        personDAOImp.closeCurrentSession();
        return persons;
    }
    
    public List<Person> findAllPersonByDateHired() {
        personDAOImp.openCurrentSession();
        List<Person> persons = personDAOImp.findAllPersonByDateHired();
        personDAOImp.closeCurrentSession();
        return persons;
    }
    
    public List<Person> findAllPersonByLastName() {
        personDAOImp.openCurrentSession();
        List<Person> persons = personDAOImp.findAllPersonByLastName();
        personDAOImp.closeCurrentSession();
        return persons;
    }
    
    public PersonDAOImp personDAOImp() {
        return personDAOImp;
    }
}