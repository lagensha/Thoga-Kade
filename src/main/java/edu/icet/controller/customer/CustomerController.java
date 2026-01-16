package edu.icet.controller.customer;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Customer_Management_InfoDTO;

import java.sql.*;

public class CustomerController implements CustomerInter{

    public ObservableList<Customer_Management_InfoDTO> viewData() {
        ObservableList<Customer_Management_InfoDTO> customerControllers = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer_Management_InfoDTO cust = new Customer_Management_InfoDTO(
                        resultSet.getString("ID"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("DOB"),
                        resultSet.getDouble("Salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalcode")
                );

                customerControllers.add(cust);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerControllers;
    }

    public void addCustomer(Integer id, String title, String name, String dob, Double salary, String province, String postalCode, String address, String city) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers VALUES(?,?,?,?,?,?,?,?,?)");

            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, title);
            preparedStatement.setObject(3, name);
            preparedStatement.setObject(4, dob);
            preparedStatement.setObject(5, salary);
            preparedStatement.setObject(6, address);
            preparedStatement.setObject(7, city);
            preparedStatement.setObject(8, province);
            preparedStatement.setObject(9, postalCode);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomer(String title, String name, String dob, Double salary, String address, String city, String province, String postalCode, Integer id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE customers SET title=?,name=?,DOB=?,Salary=?,address=?,city=?,province=?,postalcode=? WHERE ID=?");

            preparedStatement.setObject(1, title);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, dob);
            preparedStatement.setObject(4, salary);
            preparedStatement.setObject(5, address);
            preparedStatement.setObject(6, city);
            preparedStatement.setObject(7, province);
            preparedStatement.setObject(8, postalCode);
            preparedStatement.setObject(9, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteCustomer(Integer id){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE ID = ?");

            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
