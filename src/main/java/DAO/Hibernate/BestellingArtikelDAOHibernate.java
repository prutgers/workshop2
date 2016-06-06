/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Hibernate;

import POJO.Artikel;
import POJO.Bestelling;
import POJO.BestellingArtikel;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Gebruiker
 */
public class BestellingArtikelDAOHibernate {
        
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
        ms.addAnnotatedClass(Bestelling.class);
        ms.addAnnotatedClass(BestellingArtikel.class);
        ms.addAnnotatedClass(Artikel.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }
    
    public BestellingArtikel save (BestellingArtikel bestellingArtikel) {
        getCurrentSession().save(bestellingArtikel);
        return bestellingArtikel;
    }
    public ArrayList<BestellingArtikel> findByBestellingId(int bestellingId){
        Query query = getCurrentSession().createQuery("from BestellingArtikel where bestelling_id = :bestellingId");
        query.setParameter("bestellingId", bestellingId);
        ArrayList<BestellingArtikel> bestellingArtikelSet = (ArrayList<BestellingArtikel>) query.list();
        return bestellingArtikelSet;
    }
    
    public BestellingArtikel findById(int bestellingArtikelId){
        BestellingArtikel bestellingArtikel = (BestellingArtikel) getCurrentSession().get(BestellingArtikel.class, bestellingArtikelId);
        return bestellingArtikel;
    }
    
    public void update(BestellingArtikel bestellingArtikel){
        getCurrentSession().update(bestellingArtikel);
    }
    
    public void delete(int bestellingArtikelId){
        BestellingArtikel bestellingArtikel = findById(bestellingArtikelId);
        getCurrentSession().delete(bestellingArtikel);
    }
}
