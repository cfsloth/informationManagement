/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informantionmanagement.model;

import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class LoginModel {
    private String username;
    private String password;
    
    public LoginModel(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public boolean verifyUser() throws ClassNotFoundException, SQLException{
        DatabaseConection db = new DatabaseConection();
        return false;
    }
    
    
    
}
