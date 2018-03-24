/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

import com.informationmanagement.controller.UserController;
import com.informationmanagement.model.UserModel;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author claudio
 */
public class UserUIController implements Initializable {
    private UserModel model;
    @FXML
    private Label userCompleteName;
    @FXML
    private Label userType;
    @FXML
    private TextField userEmail;
    @FXML
    private TextField userName;
    @FXML
    private TextField userDepartment;
    @FXML 
    private TextField userPosition;
    @FXML 
    private TextField oldPassword;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField newPassword2;
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void initData(UserModel model){
        this.model = model;
        this.userCompleteName.setText(userCompleteName.getText() + " " 
                + model.getFirstName() + " " + model.getLastName());
        this.userType.setText(model.getUserTypes_id_type());
        this.userDepartment.setText(this.model.getDepartment());
        this.userName.setText(this.model.getFirstName());
        this.userPosition.setText(this.model.getPosition());
        this.userEmail.setText(model.getEmail());
    }
    
    
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuUI.fxml"));
            Parent menu = loader.load();
            MenuUIController controller = loader.<MenuUIController>getController();
            controller.initData(this.model);
            Scene scene = new Scene(menu);
            stage.setScene(scene);
        } 
    }
    
    @FXML
    private void changePassword(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Changing Password");
        alert.setHeaderText("Do you really wish to change the password?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            UserController userC = new UserController(model,this);
            try {
                boolean sucess = userC.changePassword(this.model,oldPassword.getText(), newPassword.getText(), newPassword2.getText());
                if(sucess){
                    System.out.println("");
                    Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                    confirmation.setTitle("Password Update");
                    confirmation.setHeaderText("Update");
                    confirmation.setContentText("Password was updated with sucess!");
                    confirmation.showAndWait();
                }
            } catch (Exception ex) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Password Not Updated");
                error.setHeaderText("Error");
                error.setContentText("Password could not be update");
                error.showAndWait();
            }
        }
    }
}
