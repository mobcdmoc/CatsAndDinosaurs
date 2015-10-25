/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import models.IModel;

/**
 *
 * @author Jacob
 */
public abstract class AbstractController implements IController, Serializable
{
    public static final String PROP_MODEL = "model";
    public static final String PROP_USER = "user";
    
    protected PropertyChangeSupport propertySupport;
    
    protected IModel user;
    protected IModel model;
    
    protected IDataSource source;
    
    public AbstractController(IDataSource source) {
        propertySupport = new PropertyChangeSupport(this);
        this.source = source;
    }
    
    public IModel getUser()
    {
        return model;
    }
    
    public void setUser(IModel value)
    {
        IModel oldValue = user;
        user = value;
        propertySupport.firePropertyChange(PROP_USER, oldValue, user);
    }
    
    public IModel getModel()
    {
        return model;
    }
    
    public void setModel(IModel value)
    {
        IModel oldValue = model;
        model = value;
        propertySupport.firePropertyChange(PROP_MODEL, oldValue, model);
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
