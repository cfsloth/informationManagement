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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author claudio
 */
public class WarningUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private void logOut(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
    private void closeWarning(ActionEvent event){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Concluir");
        alert.setHeaderText("Deseja mesmo concluir o aviso?");
        alert.setContentText("Se concluir o aviso, este será enviado para o \n"
                + "administrador que o submeteu. Este verificará \n"
                + "se o problema foi resolvido.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
        }
    }
    
    @FXML
    private void submitWarning(ActionEvent event){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Submeter");
        alert.setHeaderText("Deseja mesmo submeter o aviso?");
        alert.setContentText("Se concluir o aviso, este será enviado para um \n"
                + "administrador. Este verificará se o problema foi \n"
                + "resolvido.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
