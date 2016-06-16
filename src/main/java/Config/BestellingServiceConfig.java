/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;
import DAO.Hibernate.BestellingDAOHibernate;
import Service.BestellingService;
import org.springframework.context.annotation.*;
/**
 *
 * @author Gebruiker
 */
@Configuration
public class BestellingServiceConfig {
    @Bean 
    public BestellingDAOHibernate bestellingDAO(){
        return new BestellingDAOHibernate();
    }
    @Bean
    public BestellingService bestellingService(BestellingDAOHibernate bestellingDAOHibernate){
        return new BestellingService(bestellingDAOHibernate);
    }
    
}
