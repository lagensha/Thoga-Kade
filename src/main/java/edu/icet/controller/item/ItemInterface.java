package edu.icet.controller.item;


public interface ItemInterface {

    void addItems(Integer itemCode,String description,String category,int qtyOnHand,double unitPrice);
    void updateItems(String description, String category, int qtyOnHand, double unitPrice, Integer itemcode);
    void deleteItem(Integer itemCode);
}
