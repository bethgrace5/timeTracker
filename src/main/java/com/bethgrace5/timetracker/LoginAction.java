package com.bethgrace5.timetracker;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    private String userName;
    private String password;
    private Map<String, Object> session;

    public String login() {
        User user = Database.getUser(this.userName, this.password);
        if( user == null ){
            addActionError("Invalid Username or Password!");
            return "error";
        }
        addActionMessage("Welcome " + user.getName());
        session.put("userId", user.getId());
        return user.getType();
    }

    public String logout(){
        ((SessionMap) session).invalidate();
        //session.clear();
        //if((int) session.get(userId) != 0){
            //addActionError("User is not logged out.");
        //}
        //else{
            addActionMessage("Successfully logged out.");
        //}
        return "success";
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
