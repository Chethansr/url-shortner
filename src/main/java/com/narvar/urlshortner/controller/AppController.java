package com.narvar.urlshortner.controller;

import com.narvar.urlshortner.dtos.UrlDto;
import com.narvar.urlshortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    private UrlService service;

    @Autowired
    public AppController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlDto> shortenUrl(@RequestBody UrlDto dto) {
        if (StringUtils.isEmpty(dto.getUrl()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(this.service.shortenUrl(dto), HttpStatus.OK);
    }

    @PostMapping("/redirect")
    public ResponseEntity<UrlDto> redirectUrl(@RequestBody UrlDto dto) {
        if (StringUtils.isEmpty(dto.getShortenedUrl()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        UrlDto response = this.service.redirect(dto);
        if (response == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
