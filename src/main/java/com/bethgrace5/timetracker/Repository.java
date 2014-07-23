package com.bethgrace5.timetracker;

import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

public class Repository {
    private int id;
    private String githubUrl;
    private String name;
    private RepositoryStatus status;

    private Set<User> users = new HashSet<User>();

    public Repository() {
        // default constructor required by Hibernate
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
