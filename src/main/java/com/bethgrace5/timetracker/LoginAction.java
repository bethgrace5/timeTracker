package com.bethgrace5.timetracker;

import java.util.Map;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    private String userName;
    private String password;
    private User user;
    private Map<String, Object> session;
    private Map<String, Object> response;


    public String login() throws Exception {
        user = Database.getUserByUserNamePassword(userName, password);
        if( user == null ){
            //TODO: check that username is not an email before checking github
            getUserFromGithub( userName );
        }
        Database.updateLastLogin(user);
        addActionMessage("Welcome " + user.getName());
        session.put("userId", user.getId());
        return user.getType();
    }

    public String logout(){
        ((SessionMap) session).invalidate();
        addActionMessage("Successfully logged out.");
        return "success";
    }

    public boolean getUserFromGithub( String userName ) throws Exception{
        HttpClient httpclient = new DefaultHttpClient();
        Gson converter = new Gson();
        try{
            HttpGet httpget = new HttpGet("https://api.github.com/users/" + userName);
            httpget.getURI();

            //create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            // Body contains your json string
            String responseBody = httpclient.execute(httpget, responseHandler);
            response = converter.fromJson(responseBody, Map.class);
            //TODO: set user properties here, remove storing excess in database
            //System.out.println(response.get("name"));

            String name = (String) response.get("name");
            user = new User(name, userName, "contractor", "");
            Database.saveUser( user );


        }finally{
            httpclient.getConnectionManager().shutdown();
        }
            //if( response.get("message").equals("Not Found")){
                //httpclient.getConnectionManager().shutdown();
                //return false;
            //}


        return true;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
