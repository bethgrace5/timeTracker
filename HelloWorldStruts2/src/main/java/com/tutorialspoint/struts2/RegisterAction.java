package com.tutorialspoint.struts2;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class RegisterAction extends ActionSupport implements SessionAware{
    private String name;
    private String email;
    private String userName;
    private String type;
    private String password;
    private Map<String, Object> session;

    public String execute(){

        User user = new User(name, userName, email, type, password);
        Integer userId = Database.saveUser(user);
        session.put("userId", user.getId());
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
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
        return;
    }
    public String getPassword(){
        return password ;
    }
    public void setPassword(String password){
        this.password = password;
        return;
    }
    
}
