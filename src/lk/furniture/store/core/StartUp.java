/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.core;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.furniture.store.controller.SplashController;

/**
 *
 * @author Lakitha
 */
public class StartUp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        
       Parent root = FXMLLoader.load(this.getClass().getResource("/lk/furniture/store/view/Splash.fxml"));
     //Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fx/view/MainForm.fxml"));  
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setTitle("FurnitureStore-Login");
        primaryStage.show();
        
        //Parent root = FXMLLoader.load(SplahScreen.this.getClass().getResource("/lk/furniture/store/view/Login.fxml"));
//        Parent root=FXMLLoader.load(this.getClass().getResource("/lk/furniture/store/view/Login.fxml"));
//        Scene scene = new Scene(root);
//        Stage Stage=new Stage();
//        Stage.setScene(scene);
//        Stage.setTitle("FurnitureStore-Login");
//        Stage.show();  
//        
        
        
        
    }
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }
        
    
    
}
