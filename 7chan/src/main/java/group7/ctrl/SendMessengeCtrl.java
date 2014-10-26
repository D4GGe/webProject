/*
 * Control bean for message sending.
 * Execute business logic
 *
 */
package group7.ctrl;

import goup7.view.SendMessengeBB;
import group7.core.IUserContainer;
import group7.core.Messenge;
import group7.core.User;
import java.io.Serializable;
import javax.ejb.EJB;
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
        Messenge rmessenge = new Messenge(sendMessengeBB.getContent(), sender, reciver);
        Messenge smessenge = new Messenge(sendMessengeBB.getContent(), sender, reciver);
        sender.getMessenges().add(smessenge);
        rmessenge.setIsSender(false);
        reciver.getMessenges().add(rmessenge);
        
        userContainer.update(sender);
        userContainer.update(reciver);
        
    }
    
    
}
