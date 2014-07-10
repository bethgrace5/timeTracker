package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;

public class deactivateAction extends ActionSupport{
    private int id;

    public String execute(){
        if( Database.deactivateUser() )
            return "success";
        else
            return "error";
    }

    public int getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
        return;
    }
}
