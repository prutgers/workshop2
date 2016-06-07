/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.*;
import POJO.BestellingArtikel;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class BestellingArtikelService {
    private static BestellingArtikelDAOHibernate DAO;
    
    public BestellingArtikelService(){
        DAO = new BestellingArtikelDAOHibernate();
    }
    //create koppel
    public void save(BestellingArtikel bestellingArtikel){
        DAO.openCurrentSessionWithTransaction();
        DAO.save(bestellingArtikel);
        DAO.closeCurrentSessionWithTransaction();
    }

    //read all koppel
    public BestellingArtikel findById(int bestellingArtikelId){
        DAO.closeCurrentSessionWithTransaction();
        BestellingArtikel bestellingArtikel = DAO.findById(bestellingArtikelId);
        DAO.closeCurrentSessionWithTransaction();
        return bestellingArtikel;
        
    }
    
    //read by id koppel
    public ArrayList<BestellingArtikel> findByBestellingId(int bestellingId){
        DAO.openCurrentSession();
        ArrayList<BestellingArtikel> BestellingArtikelList = DAO.findByBestellingId(bestellingId);
        DAO.closeCurrentSession();
        return BestellingArtikelList;
    }
    
    //update koppel
    public void update(BestellingArtikel koppel){
        DAO.openCurrentSessionWithTransaction();
        DAO.update(koppel);
        DAO.closeCurrentSessionWithTransaction();
    }    
    //delete
    public void delete(int bestellingArtikelID){
        DAO.openCurrentSessionWithTransaction();
        DAO.delete(bestellingArtikelID);
        DAO.closeCurrentSessionWithTransaction();
    }
}
