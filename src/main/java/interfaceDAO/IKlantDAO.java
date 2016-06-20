/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

/**
 *
 * @author lucas
 */
import POJO.Klant;
        
public interface IKlantDAO extends IGenericDAO<Klant, Integer> {
    
    public void delete(int klant_id);
    
}
