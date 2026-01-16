package edu.icet.controller.employees;

public interface EmployeeInterface {
    void addEmployee(String employeeId, String name, String nic, String dob,double salary,String position, String contactNumber, String address, String joinedDate, String status);
    void updateEmployee(String name,String nic,String dob,double salary,String position,String contactNumber,String address,String joinedDate,String status,String employeeId);
    void deleteEmployee(String employeeId);
}
