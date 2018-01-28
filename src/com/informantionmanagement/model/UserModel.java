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
public class UserModel extends WebServiceConnection{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public UserModel(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int verifyUser(String email, String password){
        return 1;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
