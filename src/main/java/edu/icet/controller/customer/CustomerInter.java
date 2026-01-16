package edu.icet.controller.customer;

public interface CustomerInter {
    void addCustomer(Integer id, String title, String name, String dob, Double salary, String province, String postalCode, String address, String city);
    void updateCustomer(String title, String name, String dob, Double salary, String address, String city, String province, String postalCode, Integer id);
    void deleteCustomer(Integer id);
}
