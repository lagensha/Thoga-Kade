package model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@Setter
@Getter
@AllArgsConstructor
public class ItemInfoDTO {
    private String itemCode;
    private String description;
    private String category;
    private int qtyOnHand;
    private double unitPrice;
}
