/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import POJO.*;
import Service.*;
import View.*;


/**
 *
 * @author Gebruiker
 */
public class BestellingController {
    public static BestellingView view = new BestellingView();
    
    public static BestellingService bestellingService;
    
    public BestellingController(BestellingService bestellingService){
        bestellingService = bestellingService;
    }
    
    
    public static void startKeuze(){
        BestellingKeuzeView keuzeView = new BestellingKeuzeView();
        keuzeView.keuzeView();
        
      
        switch (keuzeView.getSelect()) {
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                BestellingArtikelController.update();
                break;
            case 4:
                readAll();
                break;
            case 5:
                readByID();
                break;
            case 6:
                //haal alle bestellingen op van een klant
                readByKlantID();
                break;
            case 7:
                //haal alle artikelen (bestellingArtikel op van een klant
                readArtikelen();
                break;
            case 8:
                BestellingArtikelController.delete();
                break;
            case 9:
                delete();
                break;
            case 0:
                MainController.hoofdMenu();
                break;
            default:
                view.keuzeFout();
                break;
            }
        if(keuzeView.getSelect() != 0){
            startKeuze();
        }
        
    }
    public static void create(){
        
        //maak een nieuwe bestellingview waarin je vraagt voor welke klant
        //de bestelling is
        view.readKlantID();
        
        //Nieuwe Bestelling
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(view.getKlantId());

        //Nieuw artikel
        ArtikelService AS = new ArtikelService();
        Artikel artikel = AS.readByID(view.getArtikelId());
        
        //Nieuw koppel
        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setAantal(view.getAantal());
        koppel.setArtikel(artikel);
        koppel.setBestelling(bestelling);
        
        bestelling.setBestellingArtikelSet(koppel);
        bestellingService.save(bestelling);
    }

    public static void update(){
        view.addArtikel();
        //haal bestelling op
        Bestelling bestelling = bestellingService.findById(view.getBestellingId());
        
        //haal artikel op
        Artikel artikel = new ArtikelService().findById(view.getArtikelId());
        
        //maak nieuw koppel aan
        BestellingArtikel bestellingArtikel = new BestellingArtikel();
        bestellingArtikel.setAantal(view.getAantal());
        bestellingArtikel.setArtikel(artikel);
        bestellingArtikel.setBestelling(bestelling);
        
        //voeg nieuw koppel toe
        bestelling.setBestellingArtikelSet(bestellingArtikel);
        
        bestellingService.update(bestelling);
    }

    public static void readAll(){
        view.printBestellingen(bestellingService.findAll());
    }
    
    public static void readByID(){
        view.readBestellingID();
        view.print(bestellingService.findById(view.getBestellingId()));
    }
    
    public static void readByKlantID(){
        view.readKlantID();
        view.printBestellingen(bestellingService.findByKlantId(view.getKlantId()));
    }
    
    public static void readArtikelen(){
        view.readKlantID();
        //haal bestelling op
        Bestelling bestelling = bestellingService.findById(view.getBestellingId());
        view.printArtikelen(bestelling.getBestellingArtikelSet());
    }

    public static void delete(){
        view.readBestellingID();
        bestellingService.delete(view.getBestellingId());
    }
}
