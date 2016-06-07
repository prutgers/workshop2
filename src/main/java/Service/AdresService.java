package Service;

import DAOFactory.DAOFactory;
import POJO.Adres;
import interfaceDAO.AdresDAO;
import java.util.ArrayList;

/**
 *
 * @author Sonja
 * 
 */

public class AdresService {
    
    public Adres save(Adres adres) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        Adres nieuwAdres = aDAO.createAdres(adres);
        return nieuwAdres;
    }
    
    public void update(Adres adres) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        aDAO.updateAdres(adres);
    }
    
    public ArrayList<Adres> findAll() {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        ArrayList<Adres> adresGegevens = aDAO.readAdres();
        return adresGegevens;
    }
    
    public Adres findByIf(int adresId) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        return aDAO.readAdresByID(adresId);
    }
    
    public void delete (int adresId) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        aDAO.deleteAdres(adresId);
    }
}
