/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.models;

import cs414.a5.nwalling.exceptions.StorageException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import cs414.a5.nwalling.testObjects.TestIDataSource;
import org.junit.Assert;

/**
 *
 * @author Nick
 */
public class ItemModelTest {
    
    @Test
    public void ItemModelCtor(){
        ItemModel i = new ItemModel();
        TestIDataSource tids;
        tids = new TestIDataSource();
        ItemModel j = new ItemModel(tids);
        assertNotNull(i);
        assertNotNull(j);
//        assertEquals(j.source,tids);
//        assertNull(i.source);
    }
    
    @Test
    public void ItemModelGetters(){
        ItemModel i = new ItemModel(new TestIDataSource());
        ItemModel nullItem = null;
        assertNotNull(i.getId());
        assertNull(i.getName());
        assertNotNull(i.getPrice());
//        assertNotNull(i.getType());
        assertNotNull(i.getSpecialPrice());
        assertNotNull(i.getIsSpecial());
        assertNotNull(i.getIsActive());
        
//        assertNull(nullItem.getId());
//        assertNull(nullItem.getName());
//        assertNull(nullItem.getPrice());
////        assertNull(nullItem.getType());
//        assertNull(nullItem.getSpecialPrice());
//        assertNull(nullItem.getIsSpecial());
//        assertNull(nullItem.getIsActive());
    }
    
    @Test
    public void ItemModelSetters(){
        ItemModel i = new ItemModel();
        
        i.setId(1);
        i.setName("Bob");
        i.setPrice(1.23);
//        i.setType(3);
        i.setSpecialPrice(0.01);
        i.setIsSpecial(true);
        i.setIsActive(true);
        
        assertEquals(i.getId(),1);
        assertEquals(i.getName(),"Bob");
        assertEquals(i.getPrice(),1.23,0);
//        assertEquals(i.getType(),3);
        assertEquals(i.getSpecialPrice(),0.01,0);
        assertTrue(i.getIsSpecial());
        assertTrue(i.getIsActive());
    }
    
    @Test
    public void ItemModelSave(){
        ItemModel i = new ItemModel(new TestIDataSource());
//        ItemModel nullItem = null;
        
        assertTrue(i.save());
//        nullItem.save();
        
    }
    
    @Test
    public void ItemModelgetById(){
        
        TestIDataSource tids = new TestIDataSource();

//        i.getById(0);
        try {
            assertNotNull(tids.getItem(0));
        } catch (StorageException ex) {
            Assert.fail("Exception thrown!");
        }
    
    }
    
}
    
