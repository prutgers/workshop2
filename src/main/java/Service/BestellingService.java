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
    
    public BestellingService(){
        DAO = new BestellingDAOHibernate();
    }
    
    //create bestelling
    public Bestelling save(Bestelling bestelling){
        DAO.openCurrentSessionWithTransaction();
        Bestelling newBestelling = DAO.save(bestelling);
        DAO.closeCurrentSessionWithTransaction();
        return newBestelling;
    }

        //delete koppel
    public void delete(int bestellingId){
        Bestelling bestelling = findById(bestellingId);
        DAO.delete(bestelling); 
    }

    //read all bestelling
    public ArrayList<Bestelling>readAll(){
        DAO.openCurrentSessionWithTransaction();
        ArrayList<Bestelling> bestellingen = DAO.findAll();
        DAO.closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    //read bestelling
    public Bestelling findById(int bestellingId){
        DAO.openCurrentSessionWithTransaction();
        Bestelling bestelling = DAO.findById(bestellingId);
        DAO.closeCurrentSessionWithTransaction();
        return bestelling;
    }
    
    //read bestelling by klantId
    public ArrayList<Bestelling> readByKlantID(int klantID){
        DAO.openCurrentSessionWithTransaction();
        ArrayList<Bestelling> bestellingen = DAO.findByKlantId(klantID);
        DAO.closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    
    public void update(Bestelling bestelling){
        DAO.openCurrentSessionWithTransaction();
        DAO.update(bestelling);
        DAO.closeCurrentSessionWithTransaction();
    }
   
}
