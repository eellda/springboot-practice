package com.example.demo.controller;

import com.example.demo.data.dto.ProductDto;

import com.example.demo.service.impl.ProductServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
//@AutoConfigureMockMvc // MockMvc 를 builder 없이 주입 받을 수 있음
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductServiceImpl productService;

    @Test
    @DisplayName("product data 가져오기 test")
    void getProductTest() throws Exception {
        given(productService.getProduct("12345")).willReturn(
                new ProductDto("13579", "test", 3000, 1000)
        );

        String productId = "12345";

        // andExpect 기대하는 값이 나왔는지 체크 하는 메서드
        mockMvc.perform(get("/api/v1/product/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print());

        // verify 해당 객체의 베서드가 실행되었는지 체크
        verify(productService).getProduct("12345");
    }

    @Test
    @DisplayName("product data 생성 test")
    void createProductTest() throws Exception {

        given(productService.saveProduct("13579", "anno", 4000, 500)).willReturn(
                new ProductDto("13579", "anno", 4000, 500)
        );

        ProductDto productDto = ProductDto.builder()
                .productId("13579").productName("anno").productPrice(4000).productStock(500).build();
        Gson gson = new Gson();
        String content = gson.toJson(productDto);

        // gson 대체
        // String json = new ObjectMapper().writeValueAsString(productDto);

        // andExpect 기대하는 값이 나왔는지 체크 하는 메서드
        mockMvc.perform(post("/api/v1/product").content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print());

        // verify 해당 객체의 베서드가 실행되었는지 체크
        verify(productService).saveProduct("13579", "anno", 4000, 500);
    }
}
