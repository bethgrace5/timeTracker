package com.bethgrace5.timetracker;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private String selectedRepository;

    public String deactivateUser(int userId){
        User user = Database.getUserById(userId);
        user.setIsDeactivated(true);
        Database.saveUser(user);
        return "success";
    }
    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public String getSelectedRepository() {
        return this.selectedRepository;
    }
    public void setSelectedRepository(String selectedRepository) {
        this.selectedRepository = selectedRepository;
    }
}
