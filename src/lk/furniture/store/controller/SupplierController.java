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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.furniture.store.dao.DAOFactory;
import lk.furniture.store.dao.custom.SupplierDAO;
import lk.furniture.store.dto.SupplierDTO;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class SupplierController implements Initializable {

    @FXML
    private JFXButton btnEdit;
    @FXML
    private JFXButton btnnew;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<SupplierDTO> tblSupplier;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXTextField txtConatct;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtDistrict;
    @FXML
    private JFXTextField txtSID;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXTextField txtSearchName;
    @FXML
    private JFXTextField txtSearchDistrict;
    @FXML
    private JFXTextField txtSearchContact;
    @FXML
    private Label lblRefresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        intitializing();
        try {
            setCustomerTableValues(supplierDAO.getAll());
        } catch (Exception ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadEditSupplier(ActionEvent event) throws IOException {
        SupplierDTO supplier = new SupplierDTO(
                txtSID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtDistrict.getText(),
                txtConatct.getText()
        );

        System.out.println(2);

        try {
            boolean result = updateSupplier(supplier);
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

                setCustomerTableValues(supplierDAO.getAll());
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

            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @FXML
    private void loadNewSupplier(ActionEvent event) throws IOException {
        SupplierDTO supplier = new SupplierDTO(
                txtSID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtDistrict.getText(),
                txtConatct.getText());
        try {
            boolean result = addSupplier(supplier);
//sucessMessage
            if (result) {
                setCustomerTableValues(supplierDAO.getAll());
                clearFields();

                Image img = new Image("/images/tick.png");

                Notifications notificationManager = Notifications.create()
                        .title("Saving Complete")
                        .text("Succesfully Supplier Saved!")
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
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            Image img = new Image("/images/warning.png");

            Notifications notificationManager = Notifications.create()
                    .title("Saving Incomplete")
                    .text("Something went wrong!")
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(4))
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

    @FXML
    private void loadDeleteSupllier(ActionEvent event) throws Exception {
        SupplierDTO supplier = new SupplierDTO(
                txtSID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtDistrict.getText(),
                txtConatct.getText());
        try {

            boolean result = deleteSupplier(supplier);

            if (result) {
//sucessMessage
                Image img = new Image("/images/tick.png");

                Notifications notificationManager = Notifications.create()
                        .title("Delete Complete")
                        .text("Succesfully supplier Deleted!")
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

                setCustomerTableValues(supplierDAO.getAll());
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
                setCustomerTableValues(supplierDAO.getAll());
                clearFields();
            }

        } catch (Exception e) {

            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    public static boolean addSupplier(SupplierDTO supplier) throws Exception {
        boolean result = supplierDAO.add(supplier);
        return result;
    }

    public static boolean updateSupplier(SupplierDTO supplier) throws Exception {
        boolean result = supplierDAO.update(supplier);
        return result;

    }

    public static boolean deleteSupplier(SupplierDTO supplier) throws Exception {
        boolean result = supplierDAO.delete(supplier);
        return result;
    }

    public static SupplierDTO searchSupplier(SupplierDTO supplier) throws Exception {
        SupplierDTO searchSupplier = supplierDAO.search(supplier);
        return searchSupplier;
    }

    private void intitializing() {
        tblSupplier.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        tblSupplier.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        tblSupplier.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblSupplier.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblSupplier.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("district"));

        tblSupplier.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SupplierDTO>() {
            @Override
            public void changed(ObservableValue<? extends SupplierDTO> observable, SupplierDTO oldValue, SupplierDTO newValue) {
                SupplierDTO supplierDTO = tblSupplier.getSelectionModel().getSelectedItem();
                fillTextFields(supplierDTO);
            }

        });
        txtSearchName.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            txtSearchDistrict.setText(null);
            txtSearchContact.setText(null);
            try {
                ArrayList<SupplierDTO> filteredFromName = supplierDAO.filteredFromName(txtSearchName.getText());
                setCustomerTableValues(filteredFromName);
            } catch (Exception ex) {
                Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        txtSearchDistrict.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            txtSearchName.setText(null);
            txtSearchContact.setText(null);
            try {
                ArrayList<SupplierDTO> filteredFromDistrict = supplierDAO.filteredFromDistrict(txtSearchDistrict.getText());
                setCustomerTableValues(filteredFromDistrict);
            } catch (Exception ex) {
                Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        txtSearchContact.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            txtSearchName.setText(null);
            txtSearchDistrict.setText(null);
            try {
                ArrayList<SupplierDTO> filteredFromContact = supplierDAO.filteredFromContact(txtSearchContact.getText());
                setCustomerTableValues(filteredFromContact);
            } catch (Exception ex) {
                Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    private void fillTextFields(SupplierDTO rowCustomer) {
        if(rowCustomer==null)return;
        txtSID.setText(rowCustomer.getSupplierID());
        txtName.setText(rowCustomer.getSupplierName());
        txtAddress.setText(rowCustomer.getAddress());
        txtConatct.setText(rowCustomer.getContact());
        txtDistrict.setText(rowCustomer.getDistrict());
    }

    private void setCustomerTableValues(ArrayList<SupplierDTO> arrayList) {
        ObservableList<SupplierDTO> supplierList = FXCollections.observableArrayList();
        for (SupplierDTO supplier : arrayList) {
            supplierList.add(supplier);
        }
        tblSupplier.setItems(supplierList);
    }

    private void clearFields() {
        txtSID.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtDistrict.setText(null);
        txtConatct.setText(null);

    }

    public void clearSearchFields() {
        txtSearchName.setText(null);
        txtSearchContact.setText(null);
        txtSearchDistrict.setText(null);

    }

    @FXML
    private void RefreshAllFields(MouseEvent event) throws Exception {
        int sidCount = txtSID.getLength();
        int nameCount = txtName.getLength();
        int addressCount = txtAddress.getLength();
        int districtCount = txtDistrict.getLength();
        int contactCount = txtConatct.getLength();
        int searchNameCount = txtSearchName.getLength();
        int searchContactCount = txtConatct.getLength();
        int searchDistrictCount = txtSearchDistrict.getLength();
        if (sidCount > 0 || nameCount > 0 || addressCount > 0 || districtCount > 0 || contactCount > 0 || searchDistrictCount > 0
                || searchContactCount > 0 || searchNameCount > 0) {
            RotateTransition rt = new RotateTransition(Duration.seconds(0.5), lblRefresh);
            rt.setByAngle(90);
            rt.play();
            clearFields();
            clearSearchFields();
            setCustomerTableValues(supplierDAO.getAll());

        }
    }

}
