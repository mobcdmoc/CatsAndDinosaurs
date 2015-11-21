/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.testObjects;

import cs414.a5.nwalling.data.IDataSource;
import cs414.a5.nwalling.exceptions.LoadException;
import cs414.a5.nwalling.exceptions.StorageException;
import java.util.ArrayList;
import cs414.a5.nwalling.models.IItemModel;
import cs414.a5.nwalling.models.IMenuModel;
import cs414.a5.nwalling.models.IModel;
import cs414.a5.nwalling.models.IOrderModel;
import cs414.a5.nwalling.models.IPaymentModel;
import cs414.a5.nwalling.models.IUserModel;
import cs414.a5.nwalling.models.ItemModel;
import cs414.a5.nwalling.models.UserModel;

/**
 *
 * @author danru
 */
public class TestIDataSource implements IDataSource {

    @Override
    public void load() throws LoadException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemModel getItem(int id) throws StorageException {
        return new TestIItemModel();
    }

    @Override
    public ArrayList<IItemModel> getItems() throws StorageException {
        return null;
    }

    @Override
    public IMenuModel getMenu() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOrderModel getOrder(int id) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IOrderModel> getOrders(int id) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IOrderModel> getOrders() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IUserModel getUser(int id) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IUserModel getUser(String userName, String password) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IUserModel> getUsers() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveUser(IUserModel model) throws StorageException {
        
    }

    @Override
    public void saveItem(IItemModel model) throws StorageException {
               
    }

    @Override
    public void saveMenu(IMenuModel model) throws StorageException {
        
    }

    @Override
    public void saveOrder(IOrderModel model) throws StorageException {
        
    }

    @Override
    public void savePayment(IPaymentModel model) throws StorageException {
        
    }

    @Override
    public boolean validateUsername(String name) throws StorageException {
        
        if(name == "BAD")
            throw new StorageException();
        return Boolean.parseBoolean(name);
    }

//    @Override
//    public void load() throws LoadException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IModel getItem(int id) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<IModel> getItems() throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IModel getMenu() throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IModel getOrder(int id) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<IModel> getOrders(int id) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<IModel> getOrders() throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IModel getUser(int id) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IModel getUser(String userName, String password) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<IModel> getUsers() throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    
//    
//    @Override
//    public void saveUser(IModel model) throws StorageException {
//        if(((UserModel)model).getId() < 1)
//            throw new StorageException();
//    }
//
//    @Override
//    public void saveItem(IModel model) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveMenu(IModel model) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveOrder(IModel model) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void savePayment(IModel model) throws StorageException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean validateUsername(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
