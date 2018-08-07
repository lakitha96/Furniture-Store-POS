/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class ManageCustomer_EditController implements Initializable {

    @FXML
    private JFXTextField txtFName;
    @FXML
    private JFXTextField txtLName;
    @FXML
    private JFXTextField txtDistrict;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXComboBox<?> CBCustomerID;
    @FXML
    private JFXTextField txtContactNum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadCustomerID(ActionEvent event) {
        
        
        
        
    }

            
    
}
