/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.controllers;

import cs414.a5.nwalling.enums.InputResults;

/**
 *
 * @author Jacob
 */
public interface ILoginController extends IController {
    void login();
    InputResults setUsername(String value);
    InputResults setPassword(String value);
}
