/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.*;
import java.util.*;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author lucas
 */
@Entity
@Table(name = "klant")
public class Klant implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "klant_id")
    private int id;
    @Column(name="voornaam")
    private String voornaam;
    @Column(name="achternaam")
    private String achternaam;
    @Column(name="tussenvoegsel")
    private String tussenvoegsel;
    @Column(name="email")
    private String email;
    @ManyToMany
    @JoinTable(name="koppelklantadres",
      joinColumns=@JoinColumn(name="klant_id", referencedColumnName="klant_id"),
      inverseJoinColumns=@JoinColumn(name="adres_id", referencedColumnName="adres_id"))
    private Set<Adres> adresSet;
    
    @OneToMany(mappedBy="klant", cascade = CascadeType.ALL)
    private Set<Bestelling> bestellingSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Bestelling> getBestellingSet() {
        return bestellingSet;
    }

    public void setBestellingSet(Bestelling bestelling) {
        this.bestellingSet.add(bestelling);
    }
    
    public Klant(){
        adresSet= new HashSet<>();
    }
    
    public Set<Adres> getAdresSet() {
        return adresSet;
    }

    public void setAdresSet(Adres adres) {
        this.adresSet.add(adres);
    }
    
    public Klant(int klant_id){
        this.id = klant_id;
        Scanner input = new Scanner(System.in);
        System.out.println("Create a new Klant!");
        System.out.print("Your first name :");
        voornaam = input.next();
        System.out.print("Your last name :");
        achternaam = input.next();
        System.out.print("Additieves :");
        tussenvoegsel = input.next();
        System.out.print("Your email adress :");
        email = input.next();
    }
    
    public Klant(ResultSet klantData) throws SQLException{
        klantData.next();
        id = klantData.getInt(1);
        voornaam = klantData.getString(2);
        achternaam = klantData.getString(3);
        tussenvoegsel = klantData.getString(4);
        email = klantData.getString(5);
    }
    
    public String toString(){
        return "" + getKlant_id() + ", " + getVoornaam() + ", " + getAchternaam() + ", "
                + getTussenvoegsel() + ", " + getEmail();
    }

    /**
     * @return the klant_id
     */
    public int getKlant_id() {
        return id;
    }

    /**
     * @param klant_id the klant_id to set
     */
    public void setKlant_id(int klant_id) {
        this.id = klant_id;
    }

    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @return the tussenvoegsel
     */
    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    /**
     * @param tussenvoegsel the tussenvoegsel to set
     */
    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
