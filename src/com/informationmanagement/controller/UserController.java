/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.controller;

import com.google.gson.Gson;
import com.informationmanagement.model.UserModel;
import com.informationmanagement.viewer.LoginUIController;
import com.informationmanagement.viewer.UserUIController;

/**
 *
 * @author ASUS
 */
public class UserController {
    private UserModel user;
    
    private UserUIController userUI;
    
   
    public UserController(UserModel user, UserUIController userUI){
        this.user = user;
        this.userUI = userUI;
    }
    
    
    public boolean changePassword(UserModel model, String oldPassword
            ,String newPassword, String newPassword2) throws Exception{
        if(newPassword.equals(newPassword2) && oldPassword.equals(model.getPassword()) 
                && (!newPassword.equals("") || !newPassword2.equals("")) && !oldPassword.equals("")){
            UserModel userToJson = new UserModel();
            userToJson.setEmail(model.getEmail());
            userToJson.setPassword(newPassword);
            Gson json = new Gson();
            String userJson = json.toJson(userToJson);
            this.user.setUserPassword(userJson);
            return true;
        }
        throw new Exception("Error: Make sure your new passwords are equal and/or you inserted your old password right");
    }
     
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
