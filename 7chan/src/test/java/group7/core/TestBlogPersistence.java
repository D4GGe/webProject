
package group7.core;

import java.util.List;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Richard
 */
/*
@RunWith(Arquillian.class)
public class TestBlogPersistence {
    
    @Inject
    UserContainer usecontainer;

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
    
    @Test
    public void testPersistAUser() throws Exception {
        User u = new User("aaa", "bbb");
        UserContainer.newInstance().create(u);
        List<User> us = UserContainer.newInstance().findAll();
        assertTrue(us.size() > 0);
        assertTrue(us.get(0).getName().equals(u.getName()));
    }
    
    //Standalone em is created to be able to remove testdata between tests
    //It is not accessible from interfaces
    @PersistenceContext(unitName = "jpa_shop_test_pu")
    @Produces
    @Default
    EntityManager em;

    // Order matters
    private void clearAll() throws Exception {  
        utx.begin();  
        em.joinTransaction();
        em.createQuery("delete from Post").executeUpdate();
        em.createQuery("delete from User").executeUpdate();
        em.createQuery("delete from Comment").executeUpdate();
        utx.commit();
    }
    
}
*/