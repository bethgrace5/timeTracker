package com.bethgrace5.timetracker;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class RepositoryAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private String githubUrl;
    private List<String> repositoryNames;
    private String selectRepository;

    public String addRepository() {
        Repository repo = new Repository();
        repo.setGithubUrl(selectRepository);
        int userId = (int) session.get("userId");

        if( selectRepository == null )
            return "success";


        if( Database.exists(repo) )
            repo = Database.getRepository(this.githubUrl);


        // when a repository is saved, it also connects the current
        // user to the repository

        Database.saveRepository(repo, userId);
        addActionMessage("Successfully Added Repository");
        return "success";
    }

    public String listRepositories() {
        // we need to get a list of github urls from all repositories
        // that are connected to the user logged in
        int userId = (int) session.get("userId");
        repositoryNames = Database.getRepositories(userId);
        return "success";
    }

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
        return this.selectRepository;
    }
    public void setSelectedRepository(String selectRepository) {
        this.selectRepository = selectRepository;
    }

}
