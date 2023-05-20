package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@OpenAPIDefinition(
        info = @Info(
                title = "spring Boot API Test",
                description = "API 명세서",
                version = "1.0.0",
                contact = @Contact(
                        name = "sm",
                        email = "test@test.co.kr"
                )
        )
)

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    // default 구조
    @Bean
    public Docket swaggerAPI(){
        //Docket : swagger Bean
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(true) //기본 응답 메시지 표시 여부
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo")) //swagger탐색 대상 패키지
                .paths(PathSelectors.any())
                .build();

    }
}
