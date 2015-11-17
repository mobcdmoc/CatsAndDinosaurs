/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import controllers.ILoginController;
import controllers.LoginController;
import data.ControllerFactory;
import data.IControllerFactory;
import data.IDataSource;
import data.IModelFactory;
import data.ModelFactory;
import data.PizzaServiceClient;
import exceptions.StorageException;
import models.IUserModel;

/**
 *
 * @author Jacob
 */
public class FunctionalTester {
    public static void main(String[] args) throws StorageException
    {
        IDataSource source = new PizzaServiceClient();
        IModelFactory m = new ModelFactory(source);
        IControllerFactory f = new ControllerFactory(m,source);
        
//        ILoginController c = f.getLoginController();
        IUserModel u = m.getEmptyIUserModel();
        u.setUsername("cat");
        u.setAddress1("mew");
        u.setAddress2("mew");
        u.setCity("meow");
        u.setEmailAddress("cats@cats.com");
        u.setFirstName("CATS");
        u.setLastName("CATS");
        u.setPassword("cats");
        u.setZip(1234);
        u.setAuthLevel(1);
        u.save();
//        IUserModel u = source.getUser("Jbparker", "CATSANDDAWGSYO");
        
    }
}
