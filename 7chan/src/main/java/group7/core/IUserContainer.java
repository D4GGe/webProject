/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;

import java.util.List;
import javax.ejb.Local;
import persistence.IDAO;

/**
 *
 * @author Daniel
 */
@Local
public interface IUserContainer extends IDAO<User,Long> {
    
    public User login(String name, String password);
}
