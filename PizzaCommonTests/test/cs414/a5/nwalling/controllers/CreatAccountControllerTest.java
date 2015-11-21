/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.controllers;

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
public class CreatAccountControllerTest {
    
    public CreatAccountControllerTest() {
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
    public void CreateAccountControllerCtor()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void CreateAccountControllerCtorNullFactory()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(null,s);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void CreateAccountControllerCtorNullSource()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void CreateAccountControllerCtorNullFactoryNullSource()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(null,null);
    }
    
    
    @Test
    public void CreateAccountControllerUserNameExistsTrue()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        assertTrue(controller.usernameExists("true"));
    }
    @Test
    public void CreateAccountControllerUserNameExistsFalse()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        assertFalse(controller.usernameExists("false"));
    }
    @Test
    public void CreateAccountControllerUserNameExistsException()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        assertTrue(controller.usernameExists("BAD"));
    }
    
    @Test
    public void CreateAccountControllerSetUsername()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setUsername("some name1234][]]{}==--++");
    }
    @Test
    public void CreateAccountControllerSetUsernameNull()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setUsername(null);
    }
    @Test
    public void CreateAccountControllerSetUsernameEmpty()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setUsername("");
    }
    @Test
    public void CreateAccountControllerSetUsernameWhitespace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setUsername("    \t");
    }
    
    
    
    
    
    @Test
    public void CreateAccountControllerSetPassword()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setPassword("some pass1234][]]{}==--++");
    }
    @Test
    public void CreateAccountControllerSetPasswordNull()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setPassword(null);
    }
    @Test
    public void CreateAccountControllerSetPasswordEmpty()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setPassword("");
    }
    @Test
    public void CreateAccountControllerSetPasswordWhitespace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setPassword("    \t");
    }
    
    
    @Test
    public void CreateAccountControllerSetFirstName()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setFirstName("some pass1234][]]{}==--++");
    }
    @Test
    public void CreateAccountControllerSetFirstNameNull()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setFirstName(null);
    }
    @Test
    public void CreateAccountControllerSetFirstNameEmpty()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setFirstName("");
    }
    @Test
    public void CreateAccountControllerSetFirstNameWhitespace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setFirstName("    \t");
    }
    
    @Test
    public void CreateAccountControllerSetLastName()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setLastName("some pass1234][]]{}==--++");
    }
    @Test
    public void CreateAccountControllerSetLastNameNull()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setLastName(null);
    }
    @Test
    public void CreateAccountControllerSetLastNameEmpty()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setLastName("");
    }
    @Test
    public void CreateAccountControllerSetLastNameWhitespace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setLastName("    \t");
    }
    
    @Test
    public void CreateAccountControllerSetAddress1()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress1("some pass1234][]]{}==--++");
    }
    @Test
    public void CreateAccountControllerSetAddress1Null()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress1(null);
    }
    @Test
    public void CreateAccountControllerSetAddress1Empty()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress1("");
    }
    @Test
    public void CreateAccountControllerSetAddress1Whitespace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress1("    \t");
    }
    
    
    @Test
    public void CreateAccountControllerSetAddress2()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress2("some pass1234][]]{}==--++");
    }
    @Test
    public void CreateAccountControllerSetAddress2Null()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress2(null);
    }
    @Test
    public void CreateAccountControllerSetAddress2Empty()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress1("");
    }
    @Test
    public void CreateAccountControllerSetAddress2Whitespace()
    {
        TestIModelFactory mf = new TestIModelFactory();
        TestIDataSource s = new TestIDataSource();
        CreateAccountController controller = new CreateAccountController(mf,s);
        assertNotNull(controller);
        controller.setAddress2("    \t");
    }
    
}
