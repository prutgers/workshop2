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
    private static KlantDAOHibernate DAO;
    
    public KlantService(){
        DAO = new KlantDAOHibernate();
    }
    
    public void save(Klant klant){
        DAO.openCurrentSessionWithTransaction();
        DAO.save(klant);
        DAO.closeCurrentSessionWithTransaction();
    }
    public Klant findById(int klantId){
        DAO.openCurrentSessionWithTransaction();
        Klant klant = DAO.findById(klantId);
        DAO.closeCurrentSessionWithTransaction();
        return klant;
    }
    
    public ArrayList<Klant> findAll(){
        DAO.openCurrentSessionWithTransaction();
        ArrayList<Klant> klantList = DAO.findAll();
        DAO.closeCurrentSessionWithTransaction();
        return klantList;
    }
    
    public void update(Klant klant){
        DAO.openCurrentSessionWithTransaction();
        DAO.update(klant);
        DAO.closeCurrentSessionWithTransaction();
    }
    
    public void delete(int klantId){
        DAO.openCurrentSessionWithTransaction();
        DAO.delete(klantId);
        DAO.closeCurrentSessionWithTransaction();
    }
    
    public void delete(Klant klant){
        DAO.openCurrentSessionWithTransaction();
        DAO.delete(klant);
        DAO.closeCurrentSessionWithTransaction();
    }
    
}