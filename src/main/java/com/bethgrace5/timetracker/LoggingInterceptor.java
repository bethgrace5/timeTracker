package com.bethgrace5.timetracker;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class LoggingInterceptor implements Interceptor, SessionAware{
    private Map<String, Object> session;

    // when a user is not logged in, redirect to login page
    public String intercept(ActionInvocation invocation) throws Exception{
        session = invocation.getInvocationContext().getSession();
        if(session.get("userId") == null){
            return "show-login";
        }
        String result = invocation.invoke();
        return result;
    }

    public void destroy(){
    }

    public void init(){
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
    }
}
