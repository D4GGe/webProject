/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goup7.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
/**
 *
 * @author Richard
 */
@Named
@RequestScoped
public class EditUserBB implements Serializable{ 
    
    private String name;
    private String password;

    protected EditUserBB() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
