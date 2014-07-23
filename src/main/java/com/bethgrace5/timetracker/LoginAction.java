package com.bethgrace5.timetracker;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    private String userName;
    private String password;
    private Map<String, Object> session;

    public String execute() {
        User user = Database.findUserByUsernameAndPassword(
                this.userName, this.password);
        if( user == null ){
            return "error";
        }
        session.put("userId", user.getId());
        return user.getType();
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
