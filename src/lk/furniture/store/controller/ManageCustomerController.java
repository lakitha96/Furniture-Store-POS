/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.furniture.store.dao.DAOFactory;
import lk.furniture.store.dao.custom.CustomerDAO;
import lk.furniture.store.dto.CustomerDTO;
import lk.furniture.store.utill.IDgenerator;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class ManageCustomerController implements Initializable {

    @FXML
    private JFXButton btnAddCustomer;
    @FXML
    private JFXButton btnEdit;
    @FXML
    private TableView<CustomerDTO> tblCustomer;
    @FXML
    private JFXTextField txtFName;
    @FXML
    private JFXTextField txtLName;
    @FXML
    private JFXTextField txtDistrict;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXTextField txtContactNum;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXTextField txtCID;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableColumn<?, ?> CID;
    @FXML
    private TableColumn<?, ?> fName;
    @FXML
    private TableColumn<?, ?> lName;
    @FXML
    private TableColumn<?, ?> address;
    @FXML
    private TableColumn<?, ?> district;
    @FXML
    private TableColumn<?, ?> contact;
    @FXML
    private JFXTextField txtSearchByDis;
    @FXML
    private JFXTextField txtSearchContact;
    @FXML
    private JFXTextField txtSearchByName;
    @FXML
    private ImageView iconRefresh;
    @FXML
    private Label lblRefresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            txtCID.setText(IDgenerator.getNewID("customer", "CID", "C"));
        } catch (Exception e) {
        }
        intitializing();
        try {
            setCustomerTableValues(customerDAO.getAll());
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //addCustomer
    @FXML
    void loadAddCustomer(ActionEvent event) throws IOException {
        CustomerDTO customer = new CustomerDTO(
                txtCID.getText(),
                txtFName.getText(),
                txtLName.getText(),
                txtAddress.getText(),
                txtDistrict.getText(),
                txtContactNum.getText());
        try {
            boolean result = addCustomer(customer);
//sucessMessage
            if (result) {
                setCustomerTableValues(customerDAO.getAll());
                clearFields();

                Image img = new Image("/lk/furniture/store/images/tick.png");

                Notifications notificationManager = Notifications.create()
                        .title("Saving Complete")
                        .text("Succesfully Customer Saved!")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notificationManager.darkStyle();
                notificationManager.show();

            } else {
//errorMessage
                Image img = new Image("/images/warning.png");

                Notifications notificationManager = Notifications.create()
                        .title("Saving Incomplete")
                        .text("Something went wrong!")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notificationManager.darkStyle();
                notificationManager.show();

            }

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomer_AddController.class.getName()).log(Level.SEVERE, null, ex);
            Image img = new Image("/images/warning.png");

            Notifications notificationManager = Notifications.create()
                    .title("Saving Incomplete")
                    .text("Something went wrong!")
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.BOTTOM_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                        }
                    });

            notificationManager.darkStyle();
            notificationManager.show();
        }

    }

    public static CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public static boolean addCustomer(CustomerDTO customer) throws Exception {
        boolean result = customerDAO.add(customer);
        return result;
    }

    //deleteCustomer
    @FXML
    private void loadDelete(ActionEvent event) {
        CustomerDTO customer = new CustomerDTO(
                txtCID.getText(),
                txtFName.getText(),
                txtLName.getText(),
                txtAddress.getText(),
                txtDistrict.getText(),
                txtContactNum.getText());
        try {
            boolean result = deleteCustomer(customer);

            if (result) {
//sucessMessage
                Image img = new Image("/images/tick.png");

                Notifications notificationManager = Notifications.create()
                        .title("Delete Complete")
                        .text("Succesfully Customer Deleted!")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notificationManager.darkStyle();
                notificationManager.show();

                setCustomerTableValues(customerDAO.getAll());
                clearFields();
            } else {
//errorMessage
                Image img = new Image("/images/warning.png");

                Notifications notificationManager = Notifications.create()
                        .title("Delete Incomplete")
                        .text("Something went wrong!"
                                + "\n hint: Please select Customer")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notificationManager.darkStyle();
                notificationManager.show();
                setCustomerTableValues(customerDAO.getAll());
                clearFields();
            }

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean deleteCustomer(CustomerDTO customer) throws Exception {
        boolean result = customerDAO.delete(customer);
        return result;
    }

    public static CustomerDTO searchCustomer(CustomerDTO customer) throws Exception {
        CustomerDTO searchedCustomer = customerDAO.search(customer);
        return searchedCustomer;
    }

    private void setCustomerTableValues(ArrayList<CustomerDTO> arrayList) {
        ObservableList<CustomerDTO> customerList = FXCollections.observableArrayList();
        for (CustomerDTO customer : arrayList) {
            customerList.add(customer);
        }
        tblCustomer.setItems(customerList);
    }

    private void fillTextFields(CustomerDTO rowCustomer) throws NullPointerException {
        if(rowCustomer==null)return;
        
        txtCID.setText(rowCustomer.getCID());
        txtFName.setText(rowCustomer.getFirstName());
        txtLName.setText(rowCustomer.getLastName());
        txtAddress.setText(rowCustomer.getAddress());
        txtContactNum.setText(rowCustomer.getContactNumber());
        txtDistrict.setText(rowCustomer.getDistrict());
    }

    private void intitializing() {
        //Table Cell intialized
//        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CID"));
//        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
//        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("lastName"));
//        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
//        tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("district"));
//        tblCustomer.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("contactNumber"));

        CID.setCellValueFactory(new PropertyValueFactory<>("CID"));
        fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        district.setCellValueFactory(new PropertyValueFactory<>("district"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
 
        //Table event
        tblCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerDTO>() {
            @Override
            public void changed(ObservableValue<? extends CustomerDTO> observable, CustomerDTO oldValue, CustomerDTO newValue) {
                CustomerDTO customerDTO = tblCustomer.getSelectionModel().getSelectedItem();
                fillTextFields(customerDTO);
            }
        });

        //search by name
        txtSearchByName.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                txtSearchByDis.setText(null);
                txtSearchContact.setText(null);
                ArrayList<CustomerDTO> filteredFromName = customerDAO.filteredFromName(txtSearchByName.getText());
                setCustomerTableValues(filteredFromName);
            } catch (Exception ex) {
                Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        txtSearchByDis.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                txtSearchContact.setText(null);
                txtSearchByName.setText(null);
                ArrayList<CustomerDTO> filteredFromDistrict = customerDAO.filteredFromDistrict(txtSearchByDis.getText());
                setCustomerTableValues(filteredFromDistrict);
                System.out.println(txtSearchByDis.getText());
            } catch (Exception ex) {
                Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

//        txtCID.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
//            try {
//                ArrayList<CustomerDTO> filteredFromID = customerDAO.filteredFromID(txtCID.getText());
//                setCustomerTableValues(filteredFromID);
//            } catch (Exception ex) {
//                Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        txtSearchContact.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            
            try {
                txtSearchByDis.setText(null);
                txtSearchByName.setText(null);
                ArrayList<CustomerDTO> filteredFromContact = customerDAO.filteredFromContact(txtSearchContact.getText());
                setCustomerTableValues(filteredFromContact);
            } catch (Exception ex) {
                Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void loadEditCustomer(ActionEvent event) throws Exception, IOException {
        
        CustomerDTO customer = new CustomerDTO(
                txtCID.getText(),
                txtFName.getText(),
                txtLName.getText(),
                txtAddress.getText(),
                txtDistrict.getText(),
                txtContactNum.getText()
        );

        System.out.println(2);

        try {
            boolean result = updateCustomer(customer);
            System.out.println(3);
            if (result) {
                System.out.println(4);
                Image img = new Image("/images/tick.png");

                Notifications notificationManager = Notifications.create()
                        .title("Edit Complete")
                        .text("Succesfully Customer Edited!")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notificationManager.darkStyle();
                notificationManager.show();

                setCustomerTableValues(customerDAO.getAll());
                clearFields();

            } else {
                Image img = new Image("/images/warning.png");

                Notifications notificationManager = Notifications.create()
                        .title("Edit Incomplete")
                        .text("Something went wrong!")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

            }

        } catch (Exception e) {

            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public static boolean updateCustomer(CustomerDTO customer) throws Exception {
        System.out.println("ed");
        boolean result = customerDAO.update(customer);
        return result;

    }

    private void clearFields() {
        txtCID.setText(null);
        txtFName.setText(null);
        txtLName.setText(null);
        txtAddress.setText(null);
        txtDistrict.setText(null);
        txtContactNum.setText(null);

    }
    
    public void clearSearchFields() {
        txtSearchByName.setText(null);
        txtSearchContact.setText(null);
        txtSearchByDis.setText(null);

    }

    @FXML
    private void txtSearchByDis(ActionEvent event) {

    }

    @FXML
    private void refreshAllFields(MouseEvent event) throws Exception {
        int CIDCount = txtCID.getLength();
        int fnameCount = txtFName.getLength();
        int lnameCount = txtLName.getLength();
        int addressCount = txtAddress.getLength();
        int districtCount = txtDistrict.getLength();
        int contactCount = txtContactNum.getLength();
        int searchNameCount = txtSearchByName.getLength();
        int searchContactCount = txtSearchContact.getLength();
        int searchDistrictCount = txtSearchByDis.getLength();
        if (CIDCount > 0 || fnameCount > 0 || lnameCount > 0 || addressCount > 0 || districtCount > 0 || contactCount > 0
                || searchDistrictCount > 0 || searchContactCount > 0 || searchNameCount > 0) {
            RotateTransition rt = new RotateTransition(Duration.seconds(0.5), lblRefresh);
            rt.setByAngle(90);
            rt.play();
            clearFields();
            clearSearchFields();
            setCustomerTableValues(customerDAO.getAll());

        }

    }

}
