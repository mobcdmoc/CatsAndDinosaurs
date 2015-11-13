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
public interface IOrderModel extends IModel{
    double getTotal();
    void setTotal(double value);
    void addItem(ItemModel item);
    void removeItem(ItemModel item);
}
