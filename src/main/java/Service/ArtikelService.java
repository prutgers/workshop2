/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.ArtikelDAOHibernate;
import POJO.Artikel;
import View.ArtikelView;
import interfaceDAO.BestellingArtikelDAO;
import java.util.ArrayList;
import interfaceDAO.IArtikelDAO;

/**
 *
 * @author Peter
 */
public class ArtikelService {
    
    private static ArtikelDAOHibernate DAO;
    
    public ArtikelService(){
        DAO = new ArtikelDAOHibernate();
    }
    
    
    
    public void save(Artikel artikel){
        DAO.openCurrentSessionWithTransaction();
        DAO.save(artikel);
        DAO.closeCurrentSessionWithTransaction();
        
    }
    
    public void update(Artikel artikel){
        DAO.openCurrentSessionWithTransaction();
        DAO.update(artikel);
        DAO.closeCurrentSessionWithTransaction();
    }
    
    public void delete(int artikelId){
        Artikel artikel = DAO.findById(artikelId);
        DAO.openCurrentSessionWithTransaction();
        DAO.delete(artikel); 
        DAO.closeCurrentSessionWithTransaction();
    }
    
    public Artikel findById(int artikelId){
        DAO.openCurrentSession();
        Artikel artikel = DAO.findById(artikelId);
        DAO.closeCurrentSession();
        return artikel;
    }
    
    public ArrayList<Artikel> findAll(){
        DAO.openCurrentSessionWithTransaction();
        ArrayList<Artikel> artikelLijst = DAO.findAll();
        DAO.closeCurrentSessionWithTransaction();
        return artikelLijst;
    }
    
}
