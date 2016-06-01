/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Gebruiker
 */

@Entity
@Table(name = "Bestelling")

public class Bestelling implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestelling_id")
    private int bestellingID;
    @Column(name = "klant_id")
    private int klantID;
    @Column(name = "totaal_prijs")
    private BigDecimal totaalPrijs;

    @OneToMany(mappedBy = "bestelling")
    /*
    @JoinTable(name="bestellingartikel",
      joinColumns=@JoinColumn(name="bestelling_id", referencedColumnName="bestelling_id"),
      inverseJoinColumns=@JoinColumn(name="artikel_id", referencedColumnName="artikel_id"))
      */
    private Set<BestellingArtikel> bestellingArtikelSet =new HashSet<>();;
   
    public Bestelling(){
    }
    
    public Set<BestellingArtikel> getBestellingArtikelSet() {
        return bestellingArtikelSet;
    }

    public void setBestellingArtikelSet(BestellingArtikel bestellingArtikel) {
        System.out.println("test");
        this.bestellingArtikelSet.add(bestellingArtikel);
        System.out.println("test2");
    }
    
    public int getBestellingID() {
        return bestellingID;
    }
    
    public void setBestellingID(int bestellingID) {
        this.bestellingID = bestellingID;
    }

    public int getKlantID() {
        return klantID;
    }
    
    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }
    
    public BigDecimal getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(BigDecimal totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }
    
    public Bestelling(BestellingBuilder builder){
        this.bestellingID = builder.bestellingID;
        this.klantID = builder.klantID;
    }
    public static class BestellingBuilder{
        private int bestellingID;
        private int klantID;
        
        public BestellingBuilder(){}
        
        public BestellingBuilder bestellingID(int bestellingID){
            this.bestellingID = bestellingID;
            return this;
        }
        
        public BestellingBuilder klantID(int klnat){
            this.klantID = klantID;
            return this;
        }
        public Bestelling build(){
            return new Bestelling(this);
        }
    }
}
