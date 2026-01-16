package edu.icet.controller.item;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.ItemInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class Item_Management_controller implements Initializable {
    ItemController itemController = new ItemController();
    ObservableList<ItemInfoDTO>itemInfoDTOS=FXCollections.observableArrayList();
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<ItemInfoDTO> tblItemManagement;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) {
       Integer itemcode=Integer.parseInt(txtItemCode.getText());
        String description=txtDescription.getText();
        String category=txtCategory.getText();
        Integer qtyOnHand=Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice=Double.parseDouble(txtUnitPrice.getText());

        itemController.addItems(itemcode,description,category,qtyOnHand,unitPrice);
        loadTable();
        clearText();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        itemController.deleteItem(Integer.valueOf(txtItemCode.getText()));
        loadTable();
        clearText();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

        clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Integer itemcode=Integer.parseInt(txtItemCode.getText());
        String description=txtDescription.getText();
        String category=txtCategory.getText();
        Integer qtyOnHand=Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice=Double.parseDouble(txtUnitPrice.getText());

            itemController.updateItems(description,category,qtyOnHand,unitPrice,itemcode);
            loadTable();
            clearText();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        loadTable();
        tblItemManagement.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVersion, newValue) ->{
            if(newValue != null){
                txtItemCode.setText(String.valueOf(newValue.getItemCode()));
                txtDescription.setText(newValue.getDescription());
                txtCategory.setText(newValue.getCategory());
                txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        } );

    }
    public void loadTable(){
      tblItemManagement.setItems(itemController.viewData());
    }
        public void clearText(){
            txtItemCode.clear();
            txtDescription.clear();
            txtCategory.clear();
            txtQtyOnHand.clear();
            txtUnitPrice.clear();
        }
}
