/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.LoadException;
import exceptions.StorageException;
import java.util.ArrayList;
import models.IModel;

/**
 *
 * @author Jacob
 */
public interface IDataSource {
    void load() throws LoadException;
    IModel getAddress(int id) throws StorageException;
    IModel getEmployee(int id)throws StorageException;
    IModel getItem(int id)throws StorageException;
    ArrayList<IModel> getItems()throws StorageException;
    IModel getMenu()throws StorageException;
    IModel getOrder(int id)throws StorageException;
    IModel getPizza(int id)throws StorageException;
    ArrayList<IModel> getToppings()throws StorageException;
    IModel getUser(int id)throws StorageException;
    IModel getUser(String userName, String password) throws StorageException;
    void saveAddress(IModel model)throws StorageException;
    void saveEmployee(IModel model)throws StorageException;
    void saveItem(IModel model)throws StorageException;
    void saveMenu(IModel model)throws StorageException;
    void saveOrder(IModel model)throws StorageException;
    void savePizza(IModel model)throws StorageException;
    void saveUser(IModel model)throws StorageException;
}
