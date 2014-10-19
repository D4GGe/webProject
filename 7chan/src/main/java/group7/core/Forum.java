/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named("Forum")
@ApplicationScoped
public class Forum implements IForum {
    @EJB
    private IUserContainer userContainer;
    @EJB
    private IPostContainer postContainer;
    
    public Forum(){
    
        }
    
    public static IForum newInstance(){
        return new Forum();
    }
    @Override
    public IUserContainer getUserContainer() {
          return userContainer;
    }

    @Override
    public IPostContainer getPostContainer() {
            return postContainer;
    }

    
    
}
