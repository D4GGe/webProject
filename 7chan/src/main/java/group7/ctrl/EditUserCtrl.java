/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7.ctrl; 

import goup7.view.EditUserBB;
import group7.core.IUserContainer;
import group7.util.Md5;
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
    
    @Inject
    private EditUserBB editUserBB;
    @Inject
    private LoginBean loginBean;
    //private EditUserBB editUserBB;
    @EJB
    private IUserContainer userContainer;
  

    protected EditUserCtrl() {
    }
    
    public void edit(){
        if(!loginBean.getUser().getPassword().equals(editUserBB.getPassword()) && editUserBB.getPassword().length()> 1){
        loginBean.getUser().setPassword(Md5.hash(editUserBB.getPassword()));    
        }
        
        loginBean.getUser().setFirstname(editUserBB.getFirstname());
        loginBean.getUser().setLastname(editUserBB.getLastname());
        loginBean.getUser().setAge(editUserBB.getAge());
        userContainer.update(loginBean.getUser());
        
        
       
    }


}
