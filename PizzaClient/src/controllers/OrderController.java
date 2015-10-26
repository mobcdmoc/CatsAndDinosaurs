/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import models.IModel;
import models.MenuModel;
import models.OrderModel;

/**
 *
 * @author Jacob
 */
public class OrderController extends AbstractController {
    public static final transient String PROP_MENU = "menu";
    //This is a hack to get it working.
    private IModel menu;
    
    public IModel getMenu()
    {
        return menu;
    }
    
    public void setMenu(IModel value)
    {
        IModel oldValue = menu;
        menu = value;
        propertySupport.firePropertyChange(PROP_MENU, oldValue, menu);
    }
    
    public OrderController()
    {
        super(null);
    }
    public OrderController(IDataSource source)
    {
       super(source);
       menu = new MenuModel(source);
       menu = menu.get();
    }
    
    @Override
    public void submit() {
        model.save();
    }

    @Override
    public void get() {
        model = new OrderModel();
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
