/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import models.IUserModel;

/**
 *
 * @author Jacob
 */
public class CreateAccountController extends AbstractController implements ICreateAccountController{

    IUserModel model;
    
    public CreateAccountController(IUserModel model)
    {
        super();
        this.model = model;
    }
    
    @Override
    public void init(IDataSource source)
    {
        this.source = source;
        model.init(source);
    }
    
    @Override
    public boolean usernameExists(String name) {
        return source.validateUsername(name);
    }

    @Override
    public boolean createUser() {
        return model.save();
    }
    
    @Override
    public boolean validPassword() {
        return false;
    }
    
    @Override
    public void setUsername(String value) {
        model.setUsername(value);
    }

    @Override
    public void setPassword(String value) {
       model.setPassword(value);
    }

    @Override
    public void setFirstName(String value) {
        model.setFirstName(value);
    }

    @Override
    public void setLastName(String value) {
        model.setLastName(value);
    }

    @Override
    public void setAddress1(String value) {
        model.setAddress1(value);
    }

    @Override
    public void setAddress2(String value) {
        model.setAddress2(value);
    }

//    public void submit(int creatorAuth){
//        if(creatorAuth > 0 & creatorAuth < 5)
//            (model).setAuthLevel(creatorAuth+1);
//        else
//            (model).setAuthLevel(5);
//        model.save();
//    }
}