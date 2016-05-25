/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

import POJO.Bestelling;
import POJO.BestellingArtikel;
import interfaceDAO.BestellingArtikelDAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class BestellingArtikelDAOXML implements BestellingArtikelDAO {

    @Override
    public void createKoppelBestellingArtikel(BestellingArtikel koppel) {
        ArrayList<BestellingArtikel> lijst = new ArrayList<>();
        File file = new File("c:/data/xml/bestelling.xml");
        if(file.exists()){
            lijst = readFile();
        }
        lijst.add(koppel);
        writeFile(lijst);
    }

    @Override
    public ArrayList<BestellingArtikel> readKoppelMetBestellingID(int bestellingID) {
        ArrayList<BestellingArtikel> lijst = readFile();
        ArrayList<BestellingArtikel> temp = new ArrayList<>();
        for(BestellingArtikel ba : lijst){
            if(ba.getBestelling_id() == bestellingID)
                temp.add(ba);
        }
        return temp;
    }

    @Override
    public ArrayList<BestellingArtikel> readKoppelMetArtikelID(int artikelID) {
        ArrayList<BestellingArtikel> lijst = readFile();
        ArrayList<BestellingArtikel> temp = new ArrayList<>();
        for(BestellingArtikel ba : lijst){
            if(ba.getArtikel_id() == artikelID)
                temp.add(ba);
        }
        return temp;
    }

    @Override
    public BestellingArtikel readKoppel(int bestellingID, int artikelID) {
        ArrayList<BestellingArtikel> lijst = readFile();
        BestellingArtikel koppel = new BestellingArtikel();
        for(BestellingArtikel ba : lijst){
            if(ba.getArtikel_id() == artikelID && ba.getBestelling_id() == bestellingID)
                koppel = ba;
        }
        return koppel;
    }

    @Override
    public void deleteKoppelMetBestellingID(int bestellingID) {
        ArrayList<BestellingArtikel> lijst = readFile();
        for(BestellingArtikel ba : lijst){
            if(ba.getBestelling_id() == bestellingID)
                lijst.remove(ba);
        }
        writeFile(lijst);
    }

    @Override
    public void deleteKoppelMetArtikelID(int artikelID) {
        ArrayList<BestellingArtikel> lijst = readFile();
        for(BestellingArtikel ba : lijst){
            if(ba.getArtikel_id() == artikelID)
                lijst.remove(ba);
        }
        writeFile(lijst);
    }

    @Override
    public void deleteKoppel(int bestellingID, int artikelID) {
        ArrayList<BestellingArtikel> lijst = readFile();
        for(BestellingArtikel ba : lijst){
            if(ba.getArtikel_id() == artikelID && ba.getBestelling_id() == bestellingID)
                lijst.remove(ba);
        }
        writeFile(lijst);
    }

    @Override
    public void updateKoppel(BestellingArtikel koppel) {
        ArrayList<BestellingArtikel> lijst = readFile();
        for(BestellingArtikel ba : lijst){
            if(ba.getArtikel_id() == koppel.getArtikel_id() && ba.getBestelling_id() == koppel.getBestelling_id())
                ba.setArtikel_id(koppel.getArtikel_id());
                ba.setBestelling_id(koppel.getBestelling_id());
                ba.setAantal(koppel.getAantal());
        }
        writeFile(lijst);
    }
    
    //private method
    private ArrayList<BestellingArtikel> readFile() {
    ArrayList<BestellingArtikel> lijst = new ArrayList<>();
    File file = new File("c:/data/xml/bestellingArtikel.xml");
    if(!file.exists()){
        System.out.println("Het bestand bestaat nog niet. Probeer opnieuw.");
        return new ArrayList<BestellingArtikel>();
    }
    try{
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        XMLDecoder xmlDecoder = new XMLDecoder(bis);
        lijst = (ArrayList<BestellingArtikel>) xmlDecoder.readObject();               
    }
    catch(FileNotFoundException e){
        System.out.println("\nHet bestand kon niet worden gevonden. Probeer opnieuw.\n");
        e.printStackTrace();
    }
    return lijst;
    }
    
        private void writeFile (ArrayList<BestellingArtikel> lijst) {
        try{
            FileOutputStream fos = new FileOutputStream("c:/data/xml/bestellingArtikel.xml");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            //xmlEncoder.writeObject(bestelling);
            xmlEncoder.writeObject(lijst);
            xmlEncoder.close();
        }
        catch(FileNotFoundException e){
            System.out.println("\nHet bestand kon niet worden gevonden. Probeer opnieuw.\n");
            e.printStackTrace();
        }
    }
    
}
