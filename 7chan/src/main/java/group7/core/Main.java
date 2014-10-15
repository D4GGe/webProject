/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

/**
 *
 * @author Daniel
 */
public class Main {
    User user;
    PostList<Post> posts;
    public Main(){
        user = new User();
        posts = new PostList<Post>();
        posts.add(new Post());
        posts.add(new Post());
    }
    
    public User get_user(){
        return user;
    }
    public PostList<Post> get_posts(){
        return posts;
    }
    
    
}
