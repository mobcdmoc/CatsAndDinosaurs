/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import data.IModelFactory;
import data.PizzaServiceClient;
import exceptions.StorageException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import models.IModel;
import models.IOrderModel;
import models.OrderModel;

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
