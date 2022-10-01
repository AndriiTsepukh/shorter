package com.example.shorter.service;

import com.example.shorter.dao.EndpointDescription;
import com.example.shorter.entity.ShortenedUrl;
import com.example.shorter.reposotory.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UrlService {
    @Autowired
    UrlRepository repository;

    public String saveUrlData(EndpointDescription description) {
        String randomString = RandomStringUtils.randomAlphabetic(8);

        ShortenedUrl shortenedUrl = new ShortenedUrl();
        shortenedUrl.setId(randomString);
        shortenedUrl.setOriginalUrl(description.getUrl());
        shortenedUrl.setTitle(description.getTitle());

        repository.save(shortenedUrl);
        return randomString;
    }


    public String getUrl(String shortenUrlId) {
        var url = repository.findById(shortenUrlId);
        return url.orElseThrow(() -> new RuntimeException("Url with shortId: " + shortenUrlId + " not found."))
                .getOriginalUrl();
    }
}
