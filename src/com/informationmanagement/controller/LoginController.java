/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.controller;

import com.informationmanagement.model.UserModel;
import com.informationmanagement.viewer.LoginUIController;

/**
 *
 * @author Claudio
 */
public class LoginController {
    private UserModel user;
    private LoginUIController loginUI;
    
    public LoginController(UserModel user, LoginUIController loginUI){
        this.user = user;
        this.loginUI= loginUI;
    }
    
    //Need to upgrade this to trying to enter the system with a deleted user
    public int verifyUser(String email, String password) throws Exception{
        if(password.equals(this.user.getUser(email).getPassword()) &&  "0".equals(this.user.getUser(email).getDeleted())){
            return 1;
        }
        return 0;
    }
    
    public void sendEmail(){
        
    }
    
}
