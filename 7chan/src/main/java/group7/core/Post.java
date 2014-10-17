/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import java.sql.Time;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import persistence.AbstractEntity;


/**
 *
 * @author Daniel
 */
@Entity
public class Post extends AbstractEntity {
    private String name;
    private Time   time;
    private String content;
    @OneToMany
    private List<Comment> comments;
    @OneToOne
    private User user;
   public Post( String name, Time time,String content){
       this.name =name;
       
       this.time = time;
       this.content = content;
       
}
   
   //for testing
   public Post(){
   }
   
   
    
}
