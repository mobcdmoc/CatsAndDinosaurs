/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.LoadException;
import exceptions.StorageException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.ObservableList;
import models.IModel;

/**
 *
 * @author Jacob
 */
public interface IDataSource {
    void load() throws LoadException;
    
    IModel getEmployee(int id) throws StorageException;
    ObservableList<IModel> getEmployees() throws StorageException;
    IModel getItem(int id) throws StorageException;
    ObservableList<IModel> getItems() throws StorageException;
    IModel getMenu() throws StorageException;
    IModel getOrder(int id) throws StorageException;
    ObservableList<IModel> getOrders(int id) throws StorageException;
    ObservableList<IModel> getOrders() throws StorageException;//returns only active orders
    IModel getUser(int id) throws StorageException;
    IModel getUser(String userName, String password) throws StorageException;
    ObservableList<IModel> getUsers() throws StorageException;
    
    void saveEmployee(IModel model) throws StorageException;
    void saveEmployees(Collection<IModel> models) throws StorageException;
    void saveUser(IModel model) throws StorageException;
    void saveItem(IModel model)throws StorageException;
    void saveMenu(IModel model)throws StorageException;
    void saveOrder(IModel model)throws StorageException;
}
