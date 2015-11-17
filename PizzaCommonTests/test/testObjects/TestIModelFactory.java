/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testObjects;

import data.IModelFactory;
import models.IChefModel;
import models.IItemModel;
import models.IMenuModel;
import models.IOrderModel;
import models.IPaymentModel;
import models.IUserModel;

/**
 *
 * @author Jacob
 */
public class TestIModelFactory implements IModelFactory{

    @Override
    public IUserModel getEmptyIUserModel() {
        return new TestIUserModel();
    }

    @Override
    public IMenuModel getEmptyIMenuModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IChefModel getEmptyIChefModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemModel getEmptyIItemModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOrderModel getEmptyIOrderModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPaymentModel getEmptyIPaymentModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
