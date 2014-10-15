/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

/**
 *
 * @author Sanna
 */
public class User {
    String name;
    String password;
    int id;
    int nrPosts;
    int nrComments;
    // constructor for testes
    public User(){
       this.name = "sample";
       this.password = "sample";
       this.id =1;
       this.nrComments = 0;
       this.nrPosts = 1;
    }
                   
    public String get_name(){
        return name;
    }
    public String get_password(){
        return password;
    }
    
    public int get_id(){
        return id;
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
    
    public void set_id(int id){
        this.id=id;
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

