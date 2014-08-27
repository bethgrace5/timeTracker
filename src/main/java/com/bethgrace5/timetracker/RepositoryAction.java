package com.bethgrace5.timetracker;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.struts2.interceptor.SessionAware;

public class RepositoryAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private String githubUrl;
    private List<String> repositoryNames;
    private List<String> issueNames;
    private List<String> milestoneNames;
    private String selectedRepository;
    private String repositoryJSON;


    // we need to list all repositories associated with this user
    // set the selected value to the repository being worked on last
    // use that repository to fill in the issues and milestones
    public String setupPage(){
        Database.getLastTimeSession( (int) session.get("userId") );
        listRepositories();

        return "success";
    }

    // when a repository is added the current user is linked to it
    public String addRepository() throws Exception{
        Repository repo = new Repository();
        repo.setGithubUrl(selectedRepository);
        int userId = (int) session.get("userId");

        if( selectedRepository == null )
            return "success";

        if( Database.exists(repo) )
            repo = Database.getRepository(this.githubUrl);

        Database.saveRepository(repo, userId);
        addActionMessage("Successfully Added Repository");

        return "success";
    }

    public String getRepositoryInfo() throws Exception{
        HttpClient httpclient = new DefaultHttpClient();
        Gson converter = new Gson();
        try{
            HttpGet httpget = new HttpGet("https://api.github.com/users/" + selectedRepository);
            httpget.getURI();

            //create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            // Body contains your json string
            String responseBody = httpclient.execute(httpget, responseHandler);

            Map<String, Object> response = converter.fromJson(responseBody, Map.class);
            //System.out.println(response.get("name"));

        }finally{
            httpclient.getConnectionManager().shutdown();
        }
        return "success";
    }

    public String listRepositories() {
        // we need to get a list of github urls from all repositories
        // that are connected to the user logged in
        int userId = (int) session.get("userId");
        repositoryNames = Database.getRepositories(userId);
        return "success";
    }

    // getters and setters
    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public String getGithubUrl() {
        return this.githubUrl;
    }
    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }
    public List<String> getRepositoryNames() {
        return repositoryNames;
    }
    public void setRepositoryNames(List<String> repositoryNames) {
        this.repositoryNames = repositoryNames;
    }
    public String getSelectedRepository() {
        return this.selectedRepository;
    }
    public void setSelectedRepository(String selectedRepository) {
        this.selectedRepository = selectedRepository;
    }
    public String getRepositoryJSON(){
        return repositoryJSON;
    }
    public void setRepositoryJSON(String repositoryJSON){
        this.repositoryJSON = repositoryJSON;
    }
}
