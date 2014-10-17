/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import javax.persistence.Entity;
import persistence.AbstractEntity;

/**
 *
 * @author Daniel
 */
@Entity
public class User extends AbstractEntity {
    String name;
    String password;
    int nrPosts;
    int nrComments;
    // constructor for testes
    public User(){
       
    }
    
    public User(String name, String password){
        
    }
    
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
}

