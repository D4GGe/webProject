/*
 * Backing bean. Holds data for user list-page.
 */
 
package goup7.view;

import group7.core.IUserContainer;
import group7.core.User;
import group7.ctrl.LoginBean;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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
    private String searchWord;
    private Collection<User> list;
    @Inject
    LoginBean loginBean;
    @EJB
    private IUserContainer userContainer;
    protected ListUserBB(){
        currentPage = 0;
        
    
}
    @PostConstruct
    public void user(){
        currentPage = 0;
        count = userContainer.count();
         list = userContainer.findAll();
    }
    
    //Listing all the users at once! Not sure if implementing code for different pages is necessary...
    public Collection<User> getList(){
       return list;
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
    
    public boolean isFriend(long id){
        return loginBean.getUser().getFriends().contains(userContainer.find(id));
    }
    
    // ---- Getters/Setters -------------
   
    public int getCurrentPage() {
        return currentPage;
    }
    public void userFriends(){
        list=loginBean.getUser().getFriends();
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int count() {
        return count;
    }

    /**
     * @return the searchWord
     */
    public String getSearchWord() {
        return searchWord;
    }

    /**
     * @param searchWord the searchWord to set
     */
    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
        
    }
    public void doSearch(){
        this.list = userContainer.getByName(searchWord);
    }
    
}