package com.example.demo.data.dto;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "shortUrl", timeToLive = 60)
public class ShortUrlResponseDto {
    @Id
    private String orgUrl;
    private String shortUrl;
}
