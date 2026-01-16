package edu.icet.controller.supplier;

public interface SupplierInterFace {
    void addSupplier(String supplierId,String name, String companyName, String address,String city,String province,String postalCode,String phone, String email);
    void updateSupplier(String name, String companyName, String address,String city,String province,String postalCode,String phone, String email,String supplierId);
    void deleteSupplier(String supplierId);
}
