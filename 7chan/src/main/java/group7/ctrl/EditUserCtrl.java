/*
 * Control bean for edit user page.
 * Execute business logic and return navigation outcome
 *
 */
package group7.ctrl; 

import goup7.view.EditUserBB;
import group7.core.IUserContainer;
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
        loginBean.getUser().setPassword(editUserBB.getPassword());
        loginBean.getUser().setFirstname(editUserBB.getFirstname());
        loginBean.getUser().setLastname(editUserBB.getLastname());
        loginBean.getUser().setAge(editUserBB.getAge());
        userContainer.update(loginBean.getUser());
        
        
       
    }


}
