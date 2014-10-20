/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.NewUserBB;
import group7.core.IUserContainer;
import group7.core.UserContainer;
import java.io.Serializable;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
=======
import javax.ejb.EJB;
>>>>>>> 3a38016a7385744979e731e2741c2273597b911b
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
<<<<<<< HEAD
    private SingletonForum sf;
    private NewUserBB nubb;
    
    protected NewUserCtrl(){
        
    }
    
  @Inject
    public NewUserCtrl(SingletonForum sf){
        this.sf =sf;
        
    }
=======
   // private SingletonForum sf;
    private NewUserBB newUserBB;
    @EJB
    private IUserContainer userContainer;
    public NewUserCtrl(){
        
    }
>>>>>>> 3a38016a7385744979e731e2741c2273597b911b
    @Inject
    public void setnubb(NewUserBB nubb){
        this.newUserBB = nubb;
    }
    
    public void save(){
<<<<<<< HEAD
     sf.getForum().getUserContainer().create(new User(nubb.getName(),nubb.getPassword()));
               // Logger.getAnonymousLogger.log(Level.INFO, "dihuahduha");
=======
        System.out.println("********************" + userContainer.test());
        System.out.println(newUserBB.getName()+"********************         " + newUserBB.getPassword());
        
      // sf.getForum().getUserContainer().create(new User(nubb.getName(),nubb.getPassword()));
        
>>>>>>> 3a38016a7385744979e731e2741c2273597b911b
        
    }
}
