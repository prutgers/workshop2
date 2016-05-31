package POJO;

/**
 *
 * @author Sonja
 */

import java.io.Serializable;
import javax.persistence.*;

@Entity //represents lightweight persistent domain object
@Table(name="Adres")
public class Adres implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int adres_id;          //required
    @Column
    private String straatnaam;     //required 
    @Column
    private int huisnummer;        //required
    @Column
    private String toevoeging;     //optional
    @Column
    private String postcode;       //required
    @Column
    private String woonplaats;     //required
     

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    } 
    
    public Adres() {
    }
    
    private Adres (AdresBuilder builder){
        this.straatnaam = builder.straatnaam;
        this.huisnummer = builder.huisnummer;
        this.toevoeging = builder.toevoeging;
        this.postcode = builder.postcode;
        this.woonplaats = builder.woonplaats;
        this.adres_id = builder.adres_id;
        }
    
    public static class AdresBuilder {
        private String straatnaam;
        private int huisnummer;
        private String toevoeging;
        private String postcode;
        private String woonplaats;
        private int adres_id;
        
        public AdresBuilder() {
        }
        
        public AdresBuilder adresZonderToevoeging (String straatnaam, 
                int huisnummer, String postcode, String woonplaats, int adres_id) {
            this.straatnaam = straatnaam;
            this.huisnummer = huisnummer;
            this.postcode = postcode;
            this.woonplaats = woonplaats; 
            this.adres_id = adres_id;
            return this;
        }
        
        public AdresBuilder adresMetToevoeging (String straatnaam, int huisnummer, 
                String toevoeging, String postcode, String woonplaats, int adres_id) {
            this.straatnaam = straatnaam;
            this.huisnummer = huisnummer;
            this.toevoeging = toevoeging;
            this.postcode = postcode;
            this.woonplaats = woonplaats; 
            this.adres_id = adres_id;
            return this;
        }
        
        public Adres build() {
            return new Adres(this);
        }
    }
}



/*ORIGINELE POJO ZONDER ADRESBUILDER*/
//public class Adres {
//     private String straatnaam;
//     private int huisnummer;
//     private String toevoeging;
//     private String postcode;
//     private String woonplaats;
//     private int adres_id;

     
//    public Adres (){
//    }
    /**
     * @return the straatnaam
     */
//    public String getStraatnaam() {
//        return straatnaam;
//    }

    /**
     * @param straatnaam the straatnaam to set
     */
//    public void setStraatnaam(String straatnaam) {
//        this.straatnaam = straatnaam;
//    }

    /**
     * @return the huisnummer
     */
//   public int getHuisnummer() {
//        return huisnummer;
//    }

    /**
     * @param huisnummer the huisnr to set
     */
 //   public void setHuisnummer(int huisnummer) {
 //       this.huisnummer = huisnummer;
//    }

    /**
     * @return the toevoeging
     */
//    public String getToevoeging() {
//        return toevoeging;
//    }

    /**
     * @param toevoeging the toevoeging to set
     */
//    public void setToevoeging(String toevoeging) {
//        this.toevoeging = toevoeging;
//    }

    /**
     * @return the postcode
     */
//    public String getPostcode() {
//        return postcode;
//    }

    /**
     * @param postcode the postcode to set
     */
//    public void setPostcode(String postcode) {
//        this.postcode = postcode;
 //   }

    /**
     * @return the woonplaats
     */
//    public String getWoonplaats() {
//        return woonplaats;
 //   }

    /**
     * @param woonplaats the woonplaats to set
     */
//    public void setWoonplaats(String woonplaats) {
//        this.woonplaats = woonplaats;
//    }

    /**
     * @return the adres_id
     */
//    public int getAdres_id() {
//        return adres_id;
//    }

    /**
     * @param adres_id the adres_id to set
     */
 //   public void setAdres_id(int adres_id) {
//        this.adres_id = adres_id;
//    }    
//}

