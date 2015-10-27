/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.PaymentType;
import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;

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
    public IModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(HashMap<String, Object> fields) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
