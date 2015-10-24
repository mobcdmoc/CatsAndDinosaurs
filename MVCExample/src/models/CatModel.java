/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Jacob
 */
public class CatModel extends AbstractModel {
    
    public static final String PROP_NAME = "name";
    public static final String PROP_SIZE = "size";
    
    private String name = "Chester";
    private int size = 120;
    
    public CatModel()
    {
        super();
    }
    
    public String getName(){
        return name;
    }
    public void setName(String value) {
        String oldValue = name;
        name = value;
        propertySupport.firePropertyChange(PROP_NAME, oldValue, name);
    }
    
    public int getSize() {
        return size;
    }
    public void setSize(int value) {
        int oldValue = size;
        size = value;
        propertySupport.firePropertyChange(PROP_SIZE, oldValue, size);
    }

    @Override
    public void get() {
        setName("Chester");
        setSize(120);
    }
}
