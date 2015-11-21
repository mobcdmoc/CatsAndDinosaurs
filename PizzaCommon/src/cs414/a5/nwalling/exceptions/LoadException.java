/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.exceptions;

/**
 *
 * @author Jacob
 */
public class LoadException extends Exception {

    /**
     * Creates a new instance of <code>LoadException</code> without detail
     * message.
     */
    public LoadException() {
    }

    /**
     * Constructs an instance of <code>LoadException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LoadException(String msg) {
        super(msg);
    }
    public LoadException(String msg, Exception e)
    {
        super(msg,e);
    }
}
