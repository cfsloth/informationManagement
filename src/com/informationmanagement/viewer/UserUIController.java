/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author claudio
 */
public class UserUIController implements Initializable {

    @FXML
    private TextField userEmail;
    @FXML
    private PasswordField userName;
    @FXML
    private TextField userDepartment;
    @FXML 
    private TextField userPosition;
    
    @FXML
    private void logOut(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign Out");
        alert.setHeaderText("Deseja mesmo sair do sistema?");
        alert.setContentText("Se sair do sistema, dados que não tenham sido \nguardados serão perdidos.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            System.out.println("Changing to Login");
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            Parent menu = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
            Scene scene = new Scene(menu);
            stage.setScene(scene);
        } 
    }
    
      @FXML
    private void goHome(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Go to Main Menu");
        alert.setHeaderText("Deseja mesmo ir para o Menu Inicial?");
        alert.setContentText("Se sair do sistema, dados que não tenham sido \nguardados serão perdidos.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            System.out.println("Changing to Main Menu\n");
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            Parent menu = FXMLLoader.load(getClass().getResource("MenuUI.fxml"));
            Scene scene = new Scene(menu);
            stage.setScene(scene);
        } 
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
