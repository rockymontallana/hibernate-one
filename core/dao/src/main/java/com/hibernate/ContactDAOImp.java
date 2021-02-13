package com.hibernate;

import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Transaction;

public class ContactDAOImp implements ContactDAO<Contact, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;
    
    public ContactDAOImp(){}
    
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
    public void createContact(Contact contact) {
        getCurrentSession().save(contact);
    }
    
    public void updateContact(Contact contact) {
        getCurrentSession().update(contact);
    }
    
    public Contact findById(Integer contactID) {
        Contact contact = (Contact) getCurrentSession().get(Contact.class, contactID);
        return contact; 
    }
    
    public void deleteContact(Contact contact) {
        getCurrentSession().delete(contact);
    }
    
    public List<Contact> findAllContact() {
        List<Contact> contacts = (List<Contact>) getCurrentSession().createQuery("from Contact").list();
        return contacts;
    }
}