/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
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
    public boolean userExsists(String name){
        EntityManager em = getEntityManager();
        EasyCriteria<User> easyCriteria  = EasyCriteriaFactory.createQueryCriteria(em,User.class);
        easyCriteria.andEquals("name", name);
        return !easyCriteria.getResultList().isEmpty();
    }
    @Override
    public User login(String name, String password) {
          EntityManager em = getEntityManager();
        EasyCriteria<User> easyCriteria  = EasyCriteriaFactory.createQueryCriteria(em,User.class);
        easyCriteria.andEquals("name", name);
        easyCriteria.andEquals("password", password);
        return easyCriteria.getSingleResult();
        
    }

    @Override
    public List<User> getByName(String name) {
        EntityManager em = getEntityManager();
        EasyCriteria<User> easyCriteria  = EasyCriteriaFactory.createQueryCriteria(em,User.class);
        easyCriteria.andStringLike("name","%"+name+"%");
        return easyCriteria.getResultList();
        
    }
    
    
}
