/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import exceptions.LoadException;
import exceptions.StorageException;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Jacob
 */
public class UserModel extends AbstractModel implements IUserModel {
    //NOTE: Jacob, I've left the sample property in this class for now as an example.
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_USERNAME = "username";
    public static final transient String PROP_PASSWORD = "password";
    public static final transient String PROP_FIRSTNAME = "firstName";
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
    private String address1;
    private String address2;
    private int authLevel;
    
    
    public UserModel() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    //<editor-fold desc="Id">
    public int getId() {
        return id;
    }
    public void setId(int value) {
        id = value;
    }
    //</editor-fold>
    //<editor-fold desc="UserName">
    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public void setUsername(String value) {
        userName = value;
    }
    //</editor-fold>
    //<editor-fold desc="Password">
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public void setPassword(String value) {
        password = value;
    }
    //</editor-fold>
    //<editor-fold desc="FirstName">
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String value) {
        firstName = value;
    }
    //</editor-fold>
    //<editor-fold desc="LastName">
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String value) {
        lastName = value;
    }
    //</editor-fold>
    //<editor-fold desc="Address">
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String value) {
        address1 = value;
    }
    //</editor-fold>
    //<editor-fold desc="Address2">
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String value) {
        address2 = value;
    }
    //</editor-fold>
    //<editor-fold desc="AuthLevel">
    public int getAuthLevel() {
        return authLevel;
    }
    public void setAuthLevel(int value) {
        authLevel = value;
    }
    //</editor-fold>
    
    
    @Override
    public boolean save() {
        try
        {
            source.saveUser(this);
            return true;
        }
        catch(Exception e)
        {
            //TODO: Do something here
        }
        return false;
    }

//    @Override
//    public void getById(int id) {
//        try
//        {
//            UserModel tempUser = new UserModel();
//            tempUser = ((UserModel)source.getUser(id));
//            setId(tempUser.getId());
//            setUserName(tempUser.getUserName());
//            setPassword(tempUser.getPassword());
//            setFirstName(tempUser.getFirstName());
//            setLastName(tempUser.getLastName());
//            setMiddleName(tempUser.getMiddleName());
//            setAddress(tempUser.getAddress());
//            setAuthLevel(tempUser.getAuthLevel());
//            
//        }
//        catch(Exception e)
//        {
//            //TODO: Do something here
//            Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }

    @Override
    public void load(HashMap<String, Object> fields) throws LoadException {
        if(fields == null || fields.keySet().size() < 1)
        {
            throw new LoadException("ItemModel: No fields passed in!");
        }
        if(fields.containsKey(PROP_ID.toLowerCase()))
            setId(Integer.parseInt(fields.get(PROP_ID.toLowerCase()).toString()));
        if(fields.containsKey(PROP_USERNAME.toLowerCase()))
            setUsername(fields.get(PROP_USERNAME.toLowerCase()).toString());
        if(fields.containsKey(PROP_PASSWORD.toLowerCase()))
            setPassword(fields.get(PROP_PASSWORD.toLowerCase()).toString());
        if(fields.containsKey(PROP_FIRSTNAME.toLowerCase()))
            setFirstName(fields.get(PROP_FIRSTNAME.toLowerCase()).toString());
        if(fields.containsKey(PROP_LASTNAME.toLowerCase()))
            setLastName(fields.get(PROP_LASTNAME.toLowerCase()).toString());
//        if(fields.containsKey(PROP_ADDRESS.toLowerCase()+"id"))
//            setAddress1(Integer.parseInt(fields.get(PROP_ADDRESS.toLowerCase()+"id").toString()));
        if(fields.containsKey(PROP_AUTHLEVEL.toLowerCase()+"id"))
            setAuthLevel(Integer.parseInt(fields.get(PROP_AUTHLEVEL.toLowerCase()+"id").toString()));
    }

//    public void getByAccount() {
//        try {
//            setId(-1);
//            String username = getUserName();
//            String password = getPassword();
//            ArrayList<IModel> users = source.getUsers();
//            users.stream().forEach((model) -> {
//                if(((UserModel)model).getUserName().equals(username) &&
//                   ((UserModel)model).getPassword().equals(password))
//                        getById(((UserModel)model).getId());
//            });
//        } catch (StorageException ex) {
//           
//        }
//        if(getId() == -1){
//            setUserName("Guest");
//            setAuthLevel(5);
//        }
//    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
