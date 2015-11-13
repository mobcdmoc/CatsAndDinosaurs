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
public interface IItemModel extends IModel {
    double getDisplayPrice();
    double getPrice();
    void setPrice(double value);
    double getSpecialPrice();
    void setSpecialPrice(double value);
    boolean getIsSpecial();
    void setIsSpecial(boolean value);
    boolean getIsActive();
    void setIsActive(boolean value);
    
}
