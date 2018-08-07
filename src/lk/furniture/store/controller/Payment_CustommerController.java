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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.furniture.store.dto.CustomerDTO;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class Payment_CustommerController implements Initializable {
    @FXML
    private JFXButton btnNext;
    @FXML
    private AnchorPane customrPane;
    @FXML
    private JFXTextField txtFName;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXTextField txtLName;
    @FXML
    private JFXTextField txtDistrict;
    @FXML
    private JFXButton btnAddCustomer;
    @FXML
    private JFXTextField txtCID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    

    @FXML
    private void loadItemOnNext(ActionEvent event) {
    }

    
    
    
    private void fillTextFields(CustomerDTO rowCustomer) {
        
        
        
//        public static CustomerDTO searchCustomer(CustomerDTO customer) throws Exception{
//        CustomerDTO searchedCustomer = customerDAO.search(customer);
//        return searchedCustomer;
//    }
        
        //CustomerDTO customer = new CustomerDTO();
                
       
        
        //Customer customer=CustomerController.searchCustomer(id);
        
                   
                
        
    }

    @FXML
    private void loadAddCustomer(ActionEvent event) {
    }
    
}
