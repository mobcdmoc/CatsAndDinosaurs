/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.employeeclient.controllers;

import cs414.a5.nwalling.common.data.IDataSource;

/**
 *
 * @author Jacob
 */
public interface IController {
    //sends the model as is to the datacontext to be saved.
    void submit();
    //gets the most up to date version of the model
    void get();
    //should be run onclose
    void onClose();
    //Initializes the controller
    void init(IDataSource source);
   
    /*
    The run command method is ment to handle requests that may not be a part 
    of all controllers, this would be something such as an add or remove.
    
    It works by taking a command as a string which will then be mapped to a
    private method that can handle the input given. 
    
    This is kind of a crutch to handle specialized commands that aren't necessarily
    an existing part of all controllers. It may be a good idea to find another way
    to handle this situation.
    */
    void runCommand(String command, Object input);
}
