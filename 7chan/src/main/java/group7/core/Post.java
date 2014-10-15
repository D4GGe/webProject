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
public class Post extends Generic_post{
   PostList<Comment> comments;
   
   public Post(int id, String name, Date date,String content){
       this.id = id;
       this.name =name;
       this.date = date;
       this.content = content;
       
   }
   //for testing
   public Post(){
       this.id = 1;
       this.name = "rubrik";
       this.date = new Date();
       this.content = "content post";
       comments =new PostList<Comment>();
       comments.add(new Comment());
       comments.add(new Comment());
   }
   
   public void set_comments(PostList<Comment> comments){
       this.comments = comments;
   }
   
    
}
