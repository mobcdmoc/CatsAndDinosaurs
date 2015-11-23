/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.common.data;

import cs414.a5.nwalling.common.controllers.IEditAccountController;
import cs414.a5.nwalling.common.controllers.IChangeMenuController;
import cs414.a5.nwalling.common.controllers.IChefController;
import cs414.a5.nwalling.common.controllers.ICreateAccountController;
import cs414.a5.nwalling.common.controllers.ILoginController;
import cs414.a5.nwalling.common.controllers.IOrderController;
import cs414.a5.nwalling.common.controllers.IPaymentController;

/**
 *
 * @author Jacob
 */
public interface IControllerFactory {
    ILoginController getLoginController();
    IChangeMenuController getChangeMenuController();
    IChefController getChefController();
    ICreateAccountController getCreateAccountController();
    IOrderController getOrderController();
    IPaymentController getPaymentController();
    IEditAccountController getEditAccountController();
}
