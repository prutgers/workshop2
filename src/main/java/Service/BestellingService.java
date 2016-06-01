/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.*;
import DAOFactory.DAOFactory;
import POJO.*;
import interfaceDAO.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class BestellingService {
    private static BestellingDAOHibernate bestellingDAO;
    private static BestellingArtikelDAOHibernate bestellingArtikelDAO;
    
    public BestellingService(){
        bestellingDAO = new BestellingDAOHibernate();
        bestellingArtikelDAO = new BestellingArtikelDAOHibernate();
    }
    //CREATE BESTELLING
    public Bestelling create(Bestelling bestelling){
        bestellingDAO.openCurrentSessionWithTransaction();
        Bestelling newBestelling = bestellingDAO.save(bestelling);
        bestellingDAO.closeCurrentSessionWithTransaction();
        return newBestelling;
    }
    //maakt nieuw koppel aan voor bestaande bestelling
    public void createKoppel(BestellingArtikel koppel){
        bestellingArtikelDAO.openCurrentSessionWithTransaction();
        bestellingArtikelDAO.save(koppel);
        bestellingArtikelDAO.closeCurrentSessionWithTransaction();
    }
    
    public void update(BestellingArtikel koppel){
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO(); 
        dao.updateKoppel(koppel);
    }
    
    public void deleteBestelling(int bestellingID){
        //Belangrijk om eerst het koppel te verwijderen voor de bestelling anders
        //gaat MySQL zeuren over contraints
        deleteKoppelMetBestellingID(bestellingID);
        
        BestellingArtikelDAO baDAO = DAOFactory.getBestellingArtikelDAO();
        baDAO.deleteKoppelMetBestellingID(bestellingID);
    }
    
    public void deleteKoppelMetBestellingID(int bestellingID){
        bestellingDAO.delete(bestellingID);       
    }
    public void deleteKoppel(int bestellingID, int artikelID){
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        dao.deleteKoppel(bestellingID, artikelID);
    }

    public ArrayList<Bestelling>readAll(){
        return bestellingDAO.findAll();
    }
    public Bestelling readByID(int bestellingID){
        return bestellingDAO.findById(bestellingID);
    }
    
    public ArrayList<Bestelling> readByKlantID(int klantID){
        return bestellingDAO.findByKlantId(klantID);
    }
    
    public ArrayList<BestellingArtikel> readKoppel(int bestellingID){
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        return dao.readKoppelMetBestellingID(bestellingID);
    }

    //deze code wordtnog niet gebruikt
    public BigDecimal getArtikelPrijs(int artikel_id){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        Artikel artikel = dao.readArtikel(artikel_id);
        BigDecimal totaal = artikel.getArtikel_prijs(); // moet nog vermenigvuldien met het aantal
        return totaal;
    }
    
}
