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

    private final Main reg;
    
@Inject
<<<<<<< HEAD
public PostBB (){
        
=======
public PostBB (Main main) throws InstantiationException, IllegalAccessException{
        this.reg = Main.class.newInstance();
>>>>>>> 6a51174930408fa4ab8ab8e6b7a2a6346a8df8cc
    }
    
}
