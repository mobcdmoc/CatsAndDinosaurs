/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.testObjects;

import cs414.a5.nwalling.data.IDataSource;
import cs414.a5.nwalling.exceptions.LoadException;
import java.util.HashMap;
import cs414.a5.nwalling.models.IUserModel;

/**
 *
 * @author Jacob
 */
public class TestIUserModel implements IUserModel{

    public boolean IsValid = true;
    
    @Override
    public String getUsername() {
        if(IsValid)
            return "GOODNAME";
        return "    \t";
    }

    @Override
    public void setUsername(String value) {
        
    }

    @Override
    public String getPassword() {
        if(IsValid)
            return "GOODPASSWORD";
        return "    \t";
    }

    @Override
    public void setPassword(String value) {
        
    }

    @Override
    public String getFirstName() {
        if(IsValid)
            return "GOODNAME";
        return "    \t";
    }

    @Override
    public void setFirstName(String value) {
        
    }

    @Override
    public String getLastName() {
        if(IsValid)
            return "GOODNAME";
        return "    \t";
    }

    @Override
    public void setLastName(String value) {
        
    }

    @Override
    public String getAddress1() {
        if(IsValid)
            return "GOODADDRESS";
        return "    \t";
    }

    @Override
    public void setAddress1(String value) {
        
    }

    @Override
    public String getAddress2() {
        if(IsValid)
            return "GOODADDRESS";
        return "    \t";
    }

    @Override
    public void setAddress2(String value) {
        
    }

    @Override
    public int getZip() {
        if(IsValid)
            return 1234;
        return -123123;
    }

    @Override
    public void setZip(int value) {
        
    }

    
    @Override
    public boolean save() {
        return true;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(IDataSource source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(HashMap<String, Object> fields) throws LoadException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmailAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmailAddress(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCity(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAuthLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthLevel(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
