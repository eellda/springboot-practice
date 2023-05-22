package com.example.demo.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShortUrlResponseDto {
    private String orgUrl;
    private String shortUrl;
}
