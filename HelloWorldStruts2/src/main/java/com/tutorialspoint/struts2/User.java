package com.tutorialspoint.struts2;

public class User{
    private int id;
    private String name;

    public void setName(String name){
        name=this.name;
    }
    public void setId(int id){
        id=this.id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public String execute(){
        Database.saveUser(this);
        return "success";
    }
}
