/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob
 */
public class MenuModel extends AbstractModel implements IMenuModel {
    public static final String PROP_ITEMS = "items";
    private ArrayList<IItemModel> items;
    
    public MenuModel() {
        super();
        items = new ArrayList<>();
    }
    
    public void newItem(String name, double price)
    {
        IItemModel m = new ItemModel(this.source, name, price);
        items.add(m);
    }
   
    public void removeItem(ItemModel item)
    {
        items.remove(item);
    }
    
    public ArrayList<IItemModel> getItems()
    {
        return items;
    }
    
    public void newSpecialPrice(int index, double price)
    {
    }
    
    public void revokeSpecial(int[] indecies)
    {
    }
    
    @Override
    public boolean save() 
    {
        boolean savedGood = true;
        for(IItemModel item : items)
        {
            savedGood &= item.save();
        }
        
        return savedGood;
    }

    @Override
    public void load(HashMap<String, Object> fields) {
        
    }

    @Override
    public void clear() {
    
    }
}
