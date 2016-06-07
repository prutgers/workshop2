/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.BestellingArtikelDAOHibernate;
import DAO.Hibernate.BestellingDAOHibernate;
import DAOFactory.DAOFactory;
import POJO.BestellingArtikel;
import interfaceDAO.BestellingArtikelDAO;
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
    public void createKoppel(BestellingArtikel koppel){
        DAO.openCurrentSessionWithTransaction();
        DAO.save(koppel);
        DAO.closeCurrentSessionWithTransaction();
    }

    //read all koppel
    public BestellingArtikel findById(int bestellingArtikelId){
        return DAO.findById(bestellingArtikelId);
    }
    
    //read by id koppel
    public ArrayList<BestellingArtikel> findByBestellingId(int bestellingID){
        return DAO.findByBestellingId(bestellingID);
    }
    
    //update koppel
    public void update(BestellingArtikel koppel){
        DAO.update(koppel);
    }    
    //delete
    public void delete(int bestellingArtikelID){
        DAO.openCurrentSessionWithTransaction();
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        DAO.delete(bestellingArtikelID);
        DAO.closeCurrentSessionWithTransaction();
    }
}
