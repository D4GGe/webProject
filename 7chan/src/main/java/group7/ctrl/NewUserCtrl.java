/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.ctrl;

import goup7.veiw.NewUserBB;
import group7.core.SingletonForum;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@RequestScoped
public class NewUserCtrl implements Serializable{
    private SingletonForum sf;
    private NewUserBB nubb;
    
}
