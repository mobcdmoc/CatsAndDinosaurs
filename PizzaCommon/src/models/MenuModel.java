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
import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob
 */
public class MenuModel extends AbstractModel {
    public static final String PROP_ITEMS = "items";
    private ListModel<IModel> items;
    
    private DefaultListModel combined;
    private ArrayList<Integer> ids = new ArrayList<>();
    private DefaultListModel names;
    private DefaultListModel prices;
    private DefaultListModel specialPrice;
    private DefaultListModel isSpecial;
    
    private ArrayList<Integer> toRemove = new ArrayList<>();
    
    public MenuModel() {
        super();
        items = new ListModel<>();
    }
    
    public void init(DefaultListModel combined, DefaultListModel names, DefaultListModel prices, DefaultListModel specialPrice,DefaultListModel isSpecial )
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
        items.add(m);
        
        
        ids.add(0);
        names.addElement(name);
        prices.addElement(price);
        specialPrice.addElement(0);
        isSpecial.addElement(false);
        
        int i = ids.size()-1;
        
        combined.addElement(java.text.MessageFormat.format("{0} | {1} | {2} | {3}", names.get(i), prices.get(i), specialPrice.get(i), isSpecial.get(i)));
    }
    
    
    public void remove(int[] indices)
    {
        Arrays.sort(indices);
        for(int j = indices.length-1; j >= 0; j--)
        {
            int i = indices[j];
            if(ids.get(i) != 0)
            {
                ItemModel m = (ItemModel)items.get(i);
                m.setIsActive(false);
            }
            combined.remove(i);
            ids.remove(i);
            names.remove(i);
            prices.remove(i);
            specialPrice.remove(i);
            isSpecial.remove(i);
        }
    }
    
    public ListModel<IModel> getItems()
    {
        return items;
    }
    public void setItems(ListModel<IModel> value)
    {
        ListModel<IModel> oldValue = items;
        items = value;
        propertySupport.firePropertyChange(PROP_ITEMS, oldValue, items);
    }
    
    public void newSpecialPrice(int index, double price)
    {
        specialPrice.set(index,price);
        isSpecial.set(index,true);
        updateCombined(index);
    }
    
    public void revokeSpecial(int[] indecies)
    {
        for(int i = 0; i < indecies.length; i++)
        {
            isSpecial.set(indecies[i], false);
            updateCombined(indecies[i]);
        }
    }
    
    @Override
    public void save() 
    {
        
        for(int i = 0; i < ids.size(); i++)
        {
            ItemModel m;
            if(ids.get(i) != 0)
            {
                //already exists
//                m = ((ItemModel)items.get(i)).getId();
            }
        }
    }

    @Override
    public void getById(int id) {
        try
        {
            ListModel<IModel> ms = source.getItems();
            items.clear();
            
            for(int i = 0; i< ms.getSize(); i++)
            {
                ItemModel model = ((ItemModel)ms.get(i));
                ids.add(model.getId());
                names.addElement(model.getName());
                prices.addElement(model.getPrice());
                isSpecial.addElement(model.getIsSpecial());
                specialPrice.addElement(model.getSpecialPrice());
                int index = ids.size()-1;
        
                combined.addElement(java.text.MessageFormat.format("{0} | {1} | {2} | {3}", names.get(index), prices.get(index), specialPrice.get(index), isSpecial.get(index)));

                items.add(model);
            }
        
        } catch (StorageException ex) {
            //Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void load(HashMap<String, Object> fields) {
    }

    @Override
    public void get() {     
        try
        {
            ListModel<IModel> ms = source.getItems();
            items.clear();
            
            for(int i = 0; i< ms.getSize(); i++)
            {
                ItemModel model = ((ItemModel)ms.get(i));
                ids.add(model.getId());
                names.addElement(model.getName());
                prices.addElement(model.getPrice());
                isSpecial.addElement(model.getIsSpecial());
                specialPrice.addElement(model.getSpecialPrice());
                int index = ids.size()-1;
        
                combined.addElement(java.text.MessageFormat.format("{0} | {1} | {2} | {3}", names.get(index), prices.get(index), specialPrice.get(index), isSpecial.get(index)));

                items.add(model);
            }
        
        } catch (StorageException ex) {
            //Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
