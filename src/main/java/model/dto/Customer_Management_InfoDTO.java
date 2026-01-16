package model.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer_Management_InfoDTO {
    private String customerId;
    private String title;
    private String name;
    private String DOB;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalcode;

}
