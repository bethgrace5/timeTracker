package com.bethgrace5.timetracker;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class RepositoryAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private String githubUrl;

    public String addRepository(){
        Repository repo = new Repository();
        repo.setGithubUrl(githubUrl);
        int userId = (int) session.get("userId");

        if( Database.exists(repo) ){
            repo = Database.getRepository(this.githubUrl);
        }

        Database.saveRepository(repo, userId);
        addActionMessage("Successfully Added Repository");
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

}
