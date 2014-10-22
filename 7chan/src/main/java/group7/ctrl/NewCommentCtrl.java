package group7.ctrl;

import goup7.view.NewCommentBB;
import group7.core.Comment;
import group7.core.IPostContainer;
import group7.core.IUserContainer;
import group7.core.Post;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class NewCommentCtrl implements Serializable {
    
    private NewCommentBB newCommentBB;
    
    protected NewCommentCtrl() {
        // Must have for CDI
    }
    
    @EJB
    private IPostContainer postContainer; 
    @EJB
    private IUserContainer userContainer; 
    @Inject
    private LoginBean loginBean;
    @Inject
    public void setNewCommentBB(NewCommentBB newCommentBB) {
        this.newCommentBB = newCommentBB;
    }
   

    public void save() {
        Post post = postContainer.find(newCommentBB.getPostid());
       
        Comment a = new Comment(newCommentBB.getContent(),loginBean.getUser());
        post.getComments().add(a);
        postContainer.update(post);  
        loginBean.getUser().increase_nr_comments();
        userContainer.update(loginBean.getUser());
        

    }
    
}
   


