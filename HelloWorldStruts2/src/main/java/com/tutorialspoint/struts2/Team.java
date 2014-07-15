package com.tutorialspoint.struts2;
import java.util.Date;
import java.util.Set;

/**
 * Team class. 
 * 
 */

public class Team{
    private int id;
    private String teamName;
    private Date startDate;
    private Date endDate;
    //class Project not created yet
    //private Set<Project> projects;
    private Set<User> users;

    public int getId(){
        return id;
    }
    public void setId( int id ){
        this.id = id;
    }
    public String getTeamName(){
        return teamName;
    }
    public void setTeamName( String teamName ){
        this.teamName = teamName;
    }
    public Date getStartDate(){
        return startDate;
    }
    public void setStartDate( Date startDate ){
        this.startDate = startDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate( Date endDate ){
        this.endDate = endDate;
    }
    //class Project not created yet
    //public Set getProjects(){
        //return projects;
    //}
    //public void setprojects( Set<Project> projects){
        //this.projects = projects;
        //return;
    //}
    public Set getUsers(){
        return users;
    }
    public void setusers( Set<User> users ){
        this.users = users;
        return;
    }
}
