package com.bethgrace5.timetracker;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Repository {
    private int id;
    private Double githubId;
    private String name;
    private String status;

    private Set<User> users = new HashSet<User>();
    private Set<Milestone> milestones = new HashSet<Milestone>();
    private Set<TimeSession> timeSessions = new HashSet<TimeSession>();

    public Repository() {
        // default constructor required by Hibernate
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Double getGithubId() {
        return this.githubId;
    }
    public void setGithubId(Double githubId) {
        this.githubId = githubId;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        if( status.equals(RepositoryStatus.InProgress.toString()) ||
            status.equals(RepositoryStatus.Complete.toString())   ||
            status.equals(RepositoryStatus.Canceled.toString())   ||
            status.equals(RepositoryStatus.Pending.toString()) ){
                this.status = status;
        }
        else{
            this.status = RepositoryStatus.InProgress.toString();
        }
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
    public String toString() {
        return getName();
    }
    public boolean equals( Repository repo ){
        return ( this.name.equals(repo.getName()));
    }

    // don't use these -- used by hibernate
    /*public String getStatusString() {
        if (this.status == null)
            return null;
        return this.status.toString();
    }

    public void setStatusString(String statusString) {
        this.status = Enum.valueOf(RepositoryStatus.class, statusString);
    }
    */

}
