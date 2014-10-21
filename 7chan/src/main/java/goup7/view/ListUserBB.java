/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goup7.view;

import group7.core.IUserContainer;
import group7.core.User;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Richard
 */
@Named 
@ViewScoped
public class ListUserBB implements Serializable{
    
    private int currentPage;
    private final int pageSize = 10;
    private int count;
    @EJB
    private IUserContainer userContainer;
    protected ListUserBB(){
        currentPage = 0;
    
}
    @PostConstruct
    public void user(){
        count = userContainer.count();
    }
    
    //Listing all the users at once! Not sure if implementing code for different pages is necessary...
    public Collection<User> getList(){
        return userContainer.findAll();
    }
    
    public void next() {
        if ((currentPage + 1) * pageSize < count) {
            currentPage = currentPage + 1;
        }
    }

    public void prev() {
        if (currentPage > 0) {
            currentPage = currentPage - 1;
        }
    }
    
    // ---- Getters/Setters -------------
   
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int count() {
        return count;
    }
    
}