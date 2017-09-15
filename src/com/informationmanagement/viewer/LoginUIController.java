/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author claudio
 */
public class LoginUIController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void loginUI(ActionEvent event) throws IOException{
        //Changing scenes
        System.out.println("Changing to WarningUI");
        Node source = (Node) event.getSource();
        
        Stage stage = (Stage) source.getScene().getWindow();
        
        Parent menu = FXMLLoader.load(getClass().getResource("WarningUI.fxml"));
        Scene scene = new Scene(menu);
        stage.setScene(scene);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
