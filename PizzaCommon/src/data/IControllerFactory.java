/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import controllers.IEditAccountController;
import controllers.IChangeMenuController;
import controllers.IChefController;
import controllers.ICreateAccountController;
import controllers.ILoginController;
import controllers.IOrderController;
import controllers.IPaymentController;

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
