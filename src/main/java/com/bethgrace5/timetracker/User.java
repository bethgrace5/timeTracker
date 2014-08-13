package com.bethgrace5.timetracker;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import java.util.Map;

/**
 * User class.
 * user is either a client or contractor type.
 * Contractor's userName must be github username. Contractor is authenticated via github.
 * Client's userName must be company name. Client is added by a contractor.
 */
public class User{
    private int id;
    private String name;
    private String userName;
    private String email;
    private String type;
    private String password;
    private String selectedRepository;
    private boolean isDeactivated = false;

    private Set<Repository> repositories = new HashSet<Repository>();
    private Set<TimeSession> timeSessions = new HashSet<TimeSession>();

    public User() {
        // default constructor required by Hibernate
    }

    public User(String name, String userName, String email,
                String type, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.type = type;
        this.password = password;
        this.isDeactivated = false;
        return;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
        return;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsDeactivated() {
        return isDeactivated;
    }
    public void setIsDeactivated(boolean isDeactivated) {
        this.isDeactivated = isDeactivated;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSelectedRepository() {
        return selectedRepository;
    }
    public void setSelectedRepository(String selectedClient) {
        this.selectedRepository = selectedRepository;
    }

    public Set<Repository> getRepositories() {
        return this.repositories;
    }
    public void setRepositories(Set<Repository> repositories) {
        this.repositories = repositories;
    }

    public Set<TimeSession> getTimeSessions() {
        return this.timeSessions;
    }
    public void setTimeSessions(Set<TimeSession> timeSessions) {
        this.timeSessions = timeSessions;
    }

    public String toString() {
        return getUserName();
    }
    public boolean equals( User user ){
        return ( this.email.equals(user.getEmail()) );
    }
}
