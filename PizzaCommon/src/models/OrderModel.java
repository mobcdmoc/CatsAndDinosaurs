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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob
 */
public class OrderModel extends AbstractModel{
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_USER = "user";
    public static final transient String PROP_STATUS = "status";
    public static final transient String PROP_ITEMS = "items";
    public static final transient String PROP_ITEMIDS = "itemIds";
    public static final transient String PROP_ITEMPRICES = "itemPrices";
    public static final transient String PROP_TOTAL = "total";
    public static final transient String PROP_PAYMENTID = "paymentID";
    
    private int id;
    private int user;
    private int status;
    private int paymentID; //int stores the associated payment ID

    private ArrayList<String> items;
    private DefaultListModel<String> orderModel;
    private DefaultListModel<String> menuModel;
    private ArrayList<Integer> itemIds;
    private transient ArrayList<Double> itemPrices = new ArrayList<>();
    private transient ArrayList<Double> receipt = new ArrayList<>();
    
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) 
       {
        int oldValue = id;
        id = paymentID;
        propertySupport.firePropertyChange(PROP_ID, oldValue, id);
    }
    
    public void addItems(int[] indices)
    {
        for(int i : indices)
        {
            orderModel.addElement(items.get(i));
            receipt.add(itemPrices.get(i));
        }
        setTotal(calculateTotal());
    }
    
    public void removeItems(int[] indices)
    {
        Arrays.sort(indices);
        for(int i = indices.length-1; i >=0; i--)
        {
            orderModel.remove(indices[i]);
            receipt.remove(indices[i]);
        }
        setTotal(calculateTotal());
    }
    
    public void init(IDataSource source, DefaultListModel<String> menu, DefaultListModel<String> order) throws StorageException
    {
        this.source = source;
        orderModel = order;
        menuModel = menu;
        
        MenuModel menuIModel = (MenuModel)source.getMenu();
        menuIModel.getItems().stream().forEach((x) -> {
            ItemModel item = (ItemModel)x;
            double price = (item.getIsSpecial() ? item.getSpecialPrice() : item.getPrice());
            String itemCard = item.getName() + " | " + price + "$";
            menu.addElement(itemCard);
            items.add(itemCard);
            itemIds.add(item.getId());
            itemPrices.add(price);
        });
    }
    
    public OrderModel() {
        super();
        items = new ArrayList<String>();
        itemIds = new ArrayList<Integer>();
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
    public ArrayList<String> getItems()
    {
        return items;
    }
    public void setItems (ArrayList<String> value)
    {
        ArrayList<String> oldValue = items;
        items = value;
        propertySupport.firePropertyChange(PROP_ITEMS, oldValue, items);
    }
    //</editor-fold>
    //<editor-fold desc="Items">
    public ArrayList<Integer> getItemIds()
    {
        return itemIds;
    }
    public void setItemIds (ArrayList<Integer> value)
    {
        ArrayList<Integer> oldValue = itemIds;
        itemIds = value;
        propertySupport.firePropertyChange(PROP_ITEMS, oldValue, itemIds);
    }
    //</editor-fold>
    //<editor-fold desc="Total">
    
    private double total;
    public double getTotal()
    {
        return total;
    }
    
    public void setTotal (double value)
    {
        double oldValue = total;
        total = value;
        propertySupport.firePropertyChange(PROP_TOTAL, oldValue, total);
    }
    
    private double calculateTotal()
    {
        double t = 0;
        t = receipt.stream().map((d) -> d).reduce(t, (accumulator, _item) -> accumulator + _item);
        return t;
    }
    //</editor-fold>
    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getById(int id) {
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
        if(fields.containsKey(PROP_PAYMENTID+"id"))
            setStatus(Integer.parseInt(fields.get(PROP_PAYMENTID+"id").toString()));
//        if(fields.containsKey(PROP_ITEMS))
//            setStatus(Integer.parseInt(fields.get(PROP_ITEMS).toString()));
//        if(fields.containsKey(PROP_ITEMIDS))
//            setStatus(Integer.parseInt(fields.get(PROP_ITEMIDS).toString()));
    }

    @Override
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
