package com.hibernate;

import java.util.List;

public class ContactService {
    private static ContactDAOImp contactDAOImp;
    
    public ContactService() {
        contactDAOImp = new ContactDAOImp();
    }
    
    public void createContact(Contact contact) {
        contactDAOImp.openCurrentSessionwithTransaction();
        contactDAOImp.createContact(contact);
        contactDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public void updateContact(Contact contact) {
        contactDAOImp.openCurrentSessionwithTransaction();
        contactDAOImp.updateContact(contact);
        contactDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public Contact findById(int contactID) {
        contactDAOImp.openCurrentSessionwithTransaction();
        Contact contact = contactDAOImp.findById(contactID);
        contactDAOImp.closeCurrentSessionwithTransaction();
        
        return contact;
    }
    
    public void deleteContact(Integer contactID) {
        contactDAOImp.openCurrentSessionwithTransaction();
        Contact contact = contactDAOImp.findById(contactID);
        contactDAOImp.deleteContact(contact);
        contactDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public List<Contact> findAllContact() {
        contactDAOImp.openCurrentSessionwithTransaction();
        List<Contact> contacts = contactDAOImp.findAllContact();
        contactDAOImp.closeCurrentSessionwithTransaction();
        
        return contacts;
    }
    
    public ContactDAOImp contactDAOImp() {
        return contactDAOImp;
    }
}