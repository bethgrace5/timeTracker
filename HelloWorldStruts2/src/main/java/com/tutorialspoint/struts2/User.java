package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;
import java.lang.Integer;
import java.lang.String;

public class User extends ActionSupport{
    private int id;
    private int deactivated = 0;
    private String name;
    private String password;

//actions
    public String execute(){
        if(this.isDeactivated() == 0){
            Database.saveUser(this);
            return "success";
        }
        else if (this.isDeactivated() == 1){
            return "accountDeactivated";
        }
        else {
            return "error";
        }
    }

//getters and setters
    public void setName(String name){
        this.name=name;
        return;
    }

    public void setId(int id){
        this.id=id;
        return;
    }

    public void setPassword(String password){
        this.password=password;
        return;
    }

    public void setDeactivated(int deactivated){
        this.deactivated = deactivated;
        return;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getPassword(){
        return password;
    }

    public int isDeactivated(){
        return deactivated;
    }

}
