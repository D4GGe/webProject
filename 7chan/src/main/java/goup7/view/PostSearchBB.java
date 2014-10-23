/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goup7.view;

import group7.core.IPostContainer;
import group7.core.Post;
import group7.ctrl.PostSearchCtrl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@RequestScoped
public class PostSearchBB implements Serializable {
    private String search;
    @Inject
   private PostSearchCtrl postSearchCtrl;
    public PostSearchBB(){
    
}
   
    
    @PostConstruct
    public void post(){
   
    }
    
   
    /**
     * @return the search
     */
    public String getSearch() {
        return search;
    }
    
    /**
     * @param search the search to set
     */
    public void setSearch(String search) {
        System.out.println("search" +  search);
        this.search = search;
    }
    
    public void preformSearch(){
        postSearchCtrl.setSearch(search);
        postSearchCtrl.preform_search();
    }
    

    /**
     * @return the posts
     */
    
    
    
    
}
