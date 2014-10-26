/*
 *Backing bean. Holds data for post search.
 */

package goup7.view;


import group7.ctrl.PostSearchCtrl;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@RequestScoped
public class PostSearchBB implements Serializable {
    private String search;
    @Inject
   private PostSearchCtrl postSearchCtrl;
    public PostSearchBB(){
    
}
   
    
    @PostConstruct
    public void post(){
   
    }
    
   
    /**
     * @return the search
     */
    public String getSearch() {
        return search;
    }
    
    /**
     * @param search the search to set
     */
    public void setSearch(String search) {
        System.out.println("search" +  search);
        this.search = search;
    }
    
    public void preformSearch(){
        postSearchCtrl.setSearch(search);
        postSearchCtrl.preform_search();
    }
    

    /**
     * @return the posts
     */
    
    
    
    
}
