/*
 * User class, holds a user 
 */

package group7.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import persistence.AbstractEntity;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="CHAN_USER")
public class User extends AbstractEntity {
    private String name;
    //private Date date;
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
    @Temporal(TemporalType.TIMESTAMP)
     private Date date;
    @ManyToMany
    private List<User> friends;
    @ManyToMany
    private List<Messenge> messenges;
     

    public User(){
       
    }
    
    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.email =" ";
        this.age=0;
        this.firstname=" ";
        this.lastname=" ";
        this.nrPosts = 0;
        this.nrComments = 0 ;
        
    }
   
  public User(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
        this.nrPosts = 0;
        this.nrComments = 0 ;
        this.date = new Date();
        
    }
  
    public String getDate() {
        SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd");
        return ft.format(date);
        
    }
 
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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

    /**
     * @return the friends
     */
    public List<User> getFriends() {
        return friends;
    }

    /**
     * @param friends the friends to set
     */
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    /**
     * @return the messenges
     */
    public List<Messenge> getMessenges() {
        return messenges;
    }

    /**
     * @param messenges the messenges to set
     */
    public void setMessenges(List<Messenge> messenges) {
        this.messenges = messenges;
    }
}

