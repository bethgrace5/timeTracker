package com.bethgrace5.timetracker;

import java.util.HashSet;
import java.util.Set;

public class Milestone {
    private int id;
    private String name;
    private Repository repository;

    private Set<Issue> issues = new HashSet<Issue>();
    private Set<TimeSession> timeSessions = new HashSet<TimeSession>();

    public Milestone() {
        // default constructor required by Hibernate
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Repository getRepository() {
        return this.repository;
    }
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Set<Issue> getIssues() {
        return this.issues;
    }
    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public Set<TimeSession> getTimeSessions() {
        return this.timeSessions;
    }
    public void setTimeSessions(Set<TimeSession> timeSessions) {
        this.timeSessions = timeSessions;
    }

    public String toString() {
        return this.repository.toString();
    }

}
