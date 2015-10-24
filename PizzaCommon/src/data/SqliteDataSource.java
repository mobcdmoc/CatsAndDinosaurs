/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.LoadException;
import exceptions.StorageException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import models.*;

/**
 *
 * @author Jacob
 */
public class SqliteDataSource implements IDataSource{
    
    private String connectionString;
    private Connection connection;
    
    public SqliteDataSource(String connectionString)
    {
        this.connectionString = connectionString;
    }
    
    public void load() throws LoadException
    {
        try
        {
            connection = DriverManager.getConnection(connectionString);
        }
        catch(SQLException e)
        {
            throw new LoadException("Failure to load sqlConnection!", e);
        }
    }
    
    @Override
    public IModel getAddress(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getEmployee(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getItem(int id) throws StorageException{
        IModel rtn = new ItemModel();
        HashMap<String,Object> fields = new HashMap<String,Object>();
        try
        {
            Statement cmd = connection.createStatement();
            
            StringBuilder query = new StringBuilder("SELECT * FROM Item WHERE Id = '");
            query.append(id);
            query.append("'");
            
            
            ResultSet results = cmd.executeQuery(query.toString());
            //grab only the first one.
            results.next();
            
            fields = translateItem(results);
            
            rtn.load(fields);
            
            cmd.close();
        }
        catch(SQLException e)
        {
            throw new StorageException("Failed to fetch Item!", e);
        }
        catch(LoadException e)
        {
            
            throw new StorageException("Failed to translate data!", e);
        }
        
        return rtn;
    }
    
    private HashMap<String,Object> translateItem(ResultSet results) throws SQLException
    {
        HashMap<String,Object> fields = new HashMap<String,Object>();
        String idField = "id";
        String nameField = "name";
        String descriptionField = "description";
        String priceField = "price";
        String typeField = "type";
        fields.put(idField, results.getInt(idField));
        fields.put(nameField, results.getString(nameField));
        fields.put(descriptionField, results.getString(descriptionField));
        fields.put(priceField, results.getDouble(priceField));
        fields.put(typeField, results.getInt(typeField));
        return fields;
    }
    

    @Override
    public ArrayList<IModel> getItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getPizza(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IModel> getToppings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAddress(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveEmployee(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveItem(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveMenu(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrder(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void savePizza(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveUser(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
