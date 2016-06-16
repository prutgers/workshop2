/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Hibernate;

import POJO.Artikel;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import interfaceDAO.IArtikelDAO;

/**
 *
 * @author Peter
 */
public class ArtikelDAOHibernate implements IArtikelDAO {
     private Session currentSession;
    private Transaction currentTransaction;

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
        ms.addAnnotatedClass(Artikel.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }

    @Override
    public Artikel save(Artikel artikel) {
        getCurrentSession().save(artikel);
        return artikel;
    }

    @Override
    public Artikel findById(int artikelId) {
        Artikel artikel = (Artikel) getCurrentSession().get(Artikel.class, artikelId);
        return artikel;
    }

    @Override
    public ArrayList<Artikel> findAll() {
       ArrayList<Artikel> artikelLijst = (ArrayList<Artikel>) getCurrentSession().createQuery("from artikel").list();
        return artikelLijst;
    }

    @Override
    public void delete(Artikel artikel) {
        getCurrentSession().delete(artikel);
    }

    @Override
    public void update(Artikel artikel) {
       getCurrentSession().update(artikel);
    }
}
