package com.bethgrace5.timetracker;

import java.util.HashSet;
import java.util.Set;

public class Issue {
    private int id;
    private String title;
    private Repository repository;
    private Milestone milestone;

    private Set<TimeSession> timeSessions = new HashSet<TimeSession>();

    public Issue() {
        // default constructor required by Hibernate
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Repository getRepository() {
        return this.repository;
    }
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Milestone getMilestone() {
        return this.milestone;
    }
    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public Set<TimeSession> getTimeSessions() {
        return this.timeSessions;
    }
    public void setTimeSessions(Set<TimeSession> timeSessions) {
        this.timeSessions = timeSessions;
    }

    public String toString() {
        return this.title;
    }
}
