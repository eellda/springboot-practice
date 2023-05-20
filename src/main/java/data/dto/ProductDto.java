package data.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductDto {
    private String productId;
    private String productName;
    private String productPrice;
    private String productStock;

}
