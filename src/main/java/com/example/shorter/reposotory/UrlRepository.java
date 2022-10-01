package com.example.shorter.reposotory;

import com.example.shorter.entity.ShortenedUrl;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<ShortenedUrl, String> {
}
