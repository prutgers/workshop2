package DAO.Hibernate;

import POJO.Adres;
import interfaceDAO.*;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Sonja
 */

public class AdresDAOHibernate implements IAdresDAO {
    
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
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        MetadataSources mS = new MetadataSources(ssr);
        mS.addAnnotatedClass(Adres.class);
        SessionFactory sessionFactory = mS.buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
   
    public Adres save(Adres adres) {
        getCurrentSession().save(adres);
        return adres;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Adres> findAll() {
        ArrayList<Adres> adresGegevens = (ArrayList<Adres>)getCurrentSession()
                .createQuery("from Adres").list();
        return adresGegevens;
    }

    public Adres findById(int adresId) {
        Adres adres = (Adres)getCurrentSession().get(Adres.class, adresId);
        return adres;
    }

    @Override
    public void update(Adres adres) {
        getCurrentSession().update(adres); 
    }

    @Override
    public void delete(Adres adres) {
        getCurrentSession().delete(adres); 
    }

    @Override
    public void delete(int adresId) {
        Adres adres = (Adres)getCurrentSession().get(Adres.class, adresId);
        getCurrentSession().delete(adres); 
    }
}
