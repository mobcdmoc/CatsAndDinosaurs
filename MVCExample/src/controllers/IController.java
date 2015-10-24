/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Jacob
 */
public interface IController {
    //This was taken from the current implementation of the interface in the
    //pizza app. The only method required for this example is get().
    
    //sends the model as is to the datacontext to be saved.
//    void submit();
    //gets the most up to date version of the model
    void get();
    //should be run onclose
//    void onClose();
    
    /*
    The run command method is ment to handle requests that may not be a part 
    of all controllers, this would be something such as an add or remove.
    
    It works by taking a command as a string which will then be mapped to a
    private method that can handle the input given. 
    
    This is kind of a crutch to handle specialized commands that aren't necessarily
    an existing part of all controllers. It may be a good idea to find another way
    to handle this situation.
    */
//    void runCommand(String command, Object input);
}
