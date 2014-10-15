package group7.ctrl;

import group7.core.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Richard
 */
@Named("user")
@SessionScoped
public class UserBB implements Serializable{
    
    //private final String password;
    private final User name;
    
    @Inject
    public UserBB(User name){
        this.name = name;
    }
        
    public User getName(){
            return name;
        }
}
