/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static lk.furniture.store.controller.FurnitureStockController.furnitureStockDAO;
import static lk.furniture.store.controller.ManageCustomerController.addCustomer;
import static lk.furniture.store.controller.ManageCustomerController.customerDAO;
import lk.furniture.store.dao.DAOFactory;
import lk.furniture.store.dao.custom.DeliverDAO;
import lk.furniture.store.dao.custom.FurnitureStockDAO;
import lk.furniture.store.dao.custom.OrderDAO;
import lk.furniture.store.dao.custom.PaymentsDAO;
import lk.furniture.store.db.DBConnection;
import lk.furniture.store.dto.CustomerDTO;
import lk.furniture.store.dto.DeliverDTO;
import lk.furniture.store.dto.FurnitureStockDTO;
import lk.furniture.store.dto.OrderDTO;
import lk.furniture.store.dto.PaymentDTO;
import lk.furniture.store.tables.observablelist.ItemTable;
import lk.furniture.store.tables.observablelist.PayemntTable;
import lk.furniture.store.utill.IDgenerator;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lakitha
 */
public class DashboardController implements Initializable {

    Parent rootCustomer;
    Parent rootItem;

    private AnchorPane Ap;
    @FXML
    private ImageView logout;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton btnPayment;
    @FXML
    private JFXButton Customers;
    @FXML
    private JFXButton btnFurnitureStock;
    @FXML
    private JFXButton btnSupplier;
    @FXML
    private JFXButton btnDelivery;
    @FXML
    private JFXButton btnGRN;
    @FXML
    private JFXButton btnPurchaseOrder;
    @FXML
    private Label lblDate;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnSetting;
    @FXML
    private AnchorPane customrPane;
    @FXML
    private AnchorPane itemPane;
    @FXML
    private AnchorPane dashboardMainPane;
    //private AnchorPane customerPane;
    @FXML
    private JFXTextField txtFName;
    @FXML
    private JFXButton btnItemCancel;
    private AnchorPane payementPane;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnBack;
    @FXML
    private AnchorPane summaryPane;
    @FXML
    private JFXButton btmDone;
    @FXML
    private JFXButton btnNext;
    @FXML
    private JFXButton btnAddCustomer;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextArea txtAddress;
    @FXML
    private JFXTextField txtLName;
    @FXML
    private JFXTextField txtDistrict;
    @FXML
    private JFXTextField txtCID;
    @FXML
    private JFXTextField txtOID;
    @FXML
    private JFXTextField txtFurtype;
    @FXML
    private JFXComboBox<String> CBFID;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtPrice;
    @FXML
    private JFXTextField txtCurrentDate;
    @FXML
    private JFXButton btnOrder;
    @FXML
    private JFXTextField txtColor;
    @FXML
    private JFXTextField txtFurName;
    @FXML
    private JFXTextField txtWoodType;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private Label lblRefresh;
    @FXML
    private TableView<ItemTable> tblOrder;

    ObservableList<ItemTable> orderItems = FXCollections.observableArrayList();

    private Label lbltStoreAvalability;
    private JFXTextField txtStoreAvalability;
    //private JFXTextField txtOrderQty;
    private JFXTextArea txtPayDelivery;
    @FXML
    private JFXTextField txtDeliveryID;
    private Label lblTotal;
    @FXML
    private JFXDatePicker dpDeliveryDate;
    private TableView<PayemntTable> tblPayment;
    ObservableList<PayemntTable> itemsToPay = FXCollections.observableArrayList();

    private JFXTextField txtPayCustomerContact;
    private JFXTextField txtPayCustomerName;
    @FXML
    private JFXTextField txtPayDate;
    @FXML
    private JFXTextField txtPayPID;
    @FXML
    private JFXTextField txtPayBalance;
    @FXML
    private JFXTextField txtPayCash;
    private Label deletePayItem;
    private JFXTextField lblQty;
    @FXML
    private Label lblGetTotal;
    @FXML
    private JFXTextField txtDeliveryCustomerName;
    @FXML
    private JFXButton btnDeliverNext;
    @FXML
    private AnchorPane deliveryPane;
    @FXML
    private JFXTextArea txtDeliveryAddress;
    @FXML
    private JFXButton btnNext1;
    @FXML
    private JFXTextField txtDeliveryCustomerContact;
    @FXML
    private Label lblSumCustomerName;
    @FXML
    private Label lblSumConNumber;
    @FXML
    private JFXTextField txtSumPayID;
    @FXML
    private JFXTextArea txtSumPurchasedFurniture;
    @FXML
    private Label lblSumTotal;
    @FXML
    private JFXTextField txtSumDate;
    @FXML
    private Label lblSumAddress;

    String furnitureName = "";
    @FXML
    private JFXTextField txtMainPay;
    
    double total;

    private Connection conn = DBConnection.getInstance().getConnection();
    private OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    private PaymentsDAO paymentsDAO = (PaymentsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENTS);
    private DeliverDAO deliverDAO = (DeliverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DELIVER);
    @FXML
    private AnchorPane settingPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDate();
        rootPane.getChildren().setAll(dashboardMainPane); //mainPaneDashBoard

    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        lblDate.setText(sdf.format(d));
        txtCurrentDate.setText(sdf.format(d));
        txtPayDate.setText(sdf.format(d));

    }

    //loadPanes
    @FXML
    private void applicationSettings(MouseEvent event) throws IOException {
//        Parent root = null;
//        root = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/ApplicationSettings.fxml"));
//        Scene scene = new Scene(root);
//        Stage Stage = new Stage();
//        Stage.setScene(scene);
//        Stage.setTitle("FurnitureStore-Login");
//        Stage.show();
//        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/furniture/store/view/ApplicationSettings.fxml"));
//     //Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fx/view/MainForm.fxml"));  
//        Scene scene = new Scene(root);
//        Stage primaryStage=new Stage();
//        primaryStage.setScene(scene);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        //primaryStage.setTitle("FurnitureStore-Login");
//        primaryStage.show();
//        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/ManageCustomer.fxml"));
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/ApplicationSettings.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        
        settingPane.getChildren().clear();
        settingPane.getChildren().add(ap);
        //settingPane.getScene().getWindow().hide();
        
    }
    
    
    @FXML
    private void loadLogin(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Login.fxml"));
        Scene scene = new Scene(root);
        Stage Stage = new Stage();
        Stage.setScene(scene);
        Stage.setTitle("FurnitureStore-Login");
        Stage.show();
        Ap.getScene().getWindow().hide();
    }

    //paymentProcess
    @FXML
    private void loadPayment(ActionEvent event) throws IOException {

        FadeTransition ft = new FadeTransition(Duration.millis(1000), customrPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().setAll(customrPane);

    }

    @FXML
    private void loadManageCustomers(ActionEvent event) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/ManageCustomer.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().clear();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void loadFurnitureStock(ActionEvent event) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/FurnitureStock.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().clear();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void loadSupplier(ActionEvent event) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Supplier.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().clear();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void loadDelivery(ActionEvent event) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Delivery.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().clear();
        rootPane.getChildren().add(ap);

    }

    @FXML
    private void loadGRN(ActionEvent event) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/GRN.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().clear();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void loadPurchaseOrder(ActionEvent event) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/PurchaseOrder.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().clear();
        rootPane.getChildren().add(ap);

    }

    @FXML
    private void systemExit(MouseEvent event) {
        Platform.exit();
        System.exit(0);

    }

    @FXML
    private void loadustomerOnCancel(ActionEvent event) {
        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(customrPane);
    }

    public void summary() {
        String firstName = txtFName.getText().toString();
        String lastname = txtLName.getText().toString();
        String fullName = firstName + " " + lastname;
        String contactName = txtDeliveryCustomerContact.getText().toString();
        String address = txtDeliveryAddress.getText().toString();

        String payId = txtMainPay.getText().toString();
        String sumDate = dpDeliveryDate.getValue().toString();
        lblSumTotal.setText(Double.toString(total));
        lblSumCustomerName.setText(fullName);
        lblSumConNumber.setText(contactName);
        lblSumAddress.setText(address);

        txtSumPayID.setText(payId);
        txtSumDate.setText(sumDate);

        furnitureName = "";
        txtSumPurchasedFurniture.setText("\n");
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            Object cellData = tblOrder.getColumns().get(1).getCellData(i);
            furnitureName += cellData.toString();

            txtSumPurchasedFurniture.setText(furnitureName);
        }

    }

    @FXML
    private void loadCustomerOnCancel(ActionEvent event) {
        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(customrPane);
    }

    @FXML
    private void loadItemOnBack(ActionEvent event) {
        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(itemPane);
        
    }

   
//    public static OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    @FXML
    private void loadAddCustomer(ActionEvent event) throws IOException {

    }

    @FXML
    private void fillCustomerDetails(ActionEvent event) {

    }

    public static CustomerDTO searchCustomer(CustomerDTO customer) throws Exception {
        CustomerDTO searchedCustomer = customerDAO.search(customer);
        return searchedCustomer;
    }

    @FXML
    private void loadCustomerDetailsOnActionContact(ActionEvent event) {
        CustomerDTO customer = new CustomerDTO((String) txtContact.getText());
        try {
            CustomerDTO searchedCustomer = searchCustomer(customer);
            String contact = txtContact.getText();

            txtFName.setText(searchedCustomer.getFirstName());
            txtLName.setText(searchedCustomer.getLastName());
            txtCID.setText(searchedCustomer.getCID());
            txtAddress.setText(searchedCustomer.getAddress());
            txtDistrict.setText(searchedCustomer.getDistrict());

        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }

    private void clearFields() {
        txtCID.setText(null);
        txtFName.setText(null);
        txtLName.setText(null);
        txtAddress.setText(null);
        txtDistrict.setText(null);
        txtContact.setText(null);
    }

    //LoadItemProcess
    @FXML
    private void loadItemOnNext(ActionEvent event) throws Exception {
        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(itemPane);

        loadComboBoxItems();
        try {
            txtOID.setText(IDgenerator.getNewID("orders", "OID", "O"));
            txtDeliveryID.setText(IDgenerator.getNewID("deliver","DID" , "D"));
//(IDgenerator.getNewID("orders", "OID", "OI"));
txtMainPay.setText(IDgenerator.getNewID("payments", "PaymentID", "P"));
            CBFID.requestFocus();
        } catch (Exception e) {
        }

    }

    public void loadComboBoxItems() {
        try {

            for (FurnitureStockDTO furnitureID : furnitureStockDAO.getAll()) {
                if (!CBFID.getItems().contains(furnitureID.getFID())) {
                    CBFID.getItems().add(furnitureID.getFID());
                    //add(furnitureID.getFID())
                }
                

            }

        } catch (Exception e) {
        }

    }

    public static FurnitureStockDTO selectFurniture(FurnitureStockDTO furniture) throws Exception {
        FurnitureStockDTO selectFurniture = furnitureStockDAO.search(furniture);
        return selectFurniture;
    }

    @FXML
    private void addtemToTable(ActionEvent event) {
        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("furnitureID"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("furnitureName"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("furnitureType"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("woodType"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("color"));
        tblOrder.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblOrder.setItems(orderItems);

        String ID = CBFID.getValue();
        String name = txtFurName.getText();
        String color = txtColor.getText();
        String furType = txtFurtype.getText();
        String woodType = txtWoodType.getText();

        double getNewQty = Double.parseDouble(txtQty.getText());
        double getNewPice = Double.parseDouble(txtPrice.getText());
        double Total = getNewQty * getNewPice;
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(txtPrice.getText()));
        String Qty = txtQty.getText();

        int rowIndex = isRowAvailable(ID);
        BigDecimal totalDouble = BigDecimal.valueOf(Total);

        if (rowIndex == -1) {
            orderItems.add(new ItemTable(ID, name, furType, woodType, Qty, color, totalDouble));
        } else {
            int currentQty = Integer.parseInt(orderItems.get(rowIndex).getQuantity());
            int newQty = Integer.parseInt(Qty);
            String stringQty = (currentQty + newQty) + "";
            double priceTextField = Double.parseDouble(txtPrice.getText());
            //double currDbl= Total;
            BigDecimal priceDouble = BigDecimal.valueOf(priceTextField * (currentQty + newQty));

            orderItems.set(rowIndex, new ItemTable(ID, name, furType, woodType, stringQty, color, priceDouble));

        }
//        FurnitureStockDTO furnitreStoreDTO new FurnitureStockDTO(
//                           lblQty.setText(name));
//        lblQty.setText(txtQty.getText().toString());

    }

    private int isRowAvailable(String ID) {

        for (int i = 0; i < orderItems.size(); i++) {
            String id = orderItems.get(i).getFurnitureID();
            if (id.equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    @FXML
    private void removeItemFromTable(ActionEvent event) {
//        TableView<MyDataType> table = new TableView<>();
//then you do
//
//deleteButton.setOnAction(e -> {
//    MyDataType selectedItem = table.getSelectionModel().getSelectedItem();
//    table.getItems().remove(selectedItem);

//});
        ItemTable selectedItem = tblOrder.getSelectionModel().getSelectedItem();
        tblOrder.getItems().remove(selectedItem);

        txtQty.clear();
        calculate();

    }

    @FXML
    private void RefreshAllFields(MouseEvent event) {
    }

    @FXML
    private void fillFurnitureItemDetails(ActionEvent event) {

        if (!CBFID.getValue().isEmpty()) {
            try {
                FurnitureStockDTO dto = new FurnitureStockDTO();
                dto.setFID(CBFID.getValue());
                FurnitureStockDTO furniture = furnitureStockDAO.search(dto);
                txtFurName.setText(furniture.getFname());
                txtColor.setText(furniture.getColor());
                txtFurtype.setText(furniture.getFurnitureType());
                txtWoodType.setText(furniture.getWoodType());
                txtPrice.setText(furniture.getUnitPrice().toString());
                txtQty.setText(furniture.getAvailableQty());

                txtQty.requestFocus();
                //txtQty.setText();
                txtQty.selectAll();
            } catch (Exception ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void loadComfirmPayOnNext(ActionEvent event) {
        OrderDTO order = new OrderDTO(
                CBFID.getValue(),
                txtOID.getText(),
                txtCurrentDate.getText());

        try {
            boolean result = orderDAO.add(order);
        } catch (Exception e) {
        }
        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(payementPane);

        //addTODatabase
    }

    public void loadfiledsDelivery() {
        String customerFName = txtFName.getText();
        String customerLName = txtLName.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();

        txtDeliveryCustomerName.setText(customerFName + " " + customerLName);
        txtDeliveryCustomerContact.setText(contact);
        txtDeliveryAddress.setText(address);

        //txtDeliveryID.requestFocus();
    }

    public void calculate() {

        //lblGetTotal.setText(Double.toString(total));
    }

    @FXML
    private void loadBalanceOnAction(ActionEvent event) {

        double total = 0.0;
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            Object cellData = tblOrder.getColumns().get(6).getCellData(i);
            total += Double.parseDouble(cellData.toString());

            double balance = 0.0;
            double cash = Double.parseDouble(txtPayCash.getText());
            balance = cash - total;

            txtPayBalance.setText(Double.toString(balance));
        }

    }

    @FXML
    private void loadTotalAmount(MouseEvent event) {
        total = 0.0;
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            Object cellData = tblOrder.getColumns().get(6).getCellData(i);
            total += Double.parseDouble(cellData.toString());
        }

        lblGetTotal.setText(Double.toString(total));
    }

    @FXML
    private void loadSummaryOnNext(ActionEvent event) throws Exception {
        Image img = new Image("/lk/furniture/store/images/tick.png");

        Notifications notificationManager = Notifications.create()
                .title("Transaction Complete")
                .text("Succesfully Transaction Saved!")
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });

        notificationManager.darkStyle();
        notificationManager.show();

        Image img1 = new Image("/lk/furniture/store/images/delivery-van (5).png");

        Notifications notificationManagerDelivery = Notifications.create()
                .title("New Delivery Addedd!")
                .text("check it out.....")
                .graphic(new ImageView(img1))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            AnchorPane ap1 = FXMLLoader.load(getClass().getResource("/lk/furniture/store/view/Delivery.fxml"));
                            FadeTransition ft = new FadeTransition(Duration.millis(1500), ap1);
                            ft.setFromValue(0.0);
                            ft.setToValue(1.0);
                            ft.play();
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(ap1);
                        } catch (IOException ex) {
                            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });

        notificationManagerDelivery.darkStyle();
        notificationManagerDelivery.show();

        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(summaryPane);

        summary();
        OrderDTO orderDTO = new OrderDTO(txtOID.getText(), CBFID.getValue().toString(), txtCurrentDate.getText());
        PaymentDTO paymentDTO = new PaymentDTO(txtMainPay.getText(), CBFID.getValue().toString(), txtOID.getText(), txtQty.getText(), lblGetTotal.getText());
        DeliverDTO deliverDTO = new DeliverDTO(txtDeliveryID.getText(), txtMainPay.getText(), txtCurrentDate.getText(), txtAddress.getText());
        try {
            conn.setAutoCommit(false);

            boolean addOrder = orderDAO.add(orderDTO);
            if (!addOrder) {
                conn.rollback();
                return;

            }
            System.out.println("A");

            boolean addPayment = paymentsDAO.add(paymentDTO);
            if (!addPayment) {
                conn.rollback();
                return;
            }

            boolean addDelivery = deliverDAO.add(deliverDTO);
            if (!addDelivery) {
                conn.rollback();
                return;
            }

            System.out.println("B");

            //conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();
            return;
        } finally {
            conn.setAutoCommit(true);
        }

    }

    @FXML
    private void loadDeliveryOnNext(ActionEvent event) throws Exception {
        try {
            txtDeliveryID.setText(IDgenerator.getNewID("deliver", "DID", "D"));
        } catch (Exception e) {
        }
        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(deliveryPane);
        loadfiledsDelivery();

    }
    
    @FXML
    private void loadCustomerOnDone(ActionEvent event) {
        rootPane.getChildren().clear();
        rootPane.getChildren().setAll(customrPane);
        clearData ();
    }
    
    public void  clearData (){
        for ( int i = 0; i<tblOrder.getItems().size(); i++) {
        tblOrder.getItems().clear();
        }
    }

    
}
