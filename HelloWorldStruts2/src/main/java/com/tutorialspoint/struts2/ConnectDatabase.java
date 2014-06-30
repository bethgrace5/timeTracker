
package com.tutorialspoint.struts2;

import java.sql.*;

public class ConnectDatabase{


    /**
     * Load JDBC Driver by opening a connection
     *
     */
    public void openConnection(){
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:~/test"; //database
        String user = "sa";
        String password = "";
        Connection connection = DriverManager.getConnection(
             url, user, password);

        return;
    }

    /**
     * Close connection
     */
    public void closeConnection(){

    connection.close();
    return;
    }

    /**
     * set up a table to query
     */
    public void initializeDatabase(){
        /* set up a test database with H2.
         to use addData(), the database needs a PERSON table with
         columns: (ID, FIRST_NAME, LAST_NAME, AGE)
         TODO: erase existing test database, and initialize it here*/

         return;
    }

    /**
     * insert data into existing person table
     */
    public void addData(){
        Statement statement = connection.createStatement();
        String addData = " INSERT INTO PERSON VALUES (123, 'firstOne', 'lastOne', 11); INSERT INTO PERSON VALUES (456, 'firstTwo', 'lastTwo', 11); INSERT INTO PERSON VALUES (789, 'firstThree', 'lastThree', 11);";
        statement.execute(addData);

        statement.close();
        return;
    }

    /**
     * view data that was inserted into person table
     */
    public void queryDatabase(){
        Statement statement = connection.createStatement();
        String sql = "Select * from person";
        ResultSet result = statement.executeQuery(sql);

        // iterating result set
        while(result.next()){
            System.out.println(result.getInt(1)); //ID
            System.out.println(result.getString(2)); // FIRST_NAME
            System.out.println(result.getString(3)); // LAST_NAME
            System.out.println(result.getInt(4)); // AGE
        }

        result.close();
        statement.close();
        return;
    }

    /**
     * Update records
     */
    public void updateRecords(){
        Statement statement = connection.createStatement();
        String sql = "update people set name='John' where id=123";
        int rowsAffected = statement.executeUpdate(sql);

        statement.close();
        return;
    }

    /**
     * Delete records
     */
    public void deleteRecords(){
        Statement statement = connection.createStatement();
        String sql = "delete from people where id=123";
        int rowsAffected = statement.executeUpdate(sql);

        statement.close();
        return;
    }
}
