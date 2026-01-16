package model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@Setter
@Getter
@AllArgsConstructor
public class ItemInfoDTO {
    private Integer itemCode;
    private String description;
    private String category;
    private int qtyOnHand;
    private double unitPrice;
}
