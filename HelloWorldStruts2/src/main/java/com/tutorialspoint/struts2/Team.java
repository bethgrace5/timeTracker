package com.tutorialspoint.struts2;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/**
 * Team class. 
 * 
 */

public class Team{
    private int id;
    private String teamName;
    //private Date startDate;
    //private Date endDate;
    //class Project not created yet
    //private Set<Project> projects;
    private Set<User> users = new HashSet<User>();

    //public Team(String teamName, User user){
        //this.teamName = teamName;
        //users.add(user);
        //return;
    //}
    public Team(){
        return;
    }
    public Team(String teamName){
        this.teamName = teamName;
    }

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
    public String toString(){
        return this.getTeamName();
    }
    //public Date getStartDate(){
        //return startDate;
    //}
    //public void setStartDate( Date startDate ){
        //this.startDate = startDate;
    //}
    //public Date getEndDate(){
        //return endDate;
    //}
    //public void setEndDate( Date endDate ){
        //this.endDate = endDate;
    //}
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
    public void setUsers( Set<User> users ){
        this.users = users;
        return;
    }
}
