package com.narvar.urlshortner.repo;

import com.narvar.urlshortner.model.UrlMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlMapRepo extends JpaRepository<UrlMap, String> {

    @Override
    UrlMap save(UrlMap urlMap);

    @Override
    Optional<UrlMap> findById(String id);
}
