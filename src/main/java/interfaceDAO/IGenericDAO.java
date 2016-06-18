/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.util.List;

/**
 *
 * @author Peter
 */
public interface IGenericDAO<T, Id> {
        public void save(T entity);
        public T findById(Id id);
        public void delete(T entity);
        public List<T> findAll();
        public void update();
        
    
}
