/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.controllers;

import cs414.a5.nwalling.enums.InputResults;
import cs414.a5.nwalling.testObjects.TestIDataSource;
import cs414.a5.nwalling.testObjects.TestIModelFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacob
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void LoginControllerCtor()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void LoginControllerCtorNullSource()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,null);
        assertNotNull(controller);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void LoginControllerCtorNullFactory()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(null,s);
        assertNotNull(controller);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void LoginControllerCtorNullFactoryNullSource()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(null,null);
        assertNotNull(controller);
    }
    
    //Not sure if login can be tested. If it will contain a redirect it can't
//    @Test()
//    public void LoginControllernLoginSuccessfull()
//    {
//        TestIModelFactory mf = new TestIModelFactory();
//        TestIDataSource s = new TestIDataSource();
//        LoginController controller = new LoginController(null,null);
//        assertNotNull(controller);
//    }
    @Test()
    public void LoginControllerCtorNullFactorySetUserName()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
        assertEquals(InputResults.ValidInput, controller.setUsername("SOME VALUE"));
    }
    @Test()
    public void LoginControllerCtorNullFactorySetUserNameWhiteSpace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
        assertEquals(InputResults.InputWhiteSpace, controller.setUsername("  \t"));
    }
    @Test()
    public void LoginControllerCtorNullFactorySetUserNameNull()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
        assertEquals(InputResults.InputNull, controller.setUsername(null));
    }
    
    @Test()
    public void LoginControllerCtorNullFactorySetPassword()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
        assertEquals(InputResults.ValidInput, controller.setPassword("Some Value"));
    }
    
    @Test()
    public void LoginControllerCtorNullFactorySetPasswordWhiteSpace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
        assertEquals(InputResults.InputWhiteSpace, controller.setPassword("     \t"));
    }
    @Test()
    public void LoginControllerCtorNullFactorySetPasswordNull()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        LoginController controller = new LoginController(mf,s);
        assertNotNull(controller);
        assertEquals(InputResults.InputNull, controller.setPassword(null));
    }
}
