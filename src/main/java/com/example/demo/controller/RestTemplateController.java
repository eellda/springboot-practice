package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.RestTemplateService;
import lombok.Getter;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rest-template")
public class RestTemplateController {

    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/demo")
    public String getDemo() {
        return restTemplateService.getDemo();
    }

    @GetMapping("/name")
    public String getName() {
        return restTemplateService.getName();
    }

    @GetMapping("/name2")
    public String getName2() {
        return restTemplateService.getName2();
    }

    @PostMapping("/dto")
    public ResponseEntity<MemberDTO> getPostDtd() {
        return restTemplateService.postDto();
    }

    @PostMapping("/header")
    public ResponseEntity<MemberDTO> getAddHeader() {
        return restTemplateService.addHeader();
    }

}
