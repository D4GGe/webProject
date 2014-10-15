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
    
    private int id;
    private String password;
    private String name;
    
    @Inject
    public UserBB(String name, String password){
        this.name = name;
        this.password = password;
    }
    
    public int getId(){
        return id;
    }
        
    public String getName(){
            return name;
        }
    public String getPassword(){
            return password;
        }
}
