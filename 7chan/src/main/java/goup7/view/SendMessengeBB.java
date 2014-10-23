/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goup7.view;

import group7.core.IUserContainer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */

@Named
@ViewScoped
public class SendMessengeBB implements Serializable{
private long userId;
private String content;

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }
    @EJB
    IUserContainer userContainer;
    
    public String getUserName(){
        return userContainer.find(userId).getName();
    }
    /**
     * @param userId the userId to set
     */
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
     
}
