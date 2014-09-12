package com.bethgrace5.timetracker;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
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

    /** establish user as existing, and direct to corect dashboard
     * @param userName the username to check for
     * @param password the password for authentication
     * @return type the type of user that is logging in
     *         error if can't be established as existing
     */
    public String login() throws Exception {
        user = Database.getUserByUserNamePassword(userName, password);
        String type;

        if( user != null){
            type = user.getType();
        }
        else{
            type = "error";
        }

        if(type.equals("client")){
            // do not check for user on github 
        }
        else {
            if( !getUserFromGithub( userName, password )){
                // user is not registered with this site or github
                return "error";
            }
            else{
                // user has been established in getUserFromGithub()
                type = user.getType();
            }
        }
        Database.updateLastLogin(user);
        addActionMessage("Welcome " + user.getName());
        session.put("userId", user.getId());
        return type;
    }

    public String logout(){
        ((SessionMap) session).invalidate();
        addActionMessage("Successfully logged out.");
        return "success";
    }

    /** Creates a new user or updates user that exists in the database
     * @param userName the username to check for
     * @param password the password for authentication
     * @return true if the user is found on github, false if not
     */
    public boolean getUserFromGithub( String userName, String password ) throws Exception{
        // TODO: check that userName does not have illegal characters
        //       ( it should be able to be read as url )
        Gson converter = new Gson();
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = 
            new UsernamePasswordCredentials(userName, password);

        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient httpclient = HttpClientBuilder.create().
            setDefaultCredentialsProvider(provider).build();

        try{
            HttpResponse httpResponse = httpclient.execute(
                    new HttpGet("https://api.github.com/users/"+userName));
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println(statusCode);

            if(statusCode != HttpStatus.SC_OK){
                httpclient.getConnectionManager().shutdown();
                return false;
            }

            HttpEntity entity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            responseMap = converter.fromJson(responseString, Map.class);
        }
        catch( HttpResponseException e){
            addActionMessage("cannot retrieve user info for " 
                    + userName + " at this time.");
            System.out.println(e);
            httpclient.getConnectionManager().shutdown();
            return false;
        }

        // we need to check that the user does not exist on github
        if(responseMap.containsKey("message")){
            String responseMessage = (String) responseMap.get("message");
            if(responseMessage.equals("Not Found")){
                httpclient.getConnectionManager().shutdown();
                return false;
            }
        }
        // create new account
        if( user == null ){
            user = new User();
        }

        String name = (String) responseMap.get("name");

        // the user has not set their name in their profile,
        // or they've removed their name after setting it.
        if(null==name || "".equals(name)){
            name="";
            // the user's name is not supplied on github
            //TODO: prompt to get name
        }

        // update  user info
        user.setName(name);
        user.setUserName(userName);

        //TODO: client users that do not exist in the database, but are registered
        //with github are created as contractors.
        user.setType("contractor");

        user.setPassword("");
        Database.saveUser(user);
        httpclient.getConnectionManager().shutdown();
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
