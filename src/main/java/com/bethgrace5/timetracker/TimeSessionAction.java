package com.bethgrace5.timetracker;

import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class TimeSessionAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;

    public void setSession(Map<String, Object> session){
        this.session = session;
    }
}
