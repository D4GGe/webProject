/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import persistence.AbstractEntity;

/**
 *
 * @author Daniel
 */
@Entity
public class Comment extends AbstractEntity {
    
    private Time time;
    private String data;
    @OneToOne
    private User user;

    
    public Comment(){
        
    }
    
    public Comment(Time a, String data , User user){
        this.time = a;
        this.data = data;
        this.user = user;
        
    }
    
    public Time getTime(){
        return time;
        
    }
    public String getData(){
        return data;
    }
    
}
