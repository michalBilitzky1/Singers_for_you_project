package com.example.myapplicationtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

/**
 * A class that handles
 * the connection to DataBase.
 */
public class DBConnection {

    private java.sql.Connection conn; // DB connection
    private static DBConnection instance;

    /**
     * constructor
     */
    private DBConnection() { }

    /**
     * singleton function
     * @return the instance of DBconnection
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
            instance.openConnection();
        }
        return instance;
    }

    /**
     * return the connection to sql object
     * @return connection to sql object
     */
    public java.sql.Connection getConnection() {
        return conn;
    }
    /**
     * Open the connection to the DB
     * @return true if the connection was successfully set
     */
    public boolean openConnection() {

        System.out.print("Trying to connect... ");
        //reading the details of url, username and password of my schema from configuration connection file

        BufferedReader br;
       /* String fileName = "src/DataBase/dbconnectionconfig.txt";
        try {
            br = new BufferedReader(new FileReader(fileName));
            //the parameters for connection to DB.
            url = br.readLine().replace("url: ","");
            username = br.readLine().replace("username: ","");
            password = br.readLine().replace("password: ","");
        } catch (Exception e) {
            System.out.println("couldn't read from configuration file - " + e.getMessage());
        }*/
        // creating the connection. Parameters should be taken from config file.

        String host = "35.225.34.63";
        String port = "3306";
        String schema = "dbProject";
        String user = "root";
        String password = "0542015460mb";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + schema, user, password);
        } catch (SQLException e) {
            System.out.println("Unable to connect - " + e.getMessage());
            conn = null;
            return false;
        }
        System.out.println("Connected!");
        return true;
    }

    /**
     * close the connection
     */
    public void closeConnection() {
        // closing the connection
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Unable to close the connection - " + e.getMessage());
        }

    }
}
