/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author claudio
 */
public class MenuUIController implements Initializable {
    private UserModel model;
    @FXML
    private Label userName;
    @FXML
    private Label userType;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    public void initData(UserModel model){
        this.model = model;
        this.userName.setText(this.userName.getText() + " " + 
                model.getFirstName() + " " + this.model.getLastName());
        if(this.model.getUserTypes_id_type().equals("2")){
            this.userType.setText(this.userType.getText() + " Operário");
        }else{
            this.userType.setText(this.userType.getText() + " Administrador");
        }
        this.model.setUserTypes_id_type(this.userType.getText());
    }

    public UserModel getModel() {
        return model;
    }

    public void setModel(UserModel model) {
        this.model = model;
    }
    
    @FXML
    private void logOut(ActionEvent event) throws IOException{
        System.out.println(this.model.getFirstName());
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
    private void goToUserPage(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Go to User Page");
        alert.setHeaderText("Deseja mesmo ir para o seu perfil?");
        alert.setContentText("Ao sair desta página, os dados que não tenham sido \nguardados serão perdidos.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.out.println();
            // ... user chose OK
            System.out.println("Changing to UserUI");
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserUI.fxml"));
            Parent menu = loader.load();
            UserUIController controller = loader.<UserUIController>getController();
            controller.initData(this.model);
            Scene scene = new Scene(menu);
            stage.setScene(scene);
        } 
    }
    
    @FXML
    private void goToUserPageWithoutWarning(ActionEvent event) throws IOException{
            System.out.println("Changing to UserUI");
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserUI.fxml"));
            Parent menu = loader.load();
            UserUIController controller = loader.<UserUIController>getController();
            controller.initData(this.model);
            Scene scene = new Scene(menu);
            stage.setScene(scene); 
    }
    
    @FXML
    private void goToWarningPage(ActionEvent event) throws IOException{
        System.out.println("Changing to WarningUI");
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        Parent menu = FXMLLoader.load(getClass().getResource("WarningUI.fxml"));
        Scene scene = new Scene(menu);
        stage.setScene(scene);
    }

    public Label getUserName() {
        return userName;
    }

    public void setUserName(Label userName) {
        this.userName = userName;
    }
}
