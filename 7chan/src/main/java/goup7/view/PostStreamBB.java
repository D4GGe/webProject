/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goup7.view;

import group7.core.Post;
import group7.core.SingletonForum;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
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
    private SingletonForum sf;
    private int currentPage;
    private final int pageSize = 10;
    private int count;
    protected PostStreamBB(){
        
    }
    
    @Inject
    public PostStreamBB(SingletonForum sf){
        this.sf = sf;
    }
    
    @PostConstruct
    public void post(){
        count = sf.getForum().getPostContainer().count();
    }
    
    public Collection<Post> getList(){
        return sf.getForum().getPostContainer().findRange(pageSize * currentPage, pageSize);
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
