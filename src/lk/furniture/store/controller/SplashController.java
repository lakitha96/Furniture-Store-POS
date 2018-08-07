/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */


public class SplashController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane rootPane;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplahScreen().start();
    }    
    
    class SplahScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(3000);
                
                Platform.runLater(() -> {
                    try {
                        Parent root= null;
                        
                        root = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Login.fxml"));
                        Scene scene = new Scene(root);
                        Stage Stage=new Stage();
                        Stage.setScene(scene);
                        Stage.setTitle("FurnitureStore-Login");
                        Stage.show();
                        
                        rootPane.getScene().getWindow().hide();
                    } catch (IOException ex) {
                        Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                
                
           
                

                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}


