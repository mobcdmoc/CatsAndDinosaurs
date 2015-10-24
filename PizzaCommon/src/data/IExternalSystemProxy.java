/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import models.PaymentModel;

/**
 *
 * @author Jacob
 */
public interface IExternalSystemProxy {
    public boolean AuthorizePayment(PaymentModel paymentInfo);
}
