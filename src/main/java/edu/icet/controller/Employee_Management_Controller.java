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
import model.dto.Employee_Management_DTO;

import java.net.URL;
import java.util.ResourceBundle;

public class Employee_Management_Controller implements Initializable {
    ObservableList<Employee_Management_DTO> employeeManagementDTOS= FXCollections.observableArrayList(
            new Employee_Management_DTO("E002", "Kamal Fernando", "871254789V", "1987-03-22", "Assistant Manager", 62500.0, "0778541236", "No.20 Beach Road, Galle", "2019-02-18", "Active"),
            new Employee_Management_DTO("E003", "Nadeesha Silva", "915478963V", "1991-11-05", "Accountant", 68500.0, "0719654785", "No.42 Station Road, Panadura", "2020-07-01", "Active"),
            new Employee_Management_DTO("E004", "Chathura Jayasena", "902365478V", "1990-01-28", "Sales Executive", 52000.0, "0758456932", "No.08 Lake View, Kandy", "2021-03-15", "Active"),
            new Employee_Management_DTO("E005", "Ruvini Peris", "945632178V", "1994-06-10", "Cashier", 42000.0, "0784561239", "No.55 Temple Junction, Matara", "2022-09-09", "Active"),
            new Employee_Management_DTO("E006", "Mahesh Ranasinghe", "885694123V", "1988-12-19", "Store Keeper", 48000.0, "0763214589", "No.11 Main Street, Kurunegala", "2017-11-25", "Inactive")
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
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colEmploteeId;

    @FXML
    private TableColumn<?, ?> colJoinedDate;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableView<Employee_Management_DTO> tblEmployeeDetails;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtJoinDate;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStatus;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String employeeId=txtEmployeeId.getText();
        String name=txtName.getText();
        String nic=txtNIC.getText();
        String dob=txtDOB.getText();
        String position=txtPosition.getText();
         double salary=Double.parseDouble(txtSalary.getText());
         String contactNumber=txtPhoneNumber.getText();
         String address=txtAddress.getText();
         String joinedDate=txtJoinDate.getText();
         String status=txtStatus.getText();

        Employee_Management_DTO employeeManagementDTO=new Employee_Management_DTO(employeeId,name,nic,dob,position,salary,contactNumber,address,joinedDate,status);
        employeeManagementDTOS.add(employeeManagementDTO);
    clearText();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Employee_Management_DTO deleteIntoDTO=tblEmployeeDetails.getSelectionModel().getSelectedItem();
        employeeManagementDTOS.remove(deleteIntoDTO);
        clearText();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Employee_Management_DTO updateInfoDTO=tblEmployeeDetails.getSelectionModel().getSelectedItem();
        updateInfoDTO.setEmployeeId(txtEmployeeId.getText());
        updateInfoDTO.setName(txtName.getText());
        updateInfoDTO.setNic(txtNIC.getText());
        updateInfoDTO.setDob(txtDOB.getText());
        updateInfoDTO.setPosition(txtPosition.getText());
        updateInfoDTO.setSalary(Double.parseDouble(txtSalary.getText()));
        updateInfoDTO.setContactNumber(txtPhoneNumber.getText());
        updateInfoDTO.setAddress(txtAddress.getText());
        updateInfoDTO.setJoinedDate(txtJoinDate.getText());
        updateInfoDTO.setStatus(txtStatus.getText());
        tblEmployeeDetails.refresh();
        clearText();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmploteeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>(" name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>(" address"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblEmployeeDetails.setItems(employeeManagementDTOS);

        tblEmployeeDetails.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                txtEmployeeId.setText(newValue.getEmployeeId());
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtNIC.setText(newValue.getNic());
                txtDOB.setText(newValue.getDob());
                txtPosition.setText(newValue.getPosition());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtPhoneNumber.setText(newValue.getContactNumber());
                txtJoinDate.setText(newValue.getJoinedDate());
                txtStatus.setText(newValue.getStatus());
            }
        } );
    }
    public void clearText(){
        txtEmployeeId.clear();
        txtSalary.clear();
        txtStatus.clear();
        txtPosition.clear();
        txtJoinDate.clear();
        txtPhoneNumber.clear();
        txtStatus.clear();
        txtDOB.clear();
        txtName.clear();
        txtAddress.clear();
        txtNIC.clear();
    }
}
