package com.hibernate;

import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Transaction;

public class PersonDAOImp implements PersonDAO<Person, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;
    
    public PersonDAOImp(){}
    
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
    
    public void createPerson(Person person) {
        getCurrentSession().save(person);
    }
    
    public Person findById(Integer personID) {
        Person person = (Person) getCurrentSession().get(Person.class, personID);
        return person; 
    }
    
    public void deletePerson(Person person) {
        getCurrentSession().delete(person);
    }
    
    public void updatePerson(Person person) {
        getCurrentSession().update(person);
    }
    
    public List<Person> findAllPersonByGWA() {
        List<Person> persons = (List<Person>) getCurrentSession().createQuery("from Person").list();
        return persons;
    }
    
    public List<Person> findAllPersonByDateHired() {
        List<Person> persons = (List<Person>) getCurrentSession().createQuery("from Person P order by P.dateHired asc").list();
        return persons;
    }
    
    public List<Person> findAllPersonByLastName() {
        List<Person> persons = (List<Person>) getCurrentSession().createQuery("from Person P order by P.lastName asc").list();
        return persons;
    }
}