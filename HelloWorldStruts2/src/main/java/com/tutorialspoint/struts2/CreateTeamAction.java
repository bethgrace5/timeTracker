package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Set;
import java.util.Map;

public class CreateTeamAction extends ActionSupport implements SessionAware {
    private String teamName;
    private User currentUser;
    private Map<String, Object> session;

    public String execute(){
        User user = Database.getUserById((int)session.get("userId"));
        Team team = new Team(teamName);
        Integer teamId = Database.saveTeam(team, user);
        return "success";
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
        return;
    }
    public String getTeamName(){
        return teamName;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
        return;
    }
    public User getCurrentUser(){
        return currentUser;
    }
    public void setCurrentUser( User currentUser){
        this.currentUser = (currentUser);
        return;
    }
    
}
