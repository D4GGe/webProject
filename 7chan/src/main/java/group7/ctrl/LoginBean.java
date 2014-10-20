/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.view.LoginBB;
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
    private UserContainer userContainer;
    private LoginBB lbb;
    
    

    /**
     * @param lbb the lbb to set
     */
    @Inject
    public void setLbb(LoginBB lbb) {
        this.lbb = lbb;
    }
    
   public String login() {
        User result = userContainer.login(lbb.getName(), lbb.getPassword());
        if (result!=null) {
            // get Http Session and store username
            HttpSession session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("userid", result.getId());
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
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        long id = Long.parseLong(session.getAttribute("userid").toString());
        return null;
      
      }
      
      
      public String logout() {
      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      session.invalidate();
      return "login";
   }
    
    
    
}
