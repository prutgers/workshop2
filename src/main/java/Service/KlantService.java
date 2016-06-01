/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.*;
import POJO.*;

/**
 *
 * @author Peter
 */
public class KlantService {
    private static KlantDAOHibernate klantDAO;
    
    public KlantService(){
        klantDAO = new KlantDAOHibernate();
    }
    //CREATE BESTELLING
    public void create(Klant klant){
        klantDAO.openCurrentSessionWithTransaction();
       klantDAO.save(klant);
        klantDAO.closeCurrentSessionWithTransaction();
    }
}
