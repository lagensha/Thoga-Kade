package edu.icet.controller.employees;

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
    EmployeeController employeeController = new EmployeeController();
    ObservableList<Employee_Management_DTO> employeeManagementDTOS= FXCollections.observableArrayList();
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
        double salary=Double.parseDouble(txtSalary.getText());
        String position=txtPosition.getText();
         String contactNumber=txtPhoneNumber.getText();
         String address=txtAddress.getText();
         String joinedDate=txtJoinDate.getText();
         String status=txtStatus.getText();

        employeeController.addEmployee(employeeId,name,nic,dob,salary,position,contactNumber,address,joinedDate,status);
        loadTable();
    clearText();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String employeeId=txtEmployeeId.getText();
      employeeController.deleteEmployee(employeeId);
      loadTable();
      clearText();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        clearText();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

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

        employeeController.updateEmployee(name,nic,dob,salary,position,contactNumber,address,joinedDate,status,employeeId);
        loadTable();
        clearText();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmploteeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadTable();

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
    public void loadTable(){
        tblEmployeeDetails.setItems(employeeController.viewEmployee());
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
