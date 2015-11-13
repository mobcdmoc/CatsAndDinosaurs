/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.IChangeMenuModel;
import models.MenuModel;

/**
 *
 * @author Jacob
 */
public class ChangeMenuController extends AbstractController implements IChangeMenuController{

    IChangeMenuModel model;
    public ChangeMenuController(IChangeMenuModel model)
    {
        super();
        this.model = model;
    }


    public void remove(int[] indices)
    {
    }
    
    public void newItem(String name, double price)
    {
    }
    
    public void revokeSpecial(int[] indecies)
    {
    }
    public void newSpecialPrice(int index, double price)
    {
    }
    
    @Override
    public void save() {
       model.save();
    }
    
}
