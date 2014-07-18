package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SelectTeamAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private List<String> teams;

    public String execute(){
        teams = new ArrayList<String>();
        User user = Database.getUserById((int)session.get("userId"));
        teams = Database.getTeams(user);

        return "success";
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
        return;
    }

    public List<String> getTeams(){
        return teams;    
    }

    public void setTeams(List<String> teams){
        this.teams = teams;
    }
    
}
