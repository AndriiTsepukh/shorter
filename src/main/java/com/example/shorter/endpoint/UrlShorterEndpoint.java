package com.example.shorter.endpoint;

import com.example.shorter.dao.EndpointDescription;
import com.example.shorter.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShorterEndpoint {

    @Autowired
    UrlService urlService;

    @PostMapping("/short")
    public ResponseEntity<String> shorterUrl(@RequestBody EndpointDescription endpointDescription) {
        String generatedString = urlService.saveUrlData(endpointDescription);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", generatedString);
        return new ResponseEntity<String>("", headers, HttpStatus.CREATED);
    }

    @GetMapping("/short/{shortenUrlId}")
    public ResponseEntity<String> findByShortUrl(@PathVariable(value="shortenUrlId") final String shortenUrlId) {
        HttpHeaders headers = new HttpHeaders();
        var originalUrl = urlService.getUrl(shortenUrlId);

        headers.add("Location", originalUrl);
        return new ResponseEntity<String>("", headers, HttpStatus.MOVED_PERMANENTLY);
     }
}
