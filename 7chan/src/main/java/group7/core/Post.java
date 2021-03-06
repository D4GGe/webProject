/*
 * Post class, holds a post wich have content, header, user and comments.
 */

package group7.core;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import persistence.AbstractEntity;


/**
 *
 * @author Daniel
 */
@Entity
public class Post extends AbstractEntity {
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String content;
    @ManyToMany
    private List<Comment> comments;
    @ManyToOne
    private User user;
    
   public Post( String name,String content,User user){
       this.name =name;
       this.user = user;
       this.date = new Date();
       this.content = content;
       this.comments = new ArrayList<>();
       
       
}
   
   //for testing
   public Post(){
       
   }

    /**
     * @return the name
     */
   public Date getDate() {
        
        return date;
        
    }
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
     * @return the date
     */
    

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    } 
    
}
