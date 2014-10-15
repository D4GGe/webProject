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
public abstract class Generic_post {
    String name;
    int id;
    Date date;
    String content;
    
public String get_name(){
    return name;
}

public int get_id(){
    return id;
}

public Date get_date(){
    return date;
}

public String get_content(){
    return content;
}


public void set_name(String name){
this.name = name;    
}

public void set_id (int id){
    this.id = id;
}



    
}

