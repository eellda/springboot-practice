package com.example.demo.controller;

import com.example.demo.data.dto.ShortUrlResponseDto;
import com.example.demo.service.ShortUrlService;
import com.example.demo.service.impl.ShortUrlServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {
    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Value("${demo.hub.short.url.id}")
    private String CLIENT_ID;
    @Value("${demo.hub.short.url.secret}")
    private String CLIENT_SECRET;

    ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping()
    public ShortUrlResponseDto generateShortUrl(String originalUrl) {
        LOGGER.info("[generateShortUrl] perform API. CLIENT_ID > {}, CLIENT_SECRET > {}", CLIENT_ID, CLIENT_SECRET);
        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @GetMapping()
    public ShortUrlResponseDto getShortUrl(String originalUrl) {
        return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @PutMapping("/")
    public ShortUrlResponseDto updateShortUrl(String originalUrl) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteShortUrl(String originalUrl) {

        try {
            shortUrlService.deleteShortUrl(originalUrl);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 완료");
    }
}
