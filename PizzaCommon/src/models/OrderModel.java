/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.OrderStatus;
import exceptions.LoadException;
import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;
import javafx.collections.ObservableList;

/**
 *
 * @author Jacob
 */
public class OrderModel extends AbstractModel{
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_USER = "user";
    public static final transient String PROP_STATUS = "status";
    public static final transient String PROP_ITEMS = "items";
    
    private int id;
    private int user;
    private int status;
    private ObservableList<IModel> items;
    
    
    public OrderModel() {
        super();
    }
    
    //<editor-fold desc="Id">
    public int getId()
    {
        return id;
    }
    public void setId(int value)
    {
        int oldValue = id;
        id = value;
        propertySupport.firePropertyChange(PROP_ID, oldValue, id);
    }
    //</editor-fold>
    //<editor-fold desc="User">
    public int getUser()
    {
        return user;
    }
    public void setUser(int value)
    {
        int oldValue = user;
        user = value;
        propertySupport.firePropertyChange(PROP_USER, oldValue, user);
    }
    //</editor-fold>
    //<editor-fold desc="Status">
    public OrderStatus getStatus()
    {
        return OrderStatus.getStatus(status);
    }
    public void setStatus(int value)
    {
        int oldValue = status;
        status = value;
        propertySupport.firePropertyChange(PROP_STATUS, oldValue, status);
    }
    //</editor-fold>
    //<editor-fold desc="Items">
    public ObservableList<IModel> getItems()
    {
        return items;
    }
    public void setItems (ObservableList<IModel> value)
    {
        ObservableList<IModel> oldValue = items;
        items = value;
        propertySupport.firePropertyChange(PROP_ITEMS, oldValue, items);
    }
    //</editor-fold>
    
    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(HashMap<String, Object> fields) throws LoadException {
        if(fields == null || fields.keySet().size() < 1)
        {
            throw new LoadException("ItemModel: No fields passed in!");
        }
        //NOTE: This is a little gross but it should work.
        //We may want to find a more elegant way of doing this
        //maybe through reflection.
        if(fields.containsKey(PROP_ID))
            setId(Integer.parseInt(fields.get(PROP_ID).toString()));
        if(fields.containsKey(PROP_USER+"id"))
            setUser(Integer.parseInt(fields.get(PROP_USER+"id").toString()));
        if(fields.containsKey(PROP_STATUS+"id"))
            setStatus(Integer.parseInt(fields.get(PROP_STATUS+"id").toString()));
    }
    
}
