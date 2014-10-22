/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goup7.view;

import group7.core.IPostContainer;
import group7.core.Post;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@SessionScoped
public class PostSearchBB implements Serializable {
    private String search;
    private List<Post> posts;
   
    @EJB
    private IPostContainer postContainer;
    
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
        this.search = search;
    }

    /**
     * @return the posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    public void preform_search(){
        posts = postContainer.getByName(search);
        
    }
    
    
}
