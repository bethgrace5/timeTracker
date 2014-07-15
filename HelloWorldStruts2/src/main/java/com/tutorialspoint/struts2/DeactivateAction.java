package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.struts2.User;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class DeactivateAction extends ActionSupport implements SessionAware{
    private int id;
    private Map<String, Object> session;

    public String execute(){
        Database.deactivateUser((int)session.get("userId"));
        return "success";
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
        return;
    }

}
