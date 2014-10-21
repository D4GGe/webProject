/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.LoginBB;
import group7.core.IUserContainer;
import group7.core.PostContainer;
import group7.core.User;
import group7.core.UserContainer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private IUserContainer userContainer;
    private LoginBB loginBB;
    private User user;
    private boolean loggedIn;
    

    /**
     * @param loginBB
     * @param loginbBB the loginBB to set
     */
    @Inject
    public void setLoginbb(LoginBB loginBB) {
        this.loginBB = loginBB;
    }
    
   public String login() {
        User result = userContainer.login(loginBB.getName(), loginBB.getPassword());
        if (result!=null) {
            // get Http Session and store username
            this.loggedIn = true;
            this.user = result;
            return "home";
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "login";
        }
        
    } 
    
   
      public User getUser()
      {
        
        return user;
      
      }
      
      public boolean getLoggedIn(){
          return loggedIn;
      }
      
      public void logout() {
      this.user = null;
      this.loggedIn = false;
      
   }
    
    
    
}
