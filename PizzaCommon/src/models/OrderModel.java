/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import data.IDataSource;
import enums.OrderStatus;
import exceptions.LoadException;
import exceptions.StorageException;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob
 */
public class OrderModel extends AbstractModel implements IOrderModel{
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_USER = "user";
    public static final transient String PROP_STATUS = "status";
    public static final transient String PROP_ITEMS = "items";
    public static final transient String PROP_ITEMIDS = "itemIds";
    public static final transient String PROP_ITEMPRICES = "itemPrices";
    public static final transient String PROP_TOTAL = "total";
    public static final transient String PROP_PAYMENTID = "paymentID";
    public static final transient String PROP_ORDERITEMIDS = "orderItemIds";
    
    private int id;
    private int user;
    private int status;
    private int paymentID; //int stores the associated payment ID

    private ArrayList<IItemModel> items;
    
    
    public OrderModel(IDataSource source) {
        super();
        this.source = source;
        items = new ArrayList<>();
    }
    
    public int getPaymentID() 
    {
        return paymentID;
    }
    public void setPaymentID(int paymentID) 
    {
        id = paymentID;
    }
    //<editor-fold desc="Id">
    public int getId()
    {
        return id;
    }
    public void setId(int value)
    {
        id = value;
    }
    //</editor-fold>
    //<editor-fold desc="User">
    public int getUser()
    {
        if(user < 1)
            return 2;
        return user;
    }
    public void setUser(int value)
    {
        user = value;
    }
    //</editor-fold>
    //<editor-fold desc="Status">
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int value)
    {
        status = value;
    }
    //</editor-fold>
    //<editor-fold desc="Items">
    public ArrayList<IItemModel> getItems()
    {
        return items;
    }
    public void setItems (ArrayList<IItemModel> value)
    {
        items = value;
    }
    //</editor-fold>
    
    //<editor-fold desc="Total">
    private double total;
    @Override
    public double getTotal()
    {
        double total = 0;
        for(IItemModel item : items)
        {
            total += item.getPrice();
        }
        return total;
    }
    
    @Override
    public void setTotal (double value)
    {
        total = value;
    }
    
    private double calculateTotal()
    {
        double t = 0;
        for(IItemModel item : items)
        {
            t += item.getDisplayPrice();
        }
        return t;
    }
    //</editor-fold>
    
    @Override
    public boolean save() {
        
        try {
            source.saveOrder(this);
        } catch (StorageException ex) {
            return false;
        }
        return true;
    }


    @Override
    public void load(HashMap<String, Object> fields) throws LoadException {
        if(fields == null || fields.keySet().size() < 1)
        {
            throw new LoadException("ItemModel: No fields passed in!");
        }
        if(fields.containsKey(PROP_ID))
            setId(Integer.parseInt(fields.get(PROP_ID).toString()));
        if(fields.containsKey(PROP_USER+"id"))
            setUser(Integer.parseInt(fields.get(PROP_USER+"id").toString()));
        if(fields.containsKey(PROP_STATUS+"id"))
            setStatus(Integer.parseInt(fields.get(PROP_STATUS+"id").toString()));
        if(fields.containsKey(PROP_PAYMENTID+"id"))
            setStatus(Integer.parseInt(fields.get(PROP_PAYMENTID+"id").toString()));
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addItem(ItemModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeItem(ItemModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
