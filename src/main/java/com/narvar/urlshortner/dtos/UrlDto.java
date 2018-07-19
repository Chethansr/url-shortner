package com.narvar.urlshortner.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UrlDto {

    private String url;

    @JsonProperty("shortened_url")
    private String shortenedUrl;
}
