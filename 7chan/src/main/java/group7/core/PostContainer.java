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
public class PostContainer extends AbstractDAO<Post, Long> implements IPostContainer {
    @PersistenceContext
    private EntityManager em;
    
    public PostContainer() {
        
        super(Post.class);
    }

  
    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
  
    
     public static IPostContainer newInstance() {
        return new PostContainer();
    }
     
     @Override
     public List<Post> getByUser(User user ){
         EntityManager em = getEntityManager();
        List<Post> found = new ArrayList<>();
        EasyCriteria<Post> easyCriteria = easyCriteria = EasyCriteriaFactory.createQueryCriteria(em,Post.class);
        easyCriteria.andEquals("user", user);
        return easyCriteria.getResultList();
         
     }
    @Override
    public List<Post> getByName(String name) {
        EntityManager em = getEntityManager();
        List<Post> found = new ArrayList<>();
        EasyCriteria<Post> easyCriteria = easyCriteria = EasyCriteriaFactory.createQueryCriteria(em,Post.class);
        easyCriteria.andStringLike("content", "%"+name+"%");
        return easyCriteria.getResultList();
     
    }
    
    
}
