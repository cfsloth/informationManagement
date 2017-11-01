/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.controller;

import com.informantionmanagement.model.LoginModel;
import com.informationmanagement.viewer.LoginUIController;

/**
 *
 * @author ASUS
 */
public class LoginController {
    private LoginUIController loginUI;
    private LoginModel loginModel;
    
    public LoginController(LoginUIController loginUI, LoginModel loginModel){
        this.loginModel = loginModel;
        this.loginUI = loginUI;
    }

    public LoginUIController getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginUIController loginUI) {
        this.loginUI = loginUI;
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
}
