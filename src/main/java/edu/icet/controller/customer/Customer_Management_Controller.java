package edu.icet.controller.customer;

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

public class Customer_Management_Controller implements Initializable {

    CustomerController customerController = new CustomerController();

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
        Integer id = Integer.valueOf(txtCustomerId.getText());
         String title=txtTitle.getText();
         String name= txtName.getText();
          String dob= txtDOB.getText();
         Double salary= Double.parseDouble(txtSalary.getText());
         String province=txtProvince.getText();
         String postalCode=txtPostalcode.getText();
         String address=txtAddress.getText();
          String city= txtCity.getText();

          customerController.addCustomer(id,title,name,dob,salary,province,postalCode,address,city);
          loadTable();
          clearText();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        customerController.deleteCustomer(Integer.parseInt(txtCustomerId.getText()));
        loadTable();
        clearText();

    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Integer id = Integer.valueOf(txtCustomerId.getText());
        String title=txtTitle.getText();
        String name= txtName.getText();
        String dob= txtDOB.getText();
        Double salary= Double.parseDouble(txtSalary.getText());
        String province=txtProvince.getText();
        String postalCode=txtPostalcode.getText();
        String address=txtAddress.getText();
        String city= txtCity.getText();

            customerController.updateCustomer(title,name,dob,salary,address,city,province,postalCode,id);
            loadTable();
            clearText();
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

        loadTable();
        tblCustomerManagement.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null){
                txtCustomerId.setText(newValue.getCustomerId());
                txtTitle.setText(newValue.getTitle());
                txtName.setText(newValue.getName());
                txtDOB.setText(newValue.getDOB());
                txtAddress.setText(newValue.getName());
                txtCity.setText(newValue.getCity());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtProvince.setText(newValue.getProvince());
                txtPostalcode.setText(newValue.getPostalcode());

            }
        } );
    }

    void loadTable(){

        tblCustomerManagement.setItems(customerController.viewData());
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
