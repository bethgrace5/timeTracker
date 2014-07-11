package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;

public class DeactivateAction extends ActionSupport{
    private int id;

    public String execute(){
        Database.deactivateUser(getId());
            return "success";
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
        return;
    }
}
