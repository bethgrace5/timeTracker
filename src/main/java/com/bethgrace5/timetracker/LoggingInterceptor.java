package com.bethgrace5.timetracker;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class LoggingInterceptor implements Interceptor, SessionAware{
    private Map<String, Object> session;
    private String userName;

    public String intercept(ActionInvocation invocation) throws Exception{

        //if( session.get("userId") == null){
           //return "show-login"; 
        //}

        String result = invocation.invoke();
        System.out.println(userName);
        System.out.println(result);

        return result;
    }

    public void destroy(){

    }

    public void init(){

    }

    public void setSession(Map<String, Object> session){
        this.session = session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
