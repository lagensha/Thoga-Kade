package edu.icet.controller.employees;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Employee_Management_DTO;

import java.sql.*;

public class EmployeeController implements EmployeeInterface{
        public ObservableList<Employee_Management_DTO>viewEmployee(){
            ObservableList<Employee_Management_DTO>employee_management_dtos= FXCollections.observableArrayList();
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade","root","12345");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM Employees");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Employee_Management_DTO employeeManagementDTO = new Employee_Management_DTO(
                    resultSet.getString("employeeId"),
                    resultSet.getString("name"),
                            resultSet.getString("nic"),
                            resultSet.getString("dob"),
                            resultSet.getString("position"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("contactNumber"),
                            resultSet.getString("address"),
                            resultSet.getString("joinedDate"),
                            resultSet.getString("status")
                            );
                    employee_management_dtos.add(employeeManagementDTO);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
                return employee_management_dtos;
        }
    @Override
    public void addEmployee(String employeeId, String name, String nic, String dob, double salary, String position, String contactNumber, String address, String joinedDate, String status) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade","root","12345");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employees VALUES(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1,employeeId);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,nic);
            preparedStatement.setObject(4,dob);
            preparedStatement.setObject(5,position);
            preparedStatement.setObject(6,salary);
            preparedStatement.setObject(7,contactNumber);
            preparedStatement.setObject(8,address);
            preparedStatement.setObject(9,joinedDate);
            preparedStatement.setObject(10,status);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(String name, String nic, String dob, double salary, String position, String contactNumber, String address, String joinedDate, String status, String employeeId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade","root","12345");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employees SET name=?,nic=? dob=?,salary=?,position=?,contactNumber=?,address=?,joinDate=?,status=? WHERE employeeId=?");
            preparedStatement.setObject(1,name);
            preparedStatement.setObject(2,nic);
            preparedStatement.setObject(3,dob);
            preparedStatement.setObject(4,salary);
            preparedStatement.setObject(5,position);
            preparedStatement.setObject(6,contactNumber);
            preparedStatement.setObject(7,address);
            preparedStatement.setObject(8,joinedDate);
            preparedStatement.setObject(9,status);
            preparedStatement.setObject(10,employeeId);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEmployee(String employeeId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade","root","12345");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Employees WHERE employeeId = ?");

            preparedStatement.setObject(1, employeeId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
