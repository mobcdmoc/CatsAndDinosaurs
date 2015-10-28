/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import exceptions.LoadException;
import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Jacob
 */
public class UserModel extends AbstractModel {
    //NOTE: Jacob, I've left the sample property in this class for now as an example.
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_USERNAME = "userName";
    public static final transient String PROP_PASSWORD = "password";
    public static final transient String PROP_FIRSTNAME = "firstName";
    public static final transient String PROP_MIDDLENAME = "middleName";
    public static final transient String PROP_LASTNAME = "lastName";
    public static final transient String PROP_ADDRESS = "address";
    public static final transient String PROP_AUTHLEVEL = "authLevel";
    
    private int id;
    private String userName;
    /*
    In a real system we would encrypt and do as much as we possibly could
    to prevent anyone from seeing this value. but for this we don't really care
    */
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private int address;
    private int authLevel;
    
    
    public UserModel() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    //<editor-fold desc="Id">
    public int getId() {
        return id;
    }
    public void setId(int value) {
        int oldValue = id;
        id = value;
        propertySupport.firePropertyChange(PROP_ID, oldValue, id);
    }
    //</editor-fold>
    //<editor-fold desc="UserName">
    public String getUserName() {
        return userName;
    }
    public void setUserName(String value) {
        String oldValue = userName;
        userName = value;
        propertySupport.firePropertyChange(PROP_USERNAME, oldValue, userName);
    }
    //</editor-fold>
    //<editor-fold desc="Password">
    public String getPassword() {
        return password;
    }
    public void setPassword(String value) {
        String oldValue = password;
        password = value;
        propertySupport.firePropertyChange(PROP_PASSWORD, oldValue, password);
    }
    //</editor-fold>
    //<editor-fold desc="FirstName">
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String value) {
        String oldValue = firstName;
        firstName = value;
        propertySupport.firePropertyChange(PROP_FIRSTNAME, oldValue, firstName);
    }
    //</editor-fold>
    //<editor-fold desc="MiddleName">
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String value) {
        String oldValue = middleName;
        middleName = value;
        propertySupport.firePropertyChange(PROP_MIDDLENAME, oldValue, middleName);
    }
    //</editor-fold>
    //<editor-fold desc="LastName">
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String value) {
        String oldValue = lastName;
        lastName = value;
        propertySupport.firePropertyChange(PROP_LASTNAME, oldValue, lastName);
    }
    //</editor-fold>
    //<editor-fold desc="Address">
    public int getAddress() {
        return address;
    }
    public void setAddress(int value) {
        int oldValue = address;
        address = value;
        propertySupport.firePropertyChange(PROP_ADDRESS, oldValue, address);
    }
    //</editor-fold>
    //<editor-fold desc="AuthLevel">
    public int getAuthLevel() {
        return authLevel;
    }
    public void setAuthLevel(int value) {
        int oldValue = authLevel;
        authLevel = value;
        propertySupport.firePropertyChange(PROP_AUTHLEVEL, oldValue, authLevel);
    }
    //</editor-fold>
    
    
    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(HashMap<String, Object> fields) throws LoadException {
        if(fields == null || fields.keySet().size() < 1)
        {
            throw new LoadException("ItemModel: No fields passed in!");
        }
        //NOTE: This is a little gross but it should work.
        //We may want to find a more elegant way of doing this
        //maybe through reflection.
        if(fields.containsKey(PROP_ID.toLowerCase()))
            setId(Integer.parseInt(fields.get(PROP_ID.toLowerCase()).toString()));
        if(fields.containsKey(PROP_USERNAME.toLowerCase()))
            setUserName(fields.get(PROP_USERNAME.toLowerCase()).toString());
        if(fields.containsKey(PROP_PASSWORD.toLowerCase()))
            setPassword(fields.get(PROP_PASSWORD.toLowerCase()).toString());
        if(fields.containsKey(PROP_FIRSTNAME.toLowerCase()))
            setFirstName(fields.get(PROP_FIRSTNAME.toLowerCase()).toString());
        if(fields.containsKey(PROP_MIDDLENAME.toLowerCase()))
            setMiddleName(fields.get(PROP_MIDDLENAME.toLowerCase()).toString());
        if(fields.containsKey(PROP_LASTNAME.toLowerCase()))
            setLastName(fields.get(PROP_LASTNAME.toLowerCase()).toString());
        if(fields.containsKey(PROP_ADDRESS.toLowerCase()+"id"))
            setAddress(Integer.parseInt(fields.get(PROP_ADDRESS.toLowerCase()+"id").toString()));
        if(fields.containsKey(PROP_AUTHLEVEL.toLowerCase()+"id"))
            setAuthLevel(Integer.parseInt(fields.get(PROP_AUTHLEVEL.toLowerCase()+"id").toString()));
    }

    @Override
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
