package com.bethgrace5.timetracker;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    private String userName;
    private String password;
    private User user;
    private Map<String, Object> session;
    private Map<String, Object> responseMap;


    public String login() throws Exception {
        user = Database.getUserByUserNamePassword(userName, password);

        if( user == null ){
            if( !getUserFromGithub( userName, password )){
                // user is not registered with this site or github
                return "error";
            }
        }
        else{
            if( user.getType().equals("client") ){
                return "client";
            }
            try{
                getUserFromGithub( userName, password );
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

    public boolean getUserFromGithub( String userName, String password ) throws Exception{
        // TODO: check that userName does not have illegal characters
        //       ( it should be able to be read as url )

        Gson converter = new Gson();
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = 
            new UsernamePasswordCredentials(userName, password);

        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
        try{
            try{
                HttpResponse httpResponse = httpclient.execute(new HttpGet( "https://api.github.com/users/" + userName));
                HttpEntity entity = httpResponse.getEntity();
                String responseString = EntityUtils.toString(entity, "UTF-8");
                //System.out.println(responseString);
                responseMap = converter.fromJson(responseString, Map.class);
            }
            catch( HttpResponseException e){
                addActionMessage("cannot retrieve user info for " 
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
                name = (String) responseMap.get("name");
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
