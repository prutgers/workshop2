/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.MySQL.*;
import POJO.*;
import java.math.BigDecimal;

/**
 *
 * @author Gebruiker
 */
public class ServiceTest {
    public static void main(String[]args){
        BestellingService BServ = new BestellingService();           
        
        
        Bestelling b = new Bestelling();
        b.setKlantID(1);
        b.setTotaalPrijs(new BigDecimal(999));
        BServ.create(b);
        
        Artikel a = new ArtikelDAOMySQL().readArtikel(1);
        
        BestellingArtikel ba = new BestellingArtikel();
        ba.setArtikel(a);
        ba.setBestelling(b);
        ba.setAantal(5);
        
        BServ.createKoppel(ba);

        System.exit(0);
        
        /*
        Klant k = new Klant();
        k.setVoornaam("Herman");
        k.setAchternaam("jonge");
        k.setEmail("test");
        k.setTussenvoegsel("de");
        
        Adres a = new AdresDAOMySQL().readAdresByID(1);
        k.setAdresSet(a);
        
        KlantService ks = new KlantService();
        ks.create(k);
        

*/
    }
    
}
