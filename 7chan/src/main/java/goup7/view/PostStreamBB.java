/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goup7.view;

import group7.core.IPostContainer;
import group7.core.Post;
import group7.core.PostContainer;
import group7.ctrl.LoginBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
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
public class PostStreamBB implements Serializable {
    
    private int currentPage;
    private final int pageSize = 2;
    private int count;
    @EJB
    private IPostContainer postContainer;
    @Inject
    private LoginBean loginBean;
    protected PostStreamBB(){
        currentPage = 0;
    }
    
        
    @PostConstruct
    public void post(){
        count = postContainer.count();
    }
    public Collection<Post> getUserPosts(){
        return postContainer.getByUser(loginBean.getUser());
    }
    
    public Collection<Post> getList(){
        return postContainer.findRange(pageSize * currentPage, pageSize);
    }
    public Collection<Integer> getPages(){
        Collection<Integer> a = new ArrayList<>();
        for(int n = 0; (n) * pageSize < count;n++){
            a.add(n+1);
        }
        return a;
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

    // ---- Get/Set -------------
   
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
