/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import exceptions.LoadException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jacob
 */
public class ChefModel extends AbstractModel implements IChefModel {

    ArrayList<IOrderModel> orders = new ArrayList<>();
    ArrayList<IOrderModel> completedOrders = new ArrayList<>();
    
    
    
    @Override
    public boolean save() {
        boolean savedGood = true;
        for(IOrderModel order : orders)
        {
            savedGood &= order.save();
        }
        for(IOrderModel order : completedOrders)
        {
            savedGood &= order.save();
        }
        return savedGood;
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(HashMap<String, Object> fields) throws LoadException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IOrderModel> getOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOrders(ArrayList<IOrderModel> value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void markDone(int orderIdex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
