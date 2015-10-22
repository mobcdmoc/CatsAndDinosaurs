/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import models.IModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jacob
 */
public class SqliteDbContext {
    Connection connection;
    
    public SqliteDbContext(String connectionString) throws SQLException
    {
        connection = DriverManager.getConnection(connectionString);

    }
    
    public ResultSet executeQuery(String query)
    {
        ResultSet results = null;
        try
        {
            Statement statement = connection.createStatement();
            results = statement.executeQuery(query);
        }
        catch(Exception e)
        {
            //Eat it for now
        }
        return results;
    }
    
    public boolean executeNonQuery(String query)
    {
        boolean results = false;
        try
        {
            Statement statement = connection.createStatement();
            results = statement.execute(query);
        }
        catch(Exception e)
        {
            //Eat it for now
        }
        return results;
    }
    
}
