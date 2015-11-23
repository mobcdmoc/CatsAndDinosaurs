/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import cs414.a5.nwalling.common.controllers.ILoginController;
import cs414.a5.nwalling.common.controllers.LoginController;
import cs414.a5.nwalling.common.data.ControllerFactory;
import cs414.a5.nwalling.common.data.IControllerFactory;
import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.data.IModelFactory;
import cs414.a5.nwalling.common.data.ModelFactory;
import cs414.a5.nwalling.common.data.PizzaServiceClient;
import cs414.a5.nwalling.common.exceptions.StorageException;
import java.util.ArrayList;
import cs414.a5.nwalling.common.models.IOrderModel;
import cs414.a5.nwalling.common.models.IPaymentModel;
import cs414.a5.nwalling.common.models.IUserModel;

/**
 *
 * @author Jacob
 */
public class FunctionalTester {
    public static void main(String[] args) throws StorageException
    {
        IDataSource source = new PizzaServiceClient("http://localhost:8080");
        IModelFactory m = new ModelFactory(source);
        IControllerFactory f = new ControllerFactory(m,source);
        IPaymentModel p= m.getEmptyIPaymentModel();
        p.setCardFirstName("dog");
        p.setCardLastName("doggingTon");
        p.setCardNumber(12);
        p.setCustomerAddress1("woof1");
        p.setCustomerAddress2("woof2");
        p.setCustomerCity("wan");
        p.setCustomerName("dog");
        p.setCustomerZip(1234);
        p.save();
//        ILoginController c = f.getLoginController();
//        ArrayList<IOrderModel> o = source.getOrders();
//        IUserModel u = source.getUser("Jbparker", "CATSANDDAWGSYO");
        
    }
}
