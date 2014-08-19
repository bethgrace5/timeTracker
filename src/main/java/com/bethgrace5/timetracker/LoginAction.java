package com.bethgrace5.timetracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    private String userName;
    private String password;
    private Map<String, Object> session;
    private List<String> repositoryNames;


    public String listRepositories(){
        // we need to get a list of github urls from all repositories
        // that are connected to the user logged in
        int userId = (int) session.get("userId");
        repositoryNames = new ArrayList(Database.getRepositories(userId));
        return "success";
    }

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
        addActionMessage("Successfully logged out.");
        return "success";
    }
    public List<String> getRepositoryNames(){
        return repositoryNames;
    }
    public void setRepositoryNames(List<String> repositoryNames){
        this.repositoryNames = repositoryNames;
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
