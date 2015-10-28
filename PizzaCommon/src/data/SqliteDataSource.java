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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    @Override
    public void load() throws LoadException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connectionString);
        }
        catch(SQLException e)
        {
            throw new LoadException("Failure to load sqlConnection!", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqliteDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private <K extends AbstractModel> IModel executeQuery(Class<K> modelClass,String query) throws StorageException
    {   
        try (Statement cmd = connection.createStatement()) {
            K model = modelClass.newInstance();
            HashMap<String,Object> fields = new HashMap<>();
            ResultSet results = cmd.executeQuery(query);
            //grab only the first one.
            
            if(results.next())
            {
                fields = translateItem(results);
                model.load(fields);
                return model;
            }
            return null;
        }
        catch(SQLException e)
        {
            throw new StorageException("Failed to fetch Item!", e);
        }
        catch(LoadException e)
        {
            throw new StorageException("Failed to translate data!", e);
        } 
        catch (InstantiationException e) 
        {
            throw new StorageException("Failed to instantiate provided Type! Type: " + modelClass.toString(), e);
        } 
        catch (IllegalAccessException e) 
        {
            throw new StorageException("\"Failed to instantiate provided Type! Type: " + modelClass.toString(), e);
        }
        catch(Exception e)
        {
            throw new StorageException("Something went horribly wrong!");
        }
    }
    private <K extends AbstractModel> ArrayList<IModel> executeQueryMultiple (Class<K> modelClass, String query) throws StorageException
    {
        try (Statement cmd = connection.createStatement()) {
            ArrayList<IModel> rtn = new ArrayList<>();
            
            ResultSet results = cmd.executeQuery(query);
            while(results.next())
            {
                K model = modelClass.newInstance();
                HashMap<String,Object> fields = new HashMap<>();
                fields = translateItem(results);
                model.load(fields);
                rtn.add(model);
            }
            return rtn;
        }
        catch(SQLException e)
        {
            throw new StorageException("Failed to fetch Item!", e);
        }
        catch(LoadException e)
        {
            throw new StorageException("Failed to translate data!", e);
        } 
        catch (InstantiationException e) 
        {
            throw new StorageException("Failed to instantiate provided Type! Type: " + modelClass.toString(), e);
        } 
        catch (IllegalAccessException e) 
        {
            throw new StorageException("\"Failed to instantiate provided Type! Type: " + modelClass.toString(), e);
        }
        catch(Exception e)
        {
            throw new StorageException("Something went horribly wrong!");
        }
    }
    private HashMap<String,Object> translateItem(ResultSet results) throws SQLException
    {
        HashMap<String,Object> fields = new HashMap<>();
        
        ResultSetMetaData mt = results.getMetaData();
        for(int i = 1; i < mt.getColumnCount()+1; i++)
        {
            fields.put(mt.getColumnName(i).toLowerCase(), results.getObject(i));
        }
        return fields;
    }

    private void executeNonQuery(String query) throws StorageException
    {
        try (Statement cmd = connection.createStatement()) {
            cmd.execute(query);
        }
        catch(SQLException e)
        {
            throw new StorageException("Failed to fetch Item!", e);
        }
        catch(Exception e)
        {
            throw new StorageException("Something went horribly wrong!");
        }
    }
    
//    @Override
//    public IModel getEmployee(int id) {
//        IModel rtn = new MenuModel();
//        return rtn;
//    }

    @Override
    public IModel getItem(int id) throws StorageException
    {
        StringBuilder query = new StringBuilder("SELECT * FROM Items WHERE Id = '");
        query.append(id);
        query.append("' AND IsActive = 'true'");
        IModel rtn = executeQuery(ItemModel.class,query.toString());
        return rtn;
    }
    
    @Override
    public ArrayList<IModel> getItems() throws StorageException{
        String query = "SELECT * FROM Items WHERE Type > 3 AND IsActive = 'true'";
        ArrayList<IModel> rtn = executeQueryMultiple(ItemModel.class, query);
        return rtn;
    }
    
    @Override
    public IModel getMenu() throws StorageException {
        String query = "SELECT * FROM Items WHERE Type > 3 AND IsActive = 'true'";
        
        ArrayList<IModel> items = executeQueryMultiple(ItemModel.class, query);
        IModel rtn = new MenuModel();
        ((MenuModel)rtn).setItems(items);
        
        return rtn;
    }

    @Override
    public IModel getOrder(int id) throws StorageException {
        StringBuilder query = new StringBuilder("SELECT * FROM Orders WHERE id = '");
        query.append(id).append("'");
        
        IModel rtn = executeQuery(OrderModel.class, query.toString());
        
        if(rtn == null)
            return null;
                
//        StringBuilder itemQuery = new StringBuilder("SELECT * FROM Items as i JOIN ItemOrder as o ON o.ItemId = i.id WHERE o.OrderId = '");
//        itemQuery.append(((OrderModel)rtn).getId());
//        itemQuery.append("'");
//        
//        ObservableList<IModel> items = executeQueryMultiple(ItemModel.class,itemQuery.toString());
//        
//        ((OrderModel)rtn).setItems(FXCollections.observableArrayList(items));

        return rtn;
    }
    @Override
    public ArrayList<IModel> getOrders() throws StorageException {
        String query = "SELECT * FROM Orders";
        
        ArrayList<IModel> orders = executeQueryMultiple(OrderModel.class, query);
        
//        for(IModel model : orders)
//        {
//            StringBuilder itemQuery = new StringBuilder("SELECT * FROM Items as i JOIN ItemOrder as o ON o.ItemId = i.id WHERE o.OrderId = '");
//            itemQuery.append(((OrderModel)model).getId());
//            itemQuery.append("'");
        
//            ObservableList<IModel> items = executeQueryMultiple(ItemModel.class,itemQuery.toString());
//            ((OrderModel)model).setItems(FXCollections.observableArrayList(items));
//        }
        
        return orders;
    }

    @Override
    public ArrayList<IModel> getOrders(int id) throws StorageException {
        StringBuilder query = new StringBuilder("SELECT * FROM Orders WHERE UserId = '");
        query.append(id);
        query.append("'");
        
        ArrayList<IModel> orders = executeQueryMultiple(OrderModel.class, query.toString());
        
//        for(IModel model : orders)
//        {
//            StringBuilder itemQuery = new StringBuilder("SELECT * FROM Items as i JOIN ItemOrder as o ON o.ItemId = i.id WHERE o.OrderId = '");
//            itemQuery.append(((OrderModel)model).getId());
//            itemQuery.append("'");
        
//            ObservableList<IModel> items = executeQueryMultiple(ItemModel.class,itemQuery.toString());
//            ((OrderModel)model).setItems(FXCollections.observableArrayList(items));
//        }
        
        return orders;
    }

    @Override
    public ArrayList<IModel> getUsers() throws StorageException {
        String query = "SELECT * FROM Users";
        
        ArrayList<IModel> rtn = executeQueryMultiple(UserModel.class, query);
        return rtn;
    }
    
    @Override
    public IModel getUser(int id) throws StorageException {
        StringBuilder query = new StringBuilder("SELECT * FROM Users WHERE Id = '");
        query.append(id).append("'");
        
        IModel rtn = executeQuery(UserModel.class,query.toString());
        return rtn;
    }

    @Override
    public IModel getUser(String userName, String password) throws StorageException {
        StringBuilder query = new StringBuilder("SELECT * FROM Users WHERE UserName = '");
        query.append(userName).append("' AND Password = '");
        query.append(password).append("'");
        
        IModel rtn = executeQuery(UserModel.class,query.toString());
        return rtn;
    }
    
//    @Override
//    public void saveEmployee(IModel model) throws StorageException {
//        
//        EmployeeModel emp = (EmployeeModel)model;
//        
//        String query = null;
//        
//        if(emp.getId() > 0)
//            query = String.format("UPDATE Employees SET PayRate = '{0}', EmployeeStatus = '{1}' WHERE Id = '{2}'", emp.getPayRate(), emp.getEmployeeStatus, emp.getId());
//        else 
//            query = String.format("INSERT INTO Employees VALUES ('{0}','{1}','{2}'", emp.getId(),emp.getPayRate(),emp.getEmpStatus);
//        
//        executeNonQuery(query);
//    }

    @Override
    public void saveItem(IModel model) throws StorageException {
        ItemModel m = (ItemModel)model;
        StringBuilder query = new StringBuilder();
        if(m.getId() < 1)
        {
            query.append("INSERT INTO Items (Name,Description,Price,Type,SpecialPrice,IsSpecial,IsActive) VALUES ('");
            query.append(m.getName()).append("', '");
            query.append(m.getDescription()).append("', '");
            query.append(m.getPrice()).append("', '");
            query.append(m.getType().getValue()).append("', '");
            query.append(m.getSpecialPrice()).append("', '");
            query.append(m.getIsSpecial()).append("', '");
            query.append(m.getIsActive()).append("')");
        }
        else
        {
            query.append("UPDATE Items  SET Name = '");
            query.append(m.getName()).append("', Description = '");
            query.append(m.getDescription()).append("', Price = '");
            query.append(m.getPrice()).append("', IsSpecial = '");
            query.append(m.getIsSpecial()).append("', SpecialPrice = '");
            query.append(m.getSpecialPrice()).append("', IsSpecial = '");
            query.append(m.getIsSpecial()).append("', IsActive = '");
            query.append(m.getIsActive()).append("', Type = '");
            query.append(m.getType().getValue()).append("' WHERE Id = '");
            query.append(m.getId()).append("'");
        }
       
        executeNonQuery(query.toString());
    }

    @Override
    public void saveMenu(IModel model) throws StorageException {
        MenuModel m = (MenuModel)model;
        
        for(int i = 0; i< m.getItems().size(); i++)
        {
            IModel n = (IModel)m.getItems().get(i);
            saveItem(n);
        }
    }

    @Override
    public void saveOrder(IModel model) throws StorageException {
        OrderModel m = (OrderModel)model;
        StringBuilder query = new StringBuilder();
        if(m.getId() < 1)
        {
            query.append("INSERT INTO Users (UserId,StatusId) VALUES ('");
            query.append(m.getUser()).append("', '");
            query.append(m.getStatus()).append("')");
        }
        else
        {
            query.append("UPDATE Users  SET UserId = '");
            query.append(m.getUser()).append("', StatusId = '");
            query.append(m.getStatus()).append("' WHERE Id = '");
            query.append(m.getId()).append("'");
        }
       
        executeNonQuery(query.toString());
    }

    @Override
    public void saveUser(IModel model) throws StorageException {
        UserModel m = (UserModel)model;
        StringBuilder query = new StringBuilder();
        if(m.getId() < 1)
        {
            query.append("INSERT INTO Users (UserName,Password,FirstName,MiddleName,LastName,AddressId,AuthLevelId) VALUES ('");
            query.append(m.getUserName()).append("', '");
            query.append(m.getPassword()).append("', '");
            query.append(m.getFirstName()).append("', '");
            query.append(m.getMiddleName()).append("', '");
            query.append(m.getLastName()).append("', '");
            query.append(m.getAddress()).append("', '");
            query.append(m.getAuthLevel()).append("')");
        }
        else
        {
            query.append("UPDATE Users  SET UserName = '");
            query.append(m.getUserName()).append("', Password = '");
            query.append(m.getPassword()).append("', FirstName = '");
            query.append(m.getFirstName()).append("', MiddleName = '");
            query.append(m.getMiddleName()).append("', LastName = '");
            query.append(m.getLastName()).append("', AddressId = '");
            query.append(m.getAddress()).append("', AuthLevelId = '");
            query.append(m.getAuthLevel()).append("' WHERE Id = '");
            query.append(m.getId()).append("'");
        }
       
        executeNonQuery(query.toString());
    }
//
//    @Override
//    public ObservableList<IModel> getEmployees() throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveEmployees(Collection<IModel> models) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
