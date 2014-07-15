package com.tutorialspoint.struts2;

/**
 * Client class. 
 * Clients may be added by a contractor
 */

public class Client{

    //TODO: rename clientPrimaryKey and userForeignKey to client_id and user_id
    private int clientPrimaryKey;
    private int userForeignKey;
    //TODO: change passwordChanged to previousLoginDate
    private int passwordChanged;
    private String password;

    public int getClientPrimaryKey(){
        return clientPrimaryKey;
    }
    public void setClientPrimaryKey(int clientPrimaryKey){
        this.clientPrimaryKey = clientPrimaryKey;
        return;
    }
    public int getUserForeignKey(){
        return userForeignKey;
    }
    public void setUserForeignKey(int userForeignKey){
    //TODO: read about defining hibernate mapping files.
        this.userForeignKey = userForeignKey;
        return;
    }
    //TODO: Create field containing last login, if last login is null,
    //      prompt to change password.
    //TODO: read about password hashing, and look at Java's
    //      RandomStringUtils.randomAlphanumeric()
    public int getPasswordChanged(){
        return passwordChanged;
    }
    public void setPasswordChanged(int passwordChanged){
        if( this.passwordChanged == 0 ){
    //TODO: call method to prompt to change password for the first time.
            this.passwordChanged = passwordChanged;
        }
        //else
    //TODO: call method to change password that already exists.
        return;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(){
        this.password = password;
        return;
    }
}
