/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.PaymentType;
import exceptions.LoadException;
import exceptions.StorageException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static models.UserModel.PROP_ADDRESS;
import static models.UserModel.PROP_AUTHLEVEL;

/**
 *
 * @author Jacob
 */
public class PaymentModel extends AbstractModel {
    public static final transient String PROP_ID = "id";
    public static final transient String PROP_TYPE = "type";
    public static final transient String PROP_APPROVED = "approved";
    public static final transient String PROP_TOTAL = "total";
    public static final transient String PROP_CARDHOLDER = "cardHolder";
    public static final transient String PROP_CARDNUMBER = "cardNumber";
    public static final transient String PROP_EXPRDAY = "day";
    public static final transient String PROP_EXPRMONTH = "month";
    public static final transient String PROP_EXPRYEAR = "year";
    public static final transient String PROP_SECCODE = "sec";
    
    private IModel order;
    
    private int id;
    private PaymentType type;
    private boolean approved;
    private String cardHolder;
    private int cardNumber;
    private int day;
    private int month;
    private int year;
    private int orderId;
    private double total;
    private int sec;
    
    public PaymentModel(IModel orderModel) 
    {
            super();
            order = orderModel;
            
            setTotal(((OrderModel)order).getTotal());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldValue = id;
        this.id = id;
        
        propertySupport.firePropertyChange(PROP_ID,oldValue, id);
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        PaymentType oldValue = this.type;
        this.type = type;
        
        propertySupport.firePropertyChange(PROP_TYPE,oldValue, type);
    }

    public boolean isApproved() {
        
        return approved;
    }

    public void setApproved(boolean approved) {
        boolean oldValue = this.approved;
        this.approved = approved;
        
        propertySupport.firePropertyChange(PROP_APPROVED,oldValue, approved);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        double oldValue = this.total;
        this.total = total;
        
        propertySupport.firePropertyChange(PROP_APPROVED,oldValue, approved);
    }
    
    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String value) {
        String oldValue = this.cardHolder;
        this.cardHolder = value;
        
        propertySupport.firePropertyChange(PROP_CARDHOLDER,oldValue, cardHolder);
    }
    public int getDay() {
        return day;
    }

    public void setDay(int value) {
        int oldValue = this.day;
        this.day = value;
        
        propertySupport.firePropertyChange(PROP_EXPRDAY,oldValue, day);
    }
    public int getMonth() {
        return month;
    }

    public void setMonth(int value) {
        int oldValue = this.month;
        this.month = value;
        
        propertySupport.firePropertyChange(PROP_EXPRMONTH,oldValue, month);
    }
    public int getYear() {
        return year;
    }

    public void setCardYear(int value) {
        int oldValue = this.year;
        this.year = value;
        
        propertySupport.firePropertyChange(PROP_EXPRYEAR,oldValue, year);
    }
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int value) {
        int oldValue = this.cardNumber;
        this.cardNumber = value;
        
        propertySupport.firePropertyChange(PROP_CARDNUMBER,oldValue, cardNumber);
    }
    public int getSec() {
        return sec;
    }

    public void setSec(int value) {
        int oldValue = this.sec;
        this.sec = value;
        
        propertySupport.firePropertyChange(PROP_SECCODE,oldValue, sec);
    }
    
    
    @Override
    public void save() {
        try {
            this.setTotal(((OrderModel)order).getTotal());
            source.saveOrder(order);
            //source.savePayment(this);
        } catch (StorageException ex) {
            Logger.getLogger(PaymentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void setPaymentType(int selectedIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
