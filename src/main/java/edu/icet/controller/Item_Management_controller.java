package edu.icet.controller;

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
    ObservableList<ItemInfoDTO>itemInfoDTOS= FXCollections.observableArrayList(
            new ItemInfoDTO("I001", "Red Rice 5kg", "Groceries", 40, 1200.00),
            new ItemInfoDTO("I002", "White Rice 10kg", "Groceries", 25, 2350.00),
            new ItemInfoDTO("I003", "Sugar 1kg", "Groceries", 60, 320.00),
            new ItemInfoDTO("I004", "Coconut Oil 750ml", "Groceries", 35, 1450.00),
            new ItemInfoDTO("I005", "Wheat Flour 1kg", "Groceries", 50, 280.00),
            new ItemInfoDTO("I006", "Dhal 1kg", "Groceries", 45, 720.00)
    );
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
        String itemcode=txtItemCode.getText();
        String description=txtDescription.getText();
        String category=txtCategory.getText();
        int qtyOnHand=Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice=Double.parseDouble(txtUnitPrice.getText());

        ItemInfoDTO itemInfoDTO=new ItemInfoDTO(itemcode,description,category,qtyOnHand,unitPrice);
        itemInfoDTOS.add(itemInfoDTO);
        clearText();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        ItemInfoDTO deleteinfoDTO=tblItemManagement.getSelectionModel().getSelectedItem();
        itemInfoDTOS.remove(deleteinfoDTO);
        clearText();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemInfoDTO itemInfoDTO=tblItemManagement.getSelectionModel().getSelectedItem();
        itemInfoDTO.setItemCode(txtItemCode.getText());
        itemInfoDTO.setDescription(txtDescription.getText());
        itemInfoDTO.setCategory(txtCategory.getText());
        itemInfoDTO.setQtyOnHand(Integer.parseInt(txtQtyOnHand.getText()));
        itemInfoDTO.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        tblItemManagement.refresh();
        clearText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblItemManagement.setItems(itemInfoDTOS);

        tblItemManagement.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue != null){
                txtItemCode.setText(newValue.getItemCode());
                txtCategory.setText(newValue.getCategory());
                txtDescription.setText(newValue.getDescription());
                txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        } );
    }
        public void clearText(){
            txtItemCode.clear();
            txtDescription.clear();
            txtCategory.clear();
            txtQtyOnHand.clear();
            txtUnitPrice.clear();
        }
}
