package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Set;
import java.util.Map;

public class JoinTeamAction extends ActionSupport implements SessionAware {
    private String teamName;
    private Map<String, Object> session;

    public String execute(){
        User currentUser = Database.getUserById((int)session.get("userId"));
        //TODO: gets team ID from list, or gets Team from database by name.
        Team team = Database.getTeamByName(teamName);
        Database.saveTeam(team, currentUser);
        return "success";
    }
    public void setSession(Map<String, Object> session){
        this.session = session;
        return;
    }
    public String getTeamName(){
        return teamName;
    }
    public void setTeamName( String teamName ){
        this.teamName = teamName;
    }
    
}
