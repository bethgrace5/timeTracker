package com.bethgrace5.timetracker;

import java.util.Map;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
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
            if( !getUserFromGithub( userName )){
                // user is not registered with this site or github
                return "error";
            }
        }
        else{
            if( user.getType().equals("client") ){
                return "client";
            }
            try{
                getUserFromGithub( userName );
            }
            catch( NullPointerException e ){
                System.out.println(e);
            }
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
            // TODO: check that userName does not have illegal characters
            //       ( it should be able to be read as url )
            HttpGet httpget = new HttpGet("https://api.github.com/users/" + userName);
            httpget.getURI();

            //create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            // Body contains your json string
            try{
                String responseBody = httpclient.execute(httpget, responseHandler);
                response = converter.fromJson(responseBody, Map.class);
            }
            catch( HttpResponseException e){
                addActionMessage("cannot retrieve user infor for " 
                        + userName + " at this time.");
                System.out.println(e);
                return false;
            }
            //TODO: set user properties here, remove storing excess in database
            if( user == null ){
                user = new User();
            }
            String name = "";
            try{
                name = (String) response.get("name");
            }
            catch( NullPointerException e ){
            }

            if (name.equals("")){
                // the user's name is not supplied on github
                //TODO: prompt to get name
            }
            // currently the user's name is the only data being updated
            user.setName( name );
            user.setUserName( userName );
            //TODO: if a client has a github account, they would be set as
            // a contractor. find a way to prevent this.
            user.setType( "contractor" );
            user.setPassword("");
            Database.saveUser( user );
        }finally{
            httpclient.getConnectionManager().shutdown();
        }
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
