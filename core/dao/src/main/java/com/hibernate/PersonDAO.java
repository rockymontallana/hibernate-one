package com.hibernate;
import java.io.Serializable;
import java.util.List;

public interface PersonDAO<T, Id extends Serializable> {
    //Create or insert person
    public void createPerson(T entity);
    
    //Find Person
    public Person findById(Integer personID);
    
    //Delete person
    public void deletePerson(T entity);
    
    //Update person
    public void updatePerson(T entity);
    
    //List Person
    public List<T> findAllPersonByGWA();
    public List<T> findAllPersonByDateHired();
    public List<T> findAllPersonByLastName();
}