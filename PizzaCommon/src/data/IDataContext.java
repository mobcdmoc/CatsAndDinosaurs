/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import models.IModel;

/**
 *
 * @author Jacob
 */
public interface IDataContext {
    IModel get(int id);
    void save(IModel model);
}
