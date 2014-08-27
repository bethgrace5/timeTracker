package com.bethgrace5.timetracker;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
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
    private Map<String, Object> response;
    private Repository repository;

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
        repository = Database.getRepository(this.githubUrl);

        if( repository == null ){
            if( !getRepositoryFromGithub( selectedRepository )){
                // repositorty does not exist on github
                return "error";
            }
        }
        addActionMessage("Successfully Added Repository");
        return "success";
    }

    public boolean getRepositoryFromGithub( String repoFullName) throws Exception{
        //System.out.println(repoFullName);
        HttpClient httpclient = new DefaultHttpClient();
        Gson converter = new Gson();
        try{
            HttpGet httpget = 
                //repoName must be formatted "owner/repository"
                new HttpGet("https://api.github.com/repos/" + repoFullName);
            httpget.getURI();

            //create a response handler
            ResponseHandler<String> responseHandler = 
                new BasicResponseHandler();
            // Body contains json string
            try{
                String responseBody = httpclient.execute(httpget, responseHandler);
                response = converter.fromJson(responseBody, Map.class);
            }
            catch(HttpResponseException e){
                return false;
            }
            String name = (String) response.get("name");
            //System.out.println(name);
            repository = new Repository();

            // repositories are automatically set as "in progress"
            repository.setStatus( RepositoryStatus.InProgress );
            repository.setName(name);

            int userId = (int) session.get("userId");
            Database.saveRepository( repository, userId);

        }finally{
            httpclient.getConnectionManager().shutdown();
        }
        return true;
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
