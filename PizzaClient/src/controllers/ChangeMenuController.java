/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import models.MenuModel;

/**
 *
 * @author Jacob
 */
public class ChangeMenuController extends AbstractController{

    public ChangeMenuController()
    {
        super();
        model = new MenuModel();
    }
    
    public void init(IDataSource source)
    {
        this.source = source;
        model.init(source);
    }
    public void load()
    {
        
    }
    
    @Override
    public void submit() {
        model.save();
    }

    @Override
    public void get() {
        model.get();
    }

    @Override
    public void onClose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void runCommand(String command, Object input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
