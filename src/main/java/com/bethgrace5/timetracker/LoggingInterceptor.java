package com.bethgrace5.timetracker;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
import java.lang.NullPointerException;

public class LoggingInterceptor implements Interceptor, SessionAware{

    private Map<String, Object> session;
    public String intercept(ActionInvocation invocation) throws Exception{

        //try{ 
            //System.out.println(session.get("userId"));
            //FIXME: before testing if "userId" is null exception is thrown
            
            //if(session.get("userId") == null){
            //System.out.println("inside logging interceptor");
                //return "show-login";
            //}
        //}
        //catch (NullPointerException e){
        //}
        System.out.println("inside logging interceptor");
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
