/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import data.IDataSource;
import exceptions.StorageException;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jacob
 */
public class MenuModel extends AbstractModel {
    public static final String PROP_ITEMS = "items";
    
    private ObservableList<IModel> items;
    
    public MenuModel() {
        super();
        items = FXCollections.observableArrayList();
    }
    
    public MenuModel(IDataSource source)
    {
        super(source);
        items = FXCollections.observableArrayList();
    }
    
    public ObservableList<IModel> getItems()
    {
        return items;
    }
    public void setItems(ObservableList<IModel> value)
    {
        ObservableList<IModel> oldValue = items;
        items = value;
        propertySupport.firePropertyChange(PROP_ITEMS, oldValue, items);
    }
    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel get(int id) {
        try
        {
            ObservableList i = dataSource.getItems();
            items = i;
            return this;
        }
        catch(StorageException e)
        {
            //eat it
        }
        return null;
    }

    @Override
    public void load(HashMap<String, Object> fields) {
        
        
    }

    @Override
    public IModel get() {
        try
        {
            ObservableList i = dataSource.getItems();
            items = i;
            return this;
        }
        catch(StorageException e)
        {
            //eat it
        }
        return null;
    }
}
