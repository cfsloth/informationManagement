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
 * @author ASUS
 */
public class UserController {
    private UserModel user;
    private LoginUIController loginUI;
    
    public UserController(UserModel user, LoginUIController loginUI){
        this.user = user;
        this.loginUI= loginUI;
    }
    
    //Complete
    public int verifyUser(String email, String password) throws Exception{
        UserModel model = new UserModel();
        if(password.equals(model.getUser(email).getPassword())){
            return 1;
        }
        return 0;
    }
    
    public void changePassword(String email, String oldPassword
            ,String newPassword, String newPassword2) throws Exception{
        if(newPassword.equals(newPassword2) && 
                oldPassword.equals(this.user.getUser(email).getPassword())){
                //change password -> put method
        }
        throw new Exception("Error: Make sure your new passwords are equal and/or you inserted your old password right");
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
