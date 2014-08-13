package com.bethgrace5.timetracker;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private Set<String> repositoryNames;

    public String listRepositories(){
        // we need to get a list of github urls from all repositories
        // that are connected to the user logged in
        this.repositoryNames = Database.getRepositories((int) session.get("userId"));
        return "success";
    }
    public String deactivateUser(int userId){
        User user = Database.getUser(userId);
        user.setIsDeactivated(true);
        Database.saveUser(user);
        return "success";
    }
    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public Set<String> getRepositoryNames(){
        return repositoryNames;
    }
    public void setRepositoryNames(Set<String> repositoryNames){
        this.repositoryNames = repositoryNames;
    }
}
