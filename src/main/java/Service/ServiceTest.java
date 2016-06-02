/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.MySQL.*;
import POJO.*;
import java.math.BigDecimal;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Gebruiker
 */
public class ServiceTest {
    public static void main(String[]args){
        BestellingService BServ = new BestellingService();           
        Bestelling b = BServ.findByID(1);
        
        Set<BestellingArtikel> regels = b.getBestellingArtikelSet();
        for(BestellingArtikel a : regels){
            System.out.println(a.getArtikel().getArtikel_naam());
        }
        
        System.exit(0);
        
        
        
        /*
        KlantService ks = new KlantService();
        Klant k = ks.findById(21);
        Set<Adres> list =  k.getAdresSet();

        System.out.println("ADRESLIJST");
        for(Adres a : list){
            System.out.println("adres: " + a.getAdres_id() + ", straat: " + a.getStraatnaam());
        }
        
        System.exit(0);

*/
    }
    
}
