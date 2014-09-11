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
    private List<String> repositoryNames;
    private List<String> issueNames;
    private List<String> milestoneNames;
    private String selectedRepository;
    private String selectedStatus;
    private String repositoryJSON;
    private String repositoryName;
    private Repository repo;


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
        repo = new Repository();
        repo = Database.getRepository(this.selectedRepository);
        int userId = (int) session.get("userId");

        if( repo!=null ){
            // connect the user with it in the database
            Database.saveRepository( repo, userId );
        }
        else {
            // adds repository to database if it exists on github.
            // connects user with new repository
            // error message if repository does not exist on github.
            getRepositoryInfo();
        }

        return "success";
    }

    public boolean getRepositoryInfo() throws Exception{
        int userId = (int) session.get("userId");
        HttpClient httpclient = new DefaultHttpClient();
        Gson converter = new Gson();

        HttpGet httpget = new HttpGet("https://api.github.com/repos/" + selectedRepository);
        httpget.getURI();

        //create a response handler
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        // Body contains your json string

        try{
            String responseBody = httpclient.execute(httpget, responseHandler);
            Map<String, Object> response = converter.fromJson(responseBody, Map.class);
            repo = new Repository();
            repo.setName((String) response.get("full_name"));

            repo.setGithubId( (Double) response.get("id") );
            //repo.setGithubId( 12345 );

            repositoryName = repo.getName();
            repo.setStatus(RepositoryStatus.InProgress.toString());

            Database.saveRepository(repo, userId);
        }
        catch (HttpResponseException e){
            System.out.println(e);
            httpclient.getConnectionManager().shutdown();
            return false;
        }
        finally{
            httpclient.getConnectionManager().shutdown();
        }
        return true;
    }

    public String listRepositories() {
        // we need to get a list of full names from all repositories
        // that are connected to the user logged in
        int userId = (int) session.get("userId");
        repositoryNames = Database.getRepositories(userId);
        return "success";
    }

    public String updateStatus(){

        Repository repository = Database.getRepository(selectedRepository);
        repository.setStatus( selectedStatus );
        //System.out.println("selected repo: " + selectedRepository );
        //System.out.println("status: " + selectedStatus );

        Database.updateRepositoryStatus(repository, selectedStatus);

        return "success";
    }

    // getters and setters
    public void setSession(Map<String, Object> session){
        this.session = session;
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
    public String getSelectedStatus() {
        return this.selectedStatus;
    }
    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }
    public String getRepositoryJSON(){
        return repositoryJSON;
    }
    public void setRepositoryJSON(String repositoryJSON){
        this.repositoryJSON = repositoryJSON;
    }
    public String getRepositoryName(){
        return repositoryName;
    }
    public void setRepositoryName(String repositoryName){
        this.repositoryName = repositoryName;
    }
}
