/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.common.controllers;

import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.data.IModelFactory;
import cs414.a5.nwalling.common.data.PizzaServiceClient;
import cs414.a5.nwalling.common.exceptions.StorageException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import cs414.a5.nwalling.common.models.IModel;
import cs414.a5.nwalling.common.models.IOrderModel;
import cs414.a5.nwalling.common.models.OrderModel;

/**
 *
 * @author Jacob
 */
public class ChefController extends AbstractController implements IChefController{

    private ArrayList<IOrderModel> orders = new ArrayList<>();
    
    private IModelFactory modelFactory;
    public ChefController(IModelFactory modelFactory, IDataSource source)
    {
        super(source);
        this.modelFactory = modelFactory;
        this.source = source;
    }
    @Override
    public void init()
    {
        try {
            orders = source.getOrders();
        } catch (StorageException ex) {
//            Logger.getLogger(ChefController.class.getName()).log(Level.SEVERE, null, ex);
            //Do something here to keep it from freezing and vomiting to the user.
        }
    }
    
    @Override
    public ArrayList<String> getOrders(){
        return null;
    }

    @Override
    public void markDone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getCompletedOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
