/*
 * Backing bean. Holds data for edit user-page.
 */
package goup7.view;

import group7.ctrl.LoginBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditUserBB implements Serializable{ 
    private long id;
    private String name;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    
    protected EditUserBB() {
    }
    @Inject
    LoginBean loginBean;
    
      @PostConstruct
    public void post() {
        this.password = loginBean.getUser().getPassword();
        this.name = loginBean.getUser().getName();
        this.firstname = loginBean.getUser().getFirstname();
        this.lastname = loginBean.getUser().getLastname();
        this.age = loginBean.getUser().getAge();
       
    }
    
public long getId() {
        return id;
    }
public int getAge() {
        return age;
    }
public void setAge(int age) {
        this.age=age;
    }
public String getFirstname() {
        return firstname;
    }
public void setFirstname(String firstname) {
       this.firstname=firstname;
    }
public String getLastname() {
        return lastname;
    }
public void setLastname(String lastname) {
       this.lastname=lastname;
    }
    public void setId(long id) {
        this.id = id;
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
