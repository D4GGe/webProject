/*
 * comment class, holds comments and exests only in posts
 */

package group7.core;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import persistence.AbstractEntity;

/**
 *
 * @author Daniel
 */
@Entity

public class Comment extends AbstractEntity {
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String data;
    @ManyToOne
    private User user;

    
    public Comment(){
        
    }
    
    public Comment(String data,User user){
        this.date = new Date();
        this.data = data;
        this.user = user;
       // this.user = user;
        
    }
    
    public Date getDate(){
        return date;
        
    }
    public String getData(){
        return data;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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
 @Override
 public String toString(){
     return getData();
 }
}