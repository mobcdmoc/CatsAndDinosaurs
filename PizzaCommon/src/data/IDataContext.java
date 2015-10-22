/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import models.IModel;

/**
 *
 * @author Jacob
 */
public interface IDataContext {
    IModel getAddress(int id);
    IModel getEmployee(int id);
    IModel getItem(int id);
    ArrayList<IModel> getItems();
    IModel getMenu();
    IModel getOrder(int id);
    IModel getPizza(int id);
    ArrayList<IModel> getToppings();
    IModel getUser(int id);
    void saveAddress(IModel model);
    void saveEmployee(IModel model);
    void saveItem(IModel model);
    void saveMenu(IModel model);
    void saveOrder(IModel model);
    void savePizza(IModel model);
    void saveUser(IModel model);
}
