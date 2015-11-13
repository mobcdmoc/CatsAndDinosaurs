/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import models.IUserModel;
import models.UserModel;

/**
 *
 * @author Jacob
 */
public class LoginController extends AbstractController implements ILoginController {

    private IUserModel model;
    public LoginController(IUserModel model)
    {
        super();
        this.model = model;
    }
    
    @Override
    public void init(IDataSource source)
    {
        super.init(source);
        model.init(source);
    }
    
    @Override
    public void login() {
        try
        {
            IUserModel user = (IUserModel)source.getUser(model.getUsername(), model.getPassword());
            //Insert local login logic here.
            
            
            
            //End Local Login Logic
        }
        catch(Exception e)
        {
            //Should never throw an exception but if it does you need to do something with it.
            //Display an error or something or log the errror somehow
        }
    }   
    
    //This method is so that you can set the username and password into the model when it's provided
    //I would suggest calling these methods on focus lost of their respective text boxes.
    @Override
    public void setUsername(String value) {
        model.setUsername(value);
    }

    @Override
    public void setPassword(String value) {
        model.setPassword(value);
    }
}
