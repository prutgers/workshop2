/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import POJO.Artikel;
import View.ArtikelView;
import interfaceDAO.ArtikelDAO;
import interfaceDAO.BestellingArtikelDAO;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class ArtikelService {
    
    public void save(Artikel artikel){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        dao.createArtikel(artikel);
        
    }
    
    public void update(Artikel artikel){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        dao.updateArtikel(artikel);
    }
    
    public void delete(int artikelId){
        BestellingArtikelDAO baDAO = DAOFactory.getBestellingArtikelDAO();
        baDAO.deleteKoppelMetArtikelID(artikelId);
        
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        dao.deleteArtikel(artikelId);
    }
    
    public Artikel finById(int artikelId){
        //ArtikelView aView = new ArtikelView();
        //aView.readArtikelById();
        
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        Artikel artikel = dao.readArtikel(artikelId);
        return artikel;
    }
    
    public ArrayList<Artikel> findAll(){
        
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        ArrayList<Artikel> artikelLijst = dao.readArtikel();
        return artikelLijst;
    }
    
}
