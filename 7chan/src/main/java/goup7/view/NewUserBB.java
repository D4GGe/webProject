/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goup7.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Daniel
 */
@Named
@RequestScoped
public class NewUserBB implements Serializable{
    private String name;
    private String password;
    private String email;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
 public String getEmail() {
        return email;
    }
    /**
     * @param name the name to set
     */
  public void setEmail(String email) {
        this.email=email;
    }
    public void setName(String name) {
        this.name = name;
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
     @Override
    public String toString() {
        return "NewUserBB{"+"name=" + name + ", password=" + password + '}';
    }
    
}
