/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXPasswordField;
import java.awt.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXPasswordField txtPassword;
    
    private String username;
    private String password;
    
    @FXML
    private javafx.scene.control.Label lblPwError;
    
    @FXML
    private AnchorPane AP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    

    @FXML
    private void loadDashboard(javafx.event.ActionEvent event) {
    }

    @FXML
    private void loadMainScreeen(MouseEvent event) {
        
        try {
            Parent parent= FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Dashboard.fxml"));
            Scene Scene = new Scene(parent);
            Stage stage=new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(Scene);
            //stage.initStyle(StageStyle.UNDECORATED);
            //stage.setFullScreen(false);
            stage.fullScreenProperty();
            stage.setMaxHeight(768);
            stage.setMaxWidth(1366);
            //stage.setFullScreen(true);
            //stage.alwaysOnTopProperty();
            //stage.setFullScreenExitHint("");
            
            String user="user";
            String pass="user";
            
            String inpUser = txtUsername.getText();
            String inpPass = txtPassword.getText(); // gets input from user

            if (inpUser.equals(user) && inpPass.equals(pass)) {
                stage.show();

                AP.getScene().getWindow().hide();
                System.out.print("your login message");
            } else {
                Image img = new Image("/lk/furniture/store/images/warning.png");
                //Notifications
                Notifications notificationManager = Notifications.create()
                        .title("Saving Incomplete")
                        .text("Something went wrong!")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT);
                        

                notificationManager.darkStyle();
                notificationManager.show();

            
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}