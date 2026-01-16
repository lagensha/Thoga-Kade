package edu.icet.controller.supplier;

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
import model.dto.Supplier_Management_DTO;

import java.net.URL;
import java.util.ResourceBundle;

public class Supplier_Management_Controller implements Initializable {
        SupplierController supplierController = new SupplierController();
    ObservableList<Supplier_Management_DTO>supplierManagementDTOS= FXCollections.observableArrayList();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCompanyName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableView<Supplier_Management_DTO> tblSupplierDetails;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    public Button btnReset;

    @FXML
    private TextField txtSupplierId;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String supplierId=txtSupplierId.getText();
        String name=txtName.getText();
        String companyName=txtName.getText();
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province=txtProvince.getText();
        String postalCode=txtPostalCode.getText();
        String phonenumber=txtPhoneNumber.getText();
        String email=txtEmail.getText();

        supplierController.addSupplier(supplierId,name,companyName,address,city,province,postalCode,phonenumber,email);
        loadTable();
        clearText();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String supplierId=txtSupplierId.getText();
      supplierController.deleteSupplier(supplierId);
      loadTable();
      clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String name=txtName.getText();
        String companyName=txtName.getText();
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province=txtProvince.getText();
        String postalCode=txtPostalCode.getText();
        String phonenumber=txtPhoneNumber.getText();
        String email=txtEmail.getText();
        String supplierId=txtSupplierId.getText();

        supplierController.updateSupplier(name,companyName,address,city,province,postalCode,phonenumber,email,supplierId);
        loadTable();
        clearText();
    }

    @FXML
    public void btnResetOnAction(ActionEvent actionEvent) {

        clearText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadTable();

        tblSupplierDetails.getSelectionModel().selectedItemProperty().addListener((observableValue,oldValue,newValue) ->{
            if(newValue != null){
                txtSupplierId.setText(newValue.getSupplierId());
                txtName.setText(newValue.getName());
                txtCompanyName.setText(newValue.getCompanyName());
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
                txtPhoneNumber.setText(newValue.getPhone());
                txtEmail.setText(newValue.getEmail());
            }
        });
    }
    public void loadTable(){

        tblSupplierDetails.setItems(supplierController.viewSupplier());
    }
        public void clearText(){
            txtSupplierId.clear();
            txtName.clear();
            txtCompanyName.clear();
            txtAddress.clear();
            txtCity.clear();
            txtProvince.clear();
            txtPostalCode.clear();
            txtPhoneNumber.clear();
            txtEmail.clear();
        }

}
