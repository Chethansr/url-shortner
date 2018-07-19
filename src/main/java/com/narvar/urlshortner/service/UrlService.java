package com.narvar.urlshortner.service;

import com.narvar.urlshortner.commons.RandomString;
import com.narvar.urlshortner.dtos.UrlDto;
import com.narvar.urlshortner.model.UrlMap;
import com.narvar.urlshortner.repo.UrlMapRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    private static Logger logger = LoggerFactory.getLogger(UrlService.class);

    private UrlMapRepo urlMapRepo;

    private RandomString randomString;

    private final String delimiter = "://";

    @Autowired
    public UrlService(UrlMapRepo urlMapRepo, RandomString randomString) {
        this.urlMapRepo = urlMapRepo;
        this.randomString = randomString;
    }

    public UrlDto shortenUrl(UrlDto dto) {
        String [] arr = dto.getUrl().split(delimiter);
        String prefix;
        String url;

        if (arr.length == 1) {
            prefix = "http";
            url = prefix + delimiter + dto.getUrl();
        } else {
            prefix = arr[0];
            url = dto.getUrl();
        }
        logger.debug("URL: {}", url);
        UrlMap urlMap = new UrlMap();
        String id = prefix + delimiter + randomString.nextString(7);
        while(true) {
            Optional<UrlMap> map = urlMapRepo.findById(id);
            if (!map.isPresent()) {
                logger.debug("Shortened URL: {}", id);
                urlMap.setId(id);
                urlMap.setUrl(url);
                urlMapRepo.save(urlMap);
                break;
            }
        }

        dto.setShortenedUrl(id);
        return dto;
    }

    public UrlDto redirect(UrlDto dto) {
        logger.debug("Shortened URL: {}", dto.getShortenedUrl());
        Optional<UrlMap> map = urlMapRepo.findById(dto.getShortenedUrl());
        if (map.isPresent()) {
            logger.debug("URL: {}", map.get().getUrl());
            dto.setUrl(map.get().getUrl());
            return dto;
        } else {
            logger.debug("No data found");
            return null;
        }
    }
}
