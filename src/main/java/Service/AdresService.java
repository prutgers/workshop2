package Service;

import DAO.Hibernate.*;
import POJO.Adres;
import interfaceDAO.AdresDAO;
import java.util.ArrayList;

/**
 *
 * @author Sonja
 * 
 */

public class AdresService {
    
    private static AdresDAOHibernate DAO;
    
    public AdresService(){
        DAO = new AdresDAOHibernate();
    }
    
    public Adres save(Adres adres) {
        DAO.openCurrentSessionWithTransaction();
        Adres nieuwAdres = DAO.save(adres);
        return nieuwAdres;
    }
    
    public void update(Adres adres) {
        DAO.openCurrentSessionWithTransaction();
        DAO.update(adres);
        DAO.closeCurrentSessionWithTransaction();
    }
    
    public ArrayList<Adres> findAll() {
        DAO.openCurrentSession();
        ArrayList<Adres> adresGegevens = DAO.findAll();
        DAO.closeCurrentSession();
        return adresGegevens;
    }
    
    public Adres findById(int adresId) {
        DAO.openCurrentSession();
        Adres adres= DAO.findById(adresId);
        DAO.closeCurrentSession();
        return adres;
    }
    
    public void delete (int adresId) {
        DAO.openCurrentSessionWithTransaction();
        DAO.delete(adresId);
        DAO.closeCurrentSessionWithTransaction();
    }
}
