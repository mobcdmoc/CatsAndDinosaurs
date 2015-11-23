/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.employeeclient.controllers;

import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.exceptions.StorageException;
import cs414.a5.nwalling.common.models.IModel;
import cs414.a5.nwalling.common.models.IUserModel;
import cs414.a5.nwalling.common.models.UserModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class LoginController extends AbstractController {
//    private IUserModel user;
    public LoginController()
    {
        super();
        user = new UserModel();
    }
    
    public void init(IDataSource source)
    {
        this.source = source;
        user.init(source);
    }
    
    @Override
    public void submit() {
        user.save();
    }

    public void get(String username, String password) {
        try {
          user = source.getUser(username, password);

        } catch (StorageException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserModel getUser(){
        return (UserModel) (user);
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
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
