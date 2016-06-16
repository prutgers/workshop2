/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import POJO.Artikel;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public interface IArtikelDAO {
    Artikel save(Artikel artikel);
    
    Artikel findById(int artikel_id);

    ArrayList<Artikel> findAll();
    
    void delete(Artikel artikel);

    void update(Artikel artikel);
}
