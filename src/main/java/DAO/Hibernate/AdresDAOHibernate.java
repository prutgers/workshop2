package DAO.Hibernate;

import POJO.Adres;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sonja
 */

public class AdresDAOHibernate {
    
    private Session currentSession;
    private Transaction currentTransaction;
    
    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction.commit();
        currentSession.close();
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
    
    public SessionFactory getSessionFactory() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        SessionFactory sessionFactory = config.buildSessionFactory(ssrb.build());
        return sessionFactory;
    }
   
    public Adres createAdres(Adres adres) {
        getCurrentSession().save(adres);
        return adres;
    }

    public ArrayList<Adres> readAdres() {
        ArrayList<Adres> adresGegevens = (ArrayList<Adres>)getCurrentSession()
                .createQuery("from adres").list();
        return adresGegevens;
    }

    public Adres readAdresByID(int adresID) {
        Adres adres = (Adres)getCurrentSession().get(Adres.class, adresID);
        return adres;
    }

    public void updateAdres(Adres adres) {
        getCurrentSession().update(adres); 
    }

    public void deleteAdres(Adres adres) {
        getCurrentSession().delete(adres); 
    }
}
