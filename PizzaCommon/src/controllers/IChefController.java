/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.IOrderModel;

/**
 *
 * @author Jacob
 */
public interface IChefController extends IController {
    void markDone();
    void submit();
    ArrayList<String> getOrders();
    
}
