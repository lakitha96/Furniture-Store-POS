/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class Payment_ConfirmController implements Initializable {

    @FXML
    private JFXButton btnNext;
    @FXML
    private JFXButton btnBack;
    @FXML
    private AnchorPane payementPane;
    @FXML
    private JFXButton btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void loadSummary(ActionEvent event) throws IOException {
        
        
        
        AnchorPane ap=FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Summary.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1000), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        payementPane.getChildren().setAll(ap);
        
    }

    private void loadItem(ActionEvent event) throws IOException {
        AnchorPane ap=FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Payment_Item.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1000), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        payementPane.getChildren().setAll(ap);
    }

    @FXML
    private void loadSummaryOnNext(ActionEvent event) {
    }

    @FXML
    private void loadCustomerOnCancel(ActionEvent event) {
    }

    @FXML
    private void loadItemOnBack(ActionEvent event) {
    }
    
}
