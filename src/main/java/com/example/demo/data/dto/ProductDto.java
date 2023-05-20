package com.example.demo.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    private String productId;
    private String productName;
    private Integer productPrice;
    private Integer productStock;

}
