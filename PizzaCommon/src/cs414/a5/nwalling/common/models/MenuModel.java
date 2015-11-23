/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.common.models;

import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.data.IModelFactory;
import cs414.a5.nwalling.common.exceptions.StorageException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class MenuModel extends AbstractModel implements IMenuModel {
    public static final String PROP_ITEMS = "items";
    private ArrayList<IItemModel> items;
    private IModelFactory modelFactory;
    public MenuModel()
    {
        //Do not use this is a hack
    }
    public MenuModel(IModelFactory modelFactory, IDataSource source) {
        super();
        items = new ArrayList<>();
        this.source = source;
    }
    
    public void newItem(String name, double price)
    {
        IItemModel tmp = new ItemModel(source);
        tmp.setName(name);
        tmp.setPrice(price);
        tmp.setIsActive(true);
        items.add(tmp);
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
        items.get(index).setSpecialPrice(price);
        items.get(index).setIsSpecial(true);
    }
    
    public void revokeSpecial(int[] indecies)
    {
        for(int i : indecies)
            items.get(i).setIsSpecial(false);
    }
    
    @Override
    public boolean save() 
    {
        for(IItemModel item : items)
        {
            try {
                source.saveItem(item);
            } catch (StorageException ex) {
                Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        
        return true;
    }

    @Override
    public void load(HashMap<String, Object> fields) {
        
    }

    @Override
    public void clear() {
    
    }

    @Override
    public void setItems(ArrayList<IItemModel> value) {
        this.items = value;
    }
}
