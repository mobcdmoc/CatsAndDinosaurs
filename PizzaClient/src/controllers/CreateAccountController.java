/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import models.UserModel;

/**
 *
 * @author Jacob
 */
public class CreateAccountController extends AbstractController{

    public CreateAccountController()
    {
        super();
        model = new UserModel();
    }
    
    public void init(IDataSource source)
    {
        this.source = source;
        model.init(source);
    }
    
    public void submit(int creatorAuth){
        if(creatorAuth > 0 & creatorAuth < 5)
            ((UserModel)model).setAuthLevel(creatorAuth+1);
        else
            ((UserModel)model).setAuthLevel(5);
        model.save();
        }

    @Override
    public void submit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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