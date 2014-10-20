/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.NewPostBB;
import goup7.view.NewUserBB;
import group7.core.Post;
import group7.core.SingletonForum;
import group7.core.User;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@RequestScoped

public class NewUserCtrl implements Serializable{
    private SingletonForum sf;
    private NewUserBB nubb;
    
    protected NewUserCtrl(){
        
    }
    
  @Inject
    public NewUserCtrl(SingletonForum sf){
        this.sf =sf;
        
    }
    @Inject
    public void setnubb(NewUserBB nubb){
        this.nubb = nubb;
    }
    
    public void save(){
     sf.getForum().getUserContainer().create(new User(nubb.getName(),nubb.getPassword()));
               // Logger.getAnonymousLogger.log(Level.INFO, "dihuahduha");
        
    }
}
