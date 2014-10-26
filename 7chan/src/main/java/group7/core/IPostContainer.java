/*
 * 
 * a interface for the postContainer
 * 
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
public interface IPostContainer extends IDAO<Post, Long> {

    public List<Post> getByName(String name);
    public List<Post> getByUser(User user);
}
    

