/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import javax.persistence.Entity;
import javax.persistence.Table;
import persistence.AbstractEntity;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="CHAN_USER")
public class User extends AbstractEntity {
    private String name;
    private String password;
    //private String email;
   private int nrPosts;
    private int nrComments;
    // constructor for testes
    public User(){
       
    }
    
    public User(String name, String password){
        this.name = name;
        this.password = password;
        //this.email = email;
        this.nrPosts = 0;
        this.nrComments = 0 ;
        
    }
    // public String get_email(){
      //  return email;
        
    //}
    //public void set_email(String email){
      //  this.email=email;
    //}
    
    public String get_name(){
        return name;
        
    }
    public String get_password(){
        return password;
    }
    
    
    public int get_nr_posts(){
        return nrPosts;
    }
    
     public int get_nr_comments(){
        return nrComments;
    }
    
    public void set_name(String name){
        this.name=name;
    }
    
    public void set_password(String password){
        this.password=password;
    }
    public void set_nr_posts(int nrPosts){
        this.nrPosts=nrPosts;
    }
    public void set_nr_comments(int nrComments){
        this.nrComments=nrComments;
    }
     public void increase_nr_comments(){
        this.nrComments++;
    }
     public void increase_nr_posts(){
        this.nrPosts++;
    }
}

