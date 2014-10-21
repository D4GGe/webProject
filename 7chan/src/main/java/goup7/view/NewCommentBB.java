    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goup7.view;

import group7.core.Comment;
import group7.core.IPostContainer;
import group7.core.Post;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
    private long postid;
    private Post post;
    
    @EJB
    private IPostContainer postContainer;
    
    @PostConstruct
    public void post() {
        this.postid =151;
        this.setPost(getPostcontainer().find(getPostId()));
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
    public long getPostId() {
        return postid;
    }
    public List<Comment> getCommentList(){
       return getPostcontainer().find(getPostId()).getComments();
    }

    /**
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }
    
}
