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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void get(int id) {
        ObservableList<IModel> i;
        try {
            i = source.getItems();
            
        } catch (StorageException ex) {
            Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void load(HashMap<String, Object> fields) {
        
        
    }

    @Override
    public void get() {
        try
        {
            ObservableList<IModel> i = source.getItems();
            
            i.stream().forEach((model) -> {
                items.add(model);
            });
            
        }
        catch(StorageException e)
        {
            //eat it
        }
    }
}
