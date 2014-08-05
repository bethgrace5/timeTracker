package com.bethgrace5.timetracker;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class Repository extends ActionSupport implements SessionAware{
    private int id;
    private String githubUrl;
    private String name;
    private RepositoryStatus status;

    private Set<User> users = new HashSet<User>();
    private Set<Milestone> milestones = new HashSet<Milestone>();
    private Set<TimeSession> timeSessions = new HashSet<TimeSession>();
    private Map<String, Object> session;

    public Repository() {
        // default constructor required by Hibernate
    }

    public String addRepository(){
        Repository repo = new Repository();
        repo.setGithubUrl(this.githubUrl);
        if( Database.exists(repo) ){
            addActionError("Repository exists!");
            return "error";
        }
        Database.saveRepository(repo);
        addActionMessage("Successfully Added Repository");
        return "success";
    }
    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getGithubUrl() {
        return this.githubUrl;
    }
    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public RepositoryStatus getStatus() {
        return this.status;
    }

    public void setStatus(RepositoryStatus status) {
        this.status = status;
    }

    public Set<User> getUsers() {
        return this.users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Milestone> getMilestones() {
        return this.milestones;
    }
    public void setMilestones(Set<Milestone> milestones) {
        this.milestones = milestones;
    }

    public Set<TimeSession> getTimeSessions() {
        return this.timeSessions;
    }
    public void setTimeSessions(Set<TimeSession> timeSessions) {
        this.timeSessions = timeSessions;
    }

    // don't use these -- used by hibernate
    public String getStatusString() {
        if (this.status == null)
            return null;
        return this.status.toString();
    }

    public void setStatusString(String statusString) {
        this.status = Enum.valueOf(RepositoryStatus.class, statusString);
    }

}
