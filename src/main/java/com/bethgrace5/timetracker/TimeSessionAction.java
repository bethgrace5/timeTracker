package com.bethgrace5.timetracker;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class TimeSessionAction extends ActionSupport implements SessionAware{
    private String repositoryName;
    private String location;

    private List<String> timeSessions = new ArrayList<String>();
    private Map<String, Object> session;

    public String listTimeSessions(){
        repositoryName = "nameee";
        location = "locationnn";

        timeSessions.add(repositoryName);
        timeSessions.add(location);

        return "success";
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public String getRepositoryName() {
        return repositoryName;
    }
    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<String> getTimeSessions(){
        return timeSessions;
    }
}
