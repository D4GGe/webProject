/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7.ctrl;

import goup7.view.SendMessengeBB;
import group7.core.IUserContainer;
import group7.core.Messenge;
import group7.core.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@ViewScoped
public class SendMessengeCtrl implements Serializable{
    @EJB
    private IUserContainer userContainer;
    @Inject
    private LoginBean loginBean;
    @Inject
    SendMessengeBB sendMessengeBB;
    
    public void send(){
        User reciver = userContainer.find(sendMessengeBB.getUserId());
        User sender = loginBean.getUser();
        Messenge messenge = new Messenge(sendMessengeBB.getContent(), sender, reciver);
        reciver.getMessenges().add(messenge);
        sender.getMessenges().add(messenge);
        userContainer.update(sender);
        userContainer.update(reciver);
        
    }
    
    
}
