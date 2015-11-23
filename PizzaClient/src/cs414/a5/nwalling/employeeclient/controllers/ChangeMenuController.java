/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.employeeclient.controllers;

import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.exceptions.StorageException;
import cs414.a5.nwalling.common.models.IItemModel;
import cs414.a5.nwalling.common.models.IMenuModel;
import javax.swing.DefaultListModel;
import cs414.a5.nwalling.common.models.ItemModel;
import cs414.a5.nwalling.common.models.MenuModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class ChangeMenuController extends AbstractController{

    IMenuModel menu;
    DefaultListModel<String>items;
    public ChangeMenuController()
    {
        super();
        menu = new MenuModel();
    }
    
    public void init(IDataSource source,DefaultListModel<String> items)
    {
        this.source = source;
        this.items = items;
        try {
            menu = source.getMenu();
            refreshItems();
        } catch (StorageException ex) {
            Logger.getLogger(ChangeMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void load()
    {
        
    }
    
    
    @Override
    public void submit() {
        for(IItemModel item : menu.getItems())
        {
            try {
                source.saveItem(item);
            } catch (StorageException ex) {
                Logger.getLogger(ChangeMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void get() {
//        model.get();
    }

    public void remove(int[] indices)
    {
        for(int i = indices.length-1; i >= 0; i--)
        {
            menu.getItems().get(indices[i]).setIsActive(false);
//            menu.getItems().remove(indices[i]);
        }
        refreshItems();
//        ((IMenuModel)model).remove(indices);
    }
    
    private void refreshItems()
    {
        items.clear();
        for(IItemModel item : menu.getItems())
        {
            if(item.getIsActive())
                items.addElement(item.getName() + " | " + item.getPrice() + " | " + item.getSpecialPrice() + " | " + item.getIsSpecial());
        }
    }
    
    public void newItem(String name, double price)
    {
        ((MenuModel)menu).newItem(name,price);
        
        refreshItems();
    }
    
    public void revokeSpecial(int[] indecies)
    {
        ((MenuModel)menu).revokeSpecial(indecies);
        refreshItems();
    }
    public void newSpecialPrice(int index, double price)
    {
        ((MenuModel)menu).newSpecialPrice(index, price);
        refreshItems();
    }
    public void updatePrice(int index, double price)
    {
        ((MenuModel)menu).getItems().get(index).setPrice(price);
        refreshItems();
    }
    
    @Override
    public void onClose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void runCommand(String command, Object input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
