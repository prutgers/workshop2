/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.*;
import POJO.*;
import interfaceDAO.*;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class BestellingService {
    private static BestellingDAOHibernate DAO;
    
    public BestellingService(BestellingDAOHibernate bestellingDAOHibernate){
        DAO = bestellingDAOHibernate;
    }
    
    //create bestelling
    public void save(Bestelling bestelling){
        DAO.openCurrentSessionWithTransaction();
        DAO.save(bestelling);
        DAO.closeCurrentSessionWithTransaction();
    }

    //read all bestelling
    public ArrayList<Bestelling>findAll(){
        DAO.openCurrentSession();
        ArrayList<Bestelling> bestellingen = DAO.findAll();
        DAO.closeCurrentSession();
        return bestellingen;
    }
    //read bestelling
    public Bestelling findById(int bestellingId){
        DAO.openCurrentSession();
        Bestelling bestelling = DAO.findById(bestellingId);
        DAO.closeCurrentSession();
        return bestelling;
    }
    
    //read bestelling by klantId
    public ArrayList<Bestelling> findByKlantId(int klantId){
        DAO.openCurrentSessionWithTransaction();
        ArrayList<Bestelling> bestellingen = DAO.findByKlantId(klantId);
        DAO.closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    
    public void update(Bestelling bestelling){
        DAO.openCurrentSessionWithTransaction();
        DAO.update(bestelling);
        DAO.closeCurrentSessionWithTransaction();
    }
    //delete 
    public void delete(int bestellingId){
        Bestelling bestelling = findById(bestellingId);
        DAO.openCurrentSessionWithTransaction();
        DAO.delete(bestelling); 
        DAO.closeCurrentSessionWithTransaction();
    }
    public void delete(Bestelling bestelling){
        DAO.openCurrentSessionWithTransaction();
        DAO.delete(bestelling); 
        DAO.closeCurrentSessionWithTransaction();
    }
}
