package com.bethgrace5.timetracker;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.commons.lang3.RandomStringUtils;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.lang.Object;

public class ClientAction extends ActionSupport implements SessionAware{
    private String name;
    private String email;
    private String userName;
    private String client;
    private Map<String, Object> session;
    private List<String> clients;
    private String selectedClient;

    /**
     * Registers New Client User account
     */
    public String execute(){
        String password = RandomStringUtils.randomAlphanumeric(15);
        //TODO: test if email is valid
        if(Database.existsUsernameEmail(userName, email)){
            return "error";
        }
        User user = new User(name, userName, email, "client", password);
        Integer userId = Database.saveUser(user);
        session.put("userId", user.getId());
        // TODO: automatically email userName and password to client.
        return "success";
    }

    public String listClients() {
        this.clients = Database.getClientUsers();
        return "success";
    }
    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
        return;
    }
    public List<String> getClients(){
        return clients;
    }
    public void setClients(List<String> clients){
        this.clients = clients;
    }
    public String getSelectedClient(){
        return selectedClient;
    }
    public void setSelectedClient(String selectedClient){
        this.selectedClient = selectedClient;
    }
    public String getClient(){
        return client;
    }
    public void setClient(String client){
        this.client = client;
    }
}
