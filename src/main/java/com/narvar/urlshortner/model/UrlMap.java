package com.narvar.urlshortner.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UrlMap {

    @Id
    private String id;

    @Column
    private String url;
}
