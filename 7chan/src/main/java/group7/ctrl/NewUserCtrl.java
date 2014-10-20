/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.NewUserBB;
import group7.core.IUserContainer;
import group7.core.User;
import java.io.Serializable;
import javax.ejb.EJB;
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
  
    private NewUserBB newUserBB;
    @EJB
    private IUserContainer userContainer;
    
    @Inject
    public void setnubb(NewUserBB nubb){
        this.newUserBB = nubb;
    }
    
    public void save(){

        System.out.println("********************" + userContainer.test());
        System.out.println(newUserBB.getName()+"********************         " + newUserBB.getPassword());
        

      userContainer.create(new User(newUserBB.getName(),newUserBB.getPassword()));
        

        
    }
}
