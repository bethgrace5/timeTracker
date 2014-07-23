package com.bethgrace5.timetracker;

public enum RepositoryStatus {
    Canceled("canceled"),
    Complete("complete"),
    InProgress("in progress"),
    Pending("pending");

    private String statusName;

    private RepositoryStatus(String name) {
        this.statusName = name;
    }

    public String toString() {
        return this.statusName;
    }
}
