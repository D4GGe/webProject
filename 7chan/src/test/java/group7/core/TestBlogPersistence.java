
package group7.core;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Richard
 */

@RunWith(Arquillian.class)
public class TestBlogPersistence {
    
    @EJB
    IUserContainer useContainer;
    @EJB
    IPostContainer postContainer;
    @Inject
    UserTransaction utx;  // This is not an EJB so have to handle transactions

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "7chan.war")
                // Add all classes
                .addPackage("group7.core")
                // This will add test-persitence.xml as persistence.xml (renamed)
                // in folder META-INF, see Files > jpa_managing > target > arquillian
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                // Must have for CDI to work
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }

    @Before  // Run before each test
    public void before() throws Exception {
        clearAll();
    }
    // creates two users and test to send messages between them
    @Test
    public void testPersistUser() throws Exception {
        User u = new User("aaa", "bbb");
        User u2 = new User("bbb", "ccc");
        UserContainer.newInstance().create(u);
        List<User> us = UserContainer.newInstance().findAll();
        assertTrue(us.get(0).getName().equals(u.getName()));
        UserContainer.newInstance().create(u2);
        us =UserContainer.newInstance().findAll();
        assertTrue(us.size() == 2);
        
        Messenge m = new Messenge("hej", u, u2);
        u.getMessenges().add(m);
        u2.getMessenges().add(m);
        UserContainer.newInstance().update(u);
        UserContainer.newInstance().update(u2);
        assertTrue(UserContainer.newInstance().findAll().get(0).getMessenges().size()>0);
        assertTrue(UserContainer.newInstance().findAll().get(1).getMessenges().size()>0);
        
    }
    // creates one user test to create a post with teh user and comments the post 
    @Test
    public void testPersistPost() throws Exception {
        User u = new User("ccc", "bbb");
        UserContainer.newInstance().create(u);
        Post p = new Post("blablabla", "blablabal", u);
        p.getComments().add(new Comment("blabla", u));
        PostContainer.newInstance().create(p);
        
        assertTrue(PostContainer.newInstance().findAll().size()>0);
        assertTrue(PostContainer.newInstance().findAll().get(0).getComments().size()>0);
        
    }
    
    
    //Standalone em is created to be able to remove testdata between tests
    //It is not accessible from interfaces
    @PersistenceContext
    @Produces
    @Default
    EntityManager em;

    // Order matters
    private void clearAll() throws Exception {  
        utx.begin();  
        em.joinTransaction();
        em.createQuery("delete from Comment").executeUpdate();
        em.createQuery("delete from Post").executeUpdate();
        em.createQuery("delete from Messenge").executeUpdate();
        em.createQuery("delete from User").executeUpdate();
        utx.commit();
    }
    
}
