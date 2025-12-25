package model.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier_Management_DTO {
    private String supplierId;
    private String name;
    private String companyName;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String phone;
    private String email;
}
