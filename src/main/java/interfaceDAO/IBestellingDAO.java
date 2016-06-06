/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import POJO.Bestelling;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public interface IBestellingDAO {
    public Bestelling save(Bestelling bestelling);
    
    public Bestelling findById(int BestellingId);
    
    public ArrayList<Bestelling> findAll();
    
    public ArrayList<Bestelling> findByKlantId(int klantId);
    
    public void update(Bestelling bestelling);
    
    public void delete(Bestelling bestelling);
}
