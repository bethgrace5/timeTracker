package com.tutorialspoint.struts2;

/**
 * Client class. 
 * Clients may be added by a contractor with a default password that 
 * must be changed upon first login.
 */

public class Client{

    private int clientPrimaryKey;
    private int userForeignKey;
    private int passwordChanged;
    private String password = "someObscureDefaultValue"; //or randomly generated and sent to email.

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
    //TODO: how to associate client with specific user primary key?
    //      probably in .hbm.xml file. ->check
    //      if done in .hbm.xml file, then there does not need to be
    //      a way to "set" the foreign key.
    //      Or, does the .hbm.xml file use this set method?
    //this.userForeignKey = this.User.getUserPrimaryKey();
        this.userForeignKey = userForeignKey;
        return;
    }
    //TODO: instead of having "passwordChanged", set password to some obscure
    //      default value, and when logging in, check to see that password
    //      has been changed from that value. If not, prompt to change.
    public int getPasswordChanged(){
        return passwordChanged;
    }
    public void setPasswordChanged(int passwordChanged){
        if( this.passwordChanged == 0 ){
    //TODO: call method to prompt to change password for the first time.
            this.passwordChanged = passwordChanged;
            //isDefaultPassword = 1;
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
