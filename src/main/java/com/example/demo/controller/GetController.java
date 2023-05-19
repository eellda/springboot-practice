package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // REST 기능 추가
@RequestMapping("/api/v1/get")
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "hello world!";
    }

    // api/v1/get/name
    @GetMapping("/name")
    public String getName() {
        return "maratang";
    }

    // api/v1/get/variable1/{String 값}
    @GetMapping("/variable1/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }

    // api/v1/get/variable2/{String 값}
    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // api/v1/get/request?name=name&email=eamil&organization=organization
    @GetMapping("/request")
    public String getRequestParam(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // api/v1/get/request2?key=value&key2=value2&key3=value3
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(Map -> {
            sb.append(Map.getKey() + " : " + Map.getValue() + "\n");
        });

        return sb.toString();
    }

    // api/v1/get/request3?name=sunshine&email=google@gmail.com&organization=readlingbook
    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
