/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatMessage;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.commons.validator.EmailValidator;



/**
 *
 * @author Peter
 */
public class VerifyInputScanner {
    
    
/**
 * De verifyString methode is echt heel moeilijk want eignelijk is alles een string misschien moeten we hier anders op testen 
 * door bijvoorbeeld te stellen dat er geen cijfers inmogen? 
 * @return 
 */    
    public static String verifyString(){
        
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                String verified = input.nextLine();
                
                return verified;
            }
            catch(InputMismatchException e){
                System.out.println("Ongeldige invoer. Probeer opnieuw.");

            }
        }
    }
    /*
    public static String verifyPostcode(){
        Boolean ver = false;
        Scanner input = new Scanner(System.in);
        while(!ver){
            
            try{
                String verified = input.nextLine();
                if(verified.length() == 6){
                    
                }
                ver = true;
                
            }
            catch(InputMismatchException e){
                System.out.println("geen juiste lijn");

            }
        }
    }
    */
    
    public static int verifyInt(){
        
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                int verified = input.nextInt();
                
                return verified;
                
            }
            catch(InputMismatchException e){
                System.out.println("Geen geldig nummer. Probeer opnieuw.");

            }
        }
    }
    
    
    // het is onduidelijk of een double een , of een . is 
    // ik moet hem namelijk invoeren met een , maar hij geeft een . terug :D
    public static double verifyDouble(){
        
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                Double verified = input.nextDouble();
                
                return verified;
            }
            catch(InputMismatchException e){
                System.out.println("Geen geldig nummer. Probeer opnieuw.");

            }
        }
    }
    
    public static BigDecimal verifyBigDecimal(){
        
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                BigDecimal verified = input.nextBigDecimal();
                
                return verified;
            }
            catch(InputMismatchException e){
                System.out.println("Geen geldig nummer. Probeer opnieuw.");

            }
        }
    }
    
    
    /**
     * Ga naar https://commons.apache.org/proper/commons-validator/download_validator.cgi
     *         download de bin file
     * Ga naar libraries in netbeans rechtermuisknop workshop1 properties
     * Druk op libraries
     * add library
     * create
     * dan add the file commons-validator-1.5.0 aan de classpath
     * 
     * @return 
     */    
    public static String verifyEmail(){
        Scanner input = new Scanner(System.in);
        
        while(true){
            try{
                
                String verified = input.next();
                EmailValidator emailVal =  EmailValidator.getInstance();
                if(emailVal.isValid(verified)){
                    
                return verified;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Geen juiste invoer probeer opnieuw");
                
            }
        }
        
    }
    
    
    
    
    
    
    
}
