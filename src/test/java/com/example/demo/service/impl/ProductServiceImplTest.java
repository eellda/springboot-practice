package com.example.demo.service.impl;

import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.entity.ProductEntity;
import com.example.demo.data.handler.impl.ProductDataHandlerImpl;
import com.google.common.base.Verify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    @MockBean
    ProductDataHandlerImpl productDataHandler;

    @Autowired
     ProductServiceImpl productService;

    @Test
    public void getProductTest() {
        Mockito.when(productDataHandler.getProductEntity("123"))
                .thenReturn(new ProductEntity("123", "book", 2000, 500));

        ProductDto productDto = productService.getProduct("123");
        Assertions.assertEquals(productDto.getProductId(), "123"); // 매개변수가 같은지 체크
        Assertions.assertEquals(productDto.getProductName(), "book");
        verify(productDataHandler).getProductEntity("123");
    }

    @Test
    public void saveProductTest() {
        Mockito.when(productDataHandler.saveProductEntity("123", "book", 2000, 500))
                .thenReturn(new ProductEntity("123", "book", 2000, 500));

        ProductDto productDto = productService.saveProduct("123", "book", 2000, 500);
        Assertions.assertEquals(productDto.getProductId(), "123");
        Assertions.assertEquals(productDto.getProductName(), "book");
        Assertions.assertEquals(productDto.getProductPrice(), 2000);
        Assertions.assertEquals(productDto.getProductStock(), 500);

        verify(productDataHandler).saveProductEntity("123", "book", 2000, 500);
    }


}
