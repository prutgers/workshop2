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

        //BestellingService bserv = new BestellingService();           
        //Bestelling bestelling = bserv.findById(1);
        
;         
        //bserv.delete(2);
        /*
        ArtikelService Aserv = new ArtikelService();
        Artikel artikel = Aserv.readByID(1);
        

        BestellingArtikel ba = new BestellingArtikel();
        ba.setBestelling(bestelling);
        ba.setArtikel(artikel);
        System.out.println("test1");       
        System.out.println(ba.getBestelling().getBestellingID());
        bestelling.setBestellingArtikelSet(ba);
        System.out.println("test2"); 

        System.out.println(bestelling.getBestellingID());
        
        bserv.update(bestelling);
        */
        //System.exit(0);
        
        ArtikelService aserv = new ArtikelService();
        KlantService serv = new KlantService();
        Klant klant = serv.findById(4);
        System.out.println(klant.getKlant_id());   
        
        Artikel artikel = aserv.readByID(2);
        
        Bestelling bestelling = new Bestelling();
        
        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setAantal(2);
        koppel.setBestelling(bestelling);
        koppel.setArtikel(artikel);
        
        bestelling.setBestellingArtikelSet(koppel);
        bestelling.setKlant(klant);
 
        klant.setBestellingSet(bestelling);
        
        serv.update(klant);


        
        KlantService serv = new KlantService();
        serv.delete(4);
        
        System.exit(0);


    }

    
}
