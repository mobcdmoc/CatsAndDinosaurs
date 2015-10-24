/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.CatModel;
import models.IModel;

/**
 *
 * @author Jacob
 */
public class CatController extends AbstractController
{
    public static final String PROP_MODEL = "model";
    
    private IModel model;
    
    public CatController()
    {
        super();
        model = new CatModel();
    }
    
    public CatController(IModel model)
    {
        super();
        this.model = model;
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
    
    @Override
    public void get() {
        model.get();
    }
}
