package com.tutorialspoint.struts2;
import java.util.Date;

/**
 * Client class. 
 * Clients may be added by a contractor
 */

public class Client{

    private User user;
    private String password = null;
    private Date lastLogin = null;

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
        return;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword( String password ){
        if( this.password == null ){
            //TODO: calls a random string generator,
            //      and emails initial password to client;
            //password = RandomAlphaNumericWhatever()
            //email to user.getEmail(); 
        }
        this.password = password;
        return;
    }
    public Date getLastLogin(){
        return lastLogin;
    }
    public void setLastLogin( Date lastLogin ){
        this.lastLogin = lastLogin;
        return;
    }
}
