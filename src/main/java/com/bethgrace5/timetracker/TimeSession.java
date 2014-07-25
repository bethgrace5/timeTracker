package com.bethgrace5.timetracker;

import java.sql.Timestamp;

import java.util.HashSet;
import java.util.Set;

public class TimeSession {
    private int id;
    private User user;
    private Repository repository;
    private Milestone milestone;
    private Issue issue;
    private Timestamp startDate;
    private Timestamp endDate;
    private double milesDriven;
    private double hourlyRate;

    public TimeSession() {
        // default constructor required by Hibernate
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
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

    public Issue getIssue() {
        return this.issue;
    }
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Timestamp getStartDate() {
        return this.startDate;
    }
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return this.endDate;
    }
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public double getMilesDriven() {
        return this.milesDriven;
    }
    public void setMilesDriven(double milesDriven) {
        this.milesDriven = milesDriven;
    }

    public double getHourlyRate() {
        return this.hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
