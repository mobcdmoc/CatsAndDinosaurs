/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.PaymentType;
import exceptions.LoadException;
import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;
import static models.UserModel.PROP_ADDRESS;
import static models.UserModel.PROP_AUTHLEVEL;
import static models.UserModel.PROP_FIRSTNAME;
import static models.UserModel.PROP_ID;
import static models.UserModel.PROP_LASTNAME;
import static models.UserModel.PROP_MIDDLENAME;
import static models.UserModel.PROP_PASSWORD;
import static models.UserModel.PROP_USERNAME;

/**
 *
 * @author Jacob
 */
public class PaymentModel extends AbstractModel {
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_TYPE = "type";
    public static final transient String PROP_APPROVED = "approved";
    public static final transient String PROP_TOTAL = "total";
    
    private int id;
    private PaymentType type;
    private boolean approved;
    private double total;
    
    public PaymentModel() 
    {
            super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
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
            throw new LoadException("PaymentModel: No fields passed in!");
        }
        //NOTE: This is a little gross but it should work.
        //We may want to find a more elegant way of doing this
        //maybe through reflection.
        if(fields.containsKey(PROP_ID.toLowerCase()))
            setId(Integer.parseInt(fields.get(PROP_ID.toLowerCase()).toString()));
        if(fields.containsKey(PROP_ADDRESS.toLowerCase()+"id"))
            setType(PaymentType.getPaymentType(Integer.parseInt(fields.get(PROP_TYPE.toLowerCase()+"id").toString())));
        if(fields.containsKey(PROP_APPROVED.toLowerCase()+"id"))
            setApproved(Boolean.parseBoolean(fields.get(PROP_ADDRESS.toLowerCase()+"id").toString()));
        if(fields.containsKey(PROP_TOTAL.toLowerCase()+"id"))
            setTotal(Double.parseDouble(fields.get(PROP_AUTHLEVEL.toLowerCase()+"id").toString()));
    }

    @Override
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
