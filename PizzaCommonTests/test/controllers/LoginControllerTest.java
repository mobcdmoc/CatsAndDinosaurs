/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static junit.framework.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import testObjects.TestIDataSource;
import testObjects.TestIModelFactory;

/**
 *
 * @author Jacob
 */
public class LoginControllerTest {
    @Test
    public void LoginControllerCtor()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
    }
    
}
