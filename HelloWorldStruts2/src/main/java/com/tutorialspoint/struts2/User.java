package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import java.util.HashSet;

/**
 * User class. 
 * user is either a client or contractor type.
 * Contractor's userName must be github username. Contractor is authenticated via github.
 * Client's userName must be company name. Client is added by a contractor.
 */
public class User {
    private int id;
    private String name;
    private boolean isDeactivated = false;
    private String userName;
    private String email;
    private String type;
    private Set<Team> teams = new HashSet<Team>();
    //NOTE: password will be specific to Clients instead of Users
    
    //constructor
    public User(String name, String userName, String email, String type){
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.type = type;
        return;
    }
    public User(){
        return;
    }

    //public String execute(){
        //if(this.isDeactivated() == 0){
            //Database.saveUser(this);
            //return "success";
        //}
        //else if (this.isDeactivated() == 1){
            //return "accountDeactivated";
        //}
        //else {
            //return "error";
        //}
    //}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
        return;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
        return;
    }
    public boolean getIsDeactivated(){
        return isDeactivated;
    }
    public void setIsDeactivated(boolean isDeactivated){
            this.isDeactivated = isDeactivated;
        //else
        return;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
        return;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
        return;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        //TODO: set a condition to only allow type= "contractor" or "client"
            this.type = type;
        //else
        return;
    }
    public Set getTeams(){
        return teams;
    }
    public void setTeams( Set<Team> teams ){
        this.teams = teams;
        return;
    }
    public String toString(){
        return getUserName();
    }
}
