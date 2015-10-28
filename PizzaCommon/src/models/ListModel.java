/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import data.IDataSource;
import exceptions.LoadException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob
 * @param <T>
 */
public class ListModel<T> extends AbstractListModel<T> implements IModel,List {
    
    private ArrayList<T> content;
    
    public ListModel()
    {
        content = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return content.size();
    }

    @Override
    public T getElementAt(int index) {
        return content.get(index);
    }

    @Override
    public void save() {
        
    }

    @Override
    public void getById(int id) {
        
    }

    @Override
    public void get() {
        
    }

    @Override
    public void init(IDataSource source) {
        
    }

    @Override
    public void load(HashMap<String, Object> fields) throws LoadException {
        
    }

    @Override
    public int size() {
        return content.size();
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return content.contains(o);
    }

    @Override
    public Iterator iterator() {
        return content.iterator();
    }

    @Override
    public Object[] toArray() {
        return content.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return content.toArray(a);
    }

    @Override
    public boolean add(Object e) {
        boolean results =  content.add((T)e);
        if(results)
            this.fireContentsChanged(this, content.size()-1, content.size()-1);
        return results;
    }

    @Override
    public boolean remove(Object o) {
        boolean results =  content.remove((T)o);
        if(results)
            this.fireContentsChanged(this, content.size()-1, content.size()-1);
        return results;
    }

    @Override
    public boolean containsAll(Collection c) {
        return content.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        boolean results = content.addAll(c);
        if(results)
            this.fireContentsChanged(this, content.size()-c.size()-1, content.size()-1);
        return results;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean results = content.addAll(index,c);
        if(results)
            this.fireContentsChanged(this, index, content.size()-c.size()-1);
        return results;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean results = content.addAll(c);
        if(results)
            this.fireContentsChanged(this, content.size()-c.size()-1, content.size()-1);
        return results;
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        content.clear();
        fireContentsChanged(this,0,0);
    }

    @Override
    public Object get(int index) {
        return content.get(index);
    }

    @Override
    public Object set(int index, Object element) {
        Object rtn = content.set(index, (T)element);
        if(rtn != null)
        {
            fireContentsChanged(this,content.size()-1,content.size()-1);
        }
        return rtn;
    }

    @Override
    public void add(int index, Object element) {
        content.add(index, (T)element);
        fireContentsChanged(this,content.size()-1,content.size()-1);
    }

    @Override
    public Object remove(int index) {
        Object rtn = content.remove(index);
        if(rtn != null)
        {
            fireContentsChanged(this,0,content.size()-1);
        }
        return rtn;
    }

    @Override
    public int indexOf(Object o) {
        return content.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return content.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator() {
        return content.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return content.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return content.subList(fromIndex, toIndex);
    }

    
    
}
