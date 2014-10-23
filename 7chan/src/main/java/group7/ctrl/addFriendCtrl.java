/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import group7.core.IUserContainer;
import group7.core.User;
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
public class addFriendCtrl {
    @EJB
    private IUserContainer userContainer;
    @Inject
    private LoginBean loginBean;
    
    public void addFriend(long userid){
        System.out.println(userid + " *******************************************");
      User friend = userContainer.find(userid);
      loginBean.getUser().getFriends().add(friend);
      friend.getFriends().add(loginBean.getUser());
      userContainer.update(friend);
      userContainer.update(loginBean.getUser());
    }
}
