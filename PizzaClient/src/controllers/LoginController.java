/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import models.IModel;
import models.UserModel;

/**
 *
 * @author Jacob
 */
public class LoginController extends AbstractController{

    public LoginController()
    {
        super();
        model = new UserModel();
    }
    
    public void init(IDataSource source)
    {
        this.source = source;
        model.init(source);
    }
    
    @Override
    public void submit() {
        model.save();
    }

    @Override
    public void get() {
        model.get();
    }

    public void get(String username, String password){
        ((UserModel)model).get(username, password);
        //user = new model;
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
