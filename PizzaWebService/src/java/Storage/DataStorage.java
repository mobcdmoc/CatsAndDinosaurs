/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import data.IDataContext;
import data.SqliteDbContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.IModel;
import models.UserModel;

/**
 *
 * @author Jacob
 */
public class DataStorage implements IDataContext {
    /*NOTE: This class contains many sql statements. In actual systems it is
    better practice to use a system like the entity framework, or even table
    adapters. However in the interest of time, and because i don't know of any 
    such systems in java we're doing this a litte dirty.
    */
    SqliteDbContext context;
    public DataStorage()
    {
        
    }
    
    /**
     *
     * @throws SQLException
     */
    @Override
    public void load()
    {
        try
        {
            context = new SqliteDbContext("jdbc:sqlite:src/playground/resources/PizzaDb.db");
        }
        catch(Exception e)
        {
            //TODO: maybe do something here?
            //eat it for now
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
    public IModel getItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        IModel user = new UserModel();
        
        ResultSet userResult = context.executeQuery("SELECT * FROM Users WHERE Id = '"+id+"'");
        if(userResult == null)
            return null;
        
//        while(userResult.next())
//        {
//            
//        }
        
        
        return user;
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
