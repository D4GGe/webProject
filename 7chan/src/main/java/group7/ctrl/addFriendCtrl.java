/*
 * Control bean for adding friends.
 * Execute business logic.
 *
 */

package group7.ctrl;

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
public class addFriendCtrl implements Serializable{
    @EJB
    private IUserContainer userContainer;
    @Inject
    private LoginBean loginBean;
    
    
    
    public void removeFriend(long userid){
      User friend = userContainer.find(userid);
      loginBean.getUser().getFriends().remove(friend);
      friend.getFriends().remove(loginBean.getUser());
      userContainer.update(friend);
      userContainer.update(loginBean.getUser());
    }
    
    public void addFriend(long userid){
        System.out.println(userid + " *******************************************");
      User friend = userContainer.find(userid);
      loginBean.getUser().getFriends().add(friend);
      friend.getFriends().add(loginBean.getUser());
      userContainer.update(friend);
      userContainer.update(loginBean.getUser());
    }
}
