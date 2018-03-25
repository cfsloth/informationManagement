/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

import com.informationmanagement.controller.WarningController;
import com.informationmanagement.model.UserModel;
import com.informationmanagement.model.WarningModel;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author claudio
 */
public class WarningUIController implements Initializable {
    private UserModel user;
    @FXML
    private TableView warningsTable;
    @FXML
    private TextField subjects;
    @FXML
    private TextArea description;
    @FXML 
    private ComboBox severity;
    @FXML
    private Label userName;
    @FXML
    private Label userType;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    public void initData(UserModel userModel){
        this.user = userModel;
        this.userName.setText(this.userName.getText() + userModel.getFirstName() 
                + " " + user.getLastName());
        this.userType.setText(this.userType.getText() + this.user.getTypeofUser());
        severity.getItems().clear();
        severity.getItems().addAll(
        "1","2","3","4","5","6","7","8","9","10");
    }
    
    @FXML
    private void logOut(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sign Out");
        alert.setHeaderText("Deseja mesmo sair do sistema?");
        alert.setContentText("Se sair do sistema, dados que não tenham sido \nguardados serão perdidos.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
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
            controller.initData(this.user);
            Scene scene = new Scene(menu);
            stage.setScene(scene);
        } 
    }
    
     @FXML
    private void goToUserPage(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Go to User Page");
        alert.setHeaderText("Deseja mesmo ir para o seu perfil?");
        alert.setContentText("Se sair do sistema, dados que não tenham sido \nguardados serão perdidos.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            System.out.println("Changing to UserUI");
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserUI.fxml"));
            Parent menu = loader.load();
            UserUIController controller = loader.<UserUIController>getController();
            controller.initData(this.user);
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
            
            //Todo method
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
            try{
                WarningModel newWarning = new WarningModel(0,this.description.getText(),
                   this.severity.getSelectionModel().getSelectedItem().toString(),
                    this.subjects.getText(),Integer.parseInt(this.user.getId_user()));
                WarningController wController = new WarningController(newWarning,this);
                wController.postWarning();
                Alert confirmation = new Alert(AlertType.CONFIRMATION);
                confirmation.setTitle("Sucess");
                confirmation.setHeaderText("Warning was submited!");
                confirmation.setContentText("The warning was submited with sucess!");
                confirmation.showAndWait();
            }catch(NullPointerException e){
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("Warning Could Not Be Submited!");
                error.setContentText("Please fill all the data in the form.");
                error.showAndWait();
            } catch (Exception ex) {
                System.out.println(ex);
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("Warning Could Not Be Submited!");
                error.setContentText("The warning could not be submited. Please contact an IT Manager!");
                error.showAndWait();
            }
        }
    } 
    
}
