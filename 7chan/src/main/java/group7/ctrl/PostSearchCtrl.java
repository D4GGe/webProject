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
    
    private PostSearchBB postSearchBB;
    private List<Post> posts;
    
    
    public void preform_search(){
        System.out.println("*****************************   "+postSearchBB.getSearch()+" *****************************");
        setPosts(postContainer.getByName(postSearchBB.getSearch()));
        
    }

    /**
     * @return the postSearchBB
     */
    public PostSearchBB getPostSearchBB() {
        return postSearchBB;
    }

    /**
     * @param postSearchBB the postSearchBB to set
     */
    @Inject
    public void setPostSearchBB(PostSearchBB postSearchBB) {
        this.postSearchBB = postSearchBB;
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
}
