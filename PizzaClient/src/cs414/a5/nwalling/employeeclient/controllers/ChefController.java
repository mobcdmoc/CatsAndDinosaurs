/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.employeeclient.controllers;

import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.data.PizzaServiceClient;
import cs414.a5.nwalling.common.enums.OrderStatus;
import cs414.a5.nwalling.common.exceptions.StorageException;
import cs414.a5.nwalling.common.models.IItemModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import cs414.a5.nwalling.common.models.IModel;
import cs414.a5.nwalling.common.models.IOrderModel;
import cs414.a5.nwalling.common.models.ItemModel;
import cs414.a5.nwalling.common.models.OrderModel;

/**
 *
 * @author Jacob
 */
public class ChefController extends AbstractController{

    private ArrayList<IOrderModel> orders = new ArrayList<IOrderModel>();
    private ArrayList<IOrderModel> sd = new ArrayList<IOrderModel>();
    private ArrayList<IOrderModel> removed = new ArrayList<IOrderModel>();
    private ArrayList<IOrderModel> rd = new ArrayList<IOrderModel>();
    private DefaultListModel<String> orderElements;
    private DefaultListModel<String> completedElements;
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
            orders = new ArrayList<IOrderModel>();
        else{
            orders.stream().forEach((O)-> {O.init(source);});
        }
    }
    
    public void init(DefaultListModel ordersList, DefaultListModel completed){
        //items.stream().forEach((x) -> { menu.addElement(((ItemModel)x).getName());});

        String orderString = "";
        orderElements = ordersList;
        completedElements = completed;
        for(IModel im : orders){
            OrderModel om = (OrderModel)im;
            //System.out.println(om.getId());
            
            if(om.getStatus() != 4)
                sd.add(om);
            else
                rd.add(om);
        }
        
        for(IOrderModel om : sd){
            ArrayList<IItemModel> gf = null;
            
            try {
                gf = source.getOrderItems(om.getId());
            } catch (StorageException ex) {
                Logger.getLogger(ChefController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(gf == null)
                gf = new ArrayList<>();
            orderString = "Order #" + om.getId() + ":   ";
            
            for(IItemModel str : gf){
                orderString += str.getName() + " | ";
            }
            
            orderElements.addElement(orderString);
        }
        for(IOrderModel om : rd){
            ArrayList<IItemModel> gf = null;
            
            try {
                gf = source.getOrderItems(om.getId());
            } catch (StorageException ex) {
                Logger.getLogger(ChefController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(gf == null)
                gf = new ArrayList<>();
            orderString = "Order #" + om.getId() + ":   ";
            
            for(IItemModel str : gf){
                orderString += str.getName() + " | ";
            }
            
            completedElements.addElement(orderString);
        }
        
    }
    
    public void removeOrders(int[] toRemove){
        
        if(toRemove.length > 0){
            for (int i : toRemove){
                IOrderModel om = sd.get(i);
                om.setStatus(4);
                removed.add(om);
                sd.remove(om);
                completedElements.addElement(orderElements.get(i));
                orderElements.remove(i);
            }
        }
    }
    
    @Override
    public void submit() {
        for(IOrderModel ty : removed){
            ty.save();
        }
    }

    @Override
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<IOrderModel> getOrders(){
        ArrayList<IOrderModel> iOrders =null;
        
        PizzaServiceClient psc = new PizzaServiceClient("http://localhost:8080");
        
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
