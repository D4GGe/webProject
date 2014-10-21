/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7.ctrl; 

import goup7.view.EditUserBB;
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
 * @author Richard
 */
@Named
@RequestScoped
public class EditUserCtrl implements Serializable{ 
    
    private EditUserBB editUserBB;
    @EJB
    private IUserContainer userContainer;
    
    @Inject
    public void set(EditUserBB editUserBB){
        this.editUserBB = editUserBB;
    }

    protected EditUserCtrl() {
    }
    
    /*
    @Inject
    private LoginBean loginbean;
  */
    
    public void update(){
        // loginbean.getUser().set_name(userBB.getName());
        // loginbean.getUser().set_password(userBB.getPassword());
        userContainer.update(new User(editUserBB.getName(), editUserBB.getPassword()));
    }
   
    /*
    Depending on the behaviour of the database, 
    the commented solution might be the optimal solution for editing a user. 
    (Unsure whether the information is stored when using loginbean) 
    */
}
