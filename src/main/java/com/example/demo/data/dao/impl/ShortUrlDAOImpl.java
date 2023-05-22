package com.example.demo.data.dao.impl;


import com.example.demo.data.dao.ShortUrlDAO;
import com.example.demo.data.entity.ShortUrlEntity;
import com.example.demo.data.repository.ShortUrlRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.save(shortUrlEntity);
        return foundShortUrlEntity;
    }

    @Override
    public ShortUrlEntity getShortUrl(String originalUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        return foundShortUrlEntity;
    }

    @Override
    public ShortUrlEntity getOriginalUrl(String shortUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByUrl(shortUrl);
        return foundShortUrlEntity;
    }

    @Override
    public ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrlEntity) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(newShortUrlEntity.getOrgUrl());
        return foundShortUrlEntity;
    }

    @Override
    public void deleteByShortUrl(String shortUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByUrl(shortUrl);
        shortUrlRepository.delete(foundShortUrlEntity);
    }

    @Override
    public void deleteByOriginalUrl(String orgUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(orgUrl);
        shortUrlRepository.delete(foundShortUrlEntity);
    }
}
