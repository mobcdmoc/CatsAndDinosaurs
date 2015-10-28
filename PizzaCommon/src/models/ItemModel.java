/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import data.IDataSource;
import enums.ItemType;
import exceptions.LoadException;
import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Jacob
 */
public class ItemModel extends AbstractModel {
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_NAME = "name";
    public static final transient String PROP_DESCRIPTION = "description";
    public static final transient String PROP_PRICE = "price";
    public static final transient String PROP_TYPE = "type";
    
    public static final transient String PROP_SPECIALPRICE = "SpecialPrice";
    public static final transient String PROP_ISSPECIAL = "IsSpecial";
    
    private int id;
    private String name;
    private String description;
    private double price;
    private int type;
    private double specialPrice;
    private boolean isSpecial;
    
    public ItemModel() {
        super();
    }
    public ItemModel(IDataSource source)
    {
        super(source);
    }
    //<editor-fold desc="id">
    public int getId()
    {
        return id;
    }
    public void setId(int value)
    {
        int oldValue = id;
        id =  value;
        propertySupport.firePropertyChange(PROP_ID, oldValue, id);
    }
    //</editor-fold>
    //<editor-fold desc="name">
    public String getName()
    {
        return name;
    }
    public void setName(String value)
    {
        String oldValue = name;
        name = value;
        propertySupport.firePropertyChange(PROP_NAME, oldValue, name);
    }
    //</editor-fold>
    //<editor-fold desc="description">
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String value)
    {
        String oldValue = description;
        description = value;
        propertySupport.firePropertyChange(PROP_DESCRIPTION, oldValue, description);
    }
    //</editor-fold>
    //<editor-fold desc="price">
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double value)
    {
        double oldValue = price;
        price = value;
        propertySupport.firePropertyChange(PROP_PRICE, oldValue, price);
    }
    //</editor-fold>
    //<editor-fold desc="type">
    public ItemType getType()
    {
        return ItemType.getItemType(type);
    }
    public void setType(int value)
    {
        int oldValue = type;
        type = value;
        propertySupport.firePropertyChange(PROP_TYPE, oldValue, type);
    }
    //</editor-fold>
    
    //<editor-fold desc="SpeicalPrice">
    public double getSpecialPrice()
    {
        return specialPrice;
    }
    public void setSpecialPrice(double value)
    {
        double oldValue = specialPrice;
        specialPrice = value;
        propertySupport.firePropertyChange(PROP_SPECIALPRICE, oldValue, specialPrice);
    }
    //</editor-fold>
    
    //<editor-fold desc="IsSpecial">
    public boolean getIsSpecial()
    {
        return isSpecial;
    }
    public void setIsSpecial(boolean value)
    {
        boolean oldValue = isSpecial;
        isSpecial = value;
        propertySupport.firePropertyChange(PROP_ISSPECIAL, oldValue, isSpecial);
    }
    //</editor-fold>
    
    @Override
    public void save() {
        try
        {
            source.saveItem(this);
        }
        catch(Exception e)
        {
            //TODO: Do something here
            //Eat it.
        }
    }

    @Override
    public IModel get(int id) {
        try
        {
            return source.getItem(id);
        }
        catch(Exception e)
        {
            //TODO: Do something here
            //Eat it.
        }
        return null;
    }

    @Override
    /*
    The load method takes a hashmap of string object and 
    uses it to place the provided values in the model.
    
    It expects the key names to be all lowercase and identical
    to the property name.
    */
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
        if(fields.containsKey(PROP_NAME))
            setName(fields.get(PROP_NAME).toString());
        if(fields.containsKey(PROP_DESCRIPTION))
            setDescription(fields.get(PROP_DESCRIPTION).toString());
        if(fields.containsKey(PROP_PRICE))
            setPrice(Double.parseDouble(fields.get(PROP_PRICE).toString()));
        if(fields.containsKey(PROP_TYPE))
            setType(Integer.parseInt(fields.get(PROP_TYPE).toString()));
        if(fields.containsKey(PROP_SPECIALPRICE))
            setSpecialPrice(Double.parseDouble(fields.get(PROP_SPECIALPRICE).toString()));
        if(fields.containsKey(PROP_TYPE))
            setIsSpecial(Boolean.parseBoolean(fields.get(PROP_TYPE).toString()));
    }

    @Override
    public IModel get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
