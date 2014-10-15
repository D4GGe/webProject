package group7.ctrl;

import group7.core.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/*
 * @author Richard
 */
@Named("user")
@SessionScoped
public class UserBB implements Serializable{
    
    private final User password;
    private final User name;
    
    @Inject
    public UserBB(User name, User password){
        this.name = name;
        this.password = password;
    }
    
    //Unclear whether or not these following commands are necessary for the bean!
    public User getName(){
            return name;
        }
    public User getPassword(){
            return password;
        }
}
