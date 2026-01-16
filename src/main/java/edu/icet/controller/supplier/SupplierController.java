package edu.icet.controller.supplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Supplier_Management_DTO;

import java.sql.*;

public class SupplierController implements SupplierInterFace{
    public ObservableList<Supplier_Management_DTO>viewSupplier(){
        ObservableList<Supplier_Management_DTO>supplierManagementDtos= FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM Supplier");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Supplier_Management_DTO supplierManagementDto = new Supplier_Management_DTO(
                        resultSet.getString("supplierId"),
                        resultSet.getString("name"),
                        resultSet.getString("companyName"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                );
                supplierManagementDtos.add(supplierManagementDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return supplierManagementDtos;
    }
    @Override
    public void addSupplier(String supplierId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Supplier VALUE (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1,supplierId);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,companyName);
            preparedStatement.setObject(4,address);
            preparedStatement.setObject(5,city);
            preparedStatement.setObject(6,province);
            preparedStatement.setObject(7,postalCode);
            preparedStatement.setObject(8,phone);
            preparedStatement.setObject(9,email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateSupplier(String name, String companyName, String address, String city, String province, String postalCode, String phone, String email, String supplierId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Supplier SET name=?,companyName=?,address=?,city=?,province=?,postalCode=?,phone=?,email=? WHERE supplierId=?");
            preparedStatement.setObject(1,name);
            preparedStatement.setObject(2,companyName);
            preparedStatement.setObject(3,address);
            preparedStatement.setObject(4,city);
            preparedStatement.setObject(5,province);
            preparedStatement.setObject(6,postalCode);
            preparedStatement.setObject(7,phone);
            preparedStatement.setObject(8,email);
            preparedStatement.setObject(9,supplierId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteSupplier(String supplierId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement =  connection.prepareStatement("DELETE FROM Supplier WHERE supplierId=?");
            preparedStatement.setObject(1,supplierId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
