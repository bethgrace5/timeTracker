package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;

/**
 * User class. 
 * user is either a client or contractor type.
 * Contractor's userName must be github username. Contractor is authenticated via github.
 * Client's userName must be company name. Client is added by a contractor.
 */
public class User extends ActionSupport{
    private int userPrimaryKey;
    private int isDeactivated = 0;
    private String userName;
    private String email;
    private int type;
    //NOTE: password will be specific to Clients instead of Users

    public String execute(){
        //if(this.isDeactivated() == 0){
            Database.saveUser(this);
            return "success";
        //}
        //else if (this.isDeactivated() == 1){
            //return "accountDeactivated";
        //}
        //else {
            //return "error";
        //}
    }
    public int getUserPrimaryKey(){
        return userPrimaryKey;
    }
    public void setUserPrimaryKey(int userPrimaryKey){
        this.userPrimaryKey = userPrimaryKey;
        return;
    }
    public int getIsDeactivated(){
        return isDeactivated;
    }
    public void setIsDeactivated(int isDeactivated){
        if(isDeactivated == 0 || isDeactivated == 1)
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
    public int getType(){
        return type;
    }
    public void setType(int type){
        //TODO: use string instead of int?
        //Currently 0="contractor" and 1="client"
        if(type == 0 || type == 1)
            this.type = type;
        //else
        return;
    }
}
