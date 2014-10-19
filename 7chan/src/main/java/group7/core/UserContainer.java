/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
         EntityManager em = getEntityManager();
       
        // Warning because typename not found in string (clazz.getSimpleName())
        // Criteria API better, possible misstakes in String, NOTE space before t
        TypedQuery<User> q =  em.createQuery("select U from User U where U.name =':name' AND U.password =':password'",User.class);
        q.setParameter("name", name);
        q.setParameter("password", password);
        
        List<User> a = q.getResultList();
        if (a.size()==0){
            return null;
        }else{
           return a.get(0);
        }
        
    }
    
    
}
