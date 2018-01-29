/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

import com.informantionmanagement.model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author claudio
 */
public class LoginUIController implements Initializable {
    private UserModel userModel = new UserModel();
    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void loginUI(ActionEvent event) throws IOException{
        //Changing scenes
        try{
            int returnValue = userModel.verifyUser(username.getText()+"", password.getText()+"");
            if(returnValue == 1){
                System.out.println("Changing to MenuUI");
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                Parent menu = FXMLLoader.load(getClass().getResource("MenuUI.fxml"));
                Scene scene = new Scene(menu);
                stage.setScene(scene);
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Wrong Login");
                alert.setHeaderText("Wrong Login");
                alert.setContentText("You insert your email and/or password wrong!");
                alert.showAndWait();
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void recoverPassword(){
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
