/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.MySQL.*;
import POJO.*;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
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
        
        /*
        Bestelling b = new Bestelling();
        b.setKlantID(1);
        b.setTotaalPrijs(new BigDecimal(999));
        BServ.create(b);
        
        Artikel a = new ArtikelDAOMySQL().readArtikel(1);
        
        BestellingArtikel ba = new BestellingArtikel();
        ba.setArtikel(a);
        ba.setBestelling(b);
        
        BServ.createKoppel(ba);

        System.exit(0);
        */
        /*
        Klant k = new Klant();
        k.setVoornaam("Herman");
        k.setAchternaam("jonge");
        k.setEmail("1");
        k.setTussenvoegsel("de");
        
        Adres a = new AdresDAOMySQL().readAdresByID(1);
        k.setAdresSet(a);
        
        KlantService ks = new KlantService();
        ks.create(k);
*/
        
        StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources ms = new MetadataSources(ssrb);
        ms.addAnnotatedClass(Klant.class);
        ms.addAnnotatedClass(Adres.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        
        /*
        Klant k = (Klant) s.get(Klant.class, 12);
        System.out.println(k.getKlant_id());
        */
        
         List list = s.createQuery("from Klant").list();
        
        //print messages
        for ( Iterator iter = list.iterator();
                iter.hasNext(); ) {
            Klant k = (Klant) iter.next();
            System.out.println( k.getKlant_id() );
        }
        
        
        s.getTransaction().commit();
        s.close();
        sf.close();
        /*
        KlantService ks = new KlantService();
        Klant klant = ks.findById(12);
        System.out.println(klant.getKlant_id());
        System.exit(0);
*/

    }
    
}
