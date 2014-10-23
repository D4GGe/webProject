/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.PostSearchBB;
import group7.core.IPostContainer;
import group7.core.Post;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@SessionScoped

public class PostSearchCtrl implements Serializable {
    
    @EJB
     IPostContainer postContainer;
    
   
    private List<Post> posts;
    private String search;
    
    public void preform_search(){
        System.out.println("*****************************   "+getSearch()+" *****************************");
        setPosts(postContainer.getByName(getSearch()));
        
    }

    
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
}
