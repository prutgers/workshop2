/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Peter
 */

@Entity
@Table(name = "BestellingArtikel")


public class BestellingArtikel implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestellingArtikel_Id")
    private int ID;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="artikel_id")
    private Artikel artikel;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bestelling_id")
    private Bestelling bestelling;
    
    @Column(name="aantal")
    private int aantal;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    
    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public int getBestelling_id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getArtikel_id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setArtikel_id(int artikel_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBestelling_id(int bestelling_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setKoppel_id(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getKoppel_id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}


/*
public class BestellingArtikel implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestellingArtikel_Id")
    private int ID;
    
    @OneToOne(fetch=FetchType.LAZY)

@JoinColumn(name="artikel_id")
    private Artikel artikel;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bestelling_id")
    private Bestelling bestelling;
    
    @Column(name="aantal")
    private int aantal;
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }


}
*/