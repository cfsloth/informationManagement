/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.ProtocolException;

/**
 *
 * @author Claudio
 */
public class UserModel extends WebServiceConnection{
    private String id_user;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String userTypes_id_type;
    private String department;
    private String position;
    private String deleted;
    private String URI = PATH + "user.php"; 
    
    public UserModel(String email, String password, String firstName, String lastName,String department,String position,String user_type){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userTypes_id_type = "";
        this.department = department;
        this.position = position;
        this.userTypes_id_type = user_type;
    }
    
    
    public UserModel() {
        
    }
    
    public String getTypeofUser(){
        if(this.getUserTypes_id_type().equals("2")){
            return "Operário";
        }else{
            return "Administrador";
        }
    }
        
    public UserModel getUser(String email) throws Exception {
        String result = super.getRequest(URI + "?email=" + email);
        Gson a = new Gson();
        try{
            UserModel user = a.fromJson(result, UserModel.class);
            return user;
        }catch(Exception e){     
            throw new Exception("User not found in database!");
        }
    }
    
    public void postUser(UserModel model) throws Exception{
        Gson a = new Gson();
        super.postRequest(URI,a.toJson(model));
    }
    
    //Put to database
    public void setUserPassword(String json) throws IOException, ProtocolException, Exception{
        super.putRequest(URI,json);
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
