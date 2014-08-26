package com.bethgrace5.timetracker;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class TimeSessionAction extends ActionSupport implements SessionAware{

    private double milesDriven;
    private double hourlyRate;
    private boolean inProgress;
    private String description;
    private String selectedRepository;
    private String selectedMilestone;
    private String selectedIssue;
    private User user;
    private Repository lastRepository;
    private TimeSession lastTimeSession;
    private Map<String, Object> session;
    private List<String> repositories = new ArrayList<String>();
    private List<String> milestones = new ArrayList<String>();
    private List<String> issues = new ArrayList<String>();
    private List<String> timeSessions = new ArrayList<String>();


    public String setupPage(){
        int userId = (int) session.get("userId");
        user = Database.getUserById(userId);

        repositories = Database.getRepositories(userId);

        // we need to get the last time session this user was working on
        // TODO: implement Database.getLastTimeSession()
        // lastTimeSession = Database.getLastTimeSession(userId);
        // lastRepository = lastTimeSession.getRepository();

        // page should display a stop button if the time is still running
        // if(lastTimeSession.getTimeStamp() == null){
            // inProgress = true;
        // }

        // fill in suggestions based on the last time session.
        // description = lastTimeSession.getDescription();
        // milesDriven = lastTimeSession.getMilesDriven();
        // hourlyRate = lastTimeSession.getHourlyRate();

        // fill in suggestions for repositories based on the user logged in
        // repositories = new ArrayList(Database.getRepositories(userId));

        // fill in suggestions for milestones and issues 
        // based on the last repository worked on.
        // milestones = new ArrayList(lastRepository.getMilestones());
        // issues = new ArrayList(lastRepository.getIssues());

        // we need to put the last repository on top of its list,
        // the last milestone on top of its list,
        // and the last issue on top of its list.

        // return "success";
        setupPageWithArtificialData();
        return "success";
    }
    // use for testing while no data is in database
    public String setupPageWithArtificialData(){

        // we need to get the last time session this user was working on
        // TODO: implement Database.getLastTimeSession()
        lastTimeSession = new TimeSession();
        // I added "github.com/repository as githubUrl to database
        lastRepository = Database.getRepository("github.com/repository");

        // page should display a stop button if the time is still running
        inProgress = false;

        // fill in suggestions based on the last time session.
        description = "artificially supplied description";
        milesDriven = 2;
        hourlyRate = 9.0;

        // fill in suggestions for repositories based on the user logged in
        //repositories = new ArrayList(Database.getRepositories(userId));

        // fill in suggestions for milestones and issues 
        // based on the last repository worked on.
        milestones = new ArrayList();
        milestones.add("artificial milestone1");
        milestones.add("artificial milestone2");
        issues = new ArrayList();
        issues.add("artificial issue1");
        issues.add("artificial issue2");

        return "success";
    }

    public String clearFields(){
        user = Database.getUserById((int) session.get("userId"));
        milesDriven = 0;
        hourlyRate = 0;
        inProgress = false;
        description = null;
        repositories = new ArrayList(Database.getRepositories(user.getId()));
        lastRepository = null;
        lastTimeSession = null;
        return "success";
    }

    public String startTimeSession(){
        // create a new time session from the fields filled in
        //if (lastTimeSession.getEndDate() != null )
            //return "sessionInProgress";

        int userId = (int) session.get("userId");
        user = Database.getUserById(userId);

        lastTimeSession = new TimeSession();
        lastTimeSession.setDescription(description);
        lastTimeSession.setUser(user);
        lastTimeSession.setRepository(Database.getRepository(selectedRepository));
        //lastTimeSession.setMilestone(Database.getMilestone(selectedMilestone));
        //lastTimeSession.setIssue(Database.getIssue(selectedIssue));
        lastTimeSession.setStartDate(new Timestamp(System.currentTimeMillis()));
        lastTimeSession.setEndDate(null);
        lastTimeSession.setMilesDriven(milesDriven);
        lastTimeSession.setHourlyRate(hourlyRate);

        //TODO: implement Database.saveTimeSession();
        Database.saveTimeSession(lastTimeSession);

        return "success";
    }

    public String stopTimeSession(){
        // cannot be stopped if no time session is running
        if( lastTimeSession.getEndDate() == null)
            return "sessionInProgress";
        // if displaying duration, set it to zero
        // get the currentTimeSession and set endDate to the current time
        //lastTimeSession.setEndDate(/*curent time*/);
        // save it in the database
        //Database.saveTimeSession(lastTimeSession);
        return "success";
    }

    //getters and setters
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String id) {
        this.description = description;
    }

    public boolean getInProgress(){
        return inProgress;
    }
    public void setInProgress(boolean inProgress){
        this.inProgress = inProgress;
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public double getMilesDriven() {
        return this.milesDriven;
    }
    public void setMilesDriven(double milesDriven) {
        this.milesDriven = milesDriven;
    }
    public List<String> getTimeSessions(){
        return timeSessions;
    }
    public double getHourlyRate() {
        return this.hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getSelectedRepository(){
        return selectedRepository;
    }
    public void setSelectedRepository(String selectedRepository){
        this.selectedRepository = selectedRepository;
    }
    public String getSelectedMilestone(){
        return selectedMilestone;
    }
    public void setSelectedMilestone(String selectedMilestone){
        this.selectedMilestone = selectedMilestone;
    }
    public String getSelectedIssue(){
        return selectedIssue;
    }
    public void setSelectedIssue(String selectedIssue){
        this.selectedIssue = selectedIssue;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public Repository getLastRepository(){
        return lastRepository;
    }
    public void setLastRepository(Repository lastRepository){
        this.lastRepository = lastRepository;
    }

    public TimeSession getLastTimeSession(){
        return lastTimeSession;
    }
    public void setLastTimeSession(TimeSession lastTimeSession){
        this.lastTimeSession = lastTimeSession;
    }

    public List<String> getRepositories(){
        return repositories;
    }
    public void setRepositories(List<String> repositories){
        this.repositories = repositories;
    }
    public List<String> getMilestones(){
        return milestones;
    }
    public void setMilestones(List<String> milestones){
        this.milestones = milestones;
    }
    public List<String> getIssues(){
        return issues;
    }
    public void setIssues(List<String> issues){
        this.issues = issues;
    }
}
