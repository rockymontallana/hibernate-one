package com.hibernate;

import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Transaction;

public class RoleDAOImp implements RoleDAO<Role, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;
    
    public RoleDAOImp(){}
    
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
    
    public void createRole(Role role) {
        getCurrentSession().save(role);
    }
    
    public void updateRole(Role role) {
        getCurrentSession().update(role);
    }
    
    public Role findById(Integer roleID) {
        Role role = (Role) getCurrentSession().get(Role.class, roleID);
        return role; 
    }
    
    public void deleteRole(Role role) {
        getCurrentSession().delete(role);
    }
    
    public List<Role> findAllRole() {
        List<Role> roles = (List<Role>) getCurrentSession().createQuery("from Role").list();
        return roles;
    }
}