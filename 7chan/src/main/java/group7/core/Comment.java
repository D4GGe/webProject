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
    int post_id;
    
   public Comment(int id, String name, Date date,String content){
       this.id = id;
       this.name =name;
       this.date = date;
       this.content = content;
       
   }
    
   public Comment(){
       this.id = 1;
       this.name = "rubrik";
       this.date = new Date();
       this.content = "content post";
   }
}
