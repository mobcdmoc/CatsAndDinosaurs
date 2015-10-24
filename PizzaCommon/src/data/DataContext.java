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
public class DataContext implements IDataSource {
    protected IDataSource dataSource;
    public DataContext(IDataSource source)
    {
        this.dataSource = source;
    }
    
    @Override
    public IModel getAddress(int id) throws StorageException {
        return dataSource.getAddress(id);
    }

    @Override
    public IModel getEmployee(int id) throws StorageException {
        return dataSource.getEmployee(id);
    }

    @Override
    public IModel getItem(int id) throws StorageException {
        return dataSource.getItem(id);
    }

    @Override
    public ArrayList<IModel> getItems() throws StorageException {
        return dataSource.getItems();
    }

    @Override
    public IModel getMenu() throws StorageException {
        return dataSource.getMenu();
    }

    @Override
    public IModel getOrder(int id) throws StorageException {
        return dataSource.getOrder(id);
    }

    @Override
    public IModel getPizza(int id) throws StorageException {
        return dataSource.getPizza(id);
    }

    @Override
    public ArrayList<IModel> getToppings() throws StorageException {
        return dataSource.getToppings();
    }

    @Override
    public IModel getUser(int id) throws StorageException {
        return dataSource.getUser(id);
    }

    @Override
    public void saveAddress(IModel model) throws StorageException {
        dataSource.saveAddress(model);
    }

    @Override
    public void saveEmployee(IModel model) throws StorageException{
        dataSource.saveEmployee(model);
    }

    @Override
    public void saveItem(IModel model) throws StorageException {
        dataSource.saveItem(model);
    }

    @Override
    public void saveMenu(IModel model) throws StorageException {
        dataSource.saveMenu(model);
    }

    @Override
    public void saveOrder(IModel model) throws StorageException {
        dataSource.saveOrder(model);
    }

    @Override
    public void savePizza(IModel model) throws StorageException {
        dataSource.savePizza(model);
    }

    @Override
    public void saveUser(IModel model) throws StorageException {
        dataSource.saveUser(model);
    }

    @Override
    public void load() throws LoadException {
        dataSource.load();
    }
    
}
