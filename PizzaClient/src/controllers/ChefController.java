/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import data.PizzaServiceClient;
import enums.OrderStatus;
import exceptions.StorageException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import models.IModel;
import models.ItemModel;
import models.OrderModel;

/**
 *
 * @author Jacob
 */
public class ChefController extends AbstractController{

    private ArrayList<IModel> orders = new ArrayList<IModel>();
    private ArrayList<OrderModel> sd = new ArrayList<OrderModel>();
    private ArrayList<OrderModel> removed = new ArrayList<OrderModel>();
    private DefaultListModel<String> orderElements;
    
    public ChefController(IDataSource source)
    {
        super();
        this.source = source;
        
        try{
            orders = source.getOrders();
        }
        
        catch(Exception e){
            e.printStackTrace(System.out);
        }
        
        if (orders == null)
            orders = new ArrayList<IModel>();
        else{
            orders.stream().forEach((O)-> {O.init(source);});
        }
    }
    
    public void init(DefaultListModel ordersList){
        //items.stream().forEach((x) -> { menu.addElement(((ItemModel)x).getName());});

        String orderString = "";
        orderElements = ordersList;
        
        for(IModel im : orders){
            OrderModel om = (OrderModel)im;
            //System.out.println(om.getId());
            
            //if(om.getStatus() != 4)
                sd.add(om);
            
        }
        
        for(OrderModel om : sd){
            ArrayList<String> gf = om.getItems();
            orderString = "Order #" + om.getId() + ":   ";
            
            for(String str : gf){
                orderString += str + " | ";
            }
            
            orderElements.addElement(orderString);
        }
    }
    
    public void removeOrders(int[] toRemove){
        
        if(toRemove.length > 0){
            for (int i : toRemove){
                OrderModel om = sd.get(i);
                om.setStatus(4);
                removed.add(om);
                sd.remove(om);
                orderElements.remove(i);
            }
        }
    }
    
    @Override
    public void submit() {
        for(OrderModel ty : removed){
            ty.save();
        }
    }

    @Override
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<IModel> getOrders(){
        ArrayList<IModel> iOrders =null;
        
        PizzaServiceClient psc = new PizzaServiceClient();
        
        try{
            iOrders = psc.getOrders();
        }
        
        catch(Exception e){
            e.printStackTrace(System.out);
        }
        
        return iOrders;
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
