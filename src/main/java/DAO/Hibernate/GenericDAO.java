/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package DAO.Hibernate;

import POJO.*;
import interfaceDAO.IBestellingDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import interfaceDAO.IGenericDAO;

/**
 *
 * @author Peter
 */

public class GenericDAO<T> implements IGenericDAO {
     private Session currentSession;
    private Transaction currentTransaction;
    private Class<T> classje;
    
    
    public GenericDAO(Class<T> classje){
        this.classje = classje;
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

    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction.commit();
        currentSession.close();
    }

    public SessionFactory getSessionFactory(){
        StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources ms = new MetadataSources(ssrb);
        ms.addAnnotatedClass(Bestelling.class);
        ms.addAnnotatedClass(BestellingArtikel.class);
        ms.addAnnotatedClass(Artikel.class);
        ms.addAnnotatedClass(Klant.class);
        ms.addAnnotatedClass(Adres.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }
    
    
    @Override
    public void save(Object entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public Object findById(Object id) {
        T entity;   
         entity = (T)getCurrentSession().get(classje, id);
         return entity;
    }

    

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    
