package com.tutorialspoint.struts2;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterAction extends ActionSupport implements SessionAware{
    private String name;
    private String email;
    private String userName;
    private Map<String, Object> session;

    public String execute(){

        //TODO: test if email is valid
        User user = new User(name, userName, email, "client",
                                   //randomAlphanumeric(15));
                                   "password");
        Integer userId = Database.saveUser(user);
        session.put("userId", user.getId());
        // TODO: automatically email userName and password to client.
        return "success";
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
        return;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
        return;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
        return;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
        return;
    }
    
}
