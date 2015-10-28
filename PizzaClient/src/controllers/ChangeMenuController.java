/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import javax.swing.DefaultListModel;
import models.ItemModel;
import models.MenuModel;

/**
 *
 * @author Jacob
 */
public class ChangeMenuController extends AbstractController{

    
    public ChangeMenuController()
    {
        super();
        model = new MenuModel();
    }
    
    public void init(IDataSource source,DefaultListModel combined,DefaultListModel names, DefaultListModel prices, DefaultListModel specialPrice,DefaultListModel isSpecial )
    {
        this.source = source;
        model.init(source);
        
        ((MenuModel)model).init(combined,names,prices,specialPrice,isSpecial);
    }
    public void load()
    {
        
    }
    
    
    @Override
    public void submit() {
        model.save();
    }

    @Override
    public void get() {
        model.get();
    }

    public void remove(int[] indices)
    {
        ((MenuModel)model).remove(indices);
    }
    
    public void newItem(String name, double price)
    {
        ((MenuModel)model).newItem(name,price);
    }
    
    public void revokeSpecial(int[] indecies)
    {
        ((MenuModel)model).revokeSpecial(indecies);
    }
    public void newSpecialPrice(int index, double price)
    {
        ((MenuModel)model).newSpecialPrice(index, price);
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
