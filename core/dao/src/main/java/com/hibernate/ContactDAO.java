package com.hibernate;
import java.io.Serializable;
import java.util.List;

public interface ContactDAO<T, Id extends Serializable> {
    //Create or contact
    public void createContact(T entity);
    
    //Find contact
    public Contact findById(Integer contactID);
    
    //Delete contact
    public void deleteContact(T entity);
    
    //Update Contact
    public void updateContact(T entity);
    
    //find all contact
    public List<Contact> findAllContact();
}