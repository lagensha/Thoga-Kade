package edu.icet.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
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
import java.sql.*;
import java.util.ResourceBundle;

public class Customer_management_form  implements Initializable {
ObservableList<Customer_Management_InfoDTO>customerManagementInfoDTOS= FXCollections.observableArrayList();


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
        addCustomer();
        clearText();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Customer_Management_InfoDTO deleteInfoDTO=tblCustomerManagement.getSelectionModel().getSelectedItem();
        customerManagementInfoDTOS.remove(deleteInfoDTO);
        clearText();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Customer_Management_InfoDTO updateInfoDTO=tblCustomerManagement.getSelectionModel().getSelectedItem();

        updateInfoDTO.setCustomerId(txtCustomerId.getText());
        updateInfoDTO.setName(txtName.getText());
        updateInfoDTO.setTitle(txtTitle.getText());
        updateInfoDTO.setDOB(txtDOB.getText());
        updateInfoDTO.setAddress(txtAddress.getText());
        updateInfoDTO.setSalary(Double.parseDouble(txtSalary.getText()));
        updateInfoDTO.setProvince(txtProvince.getText());
        updateInfoDTO.setPostalcode(txtPostalcode.getText());
        tblCustomerManagement.refresh();
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
        tblCustomerManagement.setItems(customerManagementInfoDTOS);

        getData();
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
    public void getData(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade","root","12345");
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 String customerId=resultSet.getString("ID");
                 String title= resultSet.getString("title");
                String name= resultSet.getString("name");
                 String DOB=resultSet.getString("DOB");
                 double salary=resultSet.getDouble("Salary");
                String address=resultSet.getString("address");
                 String city=resultSet.getString("city");
                 String province=resultSet.getString("province");
                String postalcode=resultSet.getString("postalcode");
                Customer_Management_InfoDTO customerManagementInfoDTO = new Customer_Management_InfoDTO(customerId,title,name,DOB,salary,address,city,province,postalcode);
                customerManagementInfoDTOS.add(customerManagementInfoDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
     public void addCustomer(){
         try {
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade","root","12345");
             PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO customers VALUES(?,?,?,?,?,?,?,?,?)");

            Customer_Management_InfoDTO customerManagementInfoDTO = new Customer_Management_InfoDTO(txtCustomerId.getText(),txtTitle.getText(),txtName.getText(),txtDOB.getText(),Double.parseDouble(txtSalary.getText()),txtAddress.getText(),txtCity.getText(),txtProvince.getText(),txtPostalcode.getText());
            customerManagementInfoDTOS.add(customerManagementInfoDTO);
            preparedStatement.setString(1,txtCustomerId.getText());
             preparedStatement.setString(2,txtTitle.getText());
             preparedStatement.setString(3,txtName.getText());
             preparedStatement.setString(4,txtDOB.getText());
             preparedStatement.setDouble(5,Double.parseDouble(txtSalary.getText()));
             preparedStatement.setString(6,txtAddress.getText());
             preparedStatement.setString(7,txtCity.getText());
             preparedStatement.setString(8,txtProvince.getText());
             preparedStatement.setString(9,txtPostalcode.getText());

            preparedStatement.executeUpdate();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }


     }
     }

