/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.furniture.store.controller.FurnitureStockController;
import static lk.furniture.store.controller.FurnitureStockController.furnitureStockDAO;
import lk.furniture.store.dao.DAOFactory;
import lk.furniture.store.dao.custom.DeliverDAO;
import lk.furniture.store.dao.custom.FurnitureStockDAO;
import lk.furniture.store.dto.FurnitureStockDTO;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class DeliveryController implements Initializable {

    private TableView<?> tblFurnitureItem;
    @FXML
    private JFXTextField txtSearchByName;
    @FXML
    private JFXTextField txtSearchByPrice;
    @FXML
    private Label lblRefresh;
    @FXML
    private TableView<?> tbllDeliver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        intitializing();
        try {
            // setTableValues(deliverDAO.getAll());
        } catch (Exception ex) {
            Logger.getLogger(FurnitureStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DeliverDAO deliverDAO = (DeliverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DELIVER);

    @FXML
    private void RefreshAllFields(MouseEvent event) {
    }

    private void intitializing() {
        tbllDeliver.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("FID"));
        tbllDeliver.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fname"));
        tbllDeliver.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("furnitureType"));
        tbllDeliver.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("woodType"));
        tbllDeliver.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("color"));
        tblFurnitureItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("availableQty"));

//        tblFurnitureItem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FurnitureStockDTO> (){
//            @Override
//            public void changed(ObservableValue<? extends FurnitureStockDTO> observable, FurnitureStockDTO oldValue, FurnitureStockDTO newValue) {
//                FurnitureStockDTO furniture = tblFurnitureItem.getSelectionModel().getSelectedItem();
//                fillTextFields(furniture);
//            }
//        });
//    }
//    private void setTableValues(ArrayList<FurnitureStockDTO> all) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    }
}
