/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.employeeclient.controllers;

import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.exceptions.StorageException;
import cs414.a5.nwalling.common.models.IUserModel;
import cs414.a5.nwalling.common.models.UserModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class CreateAccountController extends AbstractController{

    UserModel model;
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
//        if(creatorAuth > 0 & creatorAuth < 5)
//            ((UserModel)model).setAuthLevel(creatorAuth+1);
//        else
//            ((UserModel)model).setAuthLevel(5);
        model.save();
        }

    public boolean usernameExists(String username)
    {
        try {
            ArrayList<IUserModel> users = source.getUsers();
            for(IUserModel user : users)
                if(user.getUsername().equals(username))
                    return true;
            return false;
        } catch (StorageException ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void submit(String firstname,String lastname, String username,String password, int authlevel) {
        UserModel u = new UserModel();
        u.setFirstName(firstname);
        u.setLastName(lastname);
        u.setUsername(username);
        u.setPassword(password);
        u.setAuthLevel(authlevel);
        try {
            source.saveUser(u);
        } catch (StorageException ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void get() {
//        model.get();
    }

    @Override
    public void onClose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void runCommand(String command, Object input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}