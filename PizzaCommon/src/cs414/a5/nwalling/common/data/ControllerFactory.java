/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.common.data;

import cs414.a5.nwalling.common.controllers.ChangeMenuController;
import cs414.a5.nwalling.common.controllers.PaymentController;
import cs414.a5.nwalling.common.controllers.IPaymentController;
import cs414.a5.nwalling.common.controllers.ILoginController;
import cs414.a5.nwalling.common.controllers.EditAccountController;
import cs414.a5.nwalling.common.controllers.IEditAccountController;
import cs414.a5.nwalling.common.controllers.ICreateAccountController;
import cs414.a5.nwalling.common.controllers.IChefController;
import cs414.a5.nwalling.common.controllers.CreateAccountController;
import cs414.a5.nwalling.common.controllers.IOrderController;
import cs414.a5.nwalling.common.controllers.IChangeMenuController;
import cs414.a5.nwalling.common.controllers.LoginController;
import cs414.a5.nwalling.common.controllers.OrderController;
import cs414.a5.nwalling.common.controllers.ChefController;

/**
 *
 * @author Jacob
 */
public class ControllerFactory implements IControllerFactory{

    private IModelFactory modelFactory;
    private IDataSource source;
    public ControllerFactory(IModelFactory modelFactory, IDataSource source)
    {
        this.modelFactory = modelFactory;
        this.source = source;
    }
    
    @Override
    public ILoginController getLoginController() {
        return new LoginController(modelFactory, source);
    }

    @Override
    public IChangeMenuController getChangeMenuController() {
        return new ChangeMenuController(modelFactory, source);
    }

    @Override
    public IChefController getChefController() {
        return new ChefController(modelFactory, source);
    }

    @Override
    public ICreateAccountController getCreateAccountController() {
        return new CreateAccountController(modelFactory,source);
    }

    @Override
    public IOrderController getOrderController() {
        return new OrderController(modelFactory,source);
    }

    @Override
    public IPaymentController getPaymentController() {
        return new PaymentController(modelFactory,source);
    }

    @Override
    public IEditAccountController getEditAccountController() {
        return new EditAccountController(modelFactory,source);
    }
    
}
