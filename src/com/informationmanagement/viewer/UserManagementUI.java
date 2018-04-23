/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

import com.informationmanagement.controller.UserController;
import com.informationmanagement.model.UserModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Claudio
 */
public class UserManagementUI implements Initializable  {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField department;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private CheckBox admin;
    @FXML
    private TextField position;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void addUser(){
        int isAdmin = 0;
        if(admin.isSelected()){
            isAdmin = 1;
        }
        UserModel user =  new UserModel(email.getText(),password.getText(), 
                firstName.getText(),lastName.getText(),department.getText(),position.getText(),isAdmin + "");
        UserController userController = new UserController(user,this);
        try {
            userController.getUser().postUser(user);
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something wrong happened when you tried to add a new user"
                    + ex.getMessage());
            alert.showAndWait();
        }
    }
}
