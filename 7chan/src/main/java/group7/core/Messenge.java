/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import persistence.AbstractEntity;

/**
 *
 * @author Daniel
 */
@Entity
public class Messenge extends AbstractEntity {

    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String content;
    @ManyToOne
    private User sender;
    private User receiver;
    private boolean isSender;
    public Messenge(){
        
    }
    public Messenge(String content, User sender,User receiver) {
        this.sender = sender;
        this.receiver =receiver;
        this.date = new Date();
        this.content = content;
        this.isSender = true;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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

    /**
     * @return the sender
     */
    public User getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * @return the receiver
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the isSender
     */
    public boolean isIsSender() {
        return isSender;
    }

    /**
     * @param isSender the isSender to set
     */
    public void setIsSender(boolean isSender) {
        this.isSender = isSender;
    }
}