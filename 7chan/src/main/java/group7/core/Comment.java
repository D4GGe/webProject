/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Comment extends Generic_post {
    
    
   public Comment(int id, String name, Date date,String content){
       this.id = id;
       this.name =name;
       this.date = date;
       this.content = content;
       
   }
    
}
