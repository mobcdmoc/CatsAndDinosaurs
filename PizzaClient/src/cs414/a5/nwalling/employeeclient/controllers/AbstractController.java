/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.employeeclient.controllers;

import cs414.a5.nwalling.common.data.IDataSource;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import cs414.a5.nwalling.common.models.IModel;

/**
 *
 * @author Jacob
 */
public abstract class AbstractController implements IController, Serializable
{
    public static final String PROP_MODEL = "model";
    public static final String PROP_USER = "user";
    
    protected PropertyChangeSupport propertySupport;
//    
    protected IModel user;
//    protected IModel model;
    
    protected IDataSource source;
    
    public AbstractController()
    {
        propertySupport = new PropertyChangeSupport(this);
    }
    
//    public AbstractController(IDataSource source) {
//        this();
//        this.source = source;
//    }
    @Override
    public void init(IDataSource source)
    {
        this.source = source;
    }
    
    public IModel getUser()
    {
        return user;
    }
    
    public void setUser(IModel value)
    {
        user = value;
    }
    
//    public IModel getModel()
//    {
//        return model;
//    }
    
//    public void setModel(IModel value)
//    {
//        model = value;
//    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
