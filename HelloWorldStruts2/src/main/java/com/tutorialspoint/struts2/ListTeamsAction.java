package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class ListTeamsAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    public String execute(){

        return "success";
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
        return;
    }

}
