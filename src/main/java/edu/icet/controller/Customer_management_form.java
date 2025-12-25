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
import model.dto.Customer_Management_InfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class Customer_management_form  implements Initializable {
ObservableList<Customer_Management_InfoDTO>customerManagementInfoDTOS= FXCollections.observableArrayList(
        new Customer_Management_InfoDTO("C002", "Ms.", "Kumari", "1993-11-12", 52000, "No.15 Galle Road", "Colombo", "Western", "12000"),
        new Customer_Management_InfoDTO("C003", "Mr.", "Perera", "1987-07-25", 46000, "No.8 Station Road", "Galle", "Southern", "8000"),
        new Customer_Management_InfoDTO("C004", "Mrs.", "Silva", "1990-03-10", 55000, "No.42 Temple Lane", "Kandy", "Central", "9000"),
        new Customer_Management_InfoDTO("C005", "Mr.", "Fernando", "1984-09-18", 60000, "No.5 Park Avenue", "Kurunegala", "North Western", "7000"),
        new Customer_Management_InfoDTO("C006", "Ms.", "Nadeesha", "1998-01-30", 48000, "No.33 Lake View", "Matara", "Southern", "6500")

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
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<Customer_Management_InfoDTO> tblCustomerManagement;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalcode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnAddOnAction(ActionEvent event) {
            String customerid=txtCustomerId.getText();
            String title=txtTitle.getText();
            String name=txtName.getText();
            String dob=txtDOB.getText();
            double salary=Double.parseDouble(txtSalary.getText());
            String address=txtAddress.getText();
            String city=txtCity.getText();
            String province=txtProvince.getText();
            String postalcode=txtPostalcode.getText();

            Customer_Management_InfoDTO customerManagementInfoDTO=new Customer_Management_InfoDTO(customerid,title,name,dob,salary,address,city,province,postalcode);
            customerManagementInfoDTOS.add(customerManagementInfoDTO);
        clearText();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));
        tblCustomerManagement.setItems(customerManagementInfoDTOS);

     tblCustomerManagement.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
         if(newValue != null){
             txtCustomerId.setText(newValue.getCustomerId());
             txtTitle.setText(newValue.getTitle());
             txtName.setText(newValue.getName());
             txtDOB.setText(newValue.getDOB());
             txtSalary.setText(String.valueOf(newValue.getSalary()));
             txtAddress.setText(newValue.getAddress());
             txtCity.setText(newValue.getCity());
             txtProvince.setText(newValue.getProvince());
             txtPostalcode.setText(newValue.getPostalcode());
             
         }
     } );
    }
    public void clearText(){
        txtPostalcode.clear();
        txtCustomerId.clear();
        txtName.clear();
        txtSalary.clear();
        txtProvince.clear();
        txtDOB.clear();
        txtCity.clear();
        txtAddress.clear();
        txtTitle.clear();

    }
}
