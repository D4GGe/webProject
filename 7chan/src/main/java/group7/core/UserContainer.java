/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.AbstractDAO;

@Stateless
public class UserContainer extends AbstractDAO<User, Long> implements IUserContainer {
    @PersistenceContext
    private EntityManager em;
    
    public UserContainer() {
        
        super(User.class);
    }

  
    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
     public static IUserContainer newInstance() {
        return new UserContainer();
    }


    @Override
    public User login(String name, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
