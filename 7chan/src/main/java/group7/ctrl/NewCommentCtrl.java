package group7.ctrl;

import goup7.view.NewCommentBB;
import group7.core.Comment;
import group7.core.Post;
import java.io.Serializable;
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
    
    
    // Lie this --------------------
    @Inject
    public void setNewCommentBB(NewCommentBB newCommentBB) {
        this.newCommentBB = newCommentBB;
    }
   
    
    // ---- or like this 
    /*public String save(PersonDetailBB personBB) {
        LOG.log(Level.INFO, "Save: {0}" + personBB);
        reg.create(new Person(personBB.getId(), personBB.getFname(), personBB.getAge()));
        return "personList?faces-redirect=true";
    }*/
    public void save() {
        newCommentBB.getCommentList().add(new Comment(newCommentBB.getContent()));
        
        System.out.println(newCommentBB.getCommentList().size());
//ss.getShop().getProductCatalogue().update(new Product(editprodBB.getId(), editprodBB.getName(), editprodBB.getPrice()));
                
    }
    
}
  


