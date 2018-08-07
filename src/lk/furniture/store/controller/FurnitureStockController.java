/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import static lk.furniture.store.controller.SupplierController.supplierDAO;
import static lk.furniture.store.controller.SupplierController.updateSupplier;
import lk.furniture.store.dao.DAOFactory;
import lk.furniture.store.dao.custom.FurnitureStockDAO;
import lk.furniture.store.dao.custom.SupplierDAO;
import lk.furniture.store.dto.FurnitureStockDTO;
import lk.furniture.store.dto.SupplierDTO;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class FurnitureStockController implements Initializable {

    @FXML
    private JFXButton btnEdit;
    @FXML
    private JFXButton btnNew;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField txtFType;
    @FXML
    private JFXTextField txtWType;
    @FXML
    private JFXTextField txtFID;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtQuantity;
    @FXML
    private JFXTextField txtPrice;
    @FXML
    private TableView<FurnitureStockDTO> tblFurnitureItem;
    @FXML
    private JFXTextField txtSearchByName;
    @FXML
    private JFXTextField txtSearchByWoodType;
    @FXML
    private Label lblRefresh;
    @FXML
    private JFXTextField txtColor;
    @FXML
    private JFXTextField txtSearchByPrice;
    @FXML
    private JFXButton btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        intitializing();
        try {
            setTableValues(furnitureStockDAO.getAll());
        } catch (Exception ex) {
            Logger.getLogger(FurnitureStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void editFurniture(ActionEvent event) {
        FurnitureStockDTO furnitureStock = new FurnitureStockDTO(
                txtFID.getText(),
                txtName.getText(),
                txtFType.getText(),
                txtWType.getText(),
                txtColor.getText(),
                txtQuantity.getText(),
                new BigDecimal(txtPrice.getText()));

        try {
            boolean result = updateFurniture(furnitureStock);
            if (result) {
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

                setTableValues(furnitureStockDAO.getAll());
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

            Logger.getLogger(FurnitureStockController.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @FXML
    private void deleteFurniture(ActionEvent event) {
        FurnitureStockDTO furnitureStock = new FurnitureStockDTO(
                txtFID.getText(),
                txtName.getText(),
                txtFType.getText(),
                txtWType.getText(),
                txtColor.getText(),
                txtQuantity.getText(),
                new BigDecimal(txtPrice.getText()));
        try {

            boolean result = deleteFurniture(furnitureStock);

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

                setTableValues(furnitureStockDAO.getAll());
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
                setTableValues(furnitureStockDAO.getAll());
                clearFields();
            }

        } catch (Exception e) {

            Logger.getLogger(FurnitureStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    @FXML
    private void loadNewFurniture(ActionEvent event) throws IOException {
        FurnitureStockDTO furnitureStock = new FurnitureStockDTO(
                txtFID.getText(),
                txtName.getText(),
                txtFType.getText(),
                txtWType.getText(),
                txtColor.getText(),
                txtQuantity.getText(),
                new BigDecimal(txtPrice.getText()));
                
        try {
            boolean result = furnitureStockDAO.add(furnitureStock);
//sucessMessage
            if (result) {
                setTableValues(furnitureStockDAO.getAll());
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
            Logger.getLogger(FurnitureStockController.class.getName()).log(Level.SEVERE, null, ex);
            Image img = new Image("/lk/furniture/store/images/warning.png");

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
    
    public static FurnitureStockDAO furnitureStockDAO = (FurnitureStockDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FURNITURE);

    
    
    
    
     public static boolean updateFurniture(FurnitureStockDTO furniture) throws Exception {
        boolean result = furnitureStockDAO.update(furniture);
        return result;

    }

    public static boolean deleteFurniture(FurnitureStockDTO furniture) throws Exception {
        boolean result = furnitureStockDAO.delete(furniture);
        return result;
    }

    public static FurnitureStockDTO searchSupplier(FurnitureStockDTO furniture) throws Exception {
        FurnitureStockDTO searchFurniture = furnitureStockDAO.search(furniture);
        return searchFurniture;
    }

    

    private void intitializing() {
        tblFurnitureItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("FID"));
        tblFurnitureItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fname"));
        tblFurnitureItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("furnitureType"));
        tblFurnitureItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("woodType"));
        tblFurnitureItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("color"));
        tblFurnitureItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("availableQty"));
        tblFurnitureItem.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        
        tblFurnitureItem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FurnitureStockDTO> (){
            @Override
            public void changed(ObservableValue<? extends FurnitureStockDTO> observable, FurnitureStockDTO oldValue, FurnitureStockDTO newValue) {
                FurnitureStockDTO furniture = tblFurnitureItem.getSelectionModel().getSelectedItem();
                fillTextFields(furniture);
            }
        });
        
        
        txtSearchByName.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            txtSearchByPrice.setText(null);
            txtSearchByWoodType.setText(null);
            try {
                ArrayList<FurnitureStockDTO> filteredFromName = furnitureStockDAO.filteredFromName(txtSearchByName.getText());
                setTableValues(filteredFromName);
            } catch (Exception ex) {
                Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        txtSearchByPrice.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            txtSearchByName.setText(null);
            txtSearchByWoodType.setText(null);
            try {
                ArrayList<FurnitureStockDTO> filteredFromName = furnitureStockDAO.filteredFromPrice(txtSearchByPrice.getText());
                setTableValues(filteredFromName);
            } catch (Exception ex) {
                Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        txtSearchByWoodType.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            txtSearchByName.setText(null);
            txtSearchByPrice.setText(null);
            try {
                ArrayList<FurnitureStockDTO> filteredFromName = furnitureStockDAO.filteredFromWoodType(txtSearchByWoodType.getText());
                setTableValues(filteredFromName);
            } catch (Exception ex) {
                Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    
    private void setTableValues(ArrayList<FurnitureStockDTO> arrayList) {
        try {
            ObservableList<FurnitureStockDTO> furnitureList = FXCollections.observableArrayList();
        for (FurnitureStockDTO furniture : arrayList) {
            furnitureList.add(furniture);
        }
        tblFurnitureItem.setItems(furnitureList);
        } catch (NullPointerException e) {
            Logger.getLogger(FurnitureStockController.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    private void fillTextFields(FurnitureStockDTO rowCustomer) {
        if(rowCustomer==null)return;
        txtFID.setText(rowCustomer.getFID());
        txtName.setText(rowCustomer.getFname());
        txtColor.setText(rowCustomer.getColor());
        txtQuantity.setText(rowCustomer.getAvailableQty());
        txtFType.setText(rowCustomer.getFurnitureType());
        txtWType.setText(rowCustomer.getWoodType());
        txtPrice.setText(rowCustomer.getUnitPrice().toString());
    }
    
    @FXML
    private void RefreshAllFields(MouseEvent event) throws Exception {
        int idCount = txtFID.getLength();
        int nameCount = txtName.getLength();
        int fTypeCount = txtFType.getLength();
        int clrCount = txtColor.getLength();
        int priceCount = txtPrice.getLength();
        int qtyCount = txtQuantity.getLength();
        int wTypeCount = txtWType.getLength();
        int SCount1 = txtSearchByName.getLength();
        int sCount2 = txtSearchByPrice.getLength();
        int sCount3 = txtSearchByWoodType.getLength();
        
        if (idCount > 0 || nameCount > 0 || fTypeCount > 0 || 
                clrCount > 0 || priceCount > 0 || qtyCount > 0 || wTypeCount > 0
                || SCount1 > 0 || sCount2 > 0 || sCount3 > 0 ) {
            RotateTransition rt = new RotateTransition(Duration.seconds(0.5), lblRefresh);
            rt.setByAngle(90);
            rt.play();
            clearFields();
            clearSearchFields();
            setTableValues(furnitureStockDAO.getAll());

        }
        txtFID.requestFocus();
    
        
    }

    

    private void clearFields() {
        txtFID.setText(null);
        txtName.setText(null);
        txtColor.setText(null);
        txtFType.setText(null);
        txtPrice.setText(null);
        txtQuantity.setText(null);
        txtWType.setText(null);
        
    }

    private void clearSearchFields() {
        txtSearchByName.setText(null);
        txtSearchByPrice.setText(null);
        txtSearchByWoodType.setText(null);
    }

    
    
}
