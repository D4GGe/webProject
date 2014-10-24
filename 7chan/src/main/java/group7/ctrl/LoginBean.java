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
import javax.annotation.PostConstruct;
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
    private long postid;
    private String redirect;

    
    @PostConstruct
    public void post() {
        this.loggedIn = false;
    }
    public boolean isUser(long userid){
        return user.getId() == userid;
    }

    public void updateUser(){
        user = userContainer.find(user.getId());
    }
    /**
     * @param loginBB
     */
    @Inject
    public void setLoginbb(LoginBB loginBB) {
        this.loginBB = loginBB;
    }
   
    public String login(String userName,String userPassword) {
        //User result = userContainer.login(loginBB.getName(), loginBB.getPassword());
        //wrong metod shuld be an sql query but (as the function over)
        User result = null;
        for (User user : userContainer.findAll()) {
                if(userName.equals(user.get_name()) && userPassword.equals(user.get_password())){
                    result = user;
                    
                    break;
                }
        }

        if (result != null) {
            this.loggedIn = true;
            this.user = result;
            return "user?faces-redirect=true";

        } else {
            return "loginFail.xhtml?faces-redirect=true";
        }

    }
    public String login() {
        //User result = userContainer.login(loginBB.getName(), loginBB.getPassword());
        //wrong metod shuld be an sql query but (as the function over)
        User result = null;
        for (User user : userContainer.findAll()) {
                if(loginBB.getName().equals(user.get_name()) && loginBB.getPassword().equals(user.get_password())){
                    result = user;
                    
                    break;
                }
        }

        if (result != null) {
            // get Http Session and store username
            this.loggedIn = true;
            this.user = result;
            return "user?faces-redirect=true";

        } else {

            return "loginFail.xhtml?faces-redirect=true";
            // invalidate session, and redirect to other pages
            //message = "Invalid Login. Please Try Again!";
        }

    }

    public User getUser() {

        return user;

    }
    

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void logout() {
        this.user = null;
        this.loggedIn = false;

    }

    /**
     * @return the postid
     */
    public long getPostid() {
        return postid;
    }

    /**
     * @param postid the postid to set
     */
    public void setPostid(long postid) {
        this.postid = postid;
    }

    /**
     * @return the redirect
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * @param redirect the redirect to set
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

}
