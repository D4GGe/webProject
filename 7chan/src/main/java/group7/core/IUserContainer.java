/*
 * Interfacefor UserContainer
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
    public boolean userExsists(String name);
    public List<User> getByName(String name);
    public User login(String name, String password);
}
