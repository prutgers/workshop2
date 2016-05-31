package Service;

import DAOFactory.DAOFactory;
import POJO.Adres;
import interfaceDAO.AdresDAO;
import java.util.ArrayList;

/**
 *
 * @author Sonja
 */
public class AdresService {
    
    public Adres create(Adres adres) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        Adres nieuwAdres = aDAO.createAdres(adres);
        return nieuwAdres;
    }
    
    public void update(Adres adres) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        aDAO.updateAdres(adres);
    }
    
    public ArrayList<Adres> readAdres() {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        ArrayList<Adres> adresGegevens = aDAO.readAdres();
        return adresGegevens;
    }
    
    public Adres readByID(int adresID) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        return aDAO.readAdresByID(adresID);
    }
    
    public void delete (int adres_id) {
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        aDAO.deleteAdres(adres_id);
    }
}
