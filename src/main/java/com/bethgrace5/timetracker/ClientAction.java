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
    private String selectedClient;
    private String name;
    private String clientUserName;
    private String clientJSON;
    private boolean deactivated;
    private Map<String, Object> session;
    private List<String> clients;

    public String listClients() {
        this.clients = Database.getClientUsers();
        return "success";
    }
    public String register(User user){
        //TODO: test if userName is a valid Email

        String password = RandomStringUtils.randomAlphanumeric(15);
        user = new User(selectedClient, clientUserName, "client", password);
        Integer userId = Database.saveUser(user);
        // TODO: automatically email clientUserName and password to client.
        addActionMessage("Client Successfully added.");
        return "success";
    }
    public String getClientInfo(){
        User user = Database.getUserByName(this.selectedClient);

        Map<String, Object> map = new HashMap<String, Object>(); 
        Gson converter = new Gson();

        map.put("selectedClient",  user.getName());
        map.put("name",  user.getName());
        map.put("userName", user.getUserName());
        map.put("deactivated", user.getIsDeactivated());

        this.clientJSON = converter.toJson(map);
        return "success";
    }

    public String setClientInfo(){
        User user = Database.getUserByName(this.selectedClient);

        // we need to add the user if they do not exist
        if(user == null){
            System.out.println("useris null\n");
            register(user);
            return "success";
        }

        if( clientUserName.equals("") || name.equals("") ){
            addActionMessage("Client must have name and email!");
            return "success";
        }

        selectedClient = clientUserName;
        user.setUserName(clientUserName);
        user.setName(name);
        user.setIsDeactivated(deactivated);

        Database.saveUser(user);
        addActionMessage("Successfully Updated " + name);
        return "success";
    }
    public String deactivate(){
        User user = Database.getUserByName(selectedClient);
        if( Database.exists(user) ){
            user.setIsDeactivated(true);
            Database.saveUser(user);
            addActionMessage("Deactivated User: " + this.selectedClient);
            return "success";
        }
        return "error";
    }
    // getters and setters
    public void setSession(Map<String, Object> session){
        this.session = session;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getClientUserName(){
        return clientUserName;
    }
    public void setClientUserName(String clientUserName){
        this.clientUserName = clientUserName;
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
