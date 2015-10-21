/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Jacob
 */
public class DbMapper {
    private ArrayList<DbMapping> mappings;
    
    public String mapToTable(Type type)
    {
        throw new NotImplementedException();
    }
    public Type mapToModel(String table)
    {
        throw new NotImplementedException();
    }
}
