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
public interface IModel {
    public void save();
    public IModel get(int id);
}
