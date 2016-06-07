package interfaceDAO;

import POJO.Adres;
import java.util.ArrayList;

/**
 *
 * @author Sonja
 */

public interface IAdresDAO {

    Adres create(Adres adres);
    
    ArrayList<Adres> readAll();
    
    Adres readByID(int adresID);
        
    void update(Adres adres);
    
    void delete(int adresID);
    
    void delete(Adres adres);
}
