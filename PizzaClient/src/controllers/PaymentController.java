/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import enums.PaymentType;
import models.IModel;
import models.PaymentModel;

/**
 *
 * @author Jacob
 */
public class PaymentController extends AbstractController {

    public PaymentController()
    {
        super();
    }
    public void init(IModel orderModel, IDataSource source)
    {
        init(source);
        
        model = new PaymentModel(orderModel);
        model.init(source);
    }
    @Override
    public void submit() {
        model.save();
    }

    @Override
    public void get() {
    }

    @Override
    public void onClose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void runCommand(String command, Object input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPaymentType(int selectedIndex) {
        ((PaymentModel)model).setType(PaymentType.getPaymentType(selectedIndex));
    }
    
}
