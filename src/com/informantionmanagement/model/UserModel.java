/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informantionmanagement.model;

import com.google.gson.Gson;

/**
 *
 * @author Claudio
 */
public class UserModel extends WebServiceConnection{
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String userTypes_id_type;
    private String URI = "http://192.168.1.2:8081/WebServiceIM/user.php?email="; 
    
    public UserModel(String email, String password, String firstName, String lastName){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userTypes_id_type = "";
    }
    
    
    public UserModel() {
        
    }
    
    public UserModel getUser(String email) throws Exception {
        String result = super.getRequest(URI + email);
        Gson a = new Gson();
        UserModel user = a.fromJson(result, UserModel.class);
        if(user.getFirstName() == null){
            throw new Exception("User not found in database!");
        }
        return user;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserTypes_id_type() {
        return userTypes_id_type;
    }

    public void setUserTypes_id_type(String userTypes_id_type) {
        this.userTypes_id_type = userTypes_id_type;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
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
