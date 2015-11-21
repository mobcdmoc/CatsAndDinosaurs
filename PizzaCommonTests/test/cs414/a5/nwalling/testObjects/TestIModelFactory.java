/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.testObjects;

import cs414.a5.nwalling.data.IModelFactory;
import cs414.a5.nwalling.models.IChefModel;
import cs414.a5.nwalling.models.IItemModel;
import cs414.a5.nwalling.models.IMenuModel;
import cs414.a5.nwalling.models.IOrderModel;
import cs414.a5.nwalling.models.IPaymentModel;
import cs414.a5.nwalling.models.IUserModel;

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
