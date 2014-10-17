package group7.ctrl;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct; 
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
/*
 * @author Richard
 */
@Named
@RequestScoped
public class PostBB implements Serializable{
    
@Inject
public PostBB (){
        
    }
    
}
