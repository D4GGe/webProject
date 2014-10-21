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
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;
    private boolean disabled;
    //private String email;
   private int nrPosts;
    private int nrComments;
    // constructor for testes
    public User(){
       
    }
    
    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.nrPosts = 0;
        this.nrComments = 0 ;
        
    }
    public User(long id, String name, String password){
        super(id);
        this.name = name;
        this.password = password;
        
        this.nrPosts = 0;
        this.nrComments = 0 ;
        
    }
  
    
    
    public String get_name(){
        return getName();
        
    }
    public String get_password(){
        return getPassword();
    }
    
    
    public int get_nr_posts(){
        return getNrPosts();
    }
    
     public int get_nr_comments(){
        return getNrComments();
    }
    
    public void set_name(String name){
        this.setName(name);
    }
     public boolean get_disabled(){
        return isDisabled();
    }
    
    public void set_disabled(boolean disabled){
        this.setDisabled(disabled);
    }
    
    public void set_password(String password){
        this.setPassword(password);
    }
    public void set_nr_posts(int nrPosts){
        this.setNrPosts(nrPosts);
    }
    public void set_nr_comments(int nrComments){
        this.setNrComments(nrComments);
    }
     public void increase_nr_comments(){
         this.setNrComments(this.getNrComments() + 1);
    }
     public void increase_nr_posts(){
         this.setNrPosts(this.getNrPosts() + 1);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the disabled
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * @return the nrPosts
     */
    public int getNrPosts() {
        return nrPosts;
    }

    /**
     * @param nrPosts the nrPosts to set
     */
    public void setNrPosts(int nrPosts) {
        this.nrPosts = nrPosts;
    }

    /**
     * @return the nrComments
     */
    public int getNrComments() {
        return nrComments;
    }

    /**
     * @param nrComments the nrComments to set
     */
    public void setNrComments(int nrComments) {
        this.nrComments = nrComments;
    }
}

