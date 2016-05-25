/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Firebird;

/**
 *
 * @author lucas
 */

import ConnectionPools.ConnectionPool;
import ConnectionPools.DBConnectorFirebird;
import DAO.MySQL.KlantDAOMySQL;
import POJO.Klant;
import interfaceDAO.KlantDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class KlantDAOFirebird implements KlantDAO{
    
    static Logger logger = LoggerFactory.getLogger(KlantDAOMySQL.class);
    
    @Override
    public Klant createKlant(Klant klant) {
        
        try(Connection connection = DBConnectorFirebird.getConnection();){
            String sql = "INSERT INTO klant ("
                        + "voornaam,"       //1
                        + " achternaam,"    //2
                        + " tussenvoegsel," //3
                        + " email) "         //4
                        + "values (?, ?, ?, ?)"
                        + " RETURNING bestelling_id" ;
            
            PreparedStatement pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, klant.getVoornaam() );
            pstmt.setString(2, klant.getAchternaam() );
            pstmt.setString(3, klant.getTussenvoegsel() );
            pstmt.setString(4, klant.getEmail() );
            
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()){
                klant.setKlant_id(resultSet.getInt(1)); 
            }  
        }
//        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
//            logger.info("Klant bestaat al in Database");
//            throw ex;         
//        }
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();         
        }
        return klant;
    }
    
    @Override
    public Klant readKlant(int klant_id){
        Klant klant = new Klant();

        try (
            Connection connection = DBConnectorFirebird.getConnection();
                ) {
            PreparedStatement readKlant = connection.prepareStatement(
                    "select * from klant where Klant_id = ?");
            readKlant.setString(1, Integer.toString(klant_id) );
                logger.info("Statement prepared.");

            ResultSet readKlantResult = readKlant.executeQuery();
                logger.info("Statement executed.");
            
            readKlantResult.next();
            klant.setKlant_id(readKlantResult.getInt("klant_id"));
            klant.setVoornaam(readKlantResult.getString("voornaam"));
            klant.setAchternaam(readKlantResult.getString("achternaam"));
            klant.setTussenvoegsel(readKlantResult.getString("tussenvoegsel"));
            klant.setEmail(readKlantResult.getString("email"));
            
                logger.info("POJO gemaakt.");
            
        }
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();
            return null;
        }
        return klant;
    }
    
    @Override
    public Klant updateKlant(Klant klant){
        Klant klantOut = klant;
        try (
            Connection connection = DBConnectorFirebird.getConnection();
                ) {
            
            PreparedStatement updateKlant = connection.prepareStatement(
                    "update klant set voornaam = ?,"    //1
                            + " achternaam = ?,"        //2
                            + " tussenvoegsel = ?,"     //3
                            + " email = ?"              //4
                            +"where Klant_id = ?");     //5
            
            updateKlant.setString(1, klant.getVoornaam() );
            updateKlant.setString(2, klant.getAchternaam() );
            updateKlant.setString(3, klant.getTussenvoegsel() );
            updateKlant.setString(4, klant.getEmail() );
            updateKlant.setInt(5, klant.getKlant_id() );
            
            updateKlant.executeUpdate();
            
            klantOut = readKlant(klant.getKlant_id());

        }
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();     
        }
        return klantOut;
    }

    @Override
    public void deleteKlant(int klant_id) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException {
        try (
            Connection connection = DBConnectorFirebird.getConnection();
                ) {
            PreparedStatement deleteKlant = connection.prepareStatement(
                    "delete from klant where Klant_id = ?");
            deleteKlant.setString(1, Integer.toString(klant_id) );

            deleteKlant.executeUpdate();
            
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("Probeer opnieuw.\n\n");
            throw ex;         
        }
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();     
        }
    }
    
    @Override
    public ArrayList<Klant> readAllKlantByKlant(Klant klant){
        ArrayList<Klant> AllKlant = new ArrayList();
        int i = 0;
        try (
            Connection connection = DBConnectorFirebird.getConnection();
                ) {
            PreparedStatement readKlant = connection.prepareStatement(
                    "select * from klant where "
                            + "Klant_id LIKE ? "                        //1
                            + "and voornaam LIKE ? "                    //2
                            + "and achternaam LIKE ? "                  //3
                            + "and IFNULL(tussenvoegsel,'') LIKE ? "    //4
                            + "and IFNULL(email,'') LIKE ? ");          //5
            
            readKlant.setString(1, (klant.getKlant_id() == 0)?
                    "%" : Integer.toString( klant.getKlant_id() ) );
            readKlant.setString(2, ( klant.getVoornaam() == null  || klant.getVoornaam().equals("") )?
                    "%" : klant.getVoornaam() );
            readKlant.setString(3, ( klant.getAchternaam() == null  || klant.getAchternaam().equals("") )?
                    "%" : klant.getAchternaam() );
            readKlant.setString(4, ( klant.getTussenvoegsel() == null  || klant.getTussenvoegsel().equals("") )?
                    "%" : klant.getTussenvoegsel() );
            readKlant.setString(5, ( klant.getEmail() == null  || klant.getEmail().equals("") )?
                    "%" : klant.getEmail() );
            
            
            ResultSet readKlantResult = readKlant.executeQuery();
                logger.info("Statement uitgevoerd.");
            
            while (readKlantResult.next()){
                i++;
                Klant klant4Array = new Klant();
                klant4Array.setKlant_id(readKlantResult.getInt("klant_id"));
                klant4Array.setVoornaam(readKlantResult.getString("voornaam"));
                klant4Array.setAchternaam(readKlantResult.getString("achternaam"));
                klant4Array.setTussenvoegsel(readKlantResult.getString("tussenvoegsel"));
                klant4Array.setEmail(readKlantResult.getString("email"));
                AllKlant.add(klant4Array);
            }

        }
        
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();
        }
        System.out.println("Er zijn " + i + " klanten die met de zoekopdracht overeenkomen:");
        return AllKlant;
    }
}
