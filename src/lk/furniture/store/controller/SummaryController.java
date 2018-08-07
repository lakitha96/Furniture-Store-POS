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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class SummaryController implements Initializable {

    @FXML
    private JFXButton btmDone;
    @FXML
    private AnchorPane summaryPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadCustomer(ActionEvent event) throws IOException {
        AnchorPane ap=FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Payment_Customer.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1000), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        summaryPane.getChildren().setAll(ap);
    }
    
}
