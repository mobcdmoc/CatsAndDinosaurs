/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
public interface IModelFactory {
    IUserModel getEmptyIUserModel();
    IMenuModel getEmptyIMenuModel();
    IChefModel getEmptyIChefModel();
    IItemModel getEmptyIItemModel();
    IOrderModel getEmptyIOrderModel();
    IPaymentModel getEmptyIPaymentModel();
    
}
