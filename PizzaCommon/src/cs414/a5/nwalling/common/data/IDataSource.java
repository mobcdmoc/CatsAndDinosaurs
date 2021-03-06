/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.common.data;

import cs414.a5.nwalling.common.models.IOrderModel;
import cs414.a5.nwalling.common.models.IItemModel;
import cs414.a5.nwalling.common.models.IPaymentModel;
import cs414.a5.nwalling.common.models.IMenuModel;
import cs414.a5.nwalling.common.models.IUserModel;
import cs414.a5.nwalling.common.exceptions.LoadException;
import cs414.a5.nwalling.common.exceptions.StorageException;
import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public interface IDataSource {
    void load() throws LoadException;
    
    IItemModel getItem(int id) throws StorageException;
    ArrayList<IItemModel> getItems() throws StorageException;
    IMenuModel getMenu() throws StorageException;
    IOrderModel getOrder(int id) throws StorageException;
    ArrayList<IOrderModel> getOrders(int id) throws StorageException;
    ArrayList<IOrderModel> getOrders() throws StorageException;//returns only active orders
    ArrayList<IItemModel> getOrderItems(int id) throws StorageException;
    ArrayList<IItemModel> getOrderItems() throws StorageException;
    IUserModel getUser(int id) throws StorageException;
    IUserModel getUser(String userName, String password) throws StorageException;
    ArrayList<IUserModel> getUsers() throws StorageException;
//    ObservableList<IModel> getOrderItems() throws StorageException;
    void saveUser(IUserModel model) throws StorageException;
    void saveItem(IItemModel model)throws StorageException;
    void saveMenu(IMenuModel model)throws StorageException;
    void saveOrder(IOrderModel model)throws StorageException;
    void savePayment(IPaymentModel model) throws StorageException;
    
    boolean validateUsername(String name) throws StorageException;
}
