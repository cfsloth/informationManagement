/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.controller;

import com.informantionmanagement.model.UserModel;
import com.informationmanagement.viewer.LoginUIController;

/**
 *
 * @author ASUS
 */
public class UserController {
    private UserModel user;
    private LoginUIController loginUI;
    
    public UserController(UserModel user, LoginUIController loginUI){
        this.user = user;
        this.loginUI= loginUI;
    }
    
    //Incomplete
    public boolean verifyLogin(){
        return false;
        
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public LoginUIController getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginUIController loginUI) {
        this.loginUI = loginUI;
    }
}
