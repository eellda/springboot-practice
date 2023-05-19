package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @PostMapping("/default")
    public String postMethod() {
        return "hello world!";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(Map -> {
            sb.append(Map.getKey() + " : " + Map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMemberDTO(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}
