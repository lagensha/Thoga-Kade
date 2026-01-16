package edu.icet.controller.item;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.ItemInfoDTO;

import java.sql.*;

public class ItemController implements ItemInterface {
    public ObservableList<ItemInfoDTO> viewData() {
        ObservableList<ItemInfoDTO> itemInfoDTOS = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Items");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ItemInfoDTO itemInfoDTO = new ItemInfoDTO(
                        resultSet.getInt("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("Category"),
                        resultSet.getInt("QtyOnHand"),
                        resultSet.getDouble("UnitPrice")
                );
                itemInfoDTOS.add(itemInfoDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemInfoDTOS;
    }

    @Override
    public void addItems(Integer itemCode, String description, String category, int qtyOnHand, double unitPrice) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Items VALUES (?,?,?,?,?)");

            preparedStatement.setObject(1, itemCode);
            preparedStatement.setObject(2, description);
            preparedStatement.setObject(3, category);
            preparedStatement.setObject(4, qtyOnHand);
            preparedStatement.setObject(5, unitPrice);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateItems(String description, String category, int qtyOnHand, double unitPrice, Integer itemcode) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE items SET description=?,category=?,QtyOnHand=?,unitPrice=? WHERE itemcode=?");

            preparedStatement.setObject(1, description);
            preparedStatement.setObject(2, category);
            preparedStatement.setObject(3, qtyOnHand);
            preparedStatement.setObject(4, unitPrice);
            preparedStatement.setObject(5, itemcode);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteItem(Integer itemCode){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Items WHERE ItemCode = ?");
            preparedStatement.setObject(1,itemCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
