package com.bethgrace5.timetracker;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.interceptor.SessionAware;

import java.lang.Object;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientAction extends ActionSupport implements SessionAware{
    private String name;
    private String email;
    private String userName;
    private String selectedClient;
    private String clientJSON;
    private boolean deactivated;
    private Map<String, Object> session;
    private List<String> clients;

    /**
     * Registers New Client User account
     */
    public String register(){
        //TODO: test if email is valid
        String password = RandomStringUtils.randomAlphanumeric(15);
        User user = new User(name, userName, email, "client", password);
        if(Database.exists(user)){
            addActionError("User or Email exists!");
            return "error";
        }
        Integer userId = Database.saveUser(user);
        session.put("userId", user.getId());
        // TODO: automatically email userName and password to client.
        addActionMessage("Client Successfully added.");
        return "success";
    }

    public String listClients() {
        this.clients = Database.getClientUsers();
        return "success";
    }
    public String getClient(){
        if(this.selectedClient != null ){
            return "success";
        }
        return "error";
    }

    public String getClientInfo(){
        if(this.selectedClient == null){
            this.selectedClient = "null Client";
            this.name = "null Name";
            this.email = "null Email";
            this.deactivated = false;
        }
        else{
            User user = Database.getUser(this.selectedClient);
            this.name =  user.getName();
            this.email =  user.getEmail();
            this.deactivated = user.getIsDeactivated();
        }
        Map<String, Object> map = new HashMap<String, Object>(); 
        Gson converter = new Gson();

        map.put("userName", selectedClient);
        map.put("name",  name);
        map.put("email",  email);
        map.put("deactivated", deactivated);
        this.clientJSON = converter.toJson(map);
        return "success";
    }

    public String setClientInfo(){
        User user = Database.getUser(this.selectedClient);
        user.setUserName(userName);
        user.setName(name);
        user.setEmail(email);
        user.setIsDeactivated(deactivated);

        if( user == null ){
            addActionMessage("Error Updating User");
            return "error";
        }
        Database.saveUser(user);
        addActionMessage("Successfully Updated " + this.userName);
        return "success";
    }
    public String deactivate(){
        User user = Database.getUser(this.selectedClient);
        if( Database.exists(user) ){
            user.setIsDeactivated(true);
            Database.saveUser(user);
            addActionMessage("Deactivated User: " + this.selectedClient);
            return "success";
        }
        return "error";
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
    }
    public String getClientJSON(){
        return clientJSON;
    }
    public void setClientJSON(String clientJSON){
        this.clientJSON = clientJSON;
    }
    public String getSelectedClient(){
        return selectedClient;
    }
    public void setSelectedClient(String selectedClient){
        this.selectedClient = selectedClient;
    }
    public boolean getDeactivated(){
        return deactivated;
    }
    public void setDeactivated(boolean deactivated){
        this.deactivated = deactivated;
    }
    public List<String> getClients(){
        return clients;
    }
    public void setClients(List<String> clients){
        this.clients = clients;
    }
}
