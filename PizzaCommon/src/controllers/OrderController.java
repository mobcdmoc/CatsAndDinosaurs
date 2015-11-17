/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import data.IModelFactory;
import enums.OrderStatus;
import java.util.ArrayList;
import models.IMenuModel;
import models.IOrderModel;
import models.MenuModel;

/**
 *
 * @author Jacob
 */
public class OrderController extends AbstractController implements IOrderController {
    public static final transient String PROP_MENU = "menu";
    //This is a hack to get it working.
    private IMenuModel menu;
    private IOrderModel order;
    private OrderStatus status;
    
    private IModelFactory modelFactory;
    public OrderController(IModelFactory modelFactory, IDataSource source)
    {
        super(source);
        this.modelFactory = modelFactory;
        this.menu = modelFactory.getEmptyIMenuModel();
        this.order = modelFactory.getEmptyIOrderModel();
    }
    
    public ArrayList<String> getMenu()
    {
//        return (MenuModel)menu;
        return null;
    }
    
    @Override
    public void addToOrder(int[] indices)
    {
        //
    }
    @Override
    public void removeFromOrder(int[] indices)
    {
        //
    }

    @Override
    public ArrayList<String> getOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveOrder() {
        return order.save();
    }

    @Override
    public String getOrderStatus() {
        return status.toString();
    }
}
