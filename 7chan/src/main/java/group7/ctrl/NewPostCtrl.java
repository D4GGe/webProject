/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.NewPostBB;
import group7.core.IPostContainer;
import group7.core.IUserContainer;
import group7.core.Post;
import group7.core.PostContainer;
import group7.core.UserContainer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@RequestScoped
public class NewPostCtrl implements Serializable{
    @EJB
    private IPostContainer postContainer;
    @EJB
    private IUserContainer userContainer;
    @Inject
    private NewPostBB newPostBB;
    @Inject
    private LoginBean loginBean;
            
    public NewPostCtrl(){
        
    }
    public void save(){
        System.out.println(loginBean.getUser().getName());
        postContainer.create(new Post(newPostBB.getName(),newPostBB.getContent(),loginBean.getUser()));
       loginBean.getUser().increase_nr_posts();
        userContainer.update(loginBean.getUser()); 
        
    }
    
}
