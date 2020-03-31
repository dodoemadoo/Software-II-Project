package com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection implements DB_Connection {
public static SqlConnection instance;
    
    // Database URL
    public final String DB_URL = "jdbc:sqlserver://SQL5053.site4now.net:1433;databaseName=DB_A56FD2_OnlineShipping";

    // Database credentials
    public final String USERNAME = "DB_A56FD2_OnlineShipping_admin";
    public final String PASSWORD = "fcai20170061";
    
    // Connection is the session between java application and database
    private Connection connection;
    
    // The Statement interface provides methods to execute queries with the database
    public Statement statement;
    
    // The query string value to the database
    public String query;
    
    // The object of ResultSet maintains a cursor pointing to a row of a table
    public ResultSet resultSet;
    
    private SqlConnection() throws SQLException 
    {
        try
        {
            // Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  

            // Open a connection
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);  
            System.out.println("Sucess");
        }
        catch(Exception _ex)
        {
        	System.out.println("failed");
            System.out.println(_ex.getMessage());
        }
        
    }
    
    public Connection getConnection() 
    {
        return this.connection;
    }
    
    public static SqlConnection getInstance() throws SQLException 
    {
        if(instance == null)
        {
            instance = new SqlConnection();
        }
        else if(instance.getConnection().isClosed())
        {
            instance = new SqlConnection();
        }
        
        return instance;
    }
    
    public ResultSet selectData(String _query) throws Exception
    {
        this.query = _query;
        
        // Creating statement
        this.statement = this.connection.createStatement();
        
        // Execute query
        this.resultSet = this.statement.executeQuery(_query);
        while(resultSet.next())
        {
            System.out.println(resultSet.getInt("UID")+" "+resultSet.getString("UserType"));
        }
        return this.resultSet;
    }
    
    public void executeCommand(String _query) throws Exception
    {
        this.query = _query;
        
        // Creating statement
        this.statement = this.connection.createStatement();
        
        // Execute query
        this.statement.executeUpdate(_query);
    }
    
    @Override
    public void finalize() throws Throwable
    {
        try 
        {
            // Clean-up environment
            this.resultSet.close();
            this.statement.close();
            this.connection.close();
        } 
        finally 
        {
            super.finalize();
        }
    }
}
