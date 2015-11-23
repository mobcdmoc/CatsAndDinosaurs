/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.common.controllers;

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
    protected PropertyChangeSupport propertySupport;

    protected IDataSource source;
    
    public AbstractController(IDataSource source) throws IllegalArgumentException
    {
        if(source == null)
            throw new IllegalArgumentException();
        this.source = source;
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
