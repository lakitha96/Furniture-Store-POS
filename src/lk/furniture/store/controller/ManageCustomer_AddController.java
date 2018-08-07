/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.furniture.store.dao.DAOFactory;
import lk.furniture.store.dao.custom.CustomerDAO;
import lk.furniture.store.dto.CustomerDTO;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class ManageCustomer_AddController implements Initializable {

    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField txtFName;
    @FXML
    private JFXTextField txtLName;
    @FXML
    private JFXTextField txtID;
    @FXML
    private JFXTextField txtConNum;
    @FXML
    private JFXTextField txtDistrict;
    @FXML
    private JFXTextArea txtAddress;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addCustomer(ActionEvent event) {
    
       
    }
    
    
}
