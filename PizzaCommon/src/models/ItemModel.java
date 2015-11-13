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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class ItemModel extends AbstractModel implements IItemModel {
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_NAME = "name";
    public static final transient String PROP_DESCRIPTION = "description";
    public static final transient String PROP_PRICE = "price";
    public static final transient String PROP_TYPE = "type";
    public static final transient String PROP_SPECIALPRICE = "specialPrice";
    public static final transient String PROP_ISSPECIAL = "isSpecial";
    public static final transient String PROP_ISACTIVE = "isActive";
    
    private int id;
    private String name;
    private String description;
    private double price;
    private double specialPrice;
    private boolean isSpecial;
    private boolean isActive;
    public ItemModel(IDataSource source, String name, double price)
    {
        super(source);
        this.name = name;
        this.price = price;
    }
    //<editor-fold desc="id">
    public int getId()
    {   
        return id;
    }
    public void setId(int value)
    {
        id =  value;
    }
    //</editor-fold>
    //<editor-fold desc="name">
    public String getName()
    {
        return name;
    }
    public void setName(String value)
    {
        name = value;
    }
    //</editor-fold>
    //<editor-fold desc="description">
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String value)
    {
        description = value;
    }
    //</editor-fold>
    //<editor-fold desc="price">
    @Override
    public double getDisplayPrice()
    {
        if(isSpecial)
            return specialPrice;
        return price;
    }
    @Override
    public double getPrice()
    {
        return price;
    }
    @Override
    public void setPrice(double value)
    {
        price = value;
    }
    @Override
    public void setSpecialPrice(double value)
    {
        specialPrice = value;
    }
    
    @Override
    public double getSpecialPrice() {
        return specialPrice;
    }
    //</editor-fold>
    //<editor-fold desc="IsSpecial">
    @Override
    public boolean getIsSpecial()
    {
        return isSpecial;
    }
    @Override
    public void setIsSpecial(boolean value)
    {
        isSpecial = value;
    }
    //</editor-fold>
    //<editor-fold desc="IsActive">
    @Override
    public boolean getIsActive()
    {
        return isActive;
    }
    @Override
    public void setIsActive(boolean value)
    {
        isActive = value;
    }
    //</editor-fold>
    @Override
    public boolean save() {
        try
        {
            source.saveItem(this);
        }
        catch(Exception e)
        {
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
        if(fields.containsKey(PROP_SPECIALPRICE.toLowerCase()))
            setSpecialPrice(Double.parseDouble(fields.get(PROP_SPECIALPRICE.toLowerCase()).toString()));
        if(fields.containsKey(PROP_ISSPECIAL.toLowerCase()))
            setIsSpecial(Boolean.parseBoolean(fields.get(PROP_ISSPECIAL.toLowerCase()).toString()));
        if(fields.containsKey(PROP_ISACTIVE.toLowerCase()))
            setIsActive(Boolean.parseBoolean(fields.get(PROP_ISACTIVE.toLowerCase()).toString()));
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
