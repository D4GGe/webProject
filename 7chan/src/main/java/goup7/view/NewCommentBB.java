    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goup7.view;

import group7.core.Comment;
import group7.core.IPostContainer;
import group7.core.Post;
import group7.ctrl.LoginBean;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class NewCommentBB {
 
    private String name;
    private String content;
    
    private Post post;
    
    @EJB
    private IPostContainer postContainer;
     @Inject
     private LoginBean loginBean; 
    @PostConstruct
    public void post() {
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    public IPostContainer getPostcontainer() {
        return postContainer;
    }
    
    public List<Comment> getCommentList(){
        System.out.println(loginBean.getPostid());
       return postContainer.find(loginBean.getPostid()).getComments();
    }

    /**
     * @return the post
     */
    public Post getPost() {
        this.setPost(getPostcontainer().find(getPostid()));
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * @return the postid
     */
    public long getPostid() {
        return loginBean.getPostid();
    }

    /**
     * @param postid the postid to set
     */
    
    
}
