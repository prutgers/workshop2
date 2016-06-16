/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikel")

public class Artikel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artikel_id")
    private int artikelId;
    @Column(name = "artikel_naam")
    private String artikelNaam;
    @Column(name = "artikel_voorraad")
    private int artikelVoorraad;
    @Column(name = "artikel_prijs")
    private BigDecimal artikelPrijs;
    
   public Artikel(){
    }
   
   
    /**
     * @return the artikel_ID
     */
    public int getArtikel_id() {
        return artikelId;
    }

    /**
     * @return the artikel_naam
     */
    public String getArtikel_naam() {
        return artikelNaam;
    }

    /**
     * @param artikelNaam the artikel_naam to set
     */
    public void setArtikel_naam(String artikelNaam) {
        this.artikelNaam = artikelNaam;
    }

    /**
     * @return the artikel_voorraad
     */
    public int getArtikel_voorraad() {
        return artikelVoorraad;
    }

    /**
     * @param artikelVoorraad the artikel_voorraad to set
     */
    public void setArtikel_voorraad(int artikelVoorraad) {
        this.artikelVoorraad = artikelVoorraad;
    }

    /**
     * @return the artikel_prijs
     */
    public BigDecimal getArtikelPrijs() {
        return artikelPrijs;
    }

    /**
     * @param artikel_prijs the artikel_prijs to set
     */
    public void setArtikel_prijs(BigDecimal artikel_prijs) {
        this.artikelPrijs = artikelPrijs;
    }

    /**
     * @return the artikel_naam
     */
    public String getArtikelNaam() {
        return artikelNaam;
    }

    /**
     * @return the artikel_voorraad
     */
    public int getArtikelVoorraad() {
        return artikelVoorraad;
    }
}
