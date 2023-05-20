package com.example.demo.service.impl;

import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.entity.ProductEntity;
import com.example.demo.data.handler.ProductDataHandler;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
        // controller 에서는 dto를 받도록 작성했기 때문
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());
        return productDto;
    }
}
