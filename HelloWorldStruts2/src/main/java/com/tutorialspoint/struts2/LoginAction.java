
package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
    private String user;
    private String password;
    private String name;


    /**
     * Load JDBC Driver by opening a connection
     *
     */
    public String execute(){
        String ret = ERROR;
        Connection connection = null;

        try{
            String url = "jdbc:h2:~/test"; //database
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, "sa", "");
            String sql = "SELECT FIRST_NAME FROM PERSON WHERE ";
            sql+=" ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                name = rs.getString(2);
                ret = SUCCESS;
            }
        } catch (Exception e) {
            ret = ERROR;
        } finally{
            if( connection != null){
                try {
                connection.close();
            } catch (Exception e){
            }
        }
    }

        return "success";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
        return;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
        return;
    }


}

