package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put")
public class PutController {

    @PutMapping("/default")
    public String putMethod() {
        return "Hello world!";
    }

    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(Map -> {
            sb.append(Map.getKey()  + " : " + Map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping("/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping("/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO) {
        return memberDTO;
    }

    @PutMapping("/member3")
    public ResponseEntity postMemberDto3(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
    // HttpStatus.ACCEPTED를 사용할 경우 200이 아닌 202가 return 된다
    // ACCEPTED(202, Series.SUCCESSFUL, "Accepted")
    // body(memberDTO)를 사용함으로서 return memberDTO과 같은 효과를 냄
}
