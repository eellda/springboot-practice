package com.example.demo.data.dto;

import lombok.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NaverUriDto {
    private String message;
    private String code;
    private Result result;

    @Data
    public static class Result {
        private String hash;
        private String url;
        private String orgUrl;
    }
    // {
    //    "message":"ok",
    //    "result": {
    //        "hash":"GyvykVAu",
    //        "url":"https://me2.do/GyvykVAu",
    //        "orgUrl":"http://d2.naver.com/helloworld/4874130"
    //    }
    //    ,"code":"200"
    //}
    // 이런 형식의 데이터를 받을 준비가 됨
}
