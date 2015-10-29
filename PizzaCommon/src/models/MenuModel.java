/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import exceptions.StorageException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob
 */
public class MenuModel extends AbstractModel {
    public static final String PROP_ITEMS = "items";
    private ArrayList<IModel> items;
    
    private transient DefaultListModel combined;
    private transient ArrayList<Integer> ids = new ArrayList<>();
    private transient DefaultListModel<String> names;
    private transient DefaultListModel<Double> prices;
    private transient DefaultListModel<Double> specialPrice;
    private transient DefaultListModel<Boolean> isSpecial;
    private transient ArrayList<Boolean> isActive = new ArrayList<>();
    private transient ArrayList<Boolean> updated = new ArrayList<>();
    
    
    public MenuModel() {
        super();
        items = new ArrayList<>();
    }
    
    public void init(DefaultListModel<String> combined, DefaultListModel<String> names, DefaultListModel<Double> prices, DefaultListModel<Double> specialPrice,DefaultListModel<Boolean> isSpecial )
    {
        this.combined= combined;
        this.names = names;
        this.prices = prices;
        this.specialPrice = specialPrice;
        this.isSpecial = isSpecial;
    }
    
    public void updateCombined(int i)
    {
        combined.set(i, java.text.MessageFormat.format("{0} | {1} | {2} | {3}", names.get(i), prices.get(i), specialPrice.get(i), isSpecial.get(i)));
    }
    
    
    public void newItem(String name, double price)
    {
        ItemModel m = new ItemModel();
        m.setName(name);
        m.setPrice(price);
        m.setIsActive(true);
        
        
        ids.add(0);
        names.addElement(name);
        prices.addElement(price);
        specialPrice.addElement(0.0);
        isSpecial.addElement(false);
        isActive.add(true);
        updated.add(true);
        int i = ids.size()-1;
        
        combined.addElement(java.text.MessageFormat.format("{0} | {1} | {2} | {3}", names.get(i), prices.get(i), specialPrice.get(i), isSpecial.get(i)));
    }
   
    public void remove(int[] indices)
    {
        Arrays.sort(indices);
        for(int j = indices.length-1; j >= 0; j--)
        {
            
            int i = indices[j];
            
            ItemModel m;
            
            if(ids.get(i) != 0)
            {
                m = new ItemModel();
                m.setId(ids.get(i));
                m.setName((String)names.get(i));
                m.setPrice(prices.get(i));
                m.setSpecialPrice(specialPrice.get(i));
                m.setIsSpecial(isSpecial.get(i));
                m.setType(4);
                m.setIsActive(false);
                items.add(m);
            }
            combined.remove(i);
            ids.remove(i);
            names.remove(i);
            prices.remove(i);
            specialPrice.remove(i);
            isSpecial.remove(i);
            updated.remove(i);
        }
    }
    
    public ArrayList<IModel> getItems()
    {
        return items;
    }
    public void setItems(ArrayList<IModel> value)
    {
        ArrayList<IModel> oldValue = items;
        items = value;
        propertySupport.firePropertyChange(PROP_ITEMS, oldValue, items);
    }
    
    public void newSpecialPrice(int index, double price)
    {
        specialPrice.set(index,price);
        isSpecial.set(index,true);
        updated.set(index, true);
        updateCombined(index);
    }
    
    public void revokeSpecial(int[] indecies)
    {
        for(int i = 0; i < indecies.length; i++)
        {
            isSpecial.set(indecies[i], false);
            updated.set(indecies[i], true);
            updateCombined(indecies[i]);
        }
    }
    
    @Override
    public void save() 
    {
        
        for(int i = 0; i < ids.size(); i++)
        {
            if(updated.get(i))
            {
                ItemModel m = new ItemModel();
                if(ids.get(i) != 0)
                    m.setId(ids.get(i));
                else
                    m.setId(0);
                m.setName((String)names.get(i));
                m.setPrice(prices.get(i));
                m.setSpecialPrice(specialPrice.get(i));
                m.setIsSpecial(isSpecial.get(i));
                m.setIsActive(true);
                m.setType(4);
                items.add(m);
            }
        }
        try {
            source.saveMenu(this);
        } catch (StorageException ex) {
            Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getById(int id) {
        try
        {
            ArrayList<IModel> ms = source.getItems();
            items.clear();
            
            for(int i = 0; i< ms.size(); i++)
            {
                ItemModel model = ((ItemModel)ms.get(i));
                ids.add(model.getId());
                names.addElement(model.getName());
                prices.addElement(model.getPrice());
                isSpecial.addElement(model.getIsSpecial());
                specialPrice.addElement(model.getSpecialPrice());
                int index = ids.size()-1;
        
                combined.addElement(java.text.MessageFormat.format("{0} | {1} | {2} | {3}", names.get(index), prices.get(index), specialPrice.get(index), isSpecial.get(index)));

            }
        
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
            ArrayList<IModel> ms = source.getItems();
            items.clear();
            
            for(int i = 0; i< ms.size(); i++)
            {
                ItemModel model = ((ItemModel)ms.get(i));
                ids.add(model.getId());
                names.addElement(model.getName());
                prices.addElement(model.getPrice());
                isSpecial.addElement(model.getIsSpecial());
                specialPrice.addElement(model.getSpecialPrice());
                updated.add(false);
                int index = ids.size()-1;
        
                combined.addElement(java.text.MessageFormat.format("{0} | {1} | {2} | {3}", names.get(index), prices.get(index), specialPrice.get(index), isSpecial.get(index)));

            }
        
        } catch (StorageException ex) {
            Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
