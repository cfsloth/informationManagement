/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.viewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author claudio
 */
public class InformationManagement extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent login = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
        Scene scene = new Scene(login);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("FluxI! - Management of Information");
        stage.show();
        
    }
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
