/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.veiw.NewPostBB;
import group7.core.Post;
import group7.core.SingletonForum;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@RequestScoped
public class NewPostCtrl implements Serializable{
    private SingletonForum sf;
    private NewPostBB npbb;
    
    @Inject
    public NewPostCtrl(SingletonForum sf){
        this.sf =sf;
        
    }
    @Inject
    public void setnpbb(NewPostBB npbb){
        this.npbb = npbb;
    }
    
    public void save(){
        sf.getForum().getPostContainer().create(new Post(npbb.getName(),npbb.getContent()));
                
        
    }
    
}
