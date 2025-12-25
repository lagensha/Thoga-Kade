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
import model.dto.Supplier_Management_DTO;

import java.net.URL;
import java.util.ResourceBundle;

public class Supplier_Management_Controller implements Initializable {

    ObservableList<Supplier_Management_DTO>supplierManagementDTOS= FXCollections.observableArrayList(
            new Supplier_Management_DTO("S002", "Perera Distributors", "Sunrise Foods Ltd", "No.12 Galle Road", "Colombo", "Western", "00300", "0778456123", "sunrisefoods@gmail.com"),
            new Supplier_Management_DTO("S003", "Silva Traders", "Ceylon Spices Co.", "No.88 Temple Road", "Kandy", "Central", "20000", "0759632145", "ceylonspices@gmail.com"),
            new Supplier_Management_DTO("S004", "Ranasinghe Enterprises", "Fresh Harvest Pvt Ltd", "No.22 Lake View", "Kurunegala", "North Western", "60000", "0714523987", "freshharvest@gmail.com"),
            new Supplier_Management_DTO("S005", "Jayasinghe & Sons", "Green Valley Supplies", "No.10 Market Street", "Galle", "Southern", "80000",
                    "0782145698", "greenvalley@gmail.com"),
            new Supplier_Management_DTO("S006", "Wijesooriya Traders", "Island Agro Imports", "No.05 Station Road", "Anuradhapura", "North Central", "50000",
                    "0763358921", "islandagro@gmail.com")

    );

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

        Supplier_Management_DTO supplierManagementDto=new Supplier_Management_DTO(supplierId,name,companyName,address,city,province,postalCode,phonenumber,email);
        supplierManagementDTOS.add(supplierManagementDto);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Supplier_Management_DTO deleteInfoDTO=tblSupplierDetails.getSelectionModel().getSelectedItem();
        supplierManagementDTOS.remove(deleteInfoDTO);
        clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Supplier_Management_DTO updateInfoDTO=tblSupplierDetails.getSelectionModel().getSelectedItem();
        updateInfoDTO.setSupplierId(txtSupplierId.getText());
        updateInfoDTO.setName(txtName.getText());
        updateInfoDTO.setCompanyName(txtCompanyName.getText());
        updateInfoDTO.setProvince(txtProvince.getText());
        updateInfoDTO.setAddress(txtAddress.getText());
        updateInfoDTO.setCity(txtCity.getText());
        updateInfoDTO.setPostalCode(txtPostalCode.getText());
        updateInfoDTO.setPhone(txtPhoneNumber.getText());
        updateInfoDTO.setEmail(txtEmail.getText());
        tblSupplierDetails.refresh();
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
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>(" phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblSupplierDetails.setItems(supplierManagementDTOS);

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
