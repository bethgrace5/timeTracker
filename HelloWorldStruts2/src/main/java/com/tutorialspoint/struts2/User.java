package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{
    private int id;
    private String name;
    private String password;

    public void setName(String name){
        this.name=name;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setPassword(String password){
        this.password=password;
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

    public String execute(){
        Database.saveUser(this);
        return "success";
    }
}
