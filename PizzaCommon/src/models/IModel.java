/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import data.IDataSource;
import exceptions.LoadException;
import java.util.HashMap;

/**
 *
 * @author Jacob
 */
public interface IModel {
    public void save();
    public IModel get(int id);
    public IModel get();
    public void init(IDataSource source);
    /*
    The load method takes a hashmap of string object and 
    uses it to place the provided values in the model.
    
    It expects the key names to be all lowercase and identical
    to the property name.
    */
    public void load(HashMap<String,Object> fields) throws LoadException;
}
