/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.NewUserBB;
import group7.core.IUserContainer;
import group7.core.User;
import group7.util.Md5;
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
    private LoginBean loginBean;
    
    @Inject
    public void setnubb(NewUserBB nubb){
        this.newUserBB = nubb;
    }
    
    public String save(){

        
        if(!userContainer.userExsists(newUserBB.getName())&newUserBB.getName().length()>3&newUserBB.getPassword().length()>2&newUserBB.getEmail().length()>4){
        User user = new User(newUserBB.getName(),Md5.hash(newUserBB.getPassword()), newUserBB.getEmail());
        userContainer.create(user);
        loginBean.login(user);
        return "user?faces-redirect=true"; 
        }
        System.out.println("daadssfdfds");
        return "registerFail.xhtml?faces-redirect=true";

        
    }
}
