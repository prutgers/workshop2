/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.*;
import POJO.*;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class KlantService {
    private static KlantDAOHibernate klantDAO;
    
    public KlantService(){
        klantDAO = new KlantDAOHibernate();
    }
    
    public void create(Klant klant){
        klantDAO.openCurrentSessionWithTransaction();
        klantDAO.save(klant);
        klantDAO.closeCurrentSessionWithTransaction();
    }
    public Klant findById(int klant_id){
        klantDAO.openCurrentSessionWithTransaction();
        Klant klant = klantDAO.findById(klant_id);
        klantDAO.closeCurrentSessionWithTransaction();
        return klant;
    }
    
    public ArrayList<Klant> findAll(){
        klantDAO.openCurrentSessionWithTransaction();
        ArrayList<Klant> klantList = klantDAO.findAll();
        klantDAO.closeCurrentSessionWithTransaction();
        return klantList;
    }
    
    public void update(Klant klant){
        klantDAO.openCurrentSessionWithTransaction();
        klantDAO.update(klant);
        klantDAO.closeCurrentSessionWithTransaction();
    }
    
    public void delete(int klant_id){
        klantDAO.openCurrentSessionWithTransaction();
        klantDAO.delete(klant_id);
        klantDAO.closeCurrentSessionWithTransaction();
    }
    
    public void delete(Klant klant){
        klantDAO.openCurrentSessionWithTransaction();
        klantDAO.delete(klant);
        klantDAO.closeCurrentSessionWithTransaction();
    }
    
}