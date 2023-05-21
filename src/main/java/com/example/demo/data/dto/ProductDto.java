package com.example.demo.data.dto;

import com.example.demo.data.entity.ProductEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    @NotNull
    private String productId;
    @NotNull
    private String productName;
    @NotNull
    @Min(500)
    @Max(3000000)
    private Integer productPrice;
    @NotNull
    @Min(0)
    @Max(10000)
    private Integer productStock;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }

}
